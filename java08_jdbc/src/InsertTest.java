import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTest {

	public InsertTest() {
		try {
			//JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//database 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userid = "c##scott";
			String userpwd = "tiger";
			Connection conn=DriverManager.getConnection(url, userid, userpwd);
			
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
				if(result >0) {
					System.out.println("회원 등록 되었습니다.");
				}else {
					System.out.println("회원 등록 실패하였습니다.");
				}
				
			}while(true);
			
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InsertTest();

	}

}
