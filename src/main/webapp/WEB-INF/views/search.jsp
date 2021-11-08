<%--
  Created by IntelliJ IDEA.
  User: chico
  Date: 2021-11-08
  Time: 오후 6:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>파티모집 - 검색</title>

    <link rel="icon" href="resources/images/favicon.ico"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/3035905d2a.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/search.css">
</head>
<body>

<%--HEADER--%>
<jsp:include page="include/header.jsp"/>
<h1> /WEB-INF/views/search.jsp</h1>


<div class="container">
    <main>
        <%--dropdown menu--%>
        <!-- Example single danger button -->
        <div class="btn-group">
            <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown"
                    aria-expanded="false">
                취미
            </button>
            <div class="dropdown-menu">
                <input type="text" class="dropdown-search" placeholder="취미 검색..">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
                <a class="dropdown-item" href="#">Separated link</a>
            </div>
        </div>
        <div class="btn-group">
            <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown"
                    aria-expanded="false">
                지역
            </button>
            <div class="dropdown-menu">

                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
                <a class="dropdown-item" href="#">Separated link</a>
            </div>
        </div>
    </main>
</div>

<div class="container">
    <%--FOOTER--%>
    <jsp:include page="include/footer.jsp"/>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
