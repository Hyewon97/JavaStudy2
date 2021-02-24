import java.sql.CallableStatement;
import java.sql.ResultSet;

import oracle.jdbc.internal.OracleTypes;


public class SelectAllProcedure extends DBConn{
	public SelectAllProcedure() {
		
	}
	
	public void start() {
		try {
			getConn();
			//모든 레코드를 선택하라. member
			sql = "{call mem_all(?)}";
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			stmt.executeQuery();//실행
			
			rs = (ResultSet)stmt.getObject(1);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ ", " + rs.getString(2)+ ", "+ rs.getString(3)+ ", "+ rs.getString(4)+ ", "+ rs.getNString(5) + ", " + rs.getString(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBClose();
		}
	}
	public static void main(String[] args) {
		new SelectAllProcedure().start();

	}

}
