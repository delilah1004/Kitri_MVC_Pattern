package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.Command;
import com.java.member.model.MemberDao;
import com.java.member.model.MemberDto;

public class UpdateOkCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		MemberDto dto = new MemberDto();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		dto.setId(id);
		
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		
		dto.setPassword(request.getParameter("password"));
		dto.setEmail(request.getParameter("email"));
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddress(request.getParameter("address"));
		dto.setJob(request.getParameter("job"));
		dto.setMailing(request.getParameter("mailing"));
		dto.setInterest(request.getParameter("resultInterest"));
		logger.info(logMsg + " " + dto);
		
		int check = MemberDao.getInstance().update(dto);
		logger.info(logMsg + check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/Views/member/updateOk.jsp";
	}
}