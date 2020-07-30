package com.java.fileBoard.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.java.database.ConnectionProvider;
import com.java.database.JdbcUtil;

/**
 * @날짜 : 2020. 7. 9.
 * @author : 이다은
 */

public class BoardDao {
	private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	public int insert(BoardDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int value = 0;
		
		writeNumber(dto, conn);
		
		try {
			
			if(dto.getFileSize()==0) {
				
				sql = "insert into board(BOARD_NUMBER, WRITER, TITLE, EMAIL, CONTENT, PASSWORD, WRITE_DATE, READ_COUNT, "
						+ "GROUP_NUMBER, SEQUENCE_NUMBER, SEQUENCE_LEVEL) values(board_board_number_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getEmail());
				pstmt.setString(4, dto.getContent().replace("\r\n", "<br/>"));
				pstmt.setString(5, dto.getPassword());
				
				/*
				Date date = dto.getWriteDate();
				long time = date.getTime();
				Timestamp ts = new TimeStamp(time);
				*/
				
				pstmt.setTimestamp(6, new Timestamp(dto.getWriteDate().getTime()));
				pstmt.setInt(7, dto.getReadCnt());
				pstmt.setInt(8, dto.getGroupNum());
				pstmt.setInt(9, dto.getSequenceNum());
				pstmt.setInt(10, dto.getSequenceLev());
				
			} else {
				
				sql = "insert into board values(board_board_number_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getEmail());
				pstmt.setString(4, dto.getContent().replace("\r\n", "<br/>"));
				pstmt.setString(5, dto.getPassword());
				
				pstmt.setTimestamp(6, new Timestamp(dto.getWriteDate().getTime()));
				pstmt.setInt(7, dto.getReadCnt());
				pstmt.setInt(8, dto.getGroupNum());
				pstmt.setInt(9, dto.getSequenceNum());
				pstmt.setInt(10, dto.getSequenceLev());
				
				pstmt.setString(11, dto.getFileName());
				pstmt.setString(12, dto.getPath());
				pstmt.setLong(13, dto.getFileSize());
			}
			
			value = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return value;
	}
	
	public void writeNumber(BoardDto dto, Connection conn) {
		// 그룹번호(ROOT), 글 순서(자식), 글 레벨(자식)
		
		int boardNum = dto.getBoardNum();		
		int groupNum = dto.getGroupNum();		
		int sequenceNum = dto.getSequenceNum();	
		int sequenceLev = dto.getSequenceLev();	

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			
			if(boardNum==0) {	// ROOT 글 - groupNum, 0, 0
				sql = "select max(group_number) from board";
				conn = ConnectionProvider.getConnection(); 
				pstmt = conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					int max = rs.getInt("max(group_number)");	
					dto.setGroupNum(max+1);
				}
				
			} else {	// 답글 - groupNum, sequenceNum+1, sequenceLev+1
				sql = "update board set sequence_number = sequence_number+1 where group_number=? and sequence_number>?";
				
				conn = ConnectionProvider.getConnection();
				pstmt= conn.prepareStatement(sql);
				
				pstmt.setInt(1, groupNum);
				pstmt.setInt(2, sequenceNum);
				
				pstmt.executeUpdate();
				
				sequenceNum = sequenceNum + 1;	// 글 순서 + 1
				sequenceLev = sequenceLev + 1;	// 글 레벨 + 1\
				
				dto.setSequenceNum(sequenceNum);
				dto.setSequenceLev(sequenceLev);
			}			

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}
	}
	
	public int getCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int value = 0;

		try {
			
			String sql = "select count(*) from board";
			conn = ConnectionProvider.getConnection(); 
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
				
			if(rs.next()) value = rs.getInt(1);
			
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}
		
		return value;
	}
	
	public ArrayList<BoardDto> getBoardList(int start, int end){
		
		ArrayList<BoardDto> array = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * from(select rownum rnum, a.* from (select * from board order by group_number desc, sequence_level, sequence_number desc)a )b where rnum between ? and ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			array = new ArrayList<BoardDto>();
			
			while(rs.next()) {
				
				BoardDto dto = new BoardDto();
				
				// 뿌려야 하는 데이터
				dto.setBoardNum(rs.getInt("board_number"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				
				// 뿌릴 필요 없는 데이터
				dto.setEmail(rs.getString("email"));
				dto.setContent(rs.getString("content"));
				dto.setPassword(rs.getString("password"));
				
				// 뿌려야 하는 데이터
				dto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				dto.setReadCnt(rs.getInt("read_count"));
				
				// 넘겨줘야 하는 데이터
				dto.setGroupNum(rs.getInt("group_number"));
				dto.setSequenceNum(rs.getInt("sequence_number"));
				dto.setSequenceLev(rs.getInt("sequence_level"));
				
				// System.out.println(dto);
				
				array.add(dto);
				
			}
			 
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}
		
		return array;
	}
	
	public BoardDto read(int boardNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto dto = null;

		try {
			
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			String sqlUpdate = "update board set read_count = read_count + 1 where board_number = ?";
			pstmt = conn.prepareStatement(sqlUpdate);
			
			pstmt.setInt(1, boardNum);
			
			int value = pstmt.executeUpdate();
			if(value > 0) JdbcUtil.close(pstmt);
			
			
			String sqlSelect = "select * from board where board_number = ?";
			pstmt = conn.prepareStatement(sqlSelect);
			
			pstmt.setInt(1, boardNum);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new BoardDto();
				
				dto.setBoardNum(rs.getInt("board_number"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				
				dto.setEmail(rs.getString("email"));
				dto.setContent(rs.getString("content"));
				dto.setPassword(rs.getString("password"));
				
				dto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				dto.setReadCnt(rs.getInt("read_count"));
				
				dto.setGroupNum(rs.getInt("group_number"));
				dto.setSequenceNum(rs.getInt("sequence_number"));
				dto.setSequenceLev(rs.getInt("sequence_level"));
				
				dto.setFileName(rs.getString("file_name"));
				dto.setPath(rs.getString("path"));
				dto.setFileSize(rs.getLong("file_size"));
			}
			
			conn.commit();
			
		} catch (SQLException e) {

			e.printStackTrace();
			JdbcUtil.rollback(conn);

		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}
		
		return dto;
	}
	
	public int delete(int boardNum, String password) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int value = 0;
		
		try {
			
			String sql = "delete board where board_number=? and password=?";
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNum);
			pstmt.setString(2, password);
			
			value = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return value;	
	}
	
	public BoardDto load(int boardNum) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto dto = null;

		try {
			
			conn = ConnectionProvider.getConnection();			
			
			String sql = "select * from board where board_number = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNum);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new BoardDto();
				
				dto.setBoardNum(rs.getInt("board_number"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setEmail(rs.getString("email"));
				dto.setContent(rs.getString("content"));
				dto.setPassword(rs.getString("password"));
				
				dto.setFileName(rs.getString("file_name"));
				dto.setPath(rs.getString("path"));
				dto.setFileSize(rs.getLong("file_size"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}
		
		return dto;
	}
	
	public int update(BoardDto dto, int boardNum, String password) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int value = 0;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			String sql = "update board set writer=?, title=?, email=?, content=? where board_number=? and password=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getContent());			
			
			pstmt.setInt(5, boardNum);
			pstmt.setString(6, password);
			
			value = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return value;	
	}
}