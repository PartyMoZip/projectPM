<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>파티포토갤러리</title>
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/images/favicon.ico"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <!-- 폰트어썸 -->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
      integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
      crossorigin="anonymous"
    />

    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/partyMainPhoto.css"
    />
  </head>
  <body>
    <%--HEADER--%>
    <jsp:include
      page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"
    />
    <jsp:include
      page="${pageContext.request.contextPath}/WEB-INF/views/include/partynav.jsp"
    />

    <div class="container mt-5">
      <main>
        <div class="inner-container container-title">파티 포토갤러리</div>

        <div class="album py-5">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <c:choose>
              <c:when test="${not empty __LIST__}">
                <c:forEach items="${__LIST__}" var="list">
                  <div class="col">
                    <div class="card shadow-sm">
                      <svg
                        class="bd-placeholder-img card-img-top"
                        width="100%"
                        height="225"
                        xmlns="http://www.w3.org/2000/svg"
                        role="img"
                        aria-label="Placeholder: Thumbnail"
                        preserveAspectRatio="xMidYMid slice"
                        focusable="false"
                      >
                        <title>Placeholder</title>
                        <rect width="100%" height="100%" fill="#55595c"></rect>
                        <text x="50%" y="50%" fill="#eceeef" dy=".3em">
                          Thumbnail
                        </text>
                      </svg>

                      <div class="card-body">
                        <p class="card-text">
                          <c:out value="${list.psubject}" />
                        </p>
                        <div
                          class="
                            d-flex
                            justify-content-between
                            align-items-center
                          "
                        >
                          <div class="btn-group">
                            <button
                              type="button"
                              class="btn btn-sm btn-outline-secondary"
                              onClick="location.href='/partyphoto/detail?prefer=${list.prefer}&partyCode=${list.partycode}&currPage=${pageMaker.cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}';"
                            >
                              View
                            </button>
                          </div>
                          <small class="text-muted"
                            ><c:out value="${list.pdate}"
                          /></small>
                        </div>
                      </div>
                    </div>
                  </div>
                </c:forEach>
              </c:when>
              <c:otherwise>
                <td>등록된 글이 없습니다</td>
              </c:otherwise>
            </c:choose>
          </div>
          <button
            type="submit"
            class="btn btn-primary mt-4 save-btn"
            onClick="location.href='/partyphoto/writeview?partyCode=${ldto.partyCode}&searchWord=${ldto.searchWord}&option=${ldto.option}&currPage=${pageMaker.cri.currPage}';"
          >
            글쓰기
          </button>
        </div>
      </main>
    </div>

    <div class="bottom-menu-page">
      <div class="changePage">
        <nav aria-label="Page navigation example">
          <c:choose>
            <c:when test="${not empty __LIST__}">
              <div id="pagination">
                <form id="paginationForm">
                  <ul class="pagination justify-content-center">
                    <c:if test="${pageMaker.prev}">
                      <li class="prev page-item">
                        <a
                          class="prev page-link"
                          href="/partyphoto/list?partyCode=${ldto.partyCode}&currPage=${pageMaker.startPage-1}&searchWord=${ldto.searchWord}&option=${ldto.option}"
                          >◀</a
                        >
                      </li>
                    </c:if>

                    <c:forEach
                      begin="${pageMaker.startPage}"
                      end="${pageMaker.endPage}"
                      var="pageNum"
                    >
                      <li class="page-item">
                        <a
                          id="page-curr"
                          class="page-link"
                          href="/partyphoto/list?partyCode=${ldto.partyCode}&currPage=${pageNum}&searchWord=${ldto.searchWord}&option=${ldto.option}"
                        >
                          ${pageNum}
                        </a>
                      </li>
                    </c:forEach>

                    <c:if test="${pageMaker.next}">
                      <li class="next page-item">
                        <a
                          class="next page-link"
                          href="/partyphoto/list?partyCode=${ldto.partyCode}&currPage=${pageMaker.endPage+1}&searchWord=${ldto.searchWord}&option=${ldto.option}"
                          >▶</a
                        >
                      </li>
                    </c:if>
                  </ul>
                </form>
              </div>
            </c:when>
          </c:choose>
        </nav>
      </div>
    </div>

    <div class="container">
      <%--FOOTER--%>
      <jsp:include
        page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"
      />
    </div>

    <!-- 부트스트랩 js -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <!-- 제이쿼리 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
    <!-- 스윗알러트 -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  </body>
</html>
