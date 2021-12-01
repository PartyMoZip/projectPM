<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2021-11-20
  Time: 오후 1:57
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2021-11-20
  Time: 오후 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/boardWrite.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


    <title>파티모집 - 문의</title>

    <script src="https://cdn.ckeditor.com/ckeditor5/11.0.1/classic/ckeditor.js"></script>
</head>
<body>
<%--HEADER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>

<div class="board_main">
    <main>
        <div class="container-sm">
            <ul class="nav nav-pills">
                <li class="nav-item"><a class="nav-link active"
                                        aria-current="page" href="#">문의게시판</a></li>
            </ul>

            <form action="/qnaboard/writeQnaBoardOk" method="post">
                <div class="table-Detail">
                    <input type="hidden" name="email" value="${sessionScope.__AUTH__.email}">
                    <input type="hidden" name="nickname" value="${sessionScope.__AUTH__.nickname}">
                    <div class="title" id="article-title">
                        <input type="text" name="qsubject" placeholder="제목을 입력하세요." class="titlearea_input">
                    </div>
                    <!--product details-->

                    <div class="text_area">
                        <span><textarea name="qcontent" rows="10" class="textarea" placeholder="내용을 입력하세요"></textarea></span>
                    </div>
                    <div class="container-btnGroup">
                        <button type="submit" class="btn btn-primary btn-sm">
                            <i class="fas fa-pen"></i>
                            <span>등록</span>
                        </button>
                        <button type="button" class="btn btn-primary btn-sm"
                                onclick="location.href='/qnaboard/getQnaBoardList?currPage=${cri.currPage}&amount=${cri.amount}&pagesPerPage=${cri.pagesPerPage}'">
                            <i class="fas fa-list-ul"></i>
                            <span>목록</span>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </main>
</div>

<%--FOOTER--%>
<div class="container">
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"/>
</div>
<!-- 부트스트랩 js -->
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<!--<script src="${pageContext.request.contextPath}/resources/js/comment.js"></script>-->
</body>
</html>
