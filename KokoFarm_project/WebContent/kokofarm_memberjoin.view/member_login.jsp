<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
 	$(function(){
 		$("#btnidcheck").click(function(){  //클릭이벤트
 			var member_id = $("#member_id").val();  //입력값 
 			var member_password = $("#member_password").val();
 			
 			if(member_id==""){    
 				alert("아이디를 입력하세요");
 				$("#member_id").focus();  //입력 포커스 이동
 				return;
 				
 				}
 			
 			var exp = /[a-z0-9]/; //영문과 숫자
				//정규표현식 .test(입력값) 규칙에 맞으면 true 틀리면 false
				
				if( !exp.test(member_id)){
					alert("영문자와 숫자만 입력하세요");
					$("#member_id").focus();  //입력 포커스 이동
	 				return; 			
 				}
 			
 			if(member_password==""){
 				alert("패스워드를 입력하세요");
 				$("#member_password").focus();
 				return;
 				
 			}
 			 			
 			var param ="member_id="+member_id+"&member_password="+member_password;
 			$.ajax({
 				type: "post",
 				data: param,
 				url : "loginCheck.member",
 				success: function(data){
 					
 					$("#loginResult").html(data);
 					
 				} 				
 			})
 			 			
 		}); 	
 		
 		$("#btnLogin").click(function(){

 			if(member_id==""){    
 				alert("아이디를 입력하세요");
 				$("#member_id").focus();  //입력 포커스 이동
 				return;
 				
 				}
 			
 			var exp = /[a-z0-9]/; //영문과 숫자
				//정규표현식 .test(입력값) 규칙에 맞으면 true 틀리면 false
				
				if( !exp.test(member_id)){
					alert("영문자와 숫자만 입력하세요");
					$("#member_id").focus();  //입력 포커스 이동
	 				return; 			
 				}
 			
 			if(member_password==""){
 				alert("패스워드를 입력하세요");
 				$("#member_password").focus();
 				return;
 				
 			}
 			
 			document.loginForm.submit();
 		})
 		
 		
 	});

</script>
</head>
<body>
<!-- 로그인 관련 -->

<form name = "loginForm" action="loginCheck1.member" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" id ="member_id" name="member_id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" id ="member_password" name="member_password"></td>
		</tr>	
		<tr>
			<td>
				<input type = "button" id ="btnidcheck" value="아이디중복확인">
			</td>
			<td >
			<input type="submit" id ="btnLogin" value="로그인">
			</td>
		</tr>
	</table>
</form>
	<div id = "loginResult"></div>
</body>
</html>