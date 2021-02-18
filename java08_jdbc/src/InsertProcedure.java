import java.sql.CallableStatement;

public class InsertProcedure extends DBConn {
//db에 만든 프로시져를 이용해서  db 사용하기
	public InsertProcedure() {
				
		try {
			//1. db 연결
			getConn();
			//2. preparedStatment
			//		프로시저 호출
			sql = "{call mem_insert(?, ? ,?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "배수지");
			cstmt.setString(2, "010-7777-3333");
			cstmt.setString(3, "suzie@naver.com");
			cstmt.setString(4, "서울시 용산구");
			//3. 실생
			int resualt = cstmt.executeUpdate();
			
			if(resualt>0) {
				System.out.println("회원등록 완료");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBClose();
		}
	}

	public static void main(String[] args) {
		new InsertProcedure();
	}

}
