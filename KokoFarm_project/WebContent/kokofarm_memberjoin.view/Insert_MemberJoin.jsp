<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	//버튼 클릭 이벤트
	$("#btnJoin").click(function(){
		//폼데이터 서버에 제출
	document.joinForm.submit();
	});
	
	//아이디 중복 확인 처리
	$("#member_id").keyup(function(){
			var userid = $("#member_id").val();                                                                                                                                                                      
			var param ="userid="+userid;
			if(userid.length >=4){  //최소 4글자 이상
				$.ajax({
					type : "post",
					url : "idcheck.member",
					data : param,				
					success : function(data){
										
						
						
						
						$("#span_id").html(data);
						
					}
					
				})
			}
		
	})
	
	});
	
</script>
</head>
<body>
<h2>회원가입</h2>
	<form name = "joinForm" action="insertMember.member" method="post">
		<table border="1" width="700px">
			<tr>
				<td>이름</td>
				<td><input type="text" name="member_name" id="member_name"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="member_id" id="member_id">
				 	<span id = "span_id" ></span>
				 	
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="member_password"
					id="member_password"></td>
			<tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="member_password2"
					id="member_password2"></td>
			<tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="member_email" id="member_id"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="member_phoneNum"
					id="member_phoneNum"></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" name="member_zipcode"
					id="member_zipcode"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="member_address1"
					id="member_address1"></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><input type="text" name="member_address2"
					id="member_address2"></td>
			</tr>
			<tr>
				<td>계좌번호</td>
				<td><input type="text" name="member_account"
					id="member_account"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="회원가입" id="btnJoin"> 
				<input type="button" value="취소">
				</td>
			</tr>

		</table>

	</form>
	
</body>
</html>