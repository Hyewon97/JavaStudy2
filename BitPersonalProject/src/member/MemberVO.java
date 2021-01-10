package member;

public class MemberVO {
	
	private int memberNo;
	private String memberName;
	private String memberPN;
	private String memberId;
	private int MemberNumber;
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPN() {
		return memberPN;
	}

	public void setMemberPN(String memberPN) {
		this.memberPN = memberPN;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getMemberNumber() {
		return MemberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		MemberNumber = memberNumber;
	}
	
	public MemberVO() {
		
	}
	
	public MemberVO(int memberNo, String memberName, String memberPN, String memberId) {
		this.memberNo=memberNo;
		this.memberName = memberName;
		this.memberPN = memberPN;
		this.memberId = memberId;
	}

}
