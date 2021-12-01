<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>파티모집 - 포토갤러리</title>
    <link rel="icon"
          href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous"/>
    <!-- 폰트어썸 -->
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
          crossorigin="anonymous"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/partyPhotoDetail.css"/>


    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>


    <style>
        .btn-hit {
            cursor: pointer;
            border: unset;
            outline: none;
            background-color: inherit;
        }
    </style>
</head>

<body>


<%--HEADER--%>
<jsp:include
        page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>


<c:choose>
    <c:when test="${not empty __COMMENT__}">
        <div id="pagination">
            <form id="paginationForm">
                <ul class="pagination justify-content-center">
                    <c:if test="${replyPageMaker.prev}">
                        <li class="prev page-item">
                            <a class="prev page-link"
                               href="/partyphoto/detail?prefer=${__DETAIL__.prefer}&partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&reCurrPage=${replyPageMaker.startPage-1}">◀</a>
                        </li>
                    </c:if>

                    <c:forEach begin="${replyPageMaker.startPage}" end="${replyPageMaker.endPage}" var="pageNum">
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
    </c:when>
</c:choose>

<hr>
<c:choose>
    <c:when test="${empty ldto.searchWord && empty ldto.option}">
        <a href="/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}"></option>목록</a>
    </c:when>
    <c:when test="${empty ldto.searchWord}">
        <a href="/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}"></option>목록</a>
    </c:when>
    <c:when test="${empty ldto.option}">
        <a href="/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}"></option>
            목록</a>
    </c:when>
    <c:otherwise>
        <a href="/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}"></option>
            목록</a>
    </c:otherwise>
</c:choose>
<hr>
<a href="/partyphoto/editview?prefer=${__DETAIL__.prefer}&partyCode=${ldto.partyCode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}"></option>
    수정</a>
<main>

    <%-- ${__DETAIL__}
    <hr>
    <c:forEach items="${__PHOTO__}" var="photo">
        <img src="${photo}">
    </c:forEach>
    <hr>
    <form action="/partyphoto/heart" method="post">
        <input type="hidden" name="currPage" value="${cri.currPage}">
        <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
        <input type="hidden" name="partyCode" value="${__DETAIL__.partycode}">
        <input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
        <input type="hidden" name="email"
            value="${sessionScope.__AUTH__.email}"> <input type="submit"
            value="좋아요">
    </form>
    <div>내가 누른 좋아요</div>
    ${__MYHEART__}
    <hr>
    <div>총 좋아요 개수</div>
    ${__TOTALHEART__}
    <hr>

    <form action="/partyphoto/writecomment" method="post">
        <input type="hidden" name="currPage" value="${cri.currPage}">
        <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
        <input type="hidden" name="partyCode" value="${__DETAIL__.partycode}">
        <input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
        <div>댓글 내용</div>
        <input type="text" name="precontent">
        <div>닉네임 : ${sessionScope.__AUTH__.nickname}</div>
        <input type="hidden" name="email"
            value="${sessionScope.__AUTH__.email}"> <input type="submit"
            value="댓글 작성">
    </form>

    <hr>
    <c:forEach items="${__COMMENT__}" var="comment">
        <form action="/partyphoto/editcomment" method="post">
            <input type="hidden" name="currPage" value="${cri.currPage}">
            <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
            <input type="hidden" name="partyCode"
                value="${__DETAIL__.partycode}"> <input type="hidden"
                name="prefer" value="${__DETAIL__.prefer}"> <input
                type="hidden" name="prerefer" value="${comment.prerefer}">
            <div>날짜</div>
            <div>${comment.predate}</div>
            <div>댓글 내용</div>
            <div>${comment.precontent}</div>
            <input type="hidden" id="${comment.prerefer}totext"
                name="precontent" value="${comment.precontent}">
            <div>닉네임</div>
            <div>${comment.nickname}</div>
            <input type="hidden" name="email"
                value="${sessionScope.__AUTH__.email}">
            <c:if test="${sessionScope.__AUTH__.email eq comment.email}">
                <input type="button" id="${comment.prerefer}" name="mod" value="수정">
                <input type="hidden" id="${comment.prerefer}tosubmit" value="수정완료">
            </c:if>
        </form>
        <c:if test="${sessionScope.__AUTH__.email eq comment.email}">
            <form action="/partyphoto/deletecomment" method="post">
                <input type="hidden" name="currPage" value="${cri.currPage}">
                <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
                <input type="hidden" name="partyCode"
                    value="${__DETAIL__.partycode}"> <input type="hidden"
                    name="prefer" value="${__DETAIL__.prefer}"> <input
                    type="hidden" name="prerefer" value="${comment.prerefer}">
                <input type="submit" value="삭제">
            </form>
        </c:if>
    </c:forEach>

    <c:choose>
        <c:when test="${not empty __COMMENT__}">
            <div id="pagination">
                <form id="paginationForm">
                    <ul class="pagination justify-content-center">
                        <c:if test="${replyPageMaker.prev}">
                            <li class="prev page-item"><a class="prev page-link"
                                href="/partyphoto/detail?prefer=${__DETAIL__.prefer}&partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&reCurrPage=${replyPageMaker.startPage-1}">◀</a>
                            </li>
                        </c:if>

                        <c:forEach begin="${replyPageMaker.startPage}"
                            end="${replyPageMaker.endPage}" var="pageNum">
                            <li class="page-item"><a id="page-curr" class="page-link"
                                href="/partyphoto/detail?prefer=${__DETAIL__.prefer}&partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&reCurrPage=${pageNum}">
                                    ${pageNum} </a></li>
                        </c:forEach>

                        <c:if test="${replyPageMaker.next}">
                            <li class="next page-item"><a class="next page-link"
                                href="/partyphoto/detail?prefer=${__DETAIL__.prefer}&partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&reCurrPage=${replyPageMaker.endPage+1}">▶</a>
                            </li>
                        </c:if>
                    </ul>
                </form>
            </div>
        </c:when>
    </c:choose>

    <hr>
    <c:choose>
        <c:when test="${empty ldto.searchWord && empty ldto.option}">
            <a
                href="/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}"></option>목록</a>
        </c:when>
        <c:when test="${empty ldto.searchWord}">
            <a
                href="/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}"></option>목록</a>
        </c:when>
        <c:when test="${empty ldto.option}">
            <a
                href="/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}"></option>
                목록</a>
        </c:when>
        <c:otherwise>
            <a
                href="/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}"></option>
                목록</a>
        </c:otherwise>
    </c:choose>
    <hr>
    <a
        href="/partyphoto/editview?prefer=${__DETAIL__.prefer}&partyCode=${ldto.partyCode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}"></option>
        수정</a>
--%>

    <div class="board_main">
        <main>
            <div class="container-sm">
                <div class="table-Detail">
                    <!--product details-->
                    <div class="content">
                        <div class="title_area">
                            <h5 class="title_text">제목</h5>
                        </div>
                        <div class="info_desc">
                            <div class="profile_thumb">
                                <img
                                        src="${pageContext.request.contextPath}/resources/images/profile.jpg"
                                        alt width="50" height="50" class="img_thumb">
                            </div>
                            <div class="cover_info">
                                <div>${detail.nickname}<br> <span>${detail.qdate}</span>
                                    <span>조회 ${detail.readnum}</span>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <!--product details-->

                        <div class="partyPhotoContents">
                            <div class="partyPhotoImg">
                                <c:forEach items="${__PHOTO__}" var="photo">
                                    <img src="${photo}" class="mt-3">
                                </c:forEach>
                            </div>
                            <div class="partyPhotoText">
									<span>
										ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ </span>
                            </div>
                        </div>

                    </div>

                    <c:forEach items="${__COMMENT__}" var="comment">
                        <form action="/partyphoto/editcomment" method="post">
                            <input type="hidden" name="currPage" value="${cri.currPage}">
                            <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
                            <input type="hidden" name="partyCode" value="${__DETAIL__.partycode}">
                            <input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
                            <input type="hidden" name="prerefer" value="${comment.prerefer}">
                            <div>날짜</div>
                            <div>${comment.predate}</div>
                            <div>댓글 내용</div>
                            <div>${comment.precontent}</div>
                            <input type="hidden" id="${comment.prerefer}totext" name="precontent"
                                   value="${comment.precontent}">
                            <div>닉네임</div>
                            <div>${comment.nickname}</div>
                            <input type="hidden" name="email" value="${sessionScope.__AUTH__.email}">
                            <c:if test="${sessionScope.__AUTH__.email eq comment.email}">
                                <input type="button" id="${comment.prerefer}" name="mod" value="수정">
                                <input type="hidden" id="${comment.prerefer}tosubmit" value="수정완료">
                            </c:if>
                        </form>
                        <c:if test="${sessionScope.__AUTH__.email eq comment.email}">
                            <form action="/partyphoto/deletecomment" method="post">
                                <input type="hidden" name="currPage" value="${cri.currPage}">
                                <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
                                <input type="hidden" name="partyCode" value="${__DETAIL__.partycode}">
                                <input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
                                <input type="hidden" name="prerefer" value="${comment.prerefer}">
                                <input type="submit" value="삭제">
                            </form>
                        </c:if>
                    </c:forEach>
                    <!--댓글-->
                    <div class="comment_area">
                        <div class="comment_text">
                            <i class="far fa-comment-dots"></i> <span>댓글</span>
                        </div>
                        <!--댓글 리스트-->
                        <div class="commentList_wrap">
                            <div class="commentList">
                                <table>
                                    <tbody>
                                    <c:choose>
                                        <c:when test="${not empty __COMMENT__}">
                                            <c:forEach items="${__COMMENT__}" var="comment">
                                                <form action="/partyphoto/editcomment" method="post">
                                                    <input type="hidden" name="currPage" value="${cri.currPage}">
                                                    <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
                                                    <input type="hidden" name="partyCode"
                                                           value="${__DETAIL__.partycode}">
                                                    <input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
                                                    <input type="hidden" name="prerefer" value="${comment.prerefer}">
                                                    <tr>
                                                        <td>
                                                                ${comment.nickname}
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                                ${comment.precontent}
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>
                                                            <%--<fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss"
                                                                            value="${comment.fredate}"/>--%>
                                                        </td>
                                                    </tr>
                                                        <%--<div>날짜</div>
                                                        <div>${comment.predate}</div>
                                                        <div>댓글 내용</div>
                                                        <div>${comment.precontent}</div>
                                                        <input type="hidden" id="${comment.prerefer}totext" name="precontent" value="${comment.precontent}">
                                                        <div>닉네임</div>
                                                        <div>${comment.nickname}</div>
                                                        <input type="hidden" name="email" value="${sessionScope.__AUTH__.email}">
                                                        <c:if test="${sessionScope.__AUTH__.email eq comment.email}">
                                                            <input type="button" id="${comment.prerefer}" name="mod" value="수정">
                                                            <input type="hidden" id="${comment.prerefer}tosubmit" value="수정완료">
                                                        </c:if>--%>
                                                </form>
                                                <c:if test="${sessionScope.__AUTH__.email eq comment.email}">
                                                    <form action="/partyphoto/deletecomment" method="post">
                                                        <input type="hidden" name="currPage" value="${cri.currPage}">
                                                        <input type="hidden" name="reCurrPage"
                                                               value="${recri.reCurrPage}">
                                                        <input type="hidden" name="partyCode"
                                                               value="${__DETAIL__.partycode}">
                                                        <input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
                                                        <input type="hidden" name="prerefer"
                                                               value="${comment.prerefer}">
                                                        <input type="submit" value="삭제">
                                                    </form>
                                                </c:if>
                                            </c:forEach>
                                            <c:forEach items="${reply}" var="reply">
                                                <tr>
                                                    <td><c:out value="${sessionScope.__AUTH__.nickname}"/></td>
                                                </tr>
                                                <tr>
                                                    <td><c:out value="${reply.qrecontent}"/></td>
                                                </tr>
                                                <tr>
                                                    <td><fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss"
                                                                        value="${reply.qredate}"/></td>
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
                                                <li class="prev page-item"><a class="prev page-link"
                                                                              href="">◀</a>
                                                </li>
                                            </c:if>
                                            <c:forEach begin="${replyPageMaker.startPage}"
                                                       end="${replyPageMaker.endPage}" var="pageNum">
                                                <li class="page-item"><a id="page-curr"
                                                                         class="page-link"
                                                                         href="">
                                                        ${pageNum} </a></li>
                                            </c:forEach>

                                            <c:if test="${replyPageMaker.next}">
                                                <li class="next page-item"><a class="next page-link"
                                                                              href="">▶</a>
                                                </li>
                                            </c:if>
                                        </ul>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- replylist_wrap END -->
                        <!--reply write-->
                        <!--댓글내용-->
                        <%--<form action="/partyphoto/writecomment" method="post">--%>
                        <%--	<input type="hidden" name="currPage" value="${cri.currPage}">--%>
                        <%--	<input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">--%>
                        <%--	<input type="hidden" name="partyCode" value="${__DETAIL__.partycode}">--%>
                        <%--	<input type="hidden" name="prefer" value="${__DETAIL__.prefer}">--%>
                        <%--	<div>댓글 내용</div>--%>
                        <%--	<input type="text" name="precontent">--%>
                        <%--	<div>닉네임 : ${sessionScope.__AUTH__.nickname}</div>--%>
                        <%--	<input type="hidden" name="email" value="${sessionScope.__AUTH__.email}">--%>
                        <%--	<input type="submit" value="댓글 작성">--%>
                        <%--</form>--%>

                        <form action="/partyphoto/writecomment" method="POST">
                            <input type="hidden" name="currPage" value="${cri.currPage}">
                            <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
                            <input type="hidden" name="partyCode" value="${__DETAIL__.partycode}">
                            <input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
                            <input type="hidden" name="email" value="${sessionScope.__AUTH__.email}">
                            <div class="commentWrite_Wrap">
									<textarea name="precontent" id="commentContent"
                                              placeholder=" [${sessionScope.__AUTH__.nickname}] 님,  댓글을 남겨보세요"
                                              class="comment_inbox" rows="4" cols="140"></textarea>
                                <button type="submit" class="btn btn-outline-warning">등록</button>
                            </div>
                        </form>
                    </div>
                </div>

                <div class="container-btnGroup d-flex justify-content-end">
                    <c:set value="${sessionScope.__AUTH__.nickname}" var="nickname"/>
                    <button type="button" class="btn btn-primary btn-sm"
                            onclick="location.href='/partyphoto/editview?prefer=${__DETAIL__.prefer}&partyCode=${ldto.partyCode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}'">
                        <i class="fas fa-pen"></i> <span>수정</span>
                    </button>
                    <form action="" method="post">
                        <button type="submit" class="btn btn-primary btn-sm">
                            <input type="hidden" name="frefer" value=""> <i
                                class="fas fa-trash-alt"></i> <span>삭제</span>
                        </button>
                    </form>
                    <button type="button" class="btn btn-primary btn-sm"
                            onclick="location.href='/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}'">
                        <i class="fas fa-list-ul"></i> <span>목록</span>
                    </button>
                </div>

            </div>
        </main>
    </div>

</main>

<div class="container">
    <%--FOOTER--%>
    <jsp:include
            page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"/>
</div>

<!-- 부트스트랩 js -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 스윗알러트 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</body>
<script src="${pageContext.request.contextPath}/resources/js/photoedit.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
<script>
    $(document).ready(function () {
        $(document).on("click", function (e) {
            var click_val_1 = e.target.getAttribute('id');
            console.log(click_val_1);
            $('#' + click_val_1 + 'totext').attr("type", "text");
            $('#' + click_val_1 + 'tosubmit').attr("type", "submit");
        });
    });
</script>

</html>