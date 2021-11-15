<%--
  Created by IntelliJ IDEA.
  User: chico
  Date: 2021-11-08
  Time: 오후 6:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>파티모집 - 검색</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/search.css?after">
</head>
<body>

<%--HEADER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>
<%--<h3>pageMaker: ${pageMaker}</h3>--%>
<%--<h3>searchWord: ${searchWord}</h3>--%>
<%--<h3>hobby: ${hobby}</h3>--%>
<%--<h3>local: ${local}</h3>--%>
<div class="container mt-5">
    <main>
        <div class="inner-container container-md">
            <form action="/search/searchList" method="get"
                  class="select-form d-flex justify-content-between container-md">
                <h3 class="inner-menu">
                    <c:choose>
                        <c:when test="${searchWord != null && !searchWord.equals('all') && !searchWord.equals('')}">
                            ${searchWord}
                        </c:when>
                        <c:otherwise>
                            전체
                        </c:otherwise>
                    </c:choose>
                </h3>
                <%--카테고리 선택 드랍다운 메뉴--%>
                <div class="dropdown-group d-flex align-items-center">
                    <h4 class="mb-0 m-lg-2">
                        <c:choose>
                            <c:when test="${searchWord != null && !searchWord.equals('all') && !searchWord.equals('')}">
                                #${searchWord}
                            </c:when>
                            <c:otherwise>

                            </c:otherwise>
                        </c:choose>
                    </h4>
                    <input type="hidden" class="wordInput" name="word" value="${searchWord}">
                    <div class="btn-group">
                        <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown"
                                aria-expanded="false">
                            <c:choose>
                                <c:when test="${hobby != null && !hobby.equals('')}">
                                    ${hobby}
                                </c:when>
                                <c:otherwise>
                                    취미
                                </c:otherwise>
                            </c:choose>
                        </button>
                        <ul class="dropdown-menu menu-hobby">
                            <li>
                                <input type="text" name="hobby" class="dropdown-search select-hobby"
                                       placeholder="취미 검색..">
                            </li>
                            <li class="dropdown-item">전체</li>
                            <li class="dropdown-item">컴퓨터게임</li>
                            <li class="dropdown-item">축구</li>
                            <li class="dropdown-item">등산</li>
                            <li class="dropdown-item">요리</li>
                        </ul>
                    </div>
                    <div class="btn-group">
                        <button type="button" class="btn dropdown-toggle" data-bs-toggle="dropdown"
                                aria-expanded="false">
                            <c:choose>
                                <c:when test="${local != null && !local.equals('')}">
                                    ${local}
                                </c:when>
                                <c:otherwise>
                                    지역
                                </c:otherwise>
                            </c:choose>
                        </button>
                        <ul class="dropdown-menu menu-local">
                            <li>
                                <input class="select-local" name="local" type="hidden">
                            </li>
                            <li class="dropdown-item">전체</li>
                            <li class="dropdown-item">강동</li>
                            <li class="dropdown-item">강서</li>
                            <li class="dropdown-item">강남</li>
                            <li class="dropdown-item">강북</li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>


        <div class="album py-5">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <c:forEach items="${list}" var="party">
                    <div class="col">
                        <div class="card shadow-sm">
                            <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                                 xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                                 preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                                <rect width="100%" height="100%" fill="#55595c"></rect>
                                <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                            </svg>

                            <div class="card-body">
                                <p class="card-text"><c:out value="${party.partyName}"/></p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                    </div>
                                    <small class="text-muted"><c:out value="${party.hobbyName}"/></small>
                                    <small class="text-muted"><c:out value="${party.localName}"/></small>
                                    <small class="text-muted"><c:out value="${party.partyScore}"/></small>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <%--<div class="col">
                    <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                             preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>

                        <div class="card-body">
                            <p class="card-text">파티 이름</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View</button>

                                </div>
                                <small class="text-muted">#축구</small>
                                <small class="text-muted">#강남</small>
                                <small class="text-muted">활동점수 18</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                             preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>

                        <div class="card-body">
                            <p class="card-text">파티 이름</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View</button>

                                </div>
                                <small class="text-muted">#축구</small>
                                <small class="text-muted">#강남</small>
                                <small class="text-muted">활동점수 18</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                             preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>

                        <div class="card-body">
                            <p class="card-text">파티 이름</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View</button>

                                </div>
                                <small class="text-muted">#축구</small>
                                <small class="text-muted">#강남</small>
                                <small class="text-muted">활동점수 18</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                             preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>

                        <div class="card-body">
                            <p class="card-text">파티 이름</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View</button>

                                </div>
                                <small class="text-muted">#축구</small>
                                <small class="text-muted">#강남</small>
                                <small class="text-muted">활동점수 18</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                             preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>

                        <div class="card-body">
                            <p class="card-text">파티 이름</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View</button>

                                </div>
                                <small class="text-muted">#축구</small>
                                <small class="text-muted">#강남</small>
                                <small class="text-muted">활동점수 18</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                             preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>

                        <div class="card-body">
                            <p class="card-text">파티 이름</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View</button>

                                </div>
                                <small class="text-muted">#축구</small>
                                <small class="text-muted">#강남</small>
                                <small class="text-muted">활동점수 18</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                             preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>

                        <div class="card-body">
                            <p class="card-text">파티 이름</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View</button>

                                </div>
                                <small class="text-muted">#축구</small>
                                <small class="text-muted">#강남</small>
                                <small class="text-muted">활동점수 18</small>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                             preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                            <rect width="100%" height="100%" fill="#55595c"></rect>
                            <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                        </svg>

                        <div class="card-body">
                            <p class="card-text">파티 이름</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-sm btn-outline-secondary">View</button>

                                </div>
                                <small class="text-muted">#축구</small>
                                <small class="text-muted">#강남</small>
                                <small class="text-muted">활동점수 18</small>
                            </div>
                        </div>
                    </div>
                </div>--%>
            </div>
        </div>

        <div id="pagination">
            <form id="paginationForm">
                <input type="hidden" name="currPage">
                <input type="hidden" name="amount">
                <input type="hidden" name="pagesPerPage">
                <input type="hidden" name="word" value="${searchWord}">
                <input type="hidden" name="hobby" value="${hobby}">
                <input type="hidden" name="local" value="${local}">
                <ul>
                    <c:if test="${pageMaker.prev}">
                        <li class="prev">
                            <a class="prev" href="${pageMaker.startPage-1}">◀</a>
                        </li>
                    </c:if>

                    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
                        <li>
                            <a href="/search/searchList?currPage=${pageNum}">
                                    ${pageNum}
                            </a>
                        </li>
                    </c:forEach>

                    <c:if test="${pageMaker.next}">
                        <li class="next">
                            <a class="next" href="${pageMaker.endPage+1}">▶</a>
                        </li>
                    </c:if>
                </ul>
            </form>
        </div>
    </main>
</div>

<div class="container">
    <%--FOOTER--%>
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"/>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
</body>
</html>
