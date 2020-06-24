/**
 * @PackageName: com.spring.springBM.member.model.service
 * @FileName : MemberService.java
 * @Date : 2020. 5. 19.
 * @author 
 */
package com.spring.springBM.member.model.service;

import java.sql.SQLException;
import java.util.Map;

import com.spring.springBM.member.model.vo.Member;

/**
 * @PackageName: com.spring.springBM.member.model.service
 * @FileName : MemberService.java
 * @Date : 2020. 5. 19.
 * @author 
 */
public interface MemberService {
	
	int insertMember(Map<String, Object> commandMap) throws SQLException;
	
	String idCheck(String id);
	
	void mailSending(Map<String, Object> m);
	
	Member login(Map<String,Object> commadMap);
}
