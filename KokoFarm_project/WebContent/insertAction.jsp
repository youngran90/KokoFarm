<%@page import="kokofarm.customercenter.model.BoardDao"%>
<%@page import="kokofarm.customercenter.model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
  <jsp:useBean id="board" class="kokofarm.customercenter.model.Board"></jsp:useBean>
  <jsp:setProperty property="*" name="board"/>
  <%
  	BoardDao dao = BoardDao.getInstance();
  	dao.insertBoard(board);
  %>
<%--  <%response.sendRedirect("list.jsp"); %> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<ul>
	 	<li><a href ="insert_form.jsp">글쓰기</a></li>
		<li><a href ="list.jsp">글목록</a></li>
	</ul>
</body>
</html>