package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.model.BoardDao;
import com.java.board.model.BoardDto;
import com.java.command.Command;

/**
 * @날짜 : 2020. 7. 8.
 * @author : 이다은
 */

public class ReadCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		logger.info(logMsg + "ReadCommand");
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		BoardDto dto = BoardDao.getInstance().read(boardNum);
		
		request.setAttribute("pageNumber", pageNumber);
		request.setAttribute("dto", dto);
		
		return "/WEB-INF/Views/board/read.jsp";
	}

}
