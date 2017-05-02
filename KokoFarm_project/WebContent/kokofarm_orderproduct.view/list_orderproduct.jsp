<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header><table border="1"  width="100%">헤더</table></header>
	<nav><table border="1" width="100%">네비</table></nav>
	<section>
	
	<h4>주문내역</h4>
	<form action="ActionRoutingOrderProduct.orderproduct" method="post">
		<input type="hidden" name="member_id" value="<%=session.getAttribute("member_id")%>">
		<input type="submit" value="제품목록">
	</form>
	<h4>${member_id }</h4>
	<table>
		<tr>
			<th>주문번호</th>
			<th>제품번호</th>
			<th>상품명</th>
			<th>상품금액</th>			
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.order_no }</td>
				<td>${list.product_no }</td>
				<td>${list.product_name }</td>
				<td>${list.product_price }</td>
			</tr>
		</c:forEach>
	</table><br>
	
		
	
	
	
	
	</section>
	<footer><table border="1" width="100%">푸터</table></footer>

	
</body>
</html>







