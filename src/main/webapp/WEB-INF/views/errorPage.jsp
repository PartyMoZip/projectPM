<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>파티모집 - 404</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container d-flex flex-column justify-content-center align-items-center">
    <div>
        <img class="mt-5"
             src="${pageContext.request.contextPath}/resources/images/logo.svg"
             alt="logo"
             height="80"
        >
    </div>
    <div class="mt-5">
        <img class="mt-5"
             src="${pageContext.request.contextPath}/resources/images/404.webp" height="200" alt="404">
    </div>
    <p class="display-6 text-center mt-5">찾을 수 없는 페이지입니다.<br/>요청하신 페이지가 사라졌거나, 잘못된 경로를 이용하셨어요 :)</p>
    <a href="/" class="btn btn-outline-success mt-3">홈으로 이동</a>
</div>
</body>
</html>