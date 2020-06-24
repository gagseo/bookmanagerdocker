package com.spring.springBM.book.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springBM.book.model.service.BookService;
import com.spring.springBM.book.model.vo.Book;

@Controller
public class BookController {
	     
	@Autowired
	BookService bs;
	
	@RequestMapping("/book/search.do")
	public ModelAndView searchBookList(String b_title) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		List<Book> res = bs.selectBookList(b_title);
		mav.addObject("booklist", res);
		mav.setViewName("book/booksearch");
		return mav;
		
	}
	
	@RequestMapping("/book/innersearch.do")
	public ModelAndView innerSearchBook(
			@RequestParam Map<String, Object> commandMap,
			String[] bnoList
			) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println(">>>" + commandMap);
		System.out.println(Arrays.toString(bnoList));
		commandMap.put("bnoList",bnoList);
		
		List<Book> res = bs.selectInnerBookSearchList(commandMap);
		
		mav.addObject("booklist", res);
		mav.setViewName("book/booksearch");
		return mav;
	}
	
	@RequestMapping("/book/detail.do")
	public ModelAndView searchBook(int b_bno) throws Exception {
		ModelAndView mav = new ModelAndView();
		Book b = bs.selectBook(b_bno);
		mav.addObject("book", b);
		mav.setViewName("book/bookDetail");
		return mav;
	}
}
