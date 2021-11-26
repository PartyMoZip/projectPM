<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty __LIST__}">
            <c:forEach items="${__LIST__}" var="list">
                <c:set var="pcode" value="${list.partycode}"></c:set>
                <tr>
                    <td>
                        <div class="checkbox-group">
                           <div class="partyCheckboxGroup">
                                <input type="checkbox" class="bigCheck" name="fbc">
                              </div>
                        </div>
                   </td>
                    <td><c:out value="${list.prefer}"/></td>
                     <td>
                          <a href="/partyphoto/detail?prefer=${list.prefer}&partyCode=${list.partycode}&currPage=${pageMaker.cri.currPage}&amount=${pageMaker.cri.amount}&pagesPerPage=${pageMaker.cri.pagesPerPage}">${list.psubject}</a>
                      </td>
                   <td><c:out value="${list.nickname}"/></td>
                      <td><fmt:formatDate pattern="yyyy.MM.dd" value="${list.pdate}"/></td>
                   <td><c:out value="${list.readnum}"/></td>
               </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
           <td>등록된 글이 없습니다</td>
        </c:otherwise>
    </c:choose>
    <hr>
    <a href="/partyphoto/writeview?partyCode=${pcode}&currPage=${pageMaker.cri.currPage}">글쓰기</a>
    <hr>

    <hr>
    <c:choose>
        <c:when test="${not empty __LIST__}">
    <div id="pagination">
        <form id="paginationForm">
            <input type="hidden" name="currPage">
            <input type="hidden" name="amount">
            <input type="hidden" name="pagesPerPage">
            <ul class="pagination justify-content-center">
                <c:if test="${pageMaker.prev}">
                    <li class="prev page-item">
                        <a class="prev page-link"
                           href="/partyphoto/list?currPage=${pageMaker.startPage-1}&searchWord=${searchWord}&option=${option}">◀</a>
                    </li>
                </c:if>

                <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
                    <li class="page-item">
                        <a id="page-curr" class="page-link"
                           href="/partyphoto/list?currPage=${pageNum}&searchWord=${searchWord}&option=${option}">
                                ${pageNum}
                        </a>
                    </li>
                </c:forEach>

                <c:if test="${pageMaker.next}">
                    <li class="next page-item">
                        <a class="next page-link"
                           href="/partyphoto/list?currPage=${pageMaker.endPage+1}&searchWord=${searchWord}&option=${option}">▶</a>
                    </li>
                </c:if>
            </ul>
        </form>
    </div>
</c:when>
    </c:choose>
</body>
</html>