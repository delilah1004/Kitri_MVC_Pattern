package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;
import com.java.member.model.MemberDao;

/**
 * @날짜 : 2020. 7. 2.
 * @author: 이다은
 */

public class IdCheckCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String id = request.getParameter("id");
		logger.info(logMsg + id);
		
		int check = MemberDao.getInstance().idCheck(id);	// 0이면 없는 아이디, 1이면 아이디 중복
		logger.info(logMsg + check);
		
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		
		return "/WEB-INF/Views/member/idCheck.jsp";
	}
}