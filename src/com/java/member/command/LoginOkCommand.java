package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;
import com.java.member.model.MemberDao;

/**
 * @날짜 : 2020. 7. 3.
 * @author: 이다은
 */

public class LoginOkCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		logger.info(logMsg + " " + id + " " + password);
		
		String[] info = MemberDao.getInstance().loginCheck(id, password);
		
		String memberLevel = info[0];
		logger.info(logMsg + memberLevel);
		
		String name = info[1];
		logger.info(logMsg + memberLevel);
		
		request.setAttribute("memberLevel", memberLevel);
		request.setAttribute("name", name);
		
		return "/WEB-INF/Views/member/loginOk.jsp";
	}

}
