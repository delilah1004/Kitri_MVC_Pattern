package com.java.fileBoard.model;

import java.util.Date;
import java.util.HashMap;

/**
 * @날짜 : 2020. 7. 10.
 * @author : 이다은
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
	
	private String fileName;
	private String path;
	private long fileSize;
	
	private HashMap<String, String> dataMap;

	public BoardDto() {

	}

	public BoardDto(int boardNum, int groupNum, int sequenceNum, int sequenceLev, String writer, String title,
			String email, String content, String password, Date writeDate, int readCnt, String fileName, String path,
			int fileSize) {
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
		this.fileName = fileName;
		this.path = path;
		this.fileSize = fileSize;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public HashMap<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(HashMap<String, String> dataMap) {
		this.dataMap = dataMap;
		
		setBoardNum(Integer.parseInt(dataMap.get("boardNum")));
		setGroupNum(Integer.parseInt(dataMap.get("groupNum")));
		setSequenceNum(Integer.parseInt(dataMap.get("sequenceNum")));
		setSequenceLev(Integer.parseInt(dataMap.get("sequenceLev")));
		setWriter(dataMap.get("writer"));
		setTitle(dataMap.get("title"));
		setEmail(dataMap.get("email"));
		setContent(dataMap.get("content"));
		setPassword(dataMap.get("password"));
	}

	@Override
	public String toString() {
		return "BoardDto [boardNum=" + boardNum + ", groupNum=" + groupNum + ", sequenceNum=" + sequenceNum
				+ ", sequenceLev=" + sequenceLev + ", writer=" + writer + ", title=" + title + ", email=" + email
				+ ", content=" + content + ", password=" + password + ", writeDate=" + writeDate + ", readCnt="
				+ readCnt + ", fileName=" + fileName + ", path=" + path + ", fileSize=" + fileSize + "]";
	}

}