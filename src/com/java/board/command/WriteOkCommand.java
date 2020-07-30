package com.java.board.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.model.BoardDao;
import com.java.board.model.BoardDto;
import com.java.command.Command;

/**
 * @날짜 : 2020. 7. 7.
 * @author : 이다은
 */

public class WriteOkCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		logger.info(logMsg + "WriteOkCommand");
		
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		BoardDto boardDto = new BoardDto();
		
		// hidden (WriteCommand 에서 값 지정)
		boardDto.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		boardDto.setGroupNum(Integer.parseInt(request.getParameter("groupNum")));
		boardDto.setSequenceNum(Integer.parseInt(request.getParameter("sequenceNum")));
		boardDto.setSequenceLev(Integer.parseInt(request.getParameter("sequenceLev")));
		
		// 사용자 입력
		boardDto.setWriter(request.getParameter("writer"));
		boardDto.setTitle(request.getParameter("title"));
		boardDto.setEmail(request.getParameter("email"));
		boardDto.setContent(request.getParameter("content"));
		boardDto.setPassword(request.getParameter("password"));
		
		boardDto.setWriteDate(new Date());
		
		int check = BoardDao.getInstance().insert(boardDto);
		
		request.setAttribute("check", check);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/WEB-INF/Views/board/writeOk.jsp";
	}
}