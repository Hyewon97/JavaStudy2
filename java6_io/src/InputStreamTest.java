import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		try {
			//InputSteam 클래스는 추상 클래스로 객체 생성할 수 없다.
			//InputStream은 byte단위로 입력받는 클래스
			InputStream is = System.in;
			System.out.print("입력 = ");
			//read() ->입력문자를 1byte씩 읽어온다.
			while(true) {
				
				/*
				//read() : 입력문자를 1byte씩 읽어온다.
				int inData= is.read();
				if(inData == -1) {
					break;
				}
				System.out.println("inData = " + inData + ", " + (char)inData);
				*/
				
				/*
				//read(a[]) : 배열크기 만큼 한번에 읽어온다.
				byte[] inData = new byte[500];
				//	byte수    읽은 byte는 배열에 저장
				int cnt = is.read(inData);
				System.out.println(new String(inData , 0 , cnt) + "---> "+ cnt);
				if(cnt<=0) break;
				*/
				
				//read(arr[], int, int)
				byte inData[] = new byte[10];
				//				읽은데이터 담을배열, 배열의 저장위치 index, 읽어올 byte갯수
									//  시작 길이
				int cnt= is.read(inData, 3, 4);
				for(int i = 0; i<inData.length; i++) {
					System.out.println("inData["+i+"]= " + inData[i]);
				}
				
			}
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String arg[]) {
		new InputStreamTest();
	}

}
