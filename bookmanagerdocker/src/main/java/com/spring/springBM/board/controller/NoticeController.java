package com.spring.springBM.board.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springBM.board.model.service.NoticeService;
import com.spring.springBM.board.model.vo.Notice;
import com.spring.springBM.member.model.vo.Member;

/**
 * @PackageName: bm.notice.controller
 * @FileName : NoticeController.java
 * @Date : 2020. 4. 20.
 * @author 
 */

@Controller
public class NoticeController{
	
	@Autowired
	private NoticeService ns;
	
	@RequestMapping("notice/noticewrite.do")
	public ModelAndView noticeWrite(HttpServletRequest request) throws IOException {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/boardForm");
		return mav;
	}
	
	@RequestMapping("notice/noticeupload.do")
	public ModelAndView noticeUpload(Notice notice
			, @RequestParam(required=false) List<MultipartFile> files,
			  HttpServletRequest request
			){
		
		ModelAndView mav = new ModelAndView();
		String root = request.getSession().getServletContext().getRealPath("/");
		List<Map<String,Object>> fileData = new ArrayList<Map<String,Object>>();
		
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("logInInfo");
		notice.setNoticeWriter(m.getUserId());
		
		for(MultipartFile mf : files) {
			String savePath = root + "resources/upload/";
			String originFileName = mf.getOriginalFilename();
		
			HashMap<String,Object> map = new HashMap<>();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			
			String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
			+ originFileName.substring(originFileName.lastIndexOf(".") + 1);
			
			savePath += renameFileName;
			
			map.put("originFileName", originFileName);
			map.put("renameFileName", renameFileName);
			map.put("savePath", savePath);
			map.put("file",mf);
			
			fileData.add(map);
		}
		
		ns.insertNotice(notice, fileData);
		
		mav.setViewName("board/boardList");
		return mav;
	}
	
	@RequestMapping("notice/noticedelete.do")
	public ModelAndView noticeDelete(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}








