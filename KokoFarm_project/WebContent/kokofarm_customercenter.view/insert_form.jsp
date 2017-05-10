<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% 
			String member_id = (String)session.getAttribute("member_id");
    %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>문의하기</title>
<link rel = "stylesheet" href = "../kokofarm_customercenter.css/all.css" type="text/css"/>
</head>

<body>

<header>
<div id = "header">
<jsp:include page="../Kokofarm_Main/mainheader.jsp"></jsp:include>
</div>
</header>


<div class = "container" id="center_container">


<h3>문의하기</h3>
<hr>
<form action="insertAction.gogo" method="post">	
<!-- hidden부분 수정필요  -->
<%-- 	<input type="hidden" name="customer_no" value = "${customer_no}">
	<input type="hidden" name="customer_ref" value = "${customer_ref }">
	<input type="hidden" name="customer_step" value = "${customer_step}">
	<input type="hidden" name="customer_level" value = "${customer_level}">  
 --%>

<table border = "1" id="table3" cellpadding="0" cellspacing="0">
	<thead></thead>
	<tr height = "30">
		<td width = "150">이름</td>
		<td width = "150">
		<input type="text" name="member_id" size="20" value = ${member_id } readonly="readonly">
		</td>
		<td width = "150">비밀번호</td>
		<td width = "150">
		<input type="password" name="customer_pwd" size="20">
		</td>
	</tr>
	<tr height="30">
		<td width="150">제목</td>
		<td align = "left" colspan="3">
			<c:choose >
				<c:when test= "${param.customer_no == null }">
					<input type="text" name="customer_title" size="70">	
				</c:when>
				<c:otherwise>
					<input type="text" name="customer_title" size="70"
						value="[re]: ${boarddto.customer_title }">	
				</c:otherwise>			
			</c:choose>
			</td>
	</tr>
<!-- 	
	<tr height="30">
		<td width="150">파일</td>
	</tr>
	 -->
	<tr height="30">
		<td width="150">내용</td>
		<td colspan="4">
				<textarea rows="10" cols="72" name="customer_content"></textarea>
			</td>
	</tr>

</table>

	<div id = insertmenu>
	<input type="submit" value="작성완료">
	<input type="reset" value="작성취소">
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








