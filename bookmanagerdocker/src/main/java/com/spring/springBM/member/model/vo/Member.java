package com.spring.springBM.member.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Member implements Serializable{
	private static final long serialVersionUID = -2700043316630603579L;
	
	public static Member userInfo;
	
	private String userId;
	private String password;
	private int grade;
	private String tell;
	private Date regDate;
	private Date rentableDate;
	
	public Member() {
		
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/**
	 * @return the tell
	 */
	public String getTell() {
		return tell;
	}

	/**
	 * @param tell the tell to set
	 */
	public void setTell(String tell) {
		this.tell = tell;
	}

	/**
	 * @return the regDate
	 */
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	/**
	 * @return the rentableDate
	 */
	public Date getRentableDate() {
		return rentableDate;
	}

	/**
	 * @param rentableDate the rentableDate to set
	 */
	public void setRentableDate(Date rentableDate) {
		this.rentableDate = rentableDate;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", grade=" + grade + ", tell=" + tell
				+ ", regDate=" + regDate + ", rentableDate=" + rentableDate + "]";
	}
	
	
	
}
