<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
<title>Insert title here</title>
</head>
<body>
    ${__DETAIL__}
    <hr>
    <c:forEach items="${__PHOTO__}" var="photo">
        <img src="${photo}">
    </c:forEach>
    <hr>
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
        <div>닉네임</div>
        <div>${sessionScope.__AUTH__.nickname}</div>
        <input type="hidden" name="email" value="${sessionScope.__AUTH__.email}">
        <input type="submit" value="댓글 작성">
    </form>

    <hr>
    <c:forEach items="${__COMMENT__}" var="comment">
        <form action="/partyphoto/editcommit" method="post">
            <input type="hidden" name="currPage" value="${cri.currPage}">
            <input type="hidden" name="reCurrPage" value="${recri.reCurrPage}">
            <input type="hidden" name="prerefer" value="${comment.prerefer}">
            <input type="hidden" name="prefer" value="${comment.prefer}">
            <input type="hidden" name="partyCode" value="${comment.partyCode}">
            <input type="text" name="precontent" value="${comment.precontent}" readonly>
        </form>
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
            <a href="/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}"></option>목록</a>
        </c:when>
        <c:otherwise>
            <a href="/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}"></option>목록</a>
        </c:otherwise>
    </c:choose>
    <hr>
    <a href="/partyphoto/editview?prefer=${__DETAIL__.prefer}&partyCode=${ldto.partyCode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}"></option>수정</a>

</body>
</html>