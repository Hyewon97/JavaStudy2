package member;

public class MemberVO {
	
	private int memberNo;  //회원번호
	private String memberName; //책이름
	private String memberPN; //회원전화번호
	private String memberId; //회원아이디
	private int charge; //회원충전금액
	
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
	
	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public MemberVO() {
		
	}
	
	public MemberVO(int memberNo, String memberName, String memberPN, String memberId, int charge){
		this.memberNo=memberNo;
		this.memberName = memberName;
		this.memberPN = memberPN;
		this.memberId = memberId;
		this.charge = charge;
	}

}
