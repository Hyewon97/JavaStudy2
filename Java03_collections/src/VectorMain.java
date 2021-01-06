import java.util.Calendar;
import java.util.Random;
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
		
		System.out.println("객체의 수 --> " + vv.size());
		
		//마지막 객체 얻어오기
		Random ran = (Random)vv.lastElement();
		System.out.println("난수 = " + ran.nextInt());
		
		//객체지우기
		vv.remove(3); //3번째를 지우면 뒤에가 다바뀐다.
		vv.removeAllElements();
		System.out.println("객체의 수 -->" + vv.size());
	}

}
