package com.java.board.model;

import java.util.Date;

/**
 * @날짜 : 2020. 7. 7.
 * @author: 이다은
 */

public class BoardDto {
	private int boardNum;
	private int groupNum;
	private int sequenceNum;
	private int sequenceLev;
	
	private String writer;
	private String title;
	private String email;
	private String content;
	private String password;
	
	private Date writeDate;

	private int readCnt;

	public BoardDto() {

	}

	public BoardDto(int boardNum, int groupNum, int sequenceNum, int sequenceLev, String writer, String title,
			String email, String content, String password, int readCnt, Date writeDate) {
		this.boardNum = boardNum;
		this.groupNum = groupNum;
		this.sequenceNum = sequenceNum;
		this.sequenceLev = sequenceLev;
		this.writer = writer;
		this.title = title;
		this.email = email;
		this.content = content;
		this.password = password;
		this.writeDate = writeDate;
		this.readCnt = readCnt;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}

	public int getSequenceNum() {
		return sequenceNum;
	}

	public void setSequenceNum(int sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public int getSequenceLev() {
		return sequenceLev;
	}

	public void setSequenceLev(int sequenceLev) {
		this.sequenceLev = sequenceLev;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	@Override
	public String toString() {
		return "BoardDto [boardNum=" + boardNum + ", groupNum=" + groupNum + ", sequenceNum=" + sequenceNum
				+ ", sequenceLev=" + sequenceLev + ", writer=" + writer + ", title=" + title + ", email=" + email
				+ ", content=" + content + ", password=" + password + ", writeDate=\" + writeDate + , readCnt=" + readCnt + "]";
	}

}