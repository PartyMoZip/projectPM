<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2021-11-19
  Time: 오후 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
<!-- 부트스트랩 css -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/home.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/boardList.css" />

<title>파티메인페이지 - 자유게시판</title>
</head>

<body>

<%--HEADER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>

<main>
    <div class="all-wrap">
        <nav id="freebar" class="nav nav-pills flex-column flex-sm-row">
            <a class="flex-sm-fill text-sm-center nav-link active" href="#">파티 - 자유게시판</a>
        </nav>
        <!-- 자유게시판 테이블 시작 -->
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <!-- 자유게시판 체크박스 전체선택 -->
                    <th scope="col">
                        <div class="checkbox-group">
                            <div class="checkbox-groupParty">
                                <input type="checkbox" id="check-allFreeBoard" name="check-allFreeBoard"
                                       class="bigCheck">
                            </div>
                        </div>
                    </th>
                    <!-- 자유게시판 체크박스 전체선택 끝 -->
                    <th scope="col">NO</th>
                    <th scope="col">제목</th>
                    <th scope="col">작성자</th>
                    <th scope="col">작성일</th>
                    <th scope="col">조회수</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty list}">
                        <c:forEach items="${list}" var="list">
                            <tr>
                                <td>
                                    <div class="checkbox-group">
                                        <div class="partyCheckboxGroup">
                                            <input type="checkbox" class="bigCheck" name="fbc">
                                        </div>
                                    </div>
                                </td>
                                <td><c:out value="${list}"/></td>
                                <td>
                                    <a href="/partyfree/showPartyFDetail?pfrefer=${list.pfRefer}&currPage=${pageMaker.cri.currPage}&amount=${pageMaker.cri.amount}&pagesPerPage=${pageMaker.cri.pagesPerPage}">${list.pfSubject}</a>
                                </td>
                                <td><c:out value="${list.email}"/></td>
                                <td><fmt:formatDate pattern="yyyy.MM.dd" value="${list.pfDate}"/></td>
                                <td><c:out value="${list.readnum}"/></td>
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
        <!-- 자유게시판 테이블 끝-->

        <!-- 하단메뉴 -->

        <!-- 버튼 -->
        <div class="d-grid gap-2 d-md-block">
            <button type="button" class="btn btn-primary btn-sm"
                    onclick="location.href='/partyfree/writePFreeBoardView'">
                <i class="fas fa-list-ul"></i>
                <span>글쓰기</span>
            </button>
        </div>
        <div id="pagination">
            <form id="paginationForm">
                <input type="hidden" name="currPage">
                <input type="hidden" name="amount">
                <input type="hidden" name="pagesPerPage">
                <ul class="pagination justify-content-center">
                    <c:if test="${pageMaker.prev}">
                        <li class="prev page-item">
                            <a class="prev page-link"
                               href="/partyfree/getPFreeBoardList?currPage=${pageMaker.startPage-1}">◀</a>
                        </li>
                    </c:if>

                    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
                        <li class="page-item">
                            <a id="page-curr" class="page-link"
                               href="/partyfree/getPFreeBoardList?currPage=${pageNum}">
                                    ${pageNum}
                            </a>
                        </li>
                    </c:forEach>

                    <c:if test="${pageMaker.next}">
                        <li class="next page-item">
                            <a class="next page-link"
                               href="/partyfree/getPFreeBoardList?currPage=${pageMaker.endPage+1}">▶</a>
                        </li>
                    </c:if>
                </ul>
            </form>
        </div>


        <!-- 검색창 -->
        <!-- 검색창 -->
        <form action="검색URL" method="get">
            <div class="container-sm search-wrapper">
                <div class="input-group mb-3">
                    <div class="selectBox">
                        <div class="div1">
                            <select name="option" class="optionSelect">
                                <option value="1">전체</option>
                                <option value="2">작성자</option>
                                <option value="3">제목</option>
                                <option value="4">내용</option>
                            </select>
                        </div>
                        <span class="icoArrow"><img
                                src="https://freepikpsd.com/media/2019/10/down-arrow-icon-png-7-Transparent-Images.png"
                                alt=""></span>
                    </div>
                    <!-- 검색창 -->
                    <input type="text" name="keyword" class="form-control" placeholder="   검색어를 입력해주세요."
                           aria-label="Text input with dropdown button">
                    <div id="searchIcon" class="search-btn-icon">
                        <button class="search-btn" type="submit">
            <span>
              <i class="fas fa-search"></i>
            </span>
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>


</main>
<%--FOOTER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"/>

<!-- 부트스트랩 js -->
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>

</body>

</html>