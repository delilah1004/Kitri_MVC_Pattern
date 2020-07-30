package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.model.BoardDao;
import com.java.board.model.BoardDto;
import com.java.command.Command;

public class UpdateCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		logger.info(logMsg + "UpdateCommand");
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		BoardDto dto = BoardDao.getInstance().load(boardNum);
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/WEB-INF/Views/board/update.jsp";
	}

}
