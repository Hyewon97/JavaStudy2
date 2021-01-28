import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public InetAddressTest() {
		try {
			// 현재 컴퓨터의 아이피를 구하기
			//ip, url주소
			InetAddress ia1 = InetAddress.getLocalHost();
			String ip = ia1.getHostAddress(); //ip
			String hostname = ia1.getHostName(); //컴퓨터이름
			System.out.println("1. ia1.getHostAddress() -> " + ia1.getHostAddress());
			System.out.println("2. ia1.getHostName -> "+ ia1.getHostName());
			
			//url 주소를 이용하여 ip알아보기
			InetAddress ia2 =InetAddress.getByName("www.naver.com");
			System.out.println("3. ia2.address -> " + ia2.getHostAddress());
			System.out.println("4. ia2.hostname -> " + ia2.getHostName());
			
			//ip를 이용한 InetAddress생성 - ip로 객체생성시 url를 얻어오지 않는다.
			InetAddress ia3 = InetAddress.getByName("223.130.195.200");
			System.out.println("5. ia3.address -> " + ia3.getHostAddress());
			System.out.println("6. ia3.hostName -> " + ia3.getHostName());
			
			//여러개의 InetAddress얻어오기
			InetAddress ia4[] = InetAddress.getAllByName("www.naver.com");
			for(InetAddress ia : ia4) {
				System.out.println("ia.adress --> " + ia.getHostAddress());
				System.out.println("ia.hostName --> " + ia.getHostName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InetAddressTest();
	}
}
