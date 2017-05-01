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
<h2>��ǰ����Ʈ ���</h2>
<%-- <table border="1" cellpadding="0" cellspacing="0">
			<tr height="80" align="center">
				<td width="200">���λ���</td>
				<td width="200">��ǰ�̸�</td>
				<td width="200">��ǰ����</td>
				<td width="200">��ǰ����</td>
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
			
			<!-- ���� -->
	<c:if test="${listModel.startPage > 5}">
		<a href="list.jsp?pageNum=${listModel.startPage -5 }">[����]</a>
	</c:if>
	
	<!-- ��������� , ���������� ���� -->
		<c:forEach var="pageNo" begin="${listModel.startPage}" end="${listModel.endPage}">
			<c:if test="${listModel.requestPage == pageNo}"><b></c:if>
		<a href="list_Product.jsp?pageNum=${pageNo}">[${pageNo}]</a>
		    <c:if test="${listModel.requestPage == pageNo}"></b></c:if>
		</c:forEach>
	
	
	<!-- ���� -->
	<c:if test="${listModel.endPage < listModel.totalPageCount}">
		<a href="list_Product.jsp?pageNum=${listModel.startPage+5 }">[����]</a>
	</c:if>	
			
			
			<tr height="30">
				<td colspan="4" align="center">
				<input type="button" value="����������" onclick="history.go(-1)">&nbsp;&nbsp; 
				<input type="button" value="���">
				</td>
			</tr>
		</table> --%>
		
				<div style="margin-left: 50%">
				<form action="listproductAction.product" method="post">
					 <input type="hidden" name="temp" value="temp"></input>
					 <input type="checkbox" name="area" value="b_title">����
					 <input type="checkbox" name="area" value="b_name">�ۼ���
					 <input type="text" name="searchKey" size="10"></input>
					 <input type="submit" value="�˻�">
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
						<td><span style="margin-left: 10px;color: #38a9a5; font-weight: bold;font-size: 19px; font-family: Tahoma;">�ڡڡڡڡ�  65��</span></td>
					</tr>
					<tr>
						<td><span style="margin-left: 10px;color: #403324; font-weight: bold;font-size: 13px; font-family: Tahoma;">${product.product_unit}</span></td>
					</tr>
					<tr>
						<td><span style="margin-left: 10px;color: #403324; font-weight: bold;font-size: 13px; font-family: Tahoma;">
						<fmt:formatNumber value="${product.product_price}" pattern="###,###,###"/>��</span></td>
					</tr>
				</table>
			</c:forEach>
		</ul>
	</div>
	
			<div style="clear: both; margin-left: 50%; margin-top: 36%; " >
					<!-- ���� -->
				<c:if test="${listModel.startPage > 5}">
					<a href="list.jsp?pageNum=${listModel.startPage -5 }" style="text-decoration: none; font: black">[����]</a>
				</c:if>
				
				<!-- ��������� , ���������� ���� -->
					<c:forEach var="pageNo" begin="${listModel.startPage}" end="${listModel.endPage}">
						<c:if test="${listModel.requestPage == pageNo}"><b></c:if>
					<a href="list_Product.jsp?pageNum=${pageNo}"  style="text-decoration: none; font: black">[${pageNo}]</a>
					    <c:if test="${listModel.requestPage == pageNo}"></b></c:if>
					</c:forEach>
				
				
				<!-- ���� -->
				<c:if test="${listModel.endPage < listModel.totalPageCount}">
					<a href="list_Product.jsp?pageNum=${listModel.startPage+5 }"  style="text-decoration: none; font: black">[����]</a>
				</c:if>	
			</div>
				<a href="list_Product.jsp">����Ʈ</a>			  
	
</html>
