/**
 * @PackageName: bm.book.model.service
 * @FileName : BookService.java
 * @Date : 2020. 4. 17.
 * @author 
 */
package com.spring.springBM.book.model.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.springBM.book.model.dao.BookDao;
import com.spring.springBM.book.model.vo.Book;

@Service
public class BookService {
	
	@Autowired
	BookDao bd;
	
	public List<Book> selectBookList(String title){
		
		List<Book> res = bd.selectBookList(title);
		return res;
	}
	
	public List<Book> selectInnerBookSearchList(Map<String, Object> commandMap){
		
		List<Book> res = bd.selectInnerBookSearchList(commandMap);
		return res;
	}
	
	public Book selectBook(int b_bno){
		
		Book book = bd.selectBook(b_bno);
		return book;
	}

}
