/**
 * @PackageName: bm.book.model.dao
 * @FileName : BookDao.java
 * @Date : 2020. 4. 17.
 * @author 
 */
package com.spring.springBM.book.model.dao;

import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springBM.book.model.vo.Book;
 
@Repository
public class BookDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Book> selectBookList(String title){
		return sqlSession.selectList("BOOK.selectBookList", title);
	}
	
	public List<Book> selectInnerBookSearchList(Map<String, Object> commandMap){
		List<Book> res = sqlSession.selectList("BOOK.selectInnerBookSearchList",commandMap);
		return res;
	}
	
	public Book selectBook(int b_bno) {
		return sqlSession.selectOne("BOOK.selectBook",b_bno);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
