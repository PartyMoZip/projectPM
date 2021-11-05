<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL을 사용해서 예외객체가 가지고 있는 한 개 이상의 스택트레이스를 출력해보자 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>errorPage.jsp</title>
</head>
<body>
	<h1>/WEB-INF/views/errorPage.jsp</h1>
	<h2>exception : ${exception}</h2>
	<hr>
	<!-- 최종사용자는 보이면 안된다 -->
	<ul>
		<!-- items : 여러요소를 가지고 있는 자료구조객체지정 -->
		<c:forEach items="${exception.getStackTrace()}" var="stack">
			<li>
				<c:out value="${stack}" />
			</li>
		</c:forEach>
	</ul>
	
	<p>잠시 시스템에 문제가 발생했습니다. 잠시 후에 다시 시도하여 주십시요.</p>
</body>
</html>