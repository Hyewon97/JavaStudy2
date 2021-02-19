import java.sql.CallableStatement;

public class UpdateProcedure extends DBConn {
//db에 만든 프로시져를 이용해서  db 사용하기
	public UpdateProcedure() {
		//이름을 입력받아 연락처, 이메일, 주소를 시작
		try {
			//1. db 연결
			getConn();
			//2. preparedStatment
			//		프로시저 호출
			sql = "{call mem_update(?, ? ,?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "이순신");
			cstmt.setString(2, "010-2222-33333");
			cstmt.setString(3, "ㄴㄴㄴㄴ@naver.com");
			cstmt.setString(4, "서울시 용산구");
			//3. 실생
			int resualt = cstmt.executeUpdate();
			
			if(resualt>0) {
				System.out.println("회원수정 완료");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBClose();
		}
	}

	public static void main(String[] args) {
		new UpdateProcedure();
	}

}
