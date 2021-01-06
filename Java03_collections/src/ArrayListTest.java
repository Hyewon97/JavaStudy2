import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public ArrayListTest() {
		//다른 종류의 객체 추가 가능
		ArrayList al = new ArrayList();
		//Member객체만 추가 가능
		List<Member> lst = new ArrayList<Member>();
		
		Member mem1 = new Member(100, "honh", "010-1111-2222", "서울시");
		Member mem2 = new Member(200, "kang", "010-4567-2222", "소대문구");
		Member mem3 = new Member(300, "san", "010-8978-2222", "북가좌");
		
		al.add(mem1);//0
		al.add(mem2);//1
		al.add(mem3);//2
		
		lst.add(mem1);//0
		lst.add(mem2);//0
		lst.add(mem3);//0
		
		al.add(new String("홍길동"));
		//1st.add(new String("세종대왕")); //generic은 같은 종류의 객체만 추가가능
		
		for (int i = 0; i < lst.size(); i++) {//0,1,2
			Member m = lst.get(i); //제너릭 컬렉션의 형변환 하지 않아도 된다.
			//Member m1 = (Member)al.get(i);
			m.memeberPrn();
		}
		
	}

	public static void main(String[] args) {
		new ArrayListTest();
	}

}
