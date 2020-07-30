package com.java.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @날짜 : 2020. 7. 1.
 * @author: 이다은
 */

/**
 * @날짜 : 2020. 7. 8.
 * @author: 이다은
 * 
 * rollback
 */


public class JdbcUtil {
	public static void close(Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	public static void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection conn) {
		if(conn!=null) {
			try {
				conn.rollback();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
