import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {
	
	//클라이언트(서버)
	public ServerSocketTest() {
		  try {
		         // 서브소켓 생성
		         ServerSocket ss = new ServerSocket(12000);
		      //   while(true) { //다중 접속 가능
		            System.out.println("접속 대기 중....");
		            // 클라이언트가 접속할 때까지 접속대기상태로 만들기
		            //ss.accept();
		            // 클라이언트가 접속하면 socket 객체를 리턴해준다
		            Socket s = ss.accept();
		            
		            System.out.println("클라이언트가 접속하였습니다.");
		            //클라이언트가 접속하면 Socket s는 접속자의 com ip를 inetaddress객체로 가진다
		            InetAddress ia = s.getInetAddress(); //클라이언트 컴퓨터 ip를 받아옴
		            System.out.println("접속자의 ip ? "+ia.getHostAddress()); //클라이언트 ip를 받아옴 > 접속자의 ip ? 192.168.0.54
		            
		            //접속자에게 서버가 문자 보내기
		            OutputStream os = s.getOutputStream(); //byte 단위 전송
		            //Char 단위로 바꿔주기
		            OutputStreamWriter osw = new OutputStreamWriter(os);
		            PrintWriter pw = new PrintWriter(osw); //한 줄 쓰기 기능 제공
		            pw.println("NOW YOU ACCESSED IN SERVER! 서버에 접속하셨습니다!");
		            pw.flush();
		            //pw.close(); > 소켓까지 다 닫힘...!
		            System.out.println("클라이언트에게 문자를 보냄.");
		            
		            //클라이언트의 문자 받기
		            InputStream is = s.getInputStream();
		            InputStreamReader isr = new InputStreamReader(is);
		            BufferedReader br = new BufferedReader(isr);
		            
		            String data = br.readLine();
		            System.out.println("클라이언트에게 받은 문자: "+data);
		            br.close();
		      //   }
		      }catch(IOException ioe) {
		         ioe.printStackTrace();
		      }
		   }

	public static void main(String[] args) {
		new ServerSocketTest();

	}

}
