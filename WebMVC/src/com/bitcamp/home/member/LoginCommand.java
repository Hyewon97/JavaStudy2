package com.bitcamp.home.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcamp.home.CommandService;

public class LoginCommand implements CommandService {

	@Override
	public String pocessStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		return "/member/login.jsp";
	}

}
