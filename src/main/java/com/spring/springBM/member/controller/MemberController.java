package com.spring.springBM.member.controller;


import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springBM.member.model.service.MemberService;
import com.spring.springBM.member.model.vo.Member;


@Controller
public class MemberController {
	
	@Autowired
	public MemberService ms;
	
	@RequestMapping("/member/join.do")
	// String으로 반환 : ModelAndView.setViewName("")
	//		앞에 'redirect:/' 붙일 경우  해당 경로로 리다이랙트 요청
	// ModelAndView.setViewName() : 해당 jsp호출
	// void : 요청온  url과 같은 이름의 jsp호출
	public String join() {
		return "/member/memberJoin";
		//return "redirect:/index/index.do";
	}
	
	@RequestMapping("/member/idcheck.do")  
	//Ajax처리
	//json으로 받고 json으로 돌려주는 거 해보기
	//jackson 라이브러리 설치
	//메소드에 @ResponseBody 로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은 View 를 통해서 
	//출력되지 않고 HTTP Response Body 에 직접 쓰여지게 된다.
	@ResponseBody
	public String idCheck(String userId) {
		return ms.idCheck(userId);
	}
	
	@RequestMapping("/member/joinemailCheck.do") 
	//@RequestParam(value="", required=boolean, defaultValue="")
	//value (Alias for name)	String	파라미터 이름
	//required	boolean	해당 파라미터가 반드시 필수인지 여부, 기본값은 true
	//defaultValue	String	해당 파라미터의 기본값
	public ModelAndView joinEmailCheck(@RequestParam Map<String, Object> commandMap, HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		String urlPath = request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		commandMap.put("urlPath",urlPath);
		
		ms.mailSending(commandMap);
		
		mav.addObject("alertMsg", "이메일로 인증번호가 발송 되었습니다.");
		mav.addObject("url", "index/index.do");
		mav.setViewName("common/result");
		
		return mav;
	}
	
	@RequestMapping("/member/joinimple.do")
	public ModelAndView joinImple(@RequestParam Map<String,Object> commandMap) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		int res = ms.insertMember(commandMap);
		System.out.println(commandMap);
		if(res < 1) {
			mav.setViewName("/member/memberJoin");
		}else {
			mav.setViewName("/member/joinComplete");
		}
		
		return mav;
	}
	
	@RequestMapping("/member/login.do")
	public ModelAndView logIn(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/login");
		return mav;
	}
	
	@RequestMapping("/member/loginimple.do")
	public ModelAndView logInImple(@RequestParam Map<String,Object> commadMap, HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		Member res = ms.login(commadMap);
		System.out.println(res);
		if(res == null) {
			
			mav.addObject("reCheck", "true");
			mav.addObject("msg", "true");
			mav.setViewName("/member/login");
		}else {
			session.setAttribute("logInInfo", res);
			mav.setViewName("/index/index");
		}
		
		return mav;
	}

	
	@RequestMapping("/member/logout.do")
	public ModelAndView logOut(HttpSession session) {
	
		ModelAndView mav = new ModelAndView();
		System.out.println(session.getAttribute("logInInfo"));
		session.removeAttribute("logInInfo");
		System.out.println(session.getAttribute("logInInfo"));
		mav.setViewName("/index/index");
		return mav;
	}

}
