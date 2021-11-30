<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <title>Insert title here</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">

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
<jsp:include
        page="${pageContext.request.contextPath}/WEB-INF/views/include/partynav.jsp"/>

${__DETAIL__}
<hr>
<c:forEach items="${__PHOTO__}" var="photo">
    <img src="${photo}">
</c:forEach>
<hr>
<form class="form-heart" action="/partyphoto/heart" method="post">
    <input type="hidden" name="currPage" value="${cri.currPage}">
    <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
    <input type="hidden" name="partyCode" value="${__DETAIL__.partycode}">
    <input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
    <input type="hidden" name="email" value="${sessionScope.__AUTH__.email}">
    <button class="btn-hit">
        <span>
            <c:choose>
                <c:when test="${__MYHEART__ == 1}">
                    <i class="far fa-thumbs-up" style="font-size:2rem; color:#5E92FF"></i>
                </c:when>
                <c:otherwise>
                    <i class="far fa-thumbs-up" style="font-size:2rem;"></i>
                </c:otherwise>
            </c:choose>
        </span>
    </button>
</form>
<div>내가 누른 좋아요</div>
<span class="myHeart">
    ${__MYHEART__}
</span>
<hr>
<div>총 좋아요 개수</div>
<span class="totalHeart">
    ${__TOTALHEART__}
</span>
<hr>

<form action="/partyphoto/writecomment" method="post">
    <input type="hidden" name="currPage" value="${cri.currPage}">
    <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
    <input type="hidden" name="partyCode" value="${__DETAIL__.partycode}">
    <input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
    <div>댓글 내용</div>
    <input type="text" name="precontent">
    <div>닉네임 : ${sessionScope.__AUTH__.nickname}</div>
    <input type="hidden" name="email" value="${sessionScope.__AUTH__.email}">
    <input type="submit" value="댓글 작성">
</form>

<hr>
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
        <input type="hidden" id="${comment.prerefer}totext" name="precontent" value="${comment.precontent}">
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

</body>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/photoedit.js"></script>
<script>

    $(document).ready(function () {
        $(document).on("click", function (e) {
            e.preventDefault();
            var click_val_1 = e.target.getAttribute('id');
            console.log(click_val_1);
            // $('#' + click_val_1 + 'totext').attr("type", "text");
            // $('#' + click_val_1 + 'tosubmit').attr("type", "submit");
        });
    });

</script>
</html>