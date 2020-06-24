<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/header.jsp" %>
</head>
<body>
<%@include file="../include/top.jsp" %>
<%@include file="../include/floatDiv.jsp" %>
 <div class="content">
	<section class="middle"> 		
		<div class="site-title-wrapper">
	 		<div class="site-main">
				<div class="site-title">U CLASS 도서관 </div>
					<div class="site-search">
						<form action="<%=request.getContextPath()%>/book/search.do">
						<div class="btn-search"><p>검색</p></div>			
						<input Type ="text" name="b_title" placeholder="검색어를 입력하세요">
						<button value="" class="icon-search"><i class="fas fa-search" style="color:black"></i></button>
					</form>
				</div>
	 		</div>
	 	</div>
 	</section>
 	<nav class="planshop">
			<div class="planshop-menu">
				<div class="ps-1">
				<a href="<%=request.getContextPath()%>/notice/noticelist.do"><i class="far fa-clipboard"></i>
				<p>공지사항</p></a>
				</div>
				<div class="ps-2">
				<i class="fas fa-search-plus"></i>
				<p>도서검색</p>
				</div>
				<div class="ps-3">
				<i class="far fa-question-circle"></i>
				<p>QnA</p>
				</div>
				<div class="ps-4">
				<i class="fas fa-users"></i>
				<p>AboutUs</p>
				</div>
			</div>
	</nav> 
	<section class="book">
		<div class="book-wrapper">
		<div class="book-box">
			<div class="book-box-title"><span>이번 주 인기 도서</span></div>
			<div class="book-line">
			<c:forEach begin="1" end="5">
				<div class="book-item">
					<div class="book-img">
						<img src="<%=request.getContextPath()%>/resources/image/Nudge.jpg">
					</div>
					<div class="book-title">Nudge<br>작가:리처드탈러</div>
					<div class="book-use" id="book-use">
						<div><a href="<%=request.getContextPath()%>/book/rentbook.do">대출</a></div>
						<div><a href="<%=request.getContextPath()%>/book/detail.do">상세보기</a></div>
					</div>
				</div>
			</c:forEach>
			</div>
			<div class="book-box-title"><span>스테디셀러</span></div>
			<div class="book-line">
			<c:forEach begin="1" end="5">
				<div class="book-item">
					<div class="book-img">
						<img src="<%=request.getContextPath()%>/resources/image/Nudge.jpg">
					</div>
					<div class="book-title">Nudge<br>작가:리처드탈러</div>
					<div class="book-use" id="book-use">
						<div><a href="<%=request.getContextPath()%>/book/rentbook.do">대출</a></div>
						<div><a href="<%=request.getContextPath()%>/book/detail.do">상세보기</a></div>
					</div>
				</div>
			</c:forEach>
			</div>
			<div class="book-box-title"><span>새로 들어온 책</span></div>
			<div class="book-line">
			<c:forEach begin="1" end="5">
				<div class="book-item">
					<div class="book-img">
						<img src="<%=request.getContextPath()%>/resources/image/Nudge.jpg">
					</div>
					<div class="book-title">Nudge<br>작가:리처드탈러</div>
					<div class="book-use" id="book-use">
						<div><a href="<%=request.getContextPath()%>/book/rentbook.do">대출</a></div>
						<div><a href="<%=request.getContextPath()%>/book/detail.do">상세보기</a></div>
					</div>
				</div>
			</c:forEach>
			</div>
			<div class="book-box-title"><span>최근 대출 도서</span></div>
			<div class="book-line">
			<c:forEach begin="1" end="5">
				<div class="book-item">
					<div class="book-img">
						<img src="<%=request.getContextPath()%>/resources/image/Nudge.jpg">
					</div>
					<div class="book-title">Nudge<br>작가:리처드탈러</div>
					<div class="book-use" id="book-use">
						<div><a href="<%=request.getContextPath()%>/book/rentbook.do">대출</a></div>
						<div><a href="<%=request.getContextPath()%>/book/detail.do">상세보기</a></div>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
		</div>
	 </section>
	 <footer class="bottom">bottom</footer>
</div>

<script>
	
	document.querySelectorAll('.productItem').forEach(function(v){
		v.addEventListener('mouseover',function(){
			v.lastElementChild.style.display = 'block';
		})
		
		v.addEventListener('mouseout',function(){
			v.lastElementChild.style.display = 'none';
		})
	})


</script>



</body>
</html>
