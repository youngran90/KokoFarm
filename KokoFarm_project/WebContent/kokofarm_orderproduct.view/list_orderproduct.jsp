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
	<header>
		<div id = "header">
		<jsp:include page="../Kokofarm_Main/mainheader.jsp" flush="false"></jsp:include>
		</div>
	</header>
	
	<section>
	
	<h4>주문내역</h4>
	<form action="AcitonCartList.cart" method="post">
		<input type="hidden" name="member_id" value="<%=session.getAttribute("member_id")%>">
		<input type="submit" value="제품목록">
	</form>
	<h4><a href="ActionRoutingOrderProduct.orderproduct">목록</a></h4>
	<h4>${member_id }</h4>
	<table border="1">
	<thead align="center">
		<tr>
			<td width="350">주문번호</td>
			<td width="350">제품번호</td>
			<td width="180">상품명</td>
			<td width="180">배송비</td>
			<td width="190">상품금액</td>
			<td width="170">수량</td>
			<td width="150">총 금액</td>
			</tr>
	</thead>
	<thead align="center">
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.order_no }</td>
				<td>${list.product_no }</td>
				<td>${list.product_name }</td>
				<td><fmt:formatNumber value="${list.delivery_price }" pattern="#,###" ></fmt:formatNumber> 원</td>
				<td><fmt:formatNumber value="${list.product_price }" pattern="#,###"></fmt:formatNumber> 원</td>
				<td>${list.product_amount }</td>
				<td><fmt:formatNumber value="${list.total_price }" pattern="#,###"></fmt:formatNumber> 원</td>
			</tr>
		</c:forEach>
	</thead>
	</table><br>
	</section>

	<footer>
		<div id="footer">
	   	<jsp:include page="../Kokofarm_Main/mainfooter.jsp"></jsp:include>
	   	</div>
   </footer>
   
</body>
</html>







