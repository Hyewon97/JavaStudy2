
public class UpdateTest extends DBConn{

	public UpdateTest() {
		setUpdate();
	}
	public void setUpdate() {
		try {
			getConn();
			
			sql = "update member set tel=? where username=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "010-1111-1111");
			pstmt.setString(2, "이강산");
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(result + "개의 레코드가 수정되었습니다.");
			}
		}catch(Exception e) {
			System.out.println("에러내용 ->" + e.getMessage());
		}finally {
			DBClose();
		}
	}

	public static void main(String[] args) {
		new UpdateTest();

	}

}
