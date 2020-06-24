<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<header class="header-section">
 		<div class="top">
			<div class="top-logo"><a class="top-logo-text" href="<%= request.getContextPath() %>/index/index.do">UCLASS</a></div>
				<div class="top-search"> 
					<input Type ="text" class="input-top-search" placeholder="검색어를 입력하세요"/>
					<button value="" class="btn-top-search"><i class="fas fa-search" style="color:black"></i></button>
				</div>
			<c:if test="${logInInfo == null}">
			<div class="top-user">
				<a class="top-user-join" href="<%=request.getContextPath()%>/member/join.do">회원가입</a>
				<a class="top-user-login" href="<%=request.getContextPath()%>/member/login.do">Login</a>
			</div>
			</c:if>
			<c:if test="${logInInfo != null}">
			<div class="top-user">
				<a class="top-user-join" href="<%=request.getContextPath()%>/member/logout.do">Logout</a>
				<a class="top-user-login" href="<%=request.getContextPath()%>/mypage/mypage.do">MyPage</a>
			</div>
			</c:if>
 		</div>
	</header>