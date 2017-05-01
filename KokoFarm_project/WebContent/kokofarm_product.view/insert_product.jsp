<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
<script type="text/javascript"> 

$(function() {
    $( "#testDatepicker" ).datepicker({
         changeMonth: true, 
         dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
         dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
         monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
         monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
   		 altField : '#getdate',
   		 dateFormat : 'yy년 mm월 dd일'

  });
});
</script>
</head>
<body>


	<form action="InsertProductAction.product" method="post" enctype="multipart/form-data">
	
<table border="1" cellpadding="0" cellspacing="0" style="border: solid #eaeaea 1px;">
			<tr height="30" align="center">
				<td width="200">상품이름</td>
				<td width="170">
				<input type="text" name="product_name"
					size="10"></td>
			</tr>

			<tr height="30" align="center">
				<td width="200">상품단위</td>
				<td width="170"><input type="text" name="product_unit"
					size="10"></td>
			</tr>

			<tr height="30" align="center">
				<td width="200">상품가격</td>
				<td width="170"><input type="text" name="product_price"
					size="10"></td>
			</tr>

			<tr height="30" align="center">
				<td width="200">판매자코드</td>
				<td width="170"><input type="text" name="seller_no" size="10">
				</td>
			</tr>

	
		<tr height="30" align="center">
				<td width="200">수확일</td>
				<td width="170"><input type="text" id="testDatepicker" class="text" placeholder="날짜선택"/></td>
			</tr>
	
	
			<tr height="30" align="center">
				<td width="200">메인사진</td>
				<td width="170"><input type="file" name="product_mainimage"
					size="10"></td>
			</tr>

			<tr height="30" align="center">
				<td width="200">상세사진</td>
				<td width="170"><input type="file" name="product_detailimage"
					size="10"></td>
			</tr>

			<tr height="30" align="center">
				<td width="200">제조업자사진</td>
				<td width="170"><input type="file" name="product_sellerimage"
					size="10"></td>
			</tr>

			<tr height="30">
				<td colspan="4" align="center">
				<input type="submit"value="상품저장">&nbsp;&nbsp; 
				<input type="reset" value="취소">
				</td>
			</tr>
		</table>

				<a href="list_Product.jsp">리스트</a>

	</form>

</body>
</html>