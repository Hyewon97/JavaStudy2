import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
	
	//2. DB연결
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "c##scott";
	String userpwd = "tiger";
	Connection conn = null;
	
	//1. JDBC 드라이버 로딩
	//멤버영역에 실행문 사용법
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이브가 로딩 되었습니다.");
		}catch(Exception e) {
			System.out.println("JDBC 드라이브 로딩 실패하였습니다.");
		}
	}
	public InsertTest() {
		try {
			//database 연결
			 conn=DriverManager.getConnection(url, userid, userpwd);
			
			conn.setAutoCommit(false); //자동으로 커밋안해주게 해주는것 defalut:true;
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			do {
				System.out.print("이름 = ");
					String username = br.readLine();
				System.out.print("연락처 = ");
					String tel = br.readLine();
				System.out.print("이메일 = ");
					String email = br.readLine();
				System.out.print("주소 = ");
					String addr = br.readLine();
				
				//3.preparedStatement를 생성 // 쿼리문을 만든다.
				String sql ="insert into member(num, username, tel, email, addr, writedate) "
						+" values(memsq.nextval,?,?,?,?,sysdate)";
				
				PreparedStatement pstmt=conn.prepareStatement(sql);
				
				//?에 값을 셋팅
				pstmt.setString(1, username); //
				pstmt.setString(2, tel);
				pstmt.setString(3, email);
				pstmt.setString(4, addr);
				
				//4. 실행
				int result = pstmt.executeUpdate();
/*				if(result >0) {
					System.out.println("회원 등록 되었습니다.");
				}else {
					System.out.println("회원 등록 실패하였습니다.");
				}*/
/*				
				sql ="insert into member(num, username, tel, email, addr, writedate) "
						+" values(memsq.nextval,?,?,?,?,sysdate)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, "AAAAA");
				pstmt.setString(2,  "010-5556-7878");
				pstmt.setString(3,  "qnrtjd96@sdasasdasd");
				pstmt.setString(4,  "서울시 서대문눈");
				
				int result2 = pstmt.executeUpdate();
				*/
				if(result >0) {
					conn.commit();
					System.out.println("회원 등록 되었습니다.");
				}else {
					System.out.println("회원 등록 실패하였습니다.");
				}
			}while(true);
			
		
			
		}catch(Exception e) {
			//예외발생하면 먼저 정상실행된 쿼리실행문 취소
			try {
				conn.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InsertTest();

	}

}
