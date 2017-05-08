<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">

$(function(){
	
	$("#mainPage").click(function(){
		
		location.href="mainAction.member";
			});
	});

</script>
</head>
<body>
<div>회원가입이 완료 되었습니다.</div>
<input type="button" value="메인페이지이동" id="mainPage">
</body>
</html>