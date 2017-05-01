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
		var name =$("#member_name").val();
		if(name == ""){
			alert("이름을 입력하세요");
			$("#member_name").focus();
			return;
			}
		var id = $("#member_id").val();
		if(id == ""){
			alert("아이디를 입력하세요");
			$("#member_id").focus();
			
		}
		var exp = /[a-z0-9]/; //영문과 숫자
		//정규표현식 .test(입력값) 규칙에 맞으면 true 틀리면 false
		
		if( !exp.test(id)){
			alert("영문자와 숫자만 입력하세요");
			$("#member_id").focus();  //입력 포커스 이동
				return; 			
			}
		
		
		var pw = $("#member_password").val();
		if(pw==""){
			alert("패스워드 입력하세요")
			$("#member_password").focus();	
		}
		var pw2  =$("#member_password2").val();
		
		if(pw != pw2){
			 alert("입력한 비밀번호가 다릅니다.");
			 $("#member_password2").focus();
		 }
		
		var email = $("#member_email")
		if(email==""){
			alert("이메일을 입력하세요");
			$("#member_email").focus();
		}
		
		var hp = $("#member_phoneNum")
		if(hp==""){
			alert("전화번호를 입력하세요");
			$("#member_phoneNum").focus();
			
		}
		
		var zip = $("#member_zipcon")
		if(zip==""){
			alert("우편번호를 입력하세요");
			$("#member_zipcode").focus();
			
		}
				
		
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


<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>


</head>
<body>
<h2>회원가입</h2>
	<form name = "joinForm" action="insertMember.member" method="post">
		<table border="1" width="700px">
			<tr>
				<td>이름</td>
				<td><input type="text" name="member_name" id="member_name" width="500px"></td>
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
					id="sample6_postcode" readonly="readonly" size = "10"> 
					<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
					
					</td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="member_address1"
					id="sample6_address" readonly="readonly" size="70"></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><input type="text" name="member_address2"
					id="sample6_address2" size="70"></td>
			</tr>
			<tr>
				<td>계좌번호</td>
				<td><input type="text" name="member_account"
					id="member_account" size = "50"></td>
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