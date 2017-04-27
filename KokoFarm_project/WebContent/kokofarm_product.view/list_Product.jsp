<%@page import="kokofarm.product.domain.ListProductPage"%>
<%@page import="kokofarm.product.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    <%
    request.setCharacterEncoding("utf-8");

	String pageNum = request.getParameter("pageNum");
	if(pageNum == null){
		pageNum = "1";
		
	}
	int requestPage = Integer.parseInt(pageNum);
	
	ProductService service = ProductService.getInstance();
    ListProductPage listModel = service.listProductService(request, requestPage);    		

    request.setAttribute("listModel", listModel);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>상품리스트 출력</h2>
<table border="1" cellpadding="0" cellspacing="0">
			<tr height="80" align="center">
				<td width="200">메인사진</td>
				<td width="200">상품이름</td>
				<td width="200">상품단위</td>
				<td width="200">상품가격</td>
			</tr>
	
		<c:forEach var="product" items="${listModel.list}">
		<tr height="200" align ="center" >
		<td>
		<c:if test="${product.product_mainimage != null }">
				<c:set var="pattern" value="${fn:substring(product.product_mainimage, fn:length(product.product_mainimage)-4, fn:length(product.product_mainimage))}"></c:set>
				<c:choose>
					<c:when test="${pattern eq '.jpg' || pattern eq '.gif'}">
						<a href ="detailProdutAction.product?product_no=${product.product_no}" style="text-decoration: none"" ><img  src="../upload/small_${product.product_mainimage}"></a>
					</c:when>
					<c:otherwise>
						<c:out value="NO IMAGE"></c:out>
					</c:otherwise>
				</c:choose>
			</c:if>
			
			</td>	
			<td><a href="detailProdutAction.product?product_no=${product.product_no}" style="text-decoration: none">${product.product_name}</a></td>
			<td>${product.product_unit}</td>
			<td>${product.product_price}</td>
		</tr>
			</c:forEach>
			
			<!-- 이전 -->
	<c:if test="${listModel.startPage > 5}">
		<a href="list.jsp?pageNum=${listModel.startPage -5 }">[이전]</a>
	</c:if>
	
	<!-- 페이지목록 , 선택페이지 굵게 -->
		<c:forEach var="pageNo" begin="${listModel.startPage}" end="${listModel.endPage}">
			<c:if test="${listModel.requestPage == pageNo}"><b></c:if>
		<a href="list_Product.jsp?pageNum=${pageNo}">[${pageNo}]</a>
		    <c:if test="${listModel.requestPage == pageNo}"></b></c:if>
		</c:forEach>
	
	
	<!-- 이후 -->
	<c:if test="${listModel.endPage < listModel.totalPageCount}">
		<a href="list_Product.jsp?pageNum=${listModel.startPage+5 }">[이후]</a>
	</c:if>	
			
			
			<tr height="30">
				<td colspan="4" align="center">
				<input type="button" value="메인페이지" onclick="history.go(-1)">&nbsp;&nbsp; 
				<input type="button" value="취소">
				</td>
			</tr>
		</table>
				  
	<form action="listproductAction.product" method="post">
		 <input type="hidden" name="temp" value="temp"></input>
		 <input type="checkbox" name="area" value="b_title">제목
		 <input type="checkbox" name="area" value="b_name">작성자
		 <input type="text" name="searchKey" size="10"></input>
		 <input type="submit" value="검색">
	</form>

</html>
