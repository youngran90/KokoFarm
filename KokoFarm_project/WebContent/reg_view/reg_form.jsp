<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>  <!-- jQuery UI 라이브러리 js파일 --> 
<link rel="stylesheet" href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
<script src="http://mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>
<link href="reg_view/css/reg_form.css" rel="stylesheet" type="text/css" >
<title>코코팜::상품등록</title>
<script type="text/javascript">
function tolist(){
	location.href = "consumer_auction_list.jsp?";
};
$(function(){
	$(".date").appendDtpicker({
		locale:"ko",
		dateFormat:"yyyy-MM-DD hh:mm:00"
		});
});
</script>

</head>

<body>
	
	<div id="reg_form">
		<div id="reg_title"><h1>상품 등록</h1></div>
	<form action="reg_form.reg" method="POST" enctype="multipart/form-data">
		<table id="reg_form_table">
			<tr>
				<th>상품명</th>
				<td colspan="3"><input type="text" name="auction_name" class="reg_form_input"></td>
			</tr>
			<tr>
				<th>시작일</th>
				<td colspan="3"><input type="text" name="start_date" class="date">
				</td>
			</tr>
			<tr>
				<th>종료일</th>
				<td colspan="3"><input type="text" name="end_date" class="date">
				</td>
			</tr>
			<tr>
				<th>상한가</th>
				<td colspan="3"><input type="text" name="auction_up" class="reg_form_input"></td>
			</tr>
			<tr>
				<th>하한가</th>
				<td colspan="3"><input type="text" name="auction_down" class="reg_form_input"></td>
			</tr>
			<tr>
				<th>대표이미지</th>
				<td colspan="3"><input type="file" name="auction_file" class="reg_form_input"></td>
			</tr>
			<tr>
				<th>상세이미지1</th>
				<td><input type="file" name="auction_detailImg" class="auction_detailImg"></td>
				<th>상세이미지2</th>
				<td><input type="file" name="auction_detailImg2" class="auction_detailImg"></td>
			</tr>
			<tr>
				<th>상세내용</th>
				<td colspan="3"><textarea name="auction_content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송" class="reg_form_submit"></td>
			</tr>
		</table>
	</form>
	</div>
	
</body>
</html>