package com.java.command;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.controller.FrontController;

/**
 * @날짜 : 2020. 7. 1.
 * @author: 이다은
 */
public interface Command {
	
	public Logger logger = Logger.getLogger(FrontController.class.getName());
	public String logMsg = "logMsg ===== ";
	
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable;
	
	
}
