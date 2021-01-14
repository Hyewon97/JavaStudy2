import java.io.File;
import java.io.IOException;

public class FileTest {

	public FileTest() {
		// File객체 생성: 드라이브명, 폴더명, 파일명 반드시 절대주소여야한다.
		// 없는경로도 만들수가 있다.
		// 나는 메모장을 기준으로 함 C://Users/qnrtj/AppData/Roaming/Microsoft/Windows/Start Menu/Programs/Accessories/notepad.exe
		
		File f1 = new File("c://pratice");
		File f2 = new File("c://i/oracle.sql");
		File f3 = new File(f1, "test.txt");
		
		//폴더생성
		//exists() : 폴더 또는 파일이 존재하는지 확인해주는 메소드(true:있다, false:없다.)
		/*
		if(!f1.exists()) {
			if(f1.mkdirs()) {
				System.out.println("폴더가 생성됨");
			}else {
				System.out.println("폴더 생성 실패..");
			}
		}else {
			System.out.println("폴더가 이미있슴");
		}
		*/
		
		//파일생성
		if(!f3.exists()) {
			try {
				if(f3.createNewFile()) {
					System.out.println("파일이 생성됨");
				}else {
					System.out.println("파일 생성 실패");
				}
			} catch (IOException e) {
				System.out.println("파일생성에러 발생 -----> " + e.getMessage()); 
			}
		}	
	}
	public static void main(String[] args) {
		new FileTest();

	}

}
