package com.java.fileBoard.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.java.fileBoard.model.BoardDto;
import com.java.fileBoard.model.BoardDao;
import com.java.command.Command;

/**
 * @날짜 : 2020. 7. 9 ~ 10
 * @author : 이다은
 */

public class WriteOkCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		logger.info(logMsg + "WriteOkCommand");
		
		request.setCharacterEncoding("utf-8");
		
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		logger.info(logMsg + pageNumber);

		DiskFileItemFactory factory = new DiskFileItemFactory(); // 파일보관 객체
		ServletFileUpload upload = new ServletFileUpload(factory); // 요청처리 객체

		List<FileItem> list = upload.parseRequest(request);

		Iterator<FileItem> iter = list.iterator();

		BoardDto dto = new BoardDto();
		HashMap<String, String> dataMap = new HashMap<String, String>();

		while (iter.hasNext()) { // 11개
			FileItem fileItem = iter.next();

			if (fileItem.isFormField()) {

				String name = fileItem.getFieldName();
				String value = fileItem.getString("utf-8");

				logger.info(logMsg + name + ", " + value);

				dataMap.put(name, value);

			} else {
				if (fileItem.getFieldName().equals("file")) {
					// 파일명 fileItem.getName() / 파일사이즈 fileItem.getSize(), getInputStream()

					if (fileItem.getName() == null || fileItem.getName().equals("")) continue;
					
					upload.setFileSizeMax(1024*1024*10);	// 10mb / byte*kb*mb*gb
					String fileName = System.currentTimeMillis() + "_" + fileItem.getName();
					
					// 절대 경로 - 쓰지 않음
					String dir = "C:\\delilah\\mvc\\workspace\\MVCHomePage\\WebContent\\pds\\";
					
					// 상대 경로 - 톰캣 실제 서버 경로 - 웹 서버 - 실무에서 사용하지 않음
					// String dir = request.getServletContext().getRealPath("\\pds\\");
					
					File file = new File(dir, fileItem.getName());
					
//					File dir = new File("C:\\pds\\");
//					dir.mkdir();
//					
//					File file = null;
//					if(dir.exists()&&dir.isDirectory()) {
//						file = new File(dir, fileName);
//					}
					
					logger.info(logMsg + dir);
					
					BufferedInputStream bis = null;
					BufferedOutputStream bos = null;

					try {
						bis = new BufferedInputStream(fileItem.getInputStream(), 1024);
						bos = new BufferedOutputStream(new FileOutputStream(file), 1024);


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
					
					dto.setFileName(fileName);
					dto.setFileSize(fileItem.getSize());
					dto.setPath(file.getAbsolutePath());
				}
			}
		}

		dto.setDataMap(dataMap);
		dto.setWriteDate(new Date());
		logger.info(logMsg + dto.toString());
		
		int check = BoardDao.getInstance().insert(dto);
		logger.info(logMsg + check);
		
		request.setAttribute("check", check);
		request.setAttribute("pageNumber", pageNumber);

		return "/WEB-INF/Views/fileBoard/writeOk.jsp";
	}
}