
public class Member {

	int no = 1234;
	String username = "세종대왕";
	String tel = "010-1111-2222";
	String addr ="서울시 서대문구";
	public Member() {}
	public Member(int no, String username, String tel, String addr) {
		this.no = no;
		this.username = username;
		this.tel = tel;
		this.addr = addr;
	}
	public void memeberPrn(){
		System.out.printf("%d, %s, %s, %s\n", no, username,tel, addr);
		
	}
}
