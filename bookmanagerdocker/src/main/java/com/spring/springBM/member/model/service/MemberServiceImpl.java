/**
 * @PackageName: bm.member.model.service
 * @FileName : MemberService.java
 * @Date : 2020. 4. 13.
 * @author 
 */
package com.spring.springBM.member.model.service;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import com.spring.springBM.member.model.dao.MemberDao;
import com.spring.springBM.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao mdao;
	
	@Autowired
	JavaMailSender mailSender;

	public int insertMember(Map<String,Object>commandMap) throws SQLException {
		
		int res = 0;
		res = mdao.insertMember(commandMap);
		return res;
	}
	
	public String idCheck(String id)   {
		
		String res = "";
		System.out.println("service : " + id);
		res = mdao.idCheck(id);
		return res;
	}
	
	public void mailSending(Map<String, Object> m) {
		
		 String setfrom = "killsky2014@naver.com";         
	     String tomail  = (String) m.get("m_email");     
		 String title = "사이트에 오신 것을 환영합니다";
	     
	    final String htmlBody = "<form action='http://"+m.get("urlPath")+"/member/joinimple.do' method='post'><h3>전송하기를 눌러 가입을 완료하세요</h3>"     
		   + "<input type='hidden' value='" +m.get("userId")+"' name='userId'>"
		   + "<input type='hidden' value='"+m.get("userPwd")+"' name='userPwd'>"
		   + "<input type='hidden' value='"+m.get("m_email")+"' name='m_email'>"
		   + "<input type='hidden' value='"+m.get("m_tell")+"' name='m_tell'>"
		   + "<button type='submit'>전송하기</form>";  
	    
		mailSender.send(new MimeMessagePreparator() {
			   public void prepare(MimeMessage mimeMessage) throws MessagingException {
			     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "utf-8");
			     message.setFrom(setfrom);
			     message.setTo(tomail);
			     message.setSubject(title);
			     message.setText(htmlBody, true);
			   }
			});
	  }
	
	public Member login(Map<String,Object> commadMap)   {
		
		Member res = null;
		res = mdao.login(commadMap);
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

