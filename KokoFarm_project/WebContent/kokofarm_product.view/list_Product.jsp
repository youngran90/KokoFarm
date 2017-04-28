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
<table border="1" cellpadding="0" cellspacing="0">
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
		</table>
				  
	<form action="listproductAction.product" method="post">
		 <input type="hidden" name="temp" value="temp"></input>
		 <input type="checkbox" name="area" value="b_title">����
		 <input type="checkbox" name="area" value="b_name">�ۼ���
		 <input type="text" name="searchKey" size="10"></input>
		 <input type="submit" value="�˻�">
	</form>

</html>
