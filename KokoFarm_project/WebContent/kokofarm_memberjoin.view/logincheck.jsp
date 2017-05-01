<%@page import="com.sun.xml.internal.bind.v2.runtime.Location"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<%


String message = (String)request.getAttribute("message");
String sMember_id = (String)request.getAttribute("member_id");
if(message.indexOf("환영") !=-1){ %>
	<span style = "color:blue;"><%=message%></span>
		
		<%
}else{
	%>
	<span style="color:red;"><%=message %></span>
	
<%
}
%>


</body>
</html>