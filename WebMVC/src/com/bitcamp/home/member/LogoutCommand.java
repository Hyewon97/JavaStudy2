package com.bitcamp.home.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcamp.home.CommandService;

public class LogoutCommand implements CommandService {

	@Override
	public String pocessStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//로그아웃
		HttpSession ses = req.getSession();
		System.out.println("sesId = " + ses.getId());
		System.out.println("id=============== " + ses.getAttribute("userid"));
		System.out.println("getMaxInactiveInterval ="+ ses.getMaxInactiveInterval());
		System.out.println("getLastAccessedTime = " + ses.getLastAccessedTime());
		
		//세션지우기
		ses.invalidate();
//		System.out.println("세션지운후 sesid = =========== " + ses.getAttribute("userid"));
		
		return "/index.jsp";
	}

}
