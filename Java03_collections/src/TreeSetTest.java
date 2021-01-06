import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
	
	//TreeSet : 중복허용하지않음. 입력순서 유지하지 않음, 크기순서대로 정렬됨
	public TreeSetTest() {
		int numData[] = {10,20,30,40,50,60,70,80,90,10,20,20,20,20};
		String strData[]= {"홍길동","세종대왕","홍길동","홍길동","이순신","이순신","김정희"};
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int n: numData) {
			ts.add(n);
		}
		TreeSet<String> ts2 = new TreeSet<String>();
		for(String a: strData) {
			ts2.add(a);
		}
		
		Iterator<Integer> ii =ts.iterator(); //오름차순으로
		while(ii.hasNext()) {
			System.out.println("ts -> "+ ii.next());
		}
		
		Iterator<Integer> iii = ts.descendingIterator(); //내림차순으로
		while(iii.hasNext()) {
			int data = iii.next();
			System.out.println("ts-> desc = " + data);
		}
		
		//출력
		Iterator<String> aa = ts2.iterator();
		while(aa.hasNext()) {
			System.out.println("ts2 -> " + aa.next());
		}
		
		Iterator<String> aaa = ts2.descendingIterator();
		while(aaa.hasNext()) {
			String data = aaa.next();
			System.out.println("ts2-> desc = " + data  );
		}
	}
	public static void main(String[] args) {
		new TreeSetTest();
	}
}
