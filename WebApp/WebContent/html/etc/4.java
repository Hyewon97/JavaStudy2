package member;

import java.util.HashMap;

public class MemberDataSet {

	public static HashMap<String, MemberVO> MemberList = new HashMap<String, MemberVO>();
	public MemberDataSet() {
		
	}
	
	// 회원번호, 회원이름, 회원전화번호, 회원아디
	public static void setMemberList() {
		MemberList.put("홍길동", new MemberVO(1, "홍길동", "010-6231-9238", "123", 10000));
		MemberList.put("김길동", new MemberVO(2, "김길동", "010-1111-2222", "234", 20000));
		MemberList.put("리길동", new MemberVO(3, "리길동", "010-2222-4444", "345", 30000));
		MemberList.put("금길동", new MemberVO(4, "금길동", "010-3333-1234", "456", 10000));
		MemberList.put("동길동", new MemberVO(5, "동길동", "010-5555-4321", "567", 50000));
	}

}
