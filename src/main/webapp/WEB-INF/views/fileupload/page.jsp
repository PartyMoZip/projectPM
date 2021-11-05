<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

html:5
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page.jsp</title>
</head>
<body>
	<h1>/WEB-INF/views/fileupload/page.jsp</h1>
	
	<form action="/fileupload/doit" method="POST" enctype="multipart/form-data">
		<!-- 기본 : application/x-www-form-urlencoded
			 파일업로드 : multipart/form-data -->
		<div>name : <input type="text" name="name" value="kjg"></div> <!-- 하나의 파일만 올림 -->
		<div>age : <input type="text" name="age" value="23"></div> <!-- 하나의 파일만 올림 -->
		
		<!-- <div>1. file1 : <input type="file" name="files"></div>  하나의 파일만 올림 -->
		<div>1. file : <input type="file" name="files" multiple></div> <!-- 여러개의 파일만 올림 -->
		<p>&nbsp;</p>

		<div><input type="submit" value="Upload"></div>

	</form>
</body>
</html>