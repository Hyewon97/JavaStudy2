import java.util.Calendar;
import java.util.Vector;

public class VectorMain {

	public VectorMain() {
		
	}

	public static void main(String[] args) {
		VectorTest vt = new VectorTest();
		Vector vv = vt.getData();
		
		//컬렉션에 객체 얻어오기
		Member m1 = (Member)vv.elementAt(2);
		Calendar date = (Calendar)vv.get(5);
		
		m1.memeberPrn();
		System.out.println(date);
	}

}
