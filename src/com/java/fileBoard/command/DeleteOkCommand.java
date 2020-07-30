package com.java.fileBoard.command;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileBoard.model.BoardDao;
import com.java.fileBoard.model.BoardDto;
import com.java.command.Command;

/**
 * @날짜 : 2020. 7. 9.
 * @author : 이다은
 */

public class DeleteOkCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		logger.info(logMsg + "DeleteOkCommand");

		request.setCharacterEncoding("utf-8");
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		String password = request.getParameter("password");
		
		BoardDto dto = BoardDao.getInstance().load(boardNum);
		
		int check = BoardDao.getInstance().delete(boardNum, password);
		
		if(check>0 && dto.getPath()!=null) {
			
			File file = new File(dto.getPath());
			
			if(file.exists() && file.isFile()) {
				file.delete();
			}
		}
		
		request.setAttribute("check", check);
		request.setAttribute("boardNum", boardNum);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/WEB-INF/Views/fileBoard/deleteOk.jsp";
	}

}
