/**
 * @PackageName: bm.member.model.dao
 * @FileName : MemberDao.java
 * @Date : 2020. 4. 13.
 * @author 
 */
package com.spring.springBM.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.springBM.member.model.vo.Member;

@Repository
public class MemberDao {

	@Autowired
	SqlSessionTemplate session;
	
	public int insertMember( Map<String,Object> commandMap) {
		return session.insert("MEMBER.insertMember", commandMap);
	}
	
	public String idCheck(String id) {
		return session.selectOne("MEMBER.selectId", id);
	}
	
	public Member login(Map<String,Object> commadMap)  {
		System.out.println(commadMap);
		return session.selectOne("MEMBER.selectMember", commadMap);
	}
}
