package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;

/**
 * @날짜 : 2020. 7. 3.
 * @author: 이다은
 */

public class LoginCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		return "/WEB-INF/Views/member/login.jsp";
	}
}