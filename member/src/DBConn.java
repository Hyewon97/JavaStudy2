import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
	
	//1. 드라이브 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이브 로딩 성공");
		}catch(Exception e) {
			System.out.println("드라이브 로딩 에러 발생 -> " + e.getMessage());
		}
	}
	
	Connection conn = null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	
	String sql =null;
//	String url = "jdbc:oracle:thin:@211.49.231.6:1521:orcl";
//	String username = "kangsan";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "c##scott";
	String userpwd = "tiger";
	
	
	public DBConn() {

	}
	
	//DB연결
	public void getConn() {
		try {
			conn = DriverManager.getConnection(url, username, userpwd);
			System.out.println("DB 연결성공");
		}catch(Exception e) {
			System.out.println("DB 연결 오류 발생 -> " + e.getMessage());
		}
	}
	
	//DB 연결종료
	public void DBClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			System.out.println("DB연결 종료");
		}catch(Exception e) {
			System.out.println("DB종료 에러발생 --> "+ e.getMessage());
		}
	}
}
