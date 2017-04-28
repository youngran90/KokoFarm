<%@page import="kokofarm.product.domain.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="kokofarm.product.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품상세리스트 출력</h2>
<table  border="1" cellpadding="0" cellspacing="0">

				<tr>
					<td>상품명</td>					
					<td>${product.product_name}</td>
				</tr>
			
				
				<tr>				
				<td>단위</td>
				<td>${product.product_unit}</td>
				</tr>
				
				<tr>
					<td>판매가</td>
					<td>${product.product_price}</td>
				</tr>
				
				<tr>
					<td>
					</td>
					<td>
						<input type="button" value="장바구니" onclick="location.href='list.jsp'"/>	
						<input type="button" value="즉시구매" onclick="location.href='orderproduct.jsp'"/>					
					</td>
				</tr>
				
				<tr>
					<td>수확일</td>
					<td><fmt:formatDate value="${product.product_harvestdate}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>	

				<tr>
					<td>대표이미지</td>
					<td><img  src="../upload/${product.product_sellerimage}"></td>
				</tr>		
				
				<tr>
					<td>상세이미지</td>
					<td><img  src="../upload/${product.product_mainimage}"></td>
				</tr>
				
				<tr>
					<td>판매자이미지</td>
					<td><img  src="../upload/${product.product_detailimage}"></td>
				</tr>
						
	
			<tr height="30">
				<td colspan="4" align="center">
				<input type="button" value="메인페이지" onclick="history.go(-1)">&nbsp;&nbsp; 
				<input type="button" value="취소">
				</td>
			</tr>
		</table>
		
	<h2>댓글</h2>		  
	<form action="PostInsertAction.product" method="post">
		 <input type="hidden" name="product_no" value="${product.product_no}"></input>
		<input type="hidden" name="member_id" size="10"></input>
		글내용:<input type="text" name="post_content" size="50"></input>
		 <input type="submit" value="저장">
	</form>

	<table>
		<c:if test="${post.product_no == product.product_no}">
			<c:forEach var="post" begin="0" end="${post. }"></c:forEach>
		
		</c:if>
	
	</table>

</body>
</html>