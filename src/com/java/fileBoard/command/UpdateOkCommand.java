package com.java.fileBoard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileBoard.model.BoardDao;
import com.java.fileBoard.model.BoardDto;
import com.java.command.Command;

/**
 * @날짜 : 2020. 7. 9.
 * @author : 이다은
 */

public class UpdateOkCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		logger.info(logMsg + "UpdateOkCommand");
		
		request.setCharacterEncoding("utf-8");
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		String password = request.getParameter("password");
		
		BoardDto dto = new BoardDto();
		
		dto.setWriter(request.getParameter("writer"));
		dto.setTitle(request.getParameter("title"));
		dto.setEmail(request.getParameter("email"));
		dto.setContent(request.getParameter("content"));
		
		int check = BoardDao.getInstance().update(dto, boardNum, password);
		
		request.setAttribute("check", check);
		request.setAttribute("boardNum", boardNum);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/WEB-INF/Views/fileBoard/updateOk.jsp";
	}

}
