import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class FileInicasteReceive {

	public FileInicasteReceive() {
		try {
			DatagramSocket ds = new DatagramSocket(20000); //포트 20000포트로
			byte data[] = new byte[256]; //최대 256바이트까지만 가능
			DatagramPacket dp = new DatagramPacket(data, 0, data.length);
			
			FileOutputStream fos = null;
			File file = null;
			
			while(true) {
				System.out.println("받기 대기중");
				ds.receive(dp);
				
				byte receiveData[] = dp.getData();
				int length = dp.getLength();
				
				String receiveStr = new String(receiveData, 0, length);
				
				if(length>=6 && receiveStr.substring(0,6).equals("$%$#21")) { //파일명이 전송된거지 확인
					//OutStream생성
					file = new File("C://tool/io",receiveStr.substring(6));
					fos = new FileOutputStream(file);
				}else if(length>=6 && receiveStr.substring(0,6).equals("@#DS$@")) { //마지막일때
					System.out.println("전송완료");
					fos.close();
					break;
				}else { //파일내용일때
					fos.write(receiveData, 0, length);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileInicasteReceive();

	}
}
