import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashtableTest {

	public HashtableTest() {
		
	}
	public void start() {
		//Key,Value를 가진다.
		//Hashtalbe:동기화 지원
		//HashMap: 동기화 지원하지않음
		
		//회원정보 4명을 hashtable에다가 저장
		Hashtable<String, Member> ht =new Hashtable<String, Member>();
		Member m1 = new Member(100, "홍길동", "010-1111-2222", "서울시 중구");
		ht.put("홍길동", m1);
		ht.put("세종대왕", new Member(200,"세종대왕", "010-1234-5678","서울시 종로구"));
		ht.put("이순신", new Member(300,"이순신", "010-5678-456","서울시 서대문구"));
		ht.put("김정희", new Member(400,"김정희", "010-4438-4526","서울시 마포구"));
		ht.put("세종대왕2", new Member(200,"세종대왕2", "010-1234-5678","서울시 종로구"));
		ht.put("이순신2", new Member(300,"이순신2", "010-5678-456","서울시 서대문구"));
		ht.put("김정희2", new Member(400,"김정희2", "010-4438-4526","서울시 마포구"));
		
		//key기준으로 가져오기
		Member vo = ht.get("세종대왕");
		vo.memeberPrn();
		//------------Map의 Key목록을 구하기 :Set으로 리턴된다.
		Set<String> KeyList = ht.keySet();
		
		Object[] obj = KeyList.toArray();
		for(Object o: obj) {
			System.out.println(o);
		}
		System.out.println("----------------------------------");
		Iterator<String> ii = KeyList.iterator();
		while(ii.hasNext()) {
			//System.out.println(ii.next());
			Member v = ht.get(ii.next());
			v.memeberPrn();
		}
		System.out.println("---------전체 value 목록을 불러오기-----------");
		Collection<Member> value = ht.values();
		Iterator<Member> iii = value.iterator();
		while(iii.hasNext()) {
			Member vvv = iii.next();
			vvv.memeberPrn();
		}
		
	}

	public static void main(String[] args) {
		new HashtableTest().start();
	}

}
