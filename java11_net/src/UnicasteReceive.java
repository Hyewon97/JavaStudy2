import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicasteReceive {
	
	DatagramSocket ds;
	DatagramPacket dp;
	
	public UnicasteReceive() {
		// 받는쪽은 포트만열놓으면댄다
		//UDP 방식 데이터받기
		try {
			//받기를 할 객체 생성
			ds = new DatagramSocket(10000);
			
			//받은 데이터를 저장할 배열
			byte data[] = new byte[256];
			DatagramPacket dp = new DatagramPacket(data, data.length);
			
			System.out.println("전송받기 대기중!!!!!!!");
			ds.receive(dp);//ds받기
			
			//받은데이터 처리
			byte reciveData[] = dp.getData();//전송받은 데이터 배열
			int len = dp.getLength();//전송받은 byte수 구하기
			System.out.println("받은 문자는 --> "+ new String(reciveData,0,len) + "-----------");
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}

	public static void main(String[] args) {
		new UnicasteReceive();

	}

}
