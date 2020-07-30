package com.java.member.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;
import com.java.member.model.MemberDao;
import com.java.member.model.ZipcodeDto;

/**
 * @날짜 : 2020. 7. 3.
 * @author: 이다은
 */

public class ZipcodeCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		String dongName = request.getParameter("dong");
		logger.info(logMsg + dongName);
		
		if(dongName!=null) {
			ArrayList<ZipcodeDto> zipcodeList = MemberDao.getInstance().dongSearch(dongName);
			logger.info(logMsg + zipcodeList.size());
				
			request.setAttribute("zipcodeList", zipcodeList);
		}
		
		return "/WEB-INF/Views/member/zipcode.jsp";
	}
}