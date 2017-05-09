<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kokofarm.register.model.RegDto"%>  
<%@page import="kokofarm.register.model.RegDao"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="reg_view/css/reg_list.css" rel="stylesheet" type="text/css">
<title>코코팜::상품 리스트</title>
<style>
	#reg_list{
		/* border: 1px solid red; */
		display: inline-block;
		padding: 20px;
		width: 90%;
		text-align: left;
		text-decoration: none;
		margin-left: 5%;
		margin-right: 5%;
	}
	#reg_list > #reg_list_title{
		/* border: 1px solid blue; */
		background: #287A78;
		margin-bottom: 20px;
		margin-top: 0;
		width: 100%;
		height: 25px;
		text-align: center;
		
	}
	#reg_list > #reg_list_title > h1{
		/* border: 1px solid lime; */
		background: #FFFFFF;
		display: inline-block;
		font-size: 30px;
		padding:0 12px;
		position: relative;
		top: -30px;
	}
	.reg_ul{
		/* border: 1px solid red; */
		padding: 0;
		margin-top: 10%;
		list-style: none;
	}
	.reg_ul img{
		width: 280px;
		height: auto;
	}
	.reg_li{
		/* border: 1px solid blue; */
		display: inline-block;
		margin-left: 10px;
		margin-bottom: 25px;
		text-align: center;
	}
	.list_con{
		/* border: 1px solid purple; */
		text-align: right;
		margin-top: 10px;
	}
	.list_con > p{
		margin: 0;
		/* border: 1px solid skyblue; */
		margin-bottom: 5px;
		font-size: 14px;
	}
	.list_con > p:FIRST-CHILD{
		/* border: 2px solid blue; */
		font-weight: bold;
		font-size: 18px;
		color: #111111;
	}
	.list_con > p > a{
		text-decoration: none;
		color: #111111;
	}
	.list_con > p > a:hover{
		background: #3FBFBB;
		color: #FFFFFF;
	}
	#reg_list #into_reg {
		border: 1px solid #FFFFFF;
		background-color: #287A78;
		color: #FFFFFF;
		font-size: 15px;
		font-weight: bold;
		width: 110px;
		height: 35px;
		position: absolute;
		right: 3.9%;
	}
	.reg_paging{
		width: 200px;
		position: relative;
		left: 500px;
		text-align: center;
		background: #3FBFBB;
		font-weight: bold;
		font-size: 15px;
	}
	.reg_paging a{
		text-decoration: none;
		color: #FFFFFF;
	}
	.reg_paging a:hover{
		background: #FFFFFF;
		color: #000000;
	}
</style>
</head>
<body>
	<div id="reg_list">
		<div id="reg_list_title"><h1>채소</h1></div>
		<input type="button" value="상품등록하기" id="into_reg" onclick="location.href='start.reg'">  <!-- 판매자페이지 -->
		<div id="reg_list_inner">
				<ul class="reg_ul">
				<c:forEach var="regDto" items="${regList }">
				<li class="reg_li">
					<p>TIMER</p>
					<a href="reg_detail.reg?auction_no=${regDto.auction_no }"><img src="${regDto.auction_file }"></a>
					<div class="list_con">
					<p><a href="reg_detail.reg?auction_no=${regDto.auction_no }">${regDto.auction_name}</a></p>
					<p>상한가 : ${regDto.auction_up }</p>
					<p>하한가 : ${regDto.auction_down }</p>
					</div>
				</li>
				</c:forEach>
				</ul>
		</div>
		
			
		<!-- <div class="reg_paging">
			페이징처리
			<c:if test="${regPage.startPage > 5 }">
			<a href="list.jsp?pageNum=${regPage.startPage-5}">◀</a> 
		</c:if>
			페이지목록
		<c:forEach var="pageNo" begin="${regPage.startPage }" end="${regPage.endPage }">
			<c:if test="${regPage.requestPage == pageNo }"><b></c:if>
			<a href="list.jsp?pageNum=${pageNo }">${pageNo }</a>
			<c:if test="${regPage.requestPage == pageNo }"></b></c:if>
		</c:forEach>
			다음페이지
		<c:if test="${regPage.endPage < regPage.totalPageCount }">
			<a href="list.jsp?pageNum=${regPage.startPage+5}">▶</a>
		</c:if>
		</div> -->
	</div>

</body>
</html>