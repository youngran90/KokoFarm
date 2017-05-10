<%@page import="kokofarm.customercenter.domain.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="kokofarm.customercenter.persistence.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <% request.setCharacterEncoding("utf-8"); %>  
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


	
	<h3>문의수정</h3>
	
	<form action="updateAction.gogo?customer_no=${boarddto.customer_no} " method="post">
	
		<table border="1" id="table3" cellpadding="0" cellspacing="0">
		<tr height="30">
			<td width="150">작성자</td>
			<td width="150">
				<input type="text" name="member_id" size="20" value="${boarddto.member_id }"></input>
			</td>
			<%-- <td width="150">비밀번호</td>
			<td width="150">
				<input type="password" name="b_pwd" value="" size="20" >
				<input type="hidden" name="pwd" value="${board.b_pwd}">
			</td> --%>		
		</tr>
		<tr height="30">
			<td width="150">제목</td>
			<td align="left" colspan="3">
				<input type="text" name="customer_title" value="${boarddto.customer_title }" size="50">		
			</td>			
		</tr>	
<!-- 	파일나중에 추가하기 _ 0509	
		<tr height="30">
			<td width="150">파일</td>
		</tr>
	 -->	
		<tr height="30">
			<td width="150">내용</td>		
			<td colspan="4">
				<textarea rows="10" cols="72" name="customer_content" value="">${boarddto.customer_content }</textarea>
			</td>			
		</tr>
	</table>
	

	<div id = "updatemenu">
	<input type="submit" value="수정완료">
	<input type="reset" value="수정취소">
	<input type="button" value="목록보기" onclick="location.href='listAction.gogo'">
	</div>
	
	</form>

</div>


<footer>
<div id = "footer">
   <jsp:include page="../Kokofarm_Main/mainfooter.jsp"></jsp:include>
</div>
</footer> 
</body>
</html>