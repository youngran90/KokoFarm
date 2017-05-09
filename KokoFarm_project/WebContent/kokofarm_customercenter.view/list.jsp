<%@page import="kokofarm.customercenter.domain.SearchCustomer"%>
<%@page import="kokofarm.customercenter.domain.BoardDTO"%>
<%@page import="kokofarm.customercenter.domain.ListModel"%>
<%@page import="java.util.List"%>
<%@page import="kokofarm.customercenter.service.BoardService"%>
<%@page import="kokofarm.customercenter.persistence.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<header>
<div id = "header">
<jsp:include page="../Kokofarm_Main/mainheader.jsp"></jsp:include>
</div>
</header>



	<h3>목록보기</h3>
	<input type="button" value="문의하기" onclick="location.href='insert_form.jsp'">
	
	<table border="1" cellpadding="0" cellspacing="0">
		<tr height="30">
			<th width="50">번호</th>
			<th width="350">제목</th>
			<th width="150">작성자</th>
			<th width="150">작성일</th>
			<th width="100">조회수</th>		
		</tr>
<%-- 		<c:forEach var="boarddto" items="${list }"> --%>
		<c:forEach var="boarddto" items="${listModel.list }">

		<tr height="30">
			<td align="center">${boarddto.customer_no}</td>
		
			<td align="left">  <!-- 들여쓰기 -->
			<c:if test="${boarddto.customer_level > 0}">
				<c:forEach var="k" begin="0" end="${boarddto.customer_level }">&nbsp;&nbsp;
				</c:forEach>
					<img src="../kokofarm_customercenter.view/images/AnswerLine.gif">
			</c:if>
			<a href="DetailAction.gogo?customer_no=${boarddto.customer_no}">${boarddto.customer_title}</a>
			</td>
			<td align="center">${boarddto.member_id }</td>
 			<td align="center">${boarddto.customer_date }
 		<%-- 	<fmt:formatDate value="${board.customer_date }" pattern="yyyy-MM-dd"/> --%>
 		
			</td>
			<td align="center">${boarddto.customer_hitcount }</td>
		</tr>		
		</c:forEach>
	
	</table>
	<br><br>
	
  <!-- 페이지 처리 영역 -->
   <!-- 페이지 당 글갯수, 총 글갯수, 총 페이지갯수, 시작페이지, 마지막페이지-->
   <!-- 현재페이지, start_row, end_row -->

	<!-- 이전 -->
	<c:if test = "${listModel.startPage > 5 }">
	<a href = "listAction.gogo?pageNum=${listModel.startPage -5 }">[이전]</a>
	</c:if>
	
	<!-- 페이지목록 -->
	<c:forEach var="pageNo" begin="${listModel.startPage }"
		end="${listModel.endPage }">
		<c:if test="${listModel.requestPage == pageNo }"><b></c:if>	 <!-- 현재누른페이지 진하게 -->
		<a href = "listAction.gogo?pageNum=${pageNo }">[${pageNo }]</a>	 <!-- 2페이지에서 search된 값이 못 오는 오류해결~ -->
		<c:if test="${listModel.requestPage == pageNo }"></b></c:if>
	</c:forEach>

	
	<!-- 이후  -->
	<c:if test="${listModel.endPage < listModel.totalPageCount}">
	<a href = "listAction.gogo?pageNum=${listModel.startPage + 5 }">[이후]</a> <!-- startpage + 5 -->
	</c:if>


<br><br>
<form action="listAction.gogo" method = "post">
<!-- 	<form action="/kokofarm_customercenter.view/list.jsp" method="post"> -->
		<input type="hidden" name="temp" value="temp"></input>
		<input type="checkbox" name="area" value="customer_title"/>제목
		<input type="checkbox" name="area" value="member_id"/>이름
		<input type="text" name="searchKey" size="10"/>
		<input type="submit" value="검색"/>		
<!-- 		<input type="button" value="전체목록" onclick="location.href='listAction.gogo'"> -->
	</form>
	
<footer>
<div id = "footer">
   <jsp:include page="../Kokofarm_Main/mainfooter.jsp"></jsp:include>
</div>
</footer>
	</body>
</html>