import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class fileCopy {

	public fileCopy() {
		try {
			// 파일복사
			File srcFile = new File("C://tool/io/test.gif");
			File tarFile = new File("C://tool", srcFile.getName());
			
			FileInputStream fi = new FileInputStream(srcFile);
			FileOutputStream fo = new FileOutputStream(tarFile);
			
			while(true) {
				int inData = fi.read();
				if(inData ==-1) break;
				fo.write(inData);
			}
			fo.flush();
			fo.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new fileCopy();
	}
}
