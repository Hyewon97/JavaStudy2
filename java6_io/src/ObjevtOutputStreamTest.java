import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class ObjevtOutputStreamTest {

	public ObjevtOutputStreamTest() {
		// ObjevtOutputStream : 객체를 파일로 쓰기를 할수 있다.
		
		Calendar now = Calendar.getInstance();
		FileCopy fc = new FileCopy();
		
		ArrayList lst = new ArrayList();
		lst.add(new String("홍길동"));
		lst.add(now);
		lst.add(fc);
		
		DataVO vo= new DataVO();
		vo.setNum(1234);
		vo.setName("세종대왕");
		vo.setTel("010-1111-2222");
		vo.setEmail("qnrtjd96@naver.com");
		
		//객체를 파일로 쓰기
		try {
			File f = new File("C://tool/io/Object.txt");
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(lst);
			oos.writeObject(vo);
			
			oos.flush();
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("객체저장이 완료되었습니다.");
	}

	public static void main(String[] args) {
		new ObjevtOutputStreamTest();

	}

}
