import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
		//TreeMap : key, value를 가진다. key 기준으로 정렬
		
		TreeMap<String, Member> ht =new TreeMap<String, Member>();
		Member m1 = new Member(100, "홍길동", "010-1111-2222", "서울시 중구");
		ht.put("홍길동", m1);
		ht.put("세종대왕", new Member(200,"세종대왕", "010-1234-5678","서울시 종로구"));
		ht.put("이순신", new Member(300,"이순신", "010-5678-456","서울시 서대문구"));
		ht.put("김정희", new Member(400,"김정희", "010-4438-4526","서울시 마포구"));
		ht.put("세종대왕2", new Member(200,"세종대왕2", "010-1234-5678","서울시 종로구"));
		ht.put("이순신2", new Member(300,"이순신2", "010-5678-456","서울시 서대문구"));
		ht.put("김정희2", new Member(400,"김정희2", "010-4438-4526","서울시 마포구"));
		
		Member m = ht.get("이순신");
		m.memeberPrn();
		
		System.out.println("------------KeySet으로 목록구하기-------------");
		Set<String> set = ht.keySet();
		Iterator<String> ii=set.iterator();
		while(ii.hasNext()) {
			Member mm = ht.get(ii.next());
			mm.memeberPrn();
		}
		System.out.println("------descendingKeySet()--------");
		NavigableSet<String> descKey = ht.descendingKeySet();
		Iterator<String> iii = descKey.iterator();
		while(iii.hasNext()) {
			Member mm = ht.get(iii.next());
			mm.memeberPrn();
		}
		
		System.out.println("-----------------value를 이용한 목록구하기-------");
		Collection<Member> value = ht.values();
		Iterator<Member> iiii = value.iterator();
		while(iiii.hasNext()) {
			Member vvv = iiii.next();
			vvv.memeberPrn();
		}
	}

	public static void main(String[] args) {
		new TreeMapTest();

	}

}
