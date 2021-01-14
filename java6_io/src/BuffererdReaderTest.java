import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BuffererdReaderTest {

	public BuffererdReaderTest() {
		try {
			// 한줄단위로 입력할수 있는 클래스
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.print("문자열 입력 = ");
			
			//null일 경우 읽어온 데이터가 없다.
			String inData = br.readLine();
			System.out.println("inData = " + inData);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new BuffererdReaderTest();
	}
}
