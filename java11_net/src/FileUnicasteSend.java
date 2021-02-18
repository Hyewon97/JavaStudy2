import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FileUnicasteSend extends JFrame implements ActionListener {
	
	JTextField tf = new JTextField("192.168.0.7");
	JButton btn = new JButton("파일 보내기");
	public FileUnicasteSend() {
		add("North", tf);
		add("South", btn);
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		tf.addActionListener(this);
		btn.addActionListener(this);
	}
	//이벤트처리
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == btn) {
			startSend();
		}
		
	}
	public void startSend() {
		try {
			JFileChooser fc = new JFileChooser();
			int state = fc.showOpenDialog(this);
			if(state == 0) {//열기 선택시 전송
				File f = fc.getSelectedFile(); //d:\\fasfda\dsfasdf\asdf.txt
				String filename = "$%$#21"+f.getName();
				
				InetAddress ia = InetAddress.getByName(tf.getText());
				DatagramSocket ds = new DatagramSocket();
				//파일명보내기
				DatagramPacket pd = new DatagramPacket(filename.getBytes(), filename.getBytes().length, ia,20000);
				ds.send(pd);
				
				//파일내용
				FileInputStream fis = new FileInputStream(f);
				while(true) {
					byte sendData[] = new byte[256];
					int readCount = fis.read(sendData, 0 ,256);
					if(readCount <=0) break;
					
					pd = new DatagramPacket(sendData, readCount, ia, 20000);
					ds.send(pd);
				}
				
				//마지막 알림
				String endData = "@#DS$@";
				pd = new DatagramPacket(endData.getBytes(), endData.getBytes().length, ia, 20000);
				ds.send(pd);
				System.out.println(f.getPath() +" ---> 파일 전송완료");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileUnicasteSend();

	}
}
