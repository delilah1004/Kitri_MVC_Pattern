package com.java.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;


/**
 * @날짜 : 2020. 7. 1.
 * @author: 이다은
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(FrontController.class.getName());
	public static final String logMsg = "logMsg ===== ";
	
	public HashMap<String, Object> commandMap = new HashMap<String, Object>();
	
    public FrontController() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	String configFile = config.getInitParameter("configFile");
    	String path = config.getServletContext().getRealPath(configFile);
    	logger.info(logMsg + path);
    	
    	FileInputStream fis = null;
    	BufferedInputStream bis = null;
    	Properties pro = new Properties();
    	
    	try {
    		
    		fis = new FileInputStream(path);
    		bis = new BufferedInputStream(fis, 1024);
    		pro.load(bis);
    		
    	} catch(IOException e) {
    		
    		e.printStackTrace();
    		
    	} finally {
    		
    		try {
    			
    			if(bis!=null) bis.close();
    			if(fis!=null) fis.close();
    			
    		} catch(IOException e) {
    			
    			e.printStackTrace();
    		}
    	}
    	
    	Iterator<Object> keyIter = pro.keySet().iterator();
    	while(keyIter.hasNext()) {
    		String command = (String) keyIter.next();
    		String className = pro.getProperty(command);
    		logger.info(logMsg + command + "\t" + className);
    		
    		try {
    			
    			Class<?> handlerClass = Class.forName(className);
    			Object handlerInstance = handlerClass.getDeclaredConstructor().newInstance();
    			
    			commandMap.put(command, handlerInstance);
    			
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getServletPath();
		logger.info(logMsg + cmd);
		
		String viewPage = null;
		
		try {
			
			Command com = (Command) commandMap.get(cmd);
			viewPage = com.proRequest(request, response);
			
		} catch(Throwable e) {
			
			e.printStackTrace();
		}
		
		if(viewPage!=null) {
			
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}