import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

public class VectorTest {

	public VectorTest() {
		
	}
	public Vector getData() {
		int num =1234;
		String name = "홍길동";
		Member member = new Member();
		Member member2 = new Member(500,"이순신","010-7777-8888", "서울시 종로구");
		Calendar now = Calendar.getInstance();
		Random ran = new Random();
		
		//입력순서 유지, index를 가진다 , 중복데이터 허용, 중간에 객체를 추가(삭제,수정) 가능
		Vector v = new Vector();
		
		v.add(num);//0 //1.5이전버전에서는 v.add(new Integer(num));으로 써야함
		v.addElement(name);//1
		v.add(member);//2
		v.add(member2);//3
		v.addElement(now);//4
		v.add(ran);//5번지에 저장되어있음
		
		//추가
		v.add(3, new String("hong gildong"));
		
		//add(Object e), addElement(Object obj),add(int index, E element)
		System.out.println("v.capacity"+ v.capacity());//메모리 확보공간 확인
		
		return v;
	}

}
