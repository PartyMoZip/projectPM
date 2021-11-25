<%--
  Created by IntelliJ IDEA.
  User: Hwang
  Date: 2021-11-24
  Time: 오후 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FullCalendar</title>
    <!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
    <link rel="icon" href="${pageContext.request.contextPath}resources/images/favicon.ico"/>
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <!-- jquery CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css">
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}resources/css/fullcalendar.css'>
</head>
<body>
        <div id='calendar-container'>
            <div id='calendar'></div>
        </div>
            <button onclick="allSave();">전체저장</button>


        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/fullcalendar.js"></script>
</body>
</html>
