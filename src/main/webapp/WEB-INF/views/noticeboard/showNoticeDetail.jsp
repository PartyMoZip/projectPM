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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/boardDetail.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


    <title>파티모집 - 공지</title>
</head>
<body>
<%--HEADER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>
<div class="board-main">
    <main>
        <div class="container-sm">
            <ul class="nav nav-pills">
                <li class="nav-item"><a class="nav-link active"
                                        aria-current="page" href="#">공지게시판</a></li>
            </ul>
            <div class="table-Detail">

                <!--product details-->
                <div class="content">
                    <div class="title_area">
                        <h5 class="title_text">${board.NSubject}</h5>
                    </div>

                    <div class="info_desc">
                        <div class="profile_thumb">
                            <img src="${pageContext.request.contextPath}/resources/images/profile.jpg" alt width="50"
                                 height="50" class="img_thumb">
                        </div>
                        <div class="cover_info">
                            <div>${board.nickname}<br>
                                <span>${board.NDate}</span>
                                <span>조회 ${board.readnum}</span>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <span style="text-align : left;">${board.NContent}</span>
                </div>
                <div class="container">
                    <div class="container-btnGroup">

                        <%--                                        <c:set value="${sessionScope.id}" var="id"/>--%>
                        <%-- <c:if test="${boardDetail.nickname eq nickname}">--%>
                        <button type="button" class="btn btn-primary btn-sm"
                                onclick="location.href='/noticeboard/editNoticeBoardView?nrefer=${board.NRefer}'">
                            <i class="fas fa-pen"></i>
                            <span>수정</span>
                        </button>

                        <button type="submit" id="deleteButton" class="btn btn-primary btn-sm">
                            <form action="/noticeboard/deleteNoticeBoard" name="deleteButton" method="post">
                            <input type="hidden" id="nRefer" name="nrefer" value="${board.NRefer}">
                            <i class="fas fa-trash-alt"></i>
                            <span>삭제</span>
                            </form>
                        </button>
                        <%--  </c:if>--%>
                        <button type="button" class="btn btn-primary btn-sm"
                                onclick="location.href='/noticeboard/getNoticeBoardList?currPage=${cri.currPage}'">
                            <i class="fas fa-list-ul"></i>
                            <span>목록</span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>

<div class="container">
    <%--FOOTER--%>
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"/>
</div>
<!-- 부트스트랩 js -->
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<script>


    $(document).ready(function () {
        $('#deleteButton').click(function() {


            var formObj=$('form');
            formObj.attr('method','post');
            formObj.attr('action','/noticeboard/deleteNoticeBoard');

            formObj.submit();

        }) // click #modifyBtn



        /*  var msg =

        if (msg != ""){
            alert(mag);
        }
    });

    function deleteConfirm(){
        if(!confirm("삭제하시겠습니까?")){
            return false;
        }else {
            location.href="/noticeboard/deleteNoticeBoard";

        }*/
    })
</script>
</body>
</html>
