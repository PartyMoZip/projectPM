<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>basic.jsp</title>
</head>
<body>
	<h1> /WEB-INF/views/ + "1" + .jsp </h1>
	
	<hr>
	
	<!-- JSTL 표현식 -->
	<!-- 원래 받았던것들을 그대로 물려줌 -->
	<h2>1. name : <%=request.getParameter("name") %></h2>
	<h2>2. age :  <%=request.getParameter("age") %></h2>
	
	<!-- EL 표현식 : 내장 객체 param -->
	<!-- 위와 같은 의미 -->
	<h2>1. name : ${param.name} </h2>
	<h2>2. age :  ${param.age} </h2>
	


</body>
</html>