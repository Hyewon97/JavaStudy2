import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public FileReaderTest() {
		try {
			File f = new File("C://tool/io/oracle.sql");
			//C:\tool\io
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				/*
				int read = fr.read();
				if(read == -1 ) break;
				System.out.print((char)read);
				*/
				String read = br.readLine();
				if(read ==null) break;
				System.out.println("read = "+read);
			}
		}catch(FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		}catch(IOException ie) {
			System.out.println("파일 읽기 에러발생");
		}
	}

	public static void main(String[] args) {
			new FileReaderTest();
	}

}
