<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kokofarm.register.model.RegDto"%>  
<%@page import="kokofarm.register.model.RegDao"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../reg_view/css/reg_list.css" rel="stylesheet" type="text/css">
<title>코코팜::상품 리스트</title>

</head>
<body>
<%@include file="../Kokofarm_Main/mainheader.jsp"%>
	<div id="reg_list">
		<div id="reg_list_title"><h1>채소</h1></div>
		<input type="button" value="상품등록하기" id="into_reg" onclick="location.href='start.reg'">  <!-- 판매자페이지 -->
		<div id="reg_list_inner">
				<ul class="reg_ul">
				<c:forEach var="regDto" items="${regList }">
				<li class="reg_li">
					<!-- <p>TIMER</p> -->
					<a href="reg_detail.reg?auction_no=${regDto.auction_no }"><img src="../${regDto.auction_file }"></a>
					<div class="list_con">
					<p><a href="reg_detail.reg?auction_no=${regDto.auction_no }">${regDto.auction_name}</a></p>
					<p>상한가 : ${regDto.auction_up }</p>
					<p>하한가 : ${regDto.auction_down }</p>
					</div>
				</li>
				</c:forEach>
				</ul>
		</div>
		
			
		<!-- <div class="reg_paging">
			페이징처리
			<c:if test="${regPage.startPage > 5 }">
			<a href="list.jsp?pageNum=${regPage.startPage-5}">◀</a> 
		</c:if>
			페이지목록
		<c:forEach var="pageNo" begin="${regPage.startPage }" end="${regPage.endPage }">
			<c:if test="${regPage.requestPage == pageNo }"><b></c:if>
			<a href="list.jsp?pageNum=${pageNo }">${pageNo }</a>
			<c:if test="${regPage.requestPage == pageNo }"></b></c:if>
		</c:forEach>
			다음페이지
		<c:if test="${regPage.endPage < regPage.totalPageCount }">
			<a href="list.jsp?pageNum=${regPage.startPage+5}">▶</a>
		</c:if>
		</div> -->
	</div>
<%@include file="../Kokofarm_Main/mainfooter.jsp"%>
</body>
</html>