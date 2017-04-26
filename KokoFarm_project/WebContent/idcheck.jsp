<%@page import="kokofarm.member.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    MemberService service = MemberService.getInstance();
	String userid = request.getParameter("member_id");
		
	System.out.println(userid);
	
	boolean result = service.idcheckService(userid);
	 
	if(result){
		out.print("yes");
		
	}else{
		out.print("no");
	}
    
    
    %>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>