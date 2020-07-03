package com.java.database;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @날짜 : 2020. 7. 1.
 * @author: 이다은
 */
public class DBCPInit extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
			String jdbcDriver = config.getInitParameter("jdbcDriver");
			Class.forName(jdbcDriver);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
