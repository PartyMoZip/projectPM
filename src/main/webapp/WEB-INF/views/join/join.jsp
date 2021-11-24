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
    <title>Join</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>

    <%--CSS--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/resources/css/join.css?after'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css?after">
</head>

<body>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>

<div class="container-sm login-box d-flex justify-content-center align-items-center">
    <div class="wrapper shadow d-flex">
        <div class="left d-flex flex-column align-items-center">
            <div class="display-4 mt-5">로그인</div>
            <p>간편하게 로그인하세요!</p>
            <div class="login mt-5 align-self-center">
                <div class="my-3">
                    <a href="/login/loginPage" data-content="Sign up">
                        <div style="width:200px;height:50px">
                            <img src="${pageContext.request.contextPath}/resources/images/kakao_login.png" alt="..."
                                 style="width:100%"/>
                        </div>
                    </a>
                </div>
                <div>
                    <a href="/login/naverLoginPage" data-content="Sing up">
                        <div style="width:200px;height:50px">
                            <img src="${pageContext.request.contextPath}/resources/images/naver_login.png" alt="..."
                                 style="width:100%"/>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <div class="right d-flex flex-column align-items-center">
            <div class="textbox mt-5">
                <div class="display-4" style="color:white">어서오세요!</div>
                <p style="color:white">서비스를 이용하시려면 로그인해주세요!</p>
            </div>
            <div class="ima mt-5">
                <img src="${pageContext.request.contextPath}/resources/images/joinlogo.png"/></a>
            </div>
        </div>
    </div>


</div>
</body>
</html>




