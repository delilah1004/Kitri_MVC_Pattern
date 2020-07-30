package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.Command;
import com.java.member.model.MemberDao;
import com.java.member.model.MemberDto;

public class DeleteCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		logger.info(logMsg + "DeleteCommand");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		logger.info(logMsg + id);
		
		MemberDto dto = MemberDao.getInstance().findMember(id);
		logger.info(logMsg + dto);
		
		request.setAttribute("memberDto", dto);
		
		return "/WEB-INF/Views/member/delete.jsp";
	}
}