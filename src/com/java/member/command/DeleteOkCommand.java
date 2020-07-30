package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.Command;
import com.java.member.model.MemberDao;

public class DeleteOkCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		logger.info(logMsg + "DeleteOkCommand");
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");		
		String password = request.getParameter("password");
		logger.info(logMsg + "아이디 : " + id + " / 비번 : " + password);
		
		int check = MemberDao.getInstance().delete(id, password);
		logger.info(logMsg + check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/Views/member/deleteOk.jsp";
	}
}