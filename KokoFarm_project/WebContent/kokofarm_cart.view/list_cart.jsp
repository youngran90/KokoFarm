<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>장바구니</h3>
	<h5>회원 번호 </h5>
	<table border="1">
		<tr>
			<th width="90"></th>
			<th width="150">상품명</th>
			<th width="200">배송종류</th>
			<th width="300">배송비</th>
			<th width="200">가격</th>
			<th width="100">수량</th>
			<th width="100">주문금액</th>
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				
			
			</tr>
		</c:forEach>
	</table>
</body>
</html>