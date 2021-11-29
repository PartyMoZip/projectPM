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


    <title>파티모집 - 문의</title>
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
            <input hidden id="boardName" value="lost">
            <div class="table-Detail">

                <!--product details-->
                <div class="content">
                    <div class="title_area">
                        <h5 class="title_text">${boardDetail.qsubject}</h5>
                    </div>
                    <div class="info_desc">
                        <div class="profile_thumb">
                            <img src="${pageContext.request.contextPath}/resources/images/profile.jpg" alt width="50"
                                 height="50" class="img_thumb">
                        </div>
                        <div class="cover_info">
                            <div>${boardDetail.nickname}<br>
                                <span>${boardDetail.qdate}</span>
                                <span>조회 ${boardDetail.readnum}</span>
                            </div>
                        </div>
                    </div>
                    <hr>
                    <!--product details-->
                    <span style="text-align : left;">${boardDetail.qcontent}</span>
                </div>
                <!--댓글-->
                <div class="comment_text">
                    <i class="far fa-comment-dots"></i>
                    <span>댓글</span>
                </div>
                <!--댓글 리스트-->
                <div class="commentList_wrap">
                    <div class="commentList">
                        <table>
                            <tbody>
                            <c:choose>
                                <c:when test="${not empty reply}">
                                    <c:forEach items="${reply}" var="reply">
                                        <tr>
                                            <td><c:out value="${reply.nickname}"/></td>
                                            <td><fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss"
                                                                value="${reply.qredate}"/></td>
                                        </tr>
                                        <tr>
                                            <td><c:out value="${reply.qrecontent}"/></td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <td>등록된 글이 없습니다</td>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                        <div id="pagination">
                            <form id="paginationForm">
                                <ul class="pagination justify-content-center">
                                    <c:if test="${replyPageMaker.prev}">
                                        <li class="prev page-item">
                                            <a class="prev page-link"
                                               href="/freeboard/showFreeDetail?frefer=${boardDetail.frefer}&currPage=${cri.currPage}&reCurrPage=${replyPageMaker.startPage-1}">◀</a>
                                        </li>
                                    </c:if>
                                    <c:forEach begin="${replyPageMaker.startPage}"
                                               end="${replyPageMaker.endPage}" var="pageNum">
                                        <li class="page-item">
                                            <a id="page-curr" class="page-link"
                                               href="/partyphoto/detail?prefer=${__DETAIL__.prefer}&partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&reCurrPage=${pageNum}">
                                                    ${pageNum}
                                            </a>
                                        </li>
                                    </c:forEach>

                                    <c:if test="${replyPageMaker.next}">
                                        <li class="next page-item">
                                            <a class="next page-link"
                                               href="/partyphoto/detail?prefer=${__DETAIL__.prefer}&partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&reCurrPage=${replyPageMaker.endPage+1}">▶</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- replylist_wrap END -->
                <!--reply write-->
                <div class="comment_area">
                    <!--댓글내용-->
                    <form action="/qnaboard/writeComment" method="POST">
                        <input type="hidden" name="currPage" value="${cri.currPage}">
                        <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
                        <input type="hidden" name="qrefer" value="${boardDetail.qrefer}">
                        <input type="hidden" name="email" value="${boardDetail.email}">
                        <div class="commentWrite_Wrap">
                        <textarea name="qrecontent" id="commentContent"
                                  placeholder=" [${sessionScope.__AUTH__.nickname}] 님,  댓글을 남겨보세요"
                                  class="comment_inbox" rows="4"
                                  cols="140"></textarea>
                            <button type="submit" class="btn btn-outline-warning">등록</button>
                        </div>
                    </form>

                </div>
                <div class="container-btnGroup d-flex justify-content-end">
                    <button type="button" class="btn btn-primary btn-sm"
                            onclick="location.href='/qnaboard/editQnaBoardView?qrefer=${boardDetail.qrefer}'">
                        <i class="fas fa-pen"></i>
                        <span>수정</span>
                    </button>
                    <form action="/qnaboard/deleteQnaBoard" name="deleteButton" method="post">
                        <button type="submit" id="deleteButton" class="btn btn-primary btn-sm">
                            <input type="hidden" id="qrefer" name="qrefer" value="${boardDetail.qrefer}">
                            <i class="fas fa-trash-alt"></i>
                            <span>삭제</span>
                        </button>
                    </form>
                    <%--  </c:if>--%>
                    <button type="button" class="btn btn-primary btn-sm"
                            onclick="location.href='/qnaboard/getQnaBoardList?currPage=${cri.currPage}'">
                        <i class="fas fa-list-ul"></i>
                        <span>목록</span>
                    </button>
                </div>
            </div>
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
