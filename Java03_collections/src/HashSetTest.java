import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

	public HashSetTest() {
		//Set : 입력순서 유지하지 않음, 중복데이터 허용하지 않음
		int numData[] = {10,20,30,40,50,60,70,80,90,10,20,20,20,20};
		String strData[]= {"홍길동","세종대왕","홍길동","홍길동","이순신","이순신","김정희"};
		
		HashSet<Integer> hs1 = new HashSet<Integer>();
		for(int n : numData) {
			hs1.add(n);
		}
		System.out.println("hs1의 객체수 = " + hs1.size());
		
		HashSet<String> hs2 = new HashSet<String>();
		for(String s : strData) {
			hs2.add(s);
		}
		System.out.println("hs2의 객체수 = " + hs2.size());
		
		////////////////////////
		Iterator<Integer> i =hs1.iterator();
		while(i.hasNext()) {
			System.out.println("hs1-->" + i.next());
		}
;	}

	public static void main(String[] args) {
		new HashSetTest();

	}

}
