import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicasteSend {

	DatagramSocket ds; //주고받을 소켓생성
	DatagramPacket dp; //패킷생성
	InetAddress ia; //아이피받아오기
	public UnicasteSend() {
		// UDP방식 데이터보내기
		try {
			ds = new DatagramSocket();
			
			String data ="Java network 유니캐스트 통신 연습중";
			ia = InetAddress.getByName("192.168.0.7"); //받는쪽 아이피
			//전송할 데이터 그램 패킷객체 생성
			//                      256권장바이트
			//                  보낼데이터를 바이트로 나눈다,배열의길이, ip, 포트
			dp = new DatagramPacket(data.getBytes(), data.getBytes().length,ia, 10000);
			
			//데이터보내기
			ds.send(dp); //보내고끝
			ds.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("보내기 완료");
	}

	public static void main(String[] args) {
		new UnicasteSend();

	}

}
