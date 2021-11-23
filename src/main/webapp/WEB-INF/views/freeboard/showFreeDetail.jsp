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
    <%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>


    <title>파티모집</title>
</head>
<body>
<%--HEADER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>

<main>
    <div class="all-wrap">
        <nav id="freebar" class="nav nav-pills flex-column flex-sm-row">
            <a class="flex-sm-fill text-sm-center nav-link active" href="#">자유게시판</a>
        </nav>


        <input hidden id="boardName" value="lost">
        <table class="table-Detail">
            <thead>

            <tr>
                <div class="title_area">
                    <h5 class="title_text">${boardDetail.FSubject}</h5>
                </div>
            </tr>
            <tr>
                <div class="info_desc">
                    <div class="profile_thumb">
                        <img src="${pageContext.request.contextPath}/resources/images/profile.jpg" alt width="50"
                             height="50" class="img_thumb">
                    </div>
                    <div class="cover_info">
                        <div>${boardDetail.nickname}<br>
                            <span>${boardDetail.FDate}</span>
                            <span>조회 ${boardDetail.readnum}</span>
                        </div>
                    </div>
                </div>
            </tr>
            <tbody>
            <!--product details-->
            <div class="content">
                <c:choose>
                    <c:when test="${not empty boardDetail.freePhoto}">
                        <!--.gallery-->
                        <!-- Gallery -->
                    </c:when>
                </c:choose>
                <span style="text-align : left;">${boardDetail.FContent}</span>
            </div>

            <div class="button_area">
                <div class="ms-3 button_container">
                    <%--                                        <c:set value="${sessionScope.id}" var="id"/>--%>
                   <%-- <c:if test="${boardDetail.nickname eq nickname}">--%>
                        <button type="button" class="btn btn-primary btn-sm"
                                onclick="location.href='/freeboard/editFreeBoardView?frefer=${boardDetail.FRefer}'">
                            <i class="fas fa-pen"></i>
                            <span>수정</span>
                        </button>
                        <button type="button" class="btn btn-primary btn-sm"
                                onclick="location.href='/freeboard/deleteFreeBoard?frefer=${boardDetail.FRefer}'">
                            <i class="fas fa-trash-alt"></i>
                            <span>삭제</span>
                        </button>
                  <%--  </c:if>--%>
                    <button type="button" class="btn btn-primary btn-sm"
                            onclick="location.href='/freeboard/getFreeBoardList?currPage=${cri.currPage}&amount=${cri.amount}&pagesPerPage=${cri.pagesPerPage}'">
                        <i class="fas fa-list-ul"></i>
                        <span>목록</span>
                    </button>
                </div>
            </div>
            <!--댓글-->
                <div class="comment_text">
                    <i class="far fa-comment-dots"></i>
                    <span>댓글</span>
                </div>
                <!--댓글 리스트-->
               <%-- <div class="commentList_wrap">
                    <div class="commentList">
                        <table>
                            <tbody>
                            <c:choose>
                                <c:when test="${not empty reply}">
                                    <c:forEach items="${reply}" var="reply">
                                        <tr>
                                            <td>
                                            <td><c:out value="${reply.rerefer}"/></td>
                                            <td><c:out value="${reply.nickname}"/></td>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <td>등록된 글이 없습니다</td>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>--%>
                <!-- replylist_wrap END -->

                <!--reply write-->
            <div class="comment_area">
                <form name="lostComment" method="POST" id="lostComment">
                    <div class="commentWrite_Wrap">
                        <input type="hidden" name="idx" id="idx" value="${boardDetail.nickname}">
                        <input type="hidden" name="writerid" id="writerId" value="${boardDetail.nickname}">
                        <input type="hidden" value="${nickname}" id="loginId">
                        <h2>${nickname}</h2>
                        <input type="hidden" name="commentid" id="commentId" value="${nickname}">
                        <textarea name="content" id="commentContent" placeholder=" 댓글을 남겨보세요"
                                  class="comment_inbox" rows="4"
                                  cols="140"></textarea>
                        <button type="button" class="btn btn-outline-warning">등록</button>
                    </div>
                </form>
            </div>
            </tbody>
            </thead>
        </table>

    </div>


    <%-- <div class="d-grid gap-2 d-md-block">
         <button class="btn btn-primary" type="button">글목록</button>
         <button class="btn btn-primary" type="button">글수정</button>
     </div>--%>
</main>


<%--FOOTER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"/>

<!-- 부트스트랩 js -->
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/freeboard.js"></script>
<!--<script src="${pageContext.request.contextPath}/resources/js/comment.js"></script>-->
</body>
</html>
