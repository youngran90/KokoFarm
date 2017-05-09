<%@page import="kokofarm.product.domain.ListProductPage"%>
<%@page import="kokofarm.product.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
<script type="text/javascript" src=http://code.jquery.com/jquery-1.10.2.js></script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>상품리스트 출력</h2>
<%-- <table border="1" cellpadding="0" cellspacing="0">
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
					<c:when test="${pattern eq '.jpg' or pattern eq '.gif'}">
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
		</table> --%>
		
				<div style="margin-left: 50%">
				<form action="listproductAction.product" method="post" name="searchForm">
					 <input type="hidden" name="temp" value="temp"></input>
					 <select id="searchOption" name="searchOption" style="height: 20px; width: 80px;" s>
					 	<option  value="product_name">제목</option>
					 	<option  value="seller_no">작성자</option>
					 </select>
					 <input type="text" id="searchText" name="searchText" size="20" value="${listModel.searchText }">
					 <input type="submit" value="검색">
					<!--  <input type="button" value="전체보기"> -->
				</form>
			</div>
			
	<div style="clear: both;">
		<ul>
			<c:forEach var="product" items="${listModel.list}">
			<li style="margin: 5px 10px 5px 10px; display: inline-block;  float: left;list-style: none">
				<table style="border: solid #eaeaea 3px; width: 300px; height: 400px;">
					<tr >
						<td><c:if test="${product.product_mainimage != null }">
							<c:set var="pattern" value="${fn:substring(product.product_mainimage, fn:length(product.product_mainimage)-4, fn:length(product.product_mainimage))}"></c:set>
							<c:choose>
								<c:when test="${pattern eq '.jpg' or pattern eq '.gif'}">
									<a href ="detailProdutAction.product?product_no=${product.product_no}" style="text-decoration: none"" ><img style="width: 90%; height: 220px; margin-left:5%; border:solid black 1px;"  src="../upload/small_${product.product_mainimage}"></a>
								</c:when>
								<c:otherwise>
									<c:out value="NO IMAGE"></c:out>
								</c:otherwise>
							</c:choose>
						</c:if></td>
					</tr>
					<tr>
						<td><a href="detailProdutAction.product?product_no=${product.product_no}" style="text-decoration: none; margin-left: 10px; color: #352f29;font-size: 19px; font-family: Tahoma; ">${product.product_name}</a></td>
					</tr>
					<tr>
						<td><span style="margin-left: 10px;color: #38a9a5; font-weight: bold;font-size: 19px; font-family: Tahoma;">★★★★★  65건</span></td>
					</tr>
					<tr>
						<td><span style="margin-left: 10px;color: #403324; font-weight: bold;font-size: 13px; font-family: Tahoma;">${product.product_unit}</span></td>
					</tr>
					<tr>
						<td><span style="margin-left: 10px;color: #403324; font-weight: bold;font-size: 13px; font-family: Tahoma;">
						<fmt:formatNumber value="${product.product_price}" pattern="###,###,###"/>원</span></td>
					</tr>
				</table>
			</c:forEach>
		</ul>
	</div>
	
			<div style="clear: both; margin-left: 50%; margin-top: 36%; " >
					<!-- 이전 -->
				<c:if test="${listModel.startPage > 5}">
					<a href="list.jsp?pageNum=${listModel.startPage -5 }" style="text-decoration: none; font: black">[이전]</a>
				</c:if>
				
				<!-- 페이지목록 , 선택페이지 굵게 -->
					<c:forEach var="pageNo" begin="${listModel.startPage}" end="${listModel.endPage}">
						<c:if test="${listModel.requestPage == pageNo}"><b></c:if>
					<a href="list_Product.jsp?pageNum=${pageNo}"  style="text-decoration: none; font: black">[${pageNo}]</a>
					    <c:if test="${listModel.requestPage == pageNo}"></b></c:if>
					</c:forEach>
				
				
				<!-- 이후 -->
				<c:if test="${listModel.endPage < listModel.totalPageCount}">
					<a href="list_Product.jsp?pageNum=${listModel.startPage+5 }"  style="text-decoration: none; font: black">[이후]</a>
				</c:if>	
			</div>
				<a href="listproductAction.product">리스트</a>			  
</html>

