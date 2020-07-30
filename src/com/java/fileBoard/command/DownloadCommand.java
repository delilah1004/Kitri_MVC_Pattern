package com.java.fileBoard.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;
import com.java.fileBoard.model.BoardDao;
import com.java.fileBoard.model.BoardDto;

public class DownloadCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		logger.info(logMsg + "DownloadCommand");

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		logger.info(logMsg + boardNum);
		
		BoardDto dto = BoardDao.getInstance().load(boardNum);
		logger.info(logMsg + dto);
		
		int index = dto.getFileName().indexOf("_") + 1;
		String fName = dto.getFileName().substring(index);
		String fileName = new String(fName.getBytes("utf-8"), "ISO-8859-1");

		long fileSize = dto.getFileSize();
		String path = dto.getPath();
		
		response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
		response.setContentType("application/octet-stream");
		response.setContentLengthLong(fileSize);
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(path), 1024);
			bos = new BufferedOutputStream(response.getOutputStream(), 1024);

			while (true) {
				int data = bis.read();
				if (data == -1)	break;
				
				bos.write(data);
			}
			
			bos.flush();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			if (bis != null) bis.close();
			if (bos != null) bos.close();
		}
		
		return null;
	}
}