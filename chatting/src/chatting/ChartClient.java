package chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChartClient extends JFrame implements ActionListener, Runnable{
	/////패널만들기///////////////////////////////////////////
	//JFrame-center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel connPane = new JPanel(new BorderLayout());
			JTextField connTf = new JTextField();
			JButton connBtn = new JButton("접속");
		JTextArea msgTa = new JTextArea();
		JScrollPane msgSp = new JScrollPane(msgTa);
		JPanel sendPane = new JPanel(new BorderLayout());
			JTextField sendTf = new JTextField();
			JButton sendBtn = new JButton("보내기");
	
	//JFrame-East
	JPanel eastPane = new JPanel(new BorderLayout());
		JLabel ListTiltle = new JLabel("		접속자리스트		");
		DefaultListModel<String> nameModel = new DefaultListModel<String>(); //모델주입
		JList<String> nameList = new JList<String>(nameModel); //JList에 담아줄거이므로 String객체로선언
		JScrollPane nameListSp = new JScrollPane(nameList);
		JLabel connCountLbl = new JLabel("현재원 : 0명");
			
	/////////////////////////////////////////////////////////
	Socket s;  // 소켓선언
	PrintWriter pw; //File(String), OutputStream, Writer 등의 객체를 인수로 받아 스트림을 연결할수 있음 
	BufferedReader br; //버퍼를 읽는 메소드
	
	public ChartClient() {
		//JFrame-center
		add(centerPane);
			centerPane.add("North", connPane);
				connPane.add(connTf);
				connPane.add("East", connBtn);
			centerPane.add(msgSp);
				msgSp.setBackground(Color.LIGHT_GRAY);
			centerPane.add("South", sendPane);
				sendPane.add(sendTf);
				sendPane.add("East", sendBtn);
			
		//JFrame - East
		add("East", eastPane);
			eastPane.add("North",ListTiltle);
			nameModel.addElement("");
			eastPane.add(nameListSp);
			eastPane.add("South", connCountLbl);
			
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//이벤트 등록
		connTf.addActionListener(this);
		connBtn.addActionListener(this);
		sendTf.addActionListener(this);
		sendBtn.addActionListener(this);
	}
	
	//이벤트주입
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object eObj = ae.getSource();
		if(eObj == connTf || eObj == connBtn) { //접속버튼을누르면
			//서버연결
			serverConnection();
		}else if(eObj == sendTf || eObj == sendBtn) { //eObj가 sendTf,sendBtn를 누르면
			//문자보내기
			if(sendTf.getText().equals("")) { //텍스트가 비어져있다면
				JOptionPane.showMessageDialog(this, "메세지를 입력후 보내기를 원합니다.");
			}else {
				pw.println(sendTf.getText()); //메세지를 받아와서 pw에 넣어준다.
				pw.flush(); //저장되어있는 버퍼를 비워준다.
			}
			sendTf.setText(""); //메세지 초기화
		}
	}
	
	//서버연결하는 메소드
	public void serverConnection() {
		if(connTf.getText().equals("")) { //공백이면
			JOptionPane.showMessageDialog(this,"ip를 입력후에 접속해주세요");
		}else {// 공백이아니면
			try {
				InetAddress ia = InetAddress.getByName(connTf.getText()); //InetAddress : ip주소를 자바에서 나타낼떄 쓰는 클래스이다.
																		  //connTf.getText를 받아와서 이름으로 지정한다.
				System.out.println("connTf.getText() = " + connTf.getText());
				System.out.println("ia = " + ia);
				
				s = new Socket(ia, 15000); //소켓에다가 담아주는데, ia를 담고 포트는 15000번으로 한다.
				System.out.println("s = " + s);
				
				br = new BufferedReader(new InputStreamReader(s.getInputStream())); //s.getInputStream())을 InputStreamRead에 담고, 버퍼에다가 다시담는다. 그리고 이걸 br에넣는다.
				System.out.println("s.getInputStream() = "+ s.getInputStream());
				
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));//위와동일
				//OutputStreamWriter, InputStreamReader 파일쓰기,읽기
				
				//이미 연결이 되어있으면 접속을 못하도록 비활성화
				connTf.setEnabled(false);
				connBtn.setEnabled(false);
				
				Thread t = new Thread(this);
				t.start();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//실행되고있을때 다른접속자 못들어오게 하는거 synchronized
	public synchronized void run() {
		while(true) {
			try {
				String inData = br.readLine();
				if(inData != null) { //inData에 값이 있으면
					String header = inData.substring(0, 6);
					
					/*
					 	inData = $$NG##192.168.0.7님 이 접속하셨습니다.
						inData = !&CN%$1
						inData = ^^CL*%/192.168.0.7 의 값중 앞에 6자리를 끊어서 
						if문 걸어주기 위해 문자를 끊는다.
					 */
					
					//String header = inData;
					System.out.println("inData = " + inData);
					
					if(header.equals("$$NG##")) {//접속자 정보알림
						msgTa.append(inData.substring(6)+ "\n"); //append 추가하다.
						
					}else if(header.equals("!&CN%$")) {
						connCountLbl.setText("현재원 : " + inData.substring(6) + "명"); //inData.substring(6)는 inData = !&CN%$1의 값중 6번째이후의값인 1을 꺼내기위해서 사용했다.
						
					}else if(header.equals("^^CL*%")) {//접속자 목록
						//192.168.0.6 / 192.168.5.45/ 192.132.124 등등
						setConnectListReset(inData.substring(6)); //6번째이후의값을 꺼내기위해서 사용
						
					}else if(header.equals("%$MG%^")) { //채팅창에 입력하면
						msgTa.append(inData.substring(6)+"\n"); //메세지박스에 추가한다. \n 엔터
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void setConnectListReset(String nameList){
		StringTokenizer st = new StringTokenizer(nameList, "/");
		nameModel.removeAllElements(); // 원래목록제거
		while(st.hasMoreElements()) {
			 nameModel.addElement(st.nextToken());
		}
		
	}
	public static void main(String[] args) {
		new ChartClient();

	}


}
