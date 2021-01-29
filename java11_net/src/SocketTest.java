import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTest {
	
	//클라이언트(사용자)
	public SocketTest() {
		 // socket? 서버에 접속 할 수 있는 기능을 만들어주는 객체이다
	      try {
	         //소켓 생성을 위해서 필요한 변수? 1.아이피주소 2.포트번호
	    	  InetAddress ia = InetAddress.getByName("192.168.137.1");
	         int port = 12000;
	         Socket s = new Socket(ia, port);//만들어지는 시점에 서버에 접속됨 > ss.accept()로 받아진다 > socket으로 리턴
	         //서버에서 보내진 데이터 받기
	         InputStream is = s.getInputStream(); //byte 단위
	         InputStreamReader isr = new InputStreamReader(is); //char 단위
	         BufferedReader br = new BufferedReader(isr); //line 읽어옴
	         
	         String data = br.readLine();
	         System.out.println("서버에서 받은 문자: "+data);
	         //br.close(); > 소켓까지 다 닫힘..!
	         
	         //서버에 데이터 보내기
	         OutputStream os = s.getOutputStream();
	         OutputStreamWriter osw = new OutputStreamWriter(os);
	         PrintWriter pw = new PrintWriter(osw);
	         pw.println("내가 클라이언트다. I am your client!");
	         pw.flush();
	         pw.close();
	         System.out.println("서버에 문자를 보냄.");
	         
	         
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	   }

	public static void main(String[] args) {
		new SocketTest();
	}

}
