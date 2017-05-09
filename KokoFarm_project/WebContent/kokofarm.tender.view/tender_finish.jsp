<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>코코팜::상품입찰완료</title>
<style type="text/css">
  #firstP{
    font-weight: bold;
    font-size: 20px;
    text-align: center;
  }
  #secondP{
  	font-weight: bold;
    font-size: 30px;
    text-align: center;
  }
  #firstDiv{
    margin-top: 150px;
  }
  #btn{
    margin-left: 650px;
    background: #287a78;
	color: white;
	border: 1px solid #287a78;
	padding: 7px;
  }

</style>
</head>
<body>
<div id="firstDiv">

<p id="firstP">경매번호 : ${tender.auction_no } </p>
<p id="secondP">${tender.member_id }님 입찰이 완료되었습니다.</p>
<!-- <input id="btn" type="button" value="돌아가기" onclick="fn_back()"> -->
<input id="btn" type="button" value="돌아가기" onclick="location.href='reg_list.reg'">
</div>
</body>
</html>