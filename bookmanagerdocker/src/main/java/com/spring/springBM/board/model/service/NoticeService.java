package com.spring.springBM.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.spring.springBM.board.model.dao.NoticeDao;
import com.spring.springBM.board.model.vo.Notice;


@Service
public class NoticeService {
	
	@Autowired
	NoticeDao ndao;
	
	public NoticeService(){}
	
	public int insertNotice(Notice n, List<Map<String, Object>> fileData){

		int result = ndao.insertNotice(n);
		insertFile(fileData);
		return result;
	}
	
	public boolean insertFile(List<Map<String, Object>> fileData) {
	
		for(Map<String,Object> m : fileData) {
			
			ndao.insertFile(m);
			MultipartFile mf = (MultipartFile) m.get("file");
			System.out.println(m.get("savePath"));
			File f = new File((String)m.get("savePath"));
			
			try {
				mf.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
}
