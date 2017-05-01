<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%request.setCharacterEncoding("utf-8"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입된 회원 목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="plugin/pagingplugin.js" type="text/javascript"></script>
</head>
<body>

	<h3>가입된 회원 정보들</h3>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr height = "30">
			<th width="120">아이디</th>
			<th width="120">이름</th>
			<th width="150">E-mail</th>
			<th width="150">전화번호</th>
			<th width="150">우편번호</th>
			<th width="400">주소1</th>
			<th width="400">상세주소</th>
			<th width="300">계좌번호</th>	
			<th width="200">가입일</th>
		</tr>
			
		<c:forEach var="member" items="${listModel.list }">
			<tr height="30">
				<td align="center" style="font-weight: bold">${member.member_id }</td>
				<td align="center" style="font-weight: bold">${member.member_name }</td>
				<td align="center" style="font-weight: bold">${member.member_email }</td>
				<td align="center" style="font-weight: bold">${member.member_phoneNum }</td>
				<td align="center" style="font-weight: bold">${member.member_zipcode }</td>
				<td align="center" style="font-weight: bold">${member.member_address1 }</td>
				<td align="center" style="font-weight: bold">${member.member_address2 }</td>
				<td align="center" style="font-weight: bold">${member.member_account }</td>
				<td align="center" style="font-weight: bold">${member.join_date }</td>
				
		
		</c:forEach>
		
	</table>
		<br><br>		
		<!-- 페이징 처리 영역 -->
	<!--  페이지당 글갯수, 총 글갯수, 총페이지 갯수, 시작페이지,마지막 페이지-->
	<!-- 현재 페이지, start_row, end_row -->
	
	<!-- 이전 -->
	<div align="center">
	
	<c:if test="${ listModel.startPage>5}">
		<a href="listMember.member?pageNum=${listModel.startPage-5 }">[이전]</a>
	</c:if>
	
	<c:forEach var="pageNum" begin="${listModel.startPage}" end ="${listModel.endPage}">
		<c:if test="${listModel.requestPage==pageNum }"><b></c:if>
			<a href= "listMember.member?pageNum=${pageNum}">[${pageNum}]</a>
		<c:if test="${listModel.requestPage==pageNum }"><b></c:if>
	</c:forEach>
	
	<c:if test="${listModel.endPage<listModel.totalPageCount }">
		<a href = "listMember.member?pageNum=${listModel.startPage+5}">[이후]></a>
	
	</c:if>
	
	</div>
	<!-- <div id="paging" align="center">
		<script type="text/javascript">
		$("#paging").paging({max:1});
		</script>
			
	</div>
	<br> -->
	
	
	
	<!-- 검색 -->
	<div align="center">
		<form action ="listMember.member" method="post" >
			<input type="hidden" name ="temp" value="temp"></input>
			<input type="checkbox" name = "area" value = "member_id">아이디
			<input type="checkbox" name = "area" value = "member_name">이름
			<input type = "checkbox" name = "area" value = "member_email">이메일
			<input type= "checkbox" name = "area" value = "member_phoneNum">전화번호
			<input type = "checkbox" name = "area" value = "member_address2">주소
			<input type = "checkbox" name = "area" value = "join_date">가입일
			<input type = "text" name ="searchKey" size = "40" align="middle">
			<input type="submit" value="검색">
		</form>
	</div>	

</body>
</html>