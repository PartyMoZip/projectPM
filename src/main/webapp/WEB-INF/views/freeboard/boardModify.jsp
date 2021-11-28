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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/boardDetail.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


    <title>파티모집 - 자유</title>
    <%--<style>
        .product-photo {
            background-image: url("${pageContext.request.contextPath}/assets/images/upload.png");
            background-size: 20%;
            background-position: center center;
            background-repeat: no-repeat;
        }
    </style>--%>

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
                                        aria-current="page" href="#">자유게시판</a></li>
            </ul>

            <form action="/freeboard/editFreeBoard?frefer=${__boardDetail__.FRefer}" method="post">
                <div class="table-Detail">
                    <!--product details-->
                    <div class="content">
                        <div class="title_area">
                            <span><input type="text" name="fSubject" value="${__boardDetail__.FSubject}"></span>
                        </div>
                        <hr>
                        <div class="info_desc">
                            <div class="profile_thumb">
                                <img src="${pageContext.request.contextPath}/resources/images/profile.jpg" alt
                                     width="50"
                                     height="50" class="img_thumb">
                            </div>
                            <div class="cover_info">
                                <div>${__boardDetail__.nickname}<br>
                                    <span>${__boardDetail__.FDate}</span>
                                    <span>조회 ${__boardDetail__.readnum}</span>
                                </div>
                            </div>
                        </div>

                        <div class="photo_content">
                            <div class="product-photo" id="${__boardDetail__.freePhoto}">
                                <input type="file" id="file" name="freePhoto" accept="image/jpeg, image/png, image/jpg">
                            </div>
                            <c:if test="${not empty __boardDetail__.freePhoto}">
                                <button id="delete" class="del-btn">삭제</button>
                            </c:if>
                        </div>
                        <span><textarea name="fContent" rows="10"
                                        cols="137">${__boardDetail__.FContent}"</textarea>
                        </span>

                        <div class="container">
                            <div class="container-btnGroup">
                                <%--                                        <c:set value="${sessionScope.id}" var="id"/>--%>
                                <%-- <c:if test="${boardDetail.nickname eq nickname}">--%>

                                <button type="submit" class="btn btn-primary btn-sm">
                                    <i class="fas fa-pen"></i>
                                    <span>등록</span>
                                </button>
                                <%--  </c:if>--%>
                                <button type="button" class="btn btn-primary btn-sm"
                                        onclick="location.href='/freeboard/getFreeBoardList?currPage=${cri.currPage}'">
                                    <i class="fas fa-list-ul"></i>
                                    <span>취소</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </main>
</div>


<%--FOOTER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"/>

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
