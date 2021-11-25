<%--
  Created by IntelliJ IDEA.
  User: Hwang
  Date: 2021-11-22
  Time: 오후 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link rel="icon" href="${pageContext.request.contextPath}resources/images/favicon.ico"/>

<%--CSS--%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
  integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
  <link rel='stylesheet' type='text/css' media='screen' href='${pageContext.request.contextPath}/resources/css/join.css'>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css?after">
</head>

<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>

<div id="login-box">
  <div class="left">
    <h1>Welcome</h1>
    <div class="login">
      <div class="row">
        <a href="/login/loginPage" data-content="Sign up">
          <img src="/resources/images/kakao_login_image.png"/></a>
      </div>
      <div class="row">
        <a href="/login/naverLoginPage" data-content="Sing up">
          <img src="/resources/images/naver_login.svg"/></a>
      </div>
    </div>
  </div>

  <div class="right">
    <div class="ima">
      <img src="/resources/images/joinlogo.png"/></a>
    </div>
  </div>

</div>
</body>
</html>




