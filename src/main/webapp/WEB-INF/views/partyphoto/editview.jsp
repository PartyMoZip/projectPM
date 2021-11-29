<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
<title>파티모집 - 게시글수정</title>
</head>
<body>
    <%--HEADER--%>
    <jsp:include
            page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>
    <jsp:include
            page="${pageContext.request.contextPath}/WEB-INF/views/include/partynav.jsp" />

    <form action = "/partyphoto/edit" method="post" enctype="multipart/form-data">
        <input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
        <input type="text" name="partycode" value="${__DETAIL__.partycode}" readonly>
        <input type="text" name="pcontent" value="${__DETAIL__.pcontent}">
        <input type="text" name="psubject" value="${__DETAIL__.psubject}">
        <input type="text" name="email" value="${__DETAIL__.email}" readonly>
            <c:forEach items="${__PHOTO__}" var="photo">
                        <div>${photo}</div>
            </c:forEach>
        <input type="file" multiple="multiple" name="images"/>

        <button type="submit">수정</button>
    </form>
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

</body>
</html>