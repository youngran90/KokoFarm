<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border ="1" width = "700px">
	<tr>
		<td>이름</td>
		<td><input type="text" name = "member_name" id = "member_name"></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type = "text" name = "member_id" id = "member_id"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type ="password" name = "member_password"></td>
	<tr>
	<tr>
		<td>비밀번호 확인</td>

</table>
<form action="member/insertMember.do" method="post">
아 이 디&nbsp; : <input type="text" name = "member_id"><br>
비밀번호 :  <input type="text" name = "member_password"><br>
이     름&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name = "member_name"><br>
이 메 일 : <input type = "text"	name = "member_email"><br>
전화번호 :<input type= "text" name = "member_phoneNum"><br>
주     소&nbsp;&nbsp;&nbsp;: <input type = "text" name = "member_address"><br>
계좌번호 :<input type= "text" name = "member_account"><br>
<input type= "submit" value = "회원가입">

</form>
	
</body>
</html>