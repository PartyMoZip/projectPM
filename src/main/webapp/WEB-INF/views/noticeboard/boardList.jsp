<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2021-11-19
  Time: 오후 3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <!-- 부트스트랩 css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/boardList.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>파티모집 - 공지</title>
</head>
<body>
<%--HEADER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>

<div class="board_list">
    <main>
        <div class="container-sm">
            <ul class="nav nav-pills">
                <li class="nav-item"><a class="nav-link active"
                                        aria-current="page" href="#">공지게시판</a></li>
            </ul>
            <!-- 공지게시판 테이블 시작 -->
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
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
                                    <td><c:out value="${list.NRefer}"/></td>
                                    <td>
                                        <a href="/noticeboard/showNoticeDetail?nrefer=${list.NRefer}&currPage=${pageMaker.cri.currPage}&amount=${pageMaker.cri.amount}&pagesPerPage=${pageMaker.cri.pagesPerPage}">${list.NSubject}</a>
                                    </td>
                                    <td><c:out value="${list.nickname}"/></td>
                                    <td><fmt:formatDate pattern="yyyy.MM.dd" value="${list.NDate}"/></td>
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
            <!-- 공지게시판 테이블 끝-->

            <!-- 하단메뉴 -->

            <!-- 버튼 -->
            <div class="d-grid gap-2 d-md-block">
                <c:if test="${sessionScope.__AUTH__.userBanned == -2}">
                    <button type="button" class="btn btn-primary btn-sm"
                    onclick="location.href='/noticeboard/writeNoticeBoardView'">
                    <i class="fas fa-list-ul"></i>
                <span>글쓰기</span>
            </button>
                </c:if>
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
                                   href="/noticeboard/getNoticeBoardList?currPage=${pageMaker.startPage-1}">◀</a>
                            </li>
                        </c:if>

                        <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
                            <li class="page-item">
                                <a id="page-curr" class="page-link"
                                   href="/noticeboard/getNoticeBoardList?currPage=${pageNum}">
                                        ${pageNum}
                                </a>
                            </li>
                        </c:forEach>

                        <c:if test="${pageMaker.next}">
                            <li class="next page-item">
                                <a class="next page-link"
                                   href="/noticeboard/getNoticeBoardList?currPage=${pageMaker.endPage+1}">▶</a>
                            </li>
                        </c:if>
                    </ul>
                </form>
            </div>


            <!-- 검색창 -->
            <!-- 검색창 -->
            <form action="/noticeboard/getNoticeBoardList" method="get">
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
                        <input type="text" name="searchWord" class="form-control" placeholder="   검색어를 입력해주세요."
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
<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
</body>

</html>