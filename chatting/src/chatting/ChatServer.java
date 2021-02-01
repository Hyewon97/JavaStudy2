package chatting;

import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends Thread{
	//접속대기
	ServerSocket ss; //서버소켓
	//접속자(Socket)을 보관할 객체
	List<ChatService> connAll = new ArrayList<ChatService>();  //ArrayList에 담아준다.
	
	
	public ChatServer() {
		this.start();
	}
	
	//접속대기 쓰레드
	public void run() {
		try {
			ss= new ServerSocket(15000);
			while(true) {
				System.out.println("서버 접속대기중");
				Socket s = ss.accept();  //허락,동의하다
				
				//클라이언트가 접속을하면
				ChatService cs = new ChatService(s);
				System.out.println(cs.userid +"가 접속하였습니다.");
				
				//이미접속자인지 확인
				connectionCheck(cs);
				
				//모든 접속자 리스트에 추가
				connAll.add(cs);
				
				//현재 접속중인 접속자에 접속을 알린다.
				setMessageAll("$$NG##"+cs.userid+"님 이 접속하셨습니다."); //앞에 식별코드 $$NG##를 넣어주고 뒤에 담아준다
				
				//접속자수 보내기
				setMessageAll("!&CN%$"+ connAll.size()); //앞에 식별코드 !&CN%$
				
				//접속자 명 보내기
				connectionList();
				
				//클라이언트 보낸문자를 받아낼 inputStream 스레드 시작
				cs.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void connectionCheck(ChatService cs) { //사용자인지 check
		for(int i=0; i<connAll.size(); i++) { 
			ChatService service = connAll.get(i);
			if(service.userid.equals(cs.userid)){
				connAll.remove(i); //초기화시켜준다
				break;
			}
		}
	}
	//접속자목록보내기
	public void connectionList() {
		String idList ="^^CL*%";
		for(int i=0; i<connAll.size(); i++) {
			ChatService cs = connAll.get(i);
			idList +="/"+cs.userid;
		}
		setMessageAll(idList); //idlist추가한걸 준다.
	}
	
	//전체 회원에게 메세지보내기
	public void setMessageAll(String msg) { //42줄
		for(int i=0; i<connAll.size(); i++) {
			try {
				ChatService cs = connAll.get(i);
				//쓰기
				cs.pw.println(msg); //msg를보낸다.
				cs.pw.flush();
			}catch(Exception e) {//상대방이접속이끊기면 에러가뜸
				connAll.remove(i);
				i--;
			}
		}
	}
	
	
	//클라이언트가 접속을 하면 접속자 정보를 가질 객체
	class ChatService{
		//socket, inputStream, outputSteam, 접속자이름(ip)
		Socket s;
		BufferedReader br;
		PrintWriter pw;
		String userid;
		InetAddress ia;
		
		ChatService(){}
		ChatService(Socket s){
			try {
				this.s = s;
				br = new BufferedReader(new java.io.InputStreamReader(s.getInputStream())); //입력
				pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));// 출력
				
				//접속자
				ia= s.getInetAddress();
				userid = ia.getHostAddress();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		//입력대기 Thread
		public void start() {
			while(true) {
				try {
					String inData = br.readLine();
					if(inData != null) {
						//접속한 모든 접속자에게 문자보내기
						setMessageAll("%$MG%^"+ userid + "님 : " +inData);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new ChatServer();

	}

}
