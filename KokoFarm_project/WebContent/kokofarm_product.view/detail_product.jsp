<%@page import="kokofarm.product.domain.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="kokofarm.product.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%
	request.setCharacterEncoding("utf-8");
    String id = (String)session.getAttribute("m_id");
    request.setAttribute("id", id);
    System.out.print(id);
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src=http://code.jquery.com/jquery-1.10.2.js></script>
<script type="text/javascript">
	function eaup(){
		var num = parseInt($("#ea").val());
		var ea = num+1;
		$("#ea").val(ea);
		
		var price = parseInt($("#aa").text());
		alert(price)
		$("#aa").text(price*ea+"원");
	}
	
	function eadown(){
		var num = $("#ea").val();
		var ea = parseInt(num);
		if(ea == 0){
			alert("더이상 수량을 줄일수없습니다.")
		}else{
			$("#ea").val(ea-1);
			var price = parseInt($("#aa").text());
			alert(price)
			$("#aa").text(price/ea+"원");
		}
		}
	function deletpost(post_no){
		
			$.ajax({
				type: "get",
				url:   "deletePost.product",
		        data: {"post_no":post_no},
		        success: function (data) {
		        	location.reload();
		        	alert("댓글삭제");
		        },
		        error: function (data) {
		            console.log('Error:', data);
		            alert("오류");
		        }
			})
		}
	
	function eadown(){
		var num = $("#ea").val();
		var ea = parseInt(num);
		if(ea == 0){
			alert("더이상 수량을 줄일수없습니다.")
		}else{
			$("#ea").val(ea-1);
			var price = parseInt($("#aa").text());
			alert(price)
			$("#aa").text(price/ea+"원");
		}
		}
	function updatepost(post_no){
    	
		$("#updatePost").append('<input type="submit" name="post_content" size="50"/>');
		location.reload();
		
			$.ajax({
				type: "get",
				url:   "updatePostAction.product",
		        data: {"post_no":post_no},
		        success: function (data) {
		        	location.reload();
		        	alert("댓글수정");
		        },
		        error: function (data) {
		            console.log('Error:', data);
		            alert("오류");
		        }
			})
		}
	
</script>
<style type="text/css">
td{
text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품상세리스트 출력</h2>
<table  border="1" cellpadding="0" cellspacing="0">

				<tr>
					<td>상품명</td>					
					<td id="product">${product.product_name}</td>
				</tr>
			
				
				<tr>				
				<td>단위</td>
				<td>${product.product_unit}</td>
				</tr>
				<tr>
					<td>수량</td>
					<td>
						<div >
							<button  type="button" onclick="eadown()">-</button>
							<input id="ea" name="ea" value="1" readonly="" type="text" size="1" style=" text-align: center;" >
							<button  type="button" onclick="eaup()">+</button>
					</div>
					</td>
				</tr>
				<tr>
					<td>판매가</td>
					<td id="aa">${product.product_price}원</td>
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
					<td><fmt:formatDate value="${product.product_harvestdate}" pattern="yyyy년MM월dd일"/>
					</td>
				</tr>	

				<tr>
					<td>대표이미지</td>
					<td><img  src="../upload/${product.product_mainimage}"></td>
				</tr>		
				
				<tr>
					<td>상세이미지</td>
					<td><img  src="../upload/${product.product_detailimage}"></td>
				</tr>
				
				<tr>
					<td>판매자이미지</td>
					<td><img  src="../upload/${product.product_sellerimage}"></td>
				</tr>
						
	
			<tr height="30">
				<td colspan="4" align="center">
				<input type="button" value="메인페이지" onclick="history.go(-1)">&nbsp;&nbsp; 
				<input type="button" value="취소">
				</td>
			</tr>
		</table>
		
	<h2>댓글</h2>		  
	<form action="InsertPostAction.product" method="post">
		 <input type="hidden" name="product_no" value="${product.product_no}"></input>
		<input type="hidden" name="member_id" size="10"></input>
		글내용:<input type="text" name="post_content" size="50"></input>
		 <input type="submit" value="작성 완료" >
	</form>
	
	
	
	
       
     <div class="board_comment" id="commentListArea">  
		<table id="commentList" style="border: solid #eaeaea 3px; ">
		
			<tr>
				<td style="width: 50px;" align="center">글번호</td>
				<td style="width: 100px;" align="center">작성자</td>
				<td style="width: 500px;" >글내용</td>
				<td style="width: 145px;" align="center">작성일</td>
			</tr>
			
		
				<c:if test="${not empty postlist}">
					<c:forEach var="postlist" items="${postlist}" varStatus="status">
					<tr>
						<td>${status.count}</td>
							<td class="comment_name"><span class="txt strong" id="member_id">${postlist.member_id}</span></td>
			                  <td class="comment_txt"><span>${postlist.post_content}</span></td>
			                  <td class="comment_date"><fmt:formatDate value="${postlist.post_date}" pattern="yyyy년 MM월 dd일"/></td>
			                 
			                  <c:set var="id" value="${id}"></c:set>
			                   <c:if test="${postlist.member_id eq id}">
			                  <td><button id="deletePost" value="${postlist.post_no}" onclick="deletpost('${postlist.post_no}')">삭제</button></td>
			              		</c:if>
			               </tr>
			        </c:forEach>
				</c:if>
       </table>
	</div>
		
		<a href="list_Product.jsp">리스트</a>
<br><br><br><br><br><br><br><br><br>
</body>

</html>