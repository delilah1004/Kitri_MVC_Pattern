package com.java.fileBoard.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileBoard.model.BoardDao;
import com.java.fileBoard.model.BoardDto;
import com.java.command.Command;

/**
 * @날짜 : 2020. 7. 9.
 * @author : 이다은
 */

public class ListCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		logger.info(logMsg + "ListCommand");
		
		String pageNum = request.getParameter("pageNumber");
		if(pageNum==null) pageNum="1";		
		
		int boardSize = 10;
		int pageNumber = Integer.parseInt(pageNum);
		
		int startRow = boardSize*(pageNumber-1)+1;
		int endRow = boardSize*pageNumber;
		
		int boardCount = BoardDao.getInstance().getCount();
		
		ArrayList<BoardDto> array = null;
		
		if(boardCount>0) {
			// startRow, endRow
			array = BoardDao.getInstance().getBoardList(startRow, endRow);
		}
		
		request.setAttribute("array", array);	// 전체 게시물
		request.setAttribute("boardCount", boardCount);	// 전체 게시물 개수
		request.setAttribute("boardSize", boardSize);	// 한 페이지에 보여줄 게시글의 수
		request.setAttribute("pageNumber", pageNumber);	// 현재 페이지 번호
		
		return "/WEB-INF/Views/fileBoard/list.jsp";
	}
}