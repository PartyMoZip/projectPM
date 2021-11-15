<%--
  Created by IntelliJ IDEA.
  User: Hwang
  Date: 2021-11-14
  Time: 오전 1:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>${sessionScope.__AUTH__.email}</p>
    <p>${sessionScope.__AUTH__.nickname}</p>

    <img src="${sessionScope.__AUTH__.userPic}">

    <script type="text/javascript">
    </script>
</body>
</html>
