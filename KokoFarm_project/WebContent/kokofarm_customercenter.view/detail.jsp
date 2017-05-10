<%@page import="kokofarm.customercenter.domain.BoardDTO"%>
<%@page import="kokofarm.customercenter.persistence.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% request.setCharacterEncoding("utf-8"); %>  
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "../kokofarm_customercenter.css/all.css" type="text/css"/>

</head>
<body>
<header>
<div id = "header">
<jsp:include page="../Kokofarm_Main/mainheader.jsp"></jsp:include>
</div>
</header>


<div class = "container" id="center_container">


	<h3>문의내용</h3>
	<table border ="1" id="table3" cellpadding="0" cellspacing="0">
		
		<tr height ="30">
			<td width = "150">번호</td>
			<td width = "150">${boarddto.customer_no}</td>
			<td width = "150">조회수</td>
			<td width = "150">${boarddto.customer_hitcount}</td>
		</tr>
		<tr height ="30">
			<td width = "150">작성자</td>
			<td width = "150">${boarddto.member_id}</td>
			<td width = "150">작성일</td>
			<td width = "150">${boarddto.customer_date}</td>
		</tr>
		<tr height ="30">
			<td width = "150">제목</td>
			<td colspan="3">${boarddto.customer_title}</td>
		</tr>
<%-- 	나중에 추가하기// 파일 _ 0509	
		<tr height ="30">
			<td width = "150">파일</td>
			<td colspan="3">
			<a href="download.jsp?filename=${boarddto.customer_fname }">${boarddto.customer_fname }</a>
			</td>
		</tr>
		 --%>
		
		<tr height ="30">
			<td width = "150">내용</td>
			<td colspan="3">${boarddto.customer_content}</td>
		</tr>
	</table>
	
	
	<div id = "selectmenu">
	<a href = "UpdateFormAction.gogo?customer_no=${boarddto.customer_no}">수정</a>
	<a href = "deleteAction.gogo?customer_no=${boarddto.customer_no}">삭제</a>

	<%-- 나중에 수정하기_0509!!! 답변달기

	<a href = "replyAction.gogo?customer_no=${boarddto.customer_no}">reply진짜답변달기</a>	
	
	<a href = "InsertAction.gogo?customer_no=${boarddto.customer_no}">insert답변달기</a>	
	<a href = "/kokofarm_customercenter.view/insert_form.jsp?customer_no=${boarddto.customer_no}">insertjsp답변달기2</a>
		
 	 --%>
 
	<a href="listAction.gogo">목록보기</a>
   </div>
   
   
  </div> 


<footer>
<div id = "footer">
   <jsp:include page="../Kokofarm_Main/mainfooter.jsp"></jsp:include>
</div>
</footer>   
</body>
</html>