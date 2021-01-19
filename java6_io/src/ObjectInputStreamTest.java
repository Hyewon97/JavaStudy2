import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {
		try {
			// 파일의 객체가져오기
			File f = new File("C://tool/io/Object.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//첫번째 객체 읽어오기
			ArrayList al= (ArrayList)ois.readObject();
			//두번쨰 객체 읽어오기
			DataVO vo = (DataVO)ois.readObject();
			
			//-------------------------------------------
			//값확인
			String username = (String)al.get(0);
			Calendar date = (Calendar)al.get(1);
			FileCopy copy = (FileCopy)al.get(2);
			
			System.out.println("arrayust.string -> " + username); //홍길동
			System.out.println("arryList.calendar - > " + date);// 시분 10:07
			copy.start(); //filecopy
			
			System.out.printf("dataVo->%d, %s, %s, %s\n", vo.getNum(),vo.getName(), vo.getTel(), vo.getEmail());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ObjectInputStreamTest();

	}

}
