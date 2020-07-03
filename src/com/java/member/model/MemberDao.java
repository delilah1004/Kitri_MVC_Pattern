package com.java.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.database.ConnectionProvider;
import com.java.database.JdbcUtil;

/**
 * @날짜 : 2020. 7. 2.
 * @author: 이다은
 */

public class MemberDao { // Data Access Object

	// Singleton Pattern : 단 한개의 객체만을 가지고 구현(설계)한다.

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}

	public int insert(MemberDto dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int value = 0;

		try {

			conn = ConnectionProvider.getConnection();
			String sql = "insert into member values(member_num_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getJumin1());
			pstmt.setString(5, dto.getJumin2());

			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getZipcode());
			pstmt.setString(8, dto.getAddress());
			pstmt.setString(9, dto.getJob());
			pstmt.setString(10, dto.getMailing());

			pstmt.setString(11, dto.getInterest());
			pstmt.setString(12, dto.getMemberLevel());

			// registerDate와 num은 db에서 자동 추가, 나머지는 java에서 추가

			value = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}

		return value;
	}

	public int idCheck(String id) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int value = 0;

		try {

			conn = ConnectionProvider.getConnection();
			String sql = "select id from member where id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next())
				value = 1;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}

		return value;
	}

	public ArrayList<ZipcodeDto> dongSearch(String dongName) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ZipcodeDto> arrayList = null;

		try {

			String sql = "select * from zipcode where dong like '%' || ? || '%'";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dongName);

			rs = pstmt.executeQuery();

			arrayList = new ArrayList<ZipcodeDto>();
			while (rs.next()) {
				ZipcodeDto dto = new ZipcodeDto();
				dto.setZipcode(rs.getString("zipcode"));
				dto.setSido(rs.getString("sido"));
				dto.setGugun(rs.getString("gugun"));
				dto.setDong(rs.getString("dong"));
				dto.setRi(rs.getString("ri"));
				dto.setBunji(rs.getString("bunji"));
				arrayList.add(dto);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
			JdbcUtil.close(rs);
		}

		return arrayList;
	}

	public String[] loginCheck(String id, String password) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String[] value = new String[2];

		try {

			String sql = "select member_level, name from member where id = ? and password = ?";
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				value[0] = rs.getString("member_level");
				value[1] = rs.getString("name");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			JdbcUtil.close(conn);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}

		return value;
	}

}
