package com.java.fileBoard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;

/**
 * @날짜 : 2020. 7. 9.
 * @author : 이다은
 */

public class WriteCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		logger.info(logMsg + "WriteCommand");
		
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		// ROOT
		int boardNum = 0; 		// ROOT 글이면 0
		int groupNum = 1; 		// 그룹 번호
		int sequenceNum = 0; 	// 글 순서
		int sequenceLev = 0; 	// 글 레벨

		// 답글인 경우, DB에서 ROOT 글의 글 번호(boardNum)
		if (request.getParameter("boardNum") != null) {
			
			boardNum = Integer.parseInt(request.getParameter("boardNum"));
			groupNum = Integer.parseInt(request.getParameter("groupNum"));
			sequenceNum = Integer.parseInt(request.getParameter("sequenceNum"));
			sequenceLev = Integer.parseInt(request.getParameter("sequenceLev"));
		}
	
		request.setAttribute("boardNum", boardNum);
		request.setAttribute("groupNum", groupNum);
		request.setAttribute("sequenceNum", sequenceNum);
		request.setAttribute("sequenceLev", sequenceLev);
		
		request.setAttribute("pageNumber", pageNumber);

		return "/WEB-INF/Views/fileBoard/write.jsp";
	}
}