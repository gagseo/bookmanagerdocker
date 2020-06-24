package com.spring.springBM.board.model.dao;

import java.sql.*;
import java.util.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.springBM.board.model.vo.Notice;
import common.util.Paging;

@Repository
public class NoticeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public NoticeDao(){}
	
	public int insertNotice(Notice n){
		return sqlSession.insert("Notice.insertNotice", n);
	}
	
	public int insertFile(Map<String, Object> m) {
		return sqlSession.insert("Notice.insertFile",m);
	}
	
	public List<Map> selectFile(int noticeNo) {
		return sqlSession.selectList("Notice.selectFile",noticeNo);
	}
	

}







