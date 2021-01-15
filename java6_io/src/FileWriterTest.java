import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public FileWriterTest() {
		
		try {
			File f = new File("C://tool/io/test_file.txt");
			FileWriter fw = new FileWriter(f);
			String txt = "자바에서 문자열을 파일로 쓰기 연습중";
			
			//1.배열로 저장
			//문자열을 char배열로 생성
			char c[] = txt.toCharArray();
			fw.write(c, 5, c.length-5); //쓰게하는거
			fw.flush();  //기록명령메소드
			
			//2. 문자열로쓰기
			fw.write(txt, 0 , txt.length());
			fw.flush();//기록명령메소드
			
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end");
	}

	public static void main(String[] args) {
		new FileWriterTest();

	}

}
