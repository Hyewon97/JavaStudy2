package com.bitcamp.home.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcamp.home.CommandService;
import com.bitcamp.home.DBCPConnection;

public class MemberDAO extends DBCPConnection {
	//아이디 중복검사
	public boolean idCheck(String userid) {
		boolean result = false; // true:아이디가 있다 false:아이디가 없다.
		try {
			sql = "select userid from register where userid=?";
			
			getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}else {
				
			}
		}catch (Exception e) {
			System.out.println("아이디 중복검사 실패 => " + e.getMessage());
		}finally {
			getClose();
		}
		return result;
	}

}
