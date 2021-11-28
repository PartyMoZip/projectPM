<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showMemberList.jsp</title>
</head>
<body>

    <%--HEADER--%>
<jsp:include
        page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>
<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/partyMainTab.jsp" />
    <h1>/WEB-INF/views/party/showMemberList.jsp</h1>
    <hr>
    <h3>${__USER__}</h3>
</body>
</html>