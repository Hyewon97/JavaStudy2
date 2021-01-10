package member;

import java.util.HashMap;

public class MemberDataSet {

	public static HashMap<String, MemberVO> MemberList = new HashMap<String, MemberVO>();
	public MemberDataSet() {
		
	}
	
	// 회원번호, 회원이름, 회원전화번호, 회원아디
	public static void setMemberList() {
		MemberList.put("이강산", new MemberVO(1, "이강산", "010-6231-9238", "123"));
		MemberList.put("김강산", new MemberVO(2, "김강산", "010-1111-2222", "234"));
		MemberList.put("리강산", new MemberVO(3, "리강산", "010-2222-4444", "345"));
		MemberList.put("금강산", new MemberVO(4, "금강산", "010-3333-1234", "456"));
		MemberList.put("화려강산", new MemberVO(5, "화려강산", "010-5555-4321", "567"));
	}

}
