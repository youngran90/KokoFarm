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
	<table>
		<tr>
			<th>제품번호</th>
			<th>상품명</th>
			<th>단위</th>
			<th>가격</th>
			<th>등록일</th>
			
		</tr>
	
			<c:forEach var="list" items="${list }">
			
			<tr>
				<form action="ActionCartListInsert.cart" method="post">
					<td>${list.product_no }</td>
					<td>${list.product_name }</td>
					<td>${list.product_unit }</td>
					<td>${list.product_price }</td>
					<td><fmt:formatDate value="${list.product_date }" pattern="yyyy-MM-dd"/></td>
					<td><input type="checkbox" name="check" value="${list.product_no }"></td>
			</tr>
			</c:forEach>
			<tr>
				<input type="submit" value="장바구니 담기">&nbsp;&nbsp;&nbsp;
			</tr>
			<tr>
				<a href="insert_product.jsp">제품 등록</a>
			</tr>
			</form>
	</table>
</body>
</html>
