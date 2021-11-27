<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파티포토갤러리</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<!-- 폰트어썸 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/partyMainPhoto.css" />

</head>
<body>
	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />

	<%-- <c:choose>
		<c:when test="${not empty __LIST__}">
			<c:forEach items="${__LIST__}" var="list">
				<tr>
					<td>
						<div class="checkbox-group">
							<div class="partyCheckboxGroup">
								<input type="checkbox" class="bigCheck" name="fbc">
							</div>
						</div>
					</td>
					<td><c:out value="${list.prefer}" /></td>
					<td><a
						href="/partyphoto/detail?prefer=${list.prefer}&partyCode=${list.partycode}&currPage=${pageMaker.cri.currPage}&amount=${pageMaker.cri.amount}&pagesPerPage=${pageMaker.cri.pagesPerPage}">${list.psubject}</a>
					</td>
					<td><c:out value="${list.nickname}" /></td>
					<td><fmt:formatDate pattern="yyyy.MM.dd" value="${list.pdate}" /></td>
					<td><c:out value="${list.readnum}" /></td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<td>등록된 글이 없습니다</td>
		</c:otherwise>
	</c:choose>
	<hr>
	<a
		href="/partyphoto/writeview?partyCode=${partyCode}&currPage=${pageMaker.cri.currPage}">글쓰기</a>
	<hr>

	<hr>
	<c:choose>
		<c:when test="${not empty __LIST__}">
			<div id="pagination">
				<form id="paginationForm">
					<input type="hidden" name="currPage"> <input type="hidden"
						name="amount"> <input type="hidden" name="pagesPerPage">
					<ul class="pagination justify-content-center">
						<c:if test="${pageMaker.prev}">
							<li class="prev page-item"><a class="prev page-link"
								href="/partyphoto/list?currPage=${pageMaker.startPage-1}&searchWord=${searchWord}&option=${option}">◀</a>
							</li>
						</c:if>

						<c:forEach begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}" var="pageNum">
							<li class="page-item"><a id="page-curr" class="page-link"
								href="/partyphoto/list?currPage=${pageNum}&searchWord=${searchWord}&option=${option}">
									${pageNum} </a></li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="next page-item"><a class="next page-link"
								href="/partyphoto/list?currPage=${pageMaker.endPage+1}&searchWord=${searchWord}&option=${option}">▶</a>
							</li>
						</c:if>
					</ul>
				</form>
			</div>
		</c:when>
	</c:choose> --%>

	<div class="container mt-5">
		<main>
			<ul class="nav nav-pills">
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="/party/showmain?partyCode=${partyCode}">메인</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/party/leaderpage?partyCode=${partyCode}">파티관리</a></li>
				<li class="nav-item"><a class="nav-link" href="#">일정</a></li>
				<li class="nav-item"><a class="nav-link" href="#">파티원</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/partyfree/getPFreeBoardList">자유게시판</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="/partyphoto/list?partyCode=${partyCode}">포토갤러리</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/partyfunc/partychat?partyCode=${partyCode}">채팅</a></li>
			</ul>

			<div class="inner-container container-title">파티 포토갤러리</div>

			<div class="album py-5">
				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
					<div class="col">
						<div class="card shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg" role="img"
								aria-label="Placeholder: Thumbnail"
								preserveAspectRatio="xMidYMid slice" focusable="false">
									<title>Placeholder</title>
                                <rect width="100%" height="100%"
									fill="#55595c"></rect>
                                <text x="50%" y="50%" fill="#eceeef"
									dy=".3em">Thumbnail</text>
                            </svg>

							<div class="card-body">
								<p class="card-text">행복한 진거뉘</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary"
											onClick="location.href='./detail';">View</button>
									</div>
									<small class="text-muted"><c:out
											value="게시날짜 넣어줘 형. 좋아요 카운트 넣으실?" /></small>
								</div>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="card shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg" role="img"
								aria-label="Placeholder: Thumbnail"
								preserveAspectRatio="xMidYMid slice" focusable="false">
									<title>Placeholder</title>
                                <rect width="100%" height="100%"
									fill="#55595c"></rect>
                                <text x="50%" y="50%" fill="#eceeef"
									dy=".3em">Thumbnail</text>
                            </svg>

							<div class="card-body">
								<p class="card-text">행복한 진거뉘</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
									</div>
									<small class="text-muted"><c:out value="게시날짜 넣어줘 형" /></small>
								</div>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="card shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg" role="img"
								aria-label="Placeholder: Thumbnail"
								preserveAspectRatio="xMidYMid slice" focusable="false">
									<title>Placeholder</title>
                                <rect width="100%" height="100%"
									fill="#55595c"></rect>
                                <text x="50%" y="50%" fill="#eceeef"
									dy=".3em">Thumbnail</text>
                            </svg>

							<div class="card-body">
								<p class="card-text">행복한 진거뉘</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
									</div>
									<small class="text-muted"><c:out value="게시날짜 넣어줘 형" /></small>
								</div>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="card shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg" role="img"
								aria-label="Placeholder: Thumbnail"
								preserveAspectRatio="xMidYMid slice" focusable="false">
									<title>Placeholder</title>
                                <rect width="100%" height="100%"
									fill="#55595c"></rect>
                                <text x="50%" y="50%" fill="#eceeef"
									dy=".3em">Thumbnail</text>
                            </svg>

							<div class="card-body">
								<p class="card-text">행복한 진거뉘</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
									</div>
									<small class="text-muted"><c:out value="게시날짜 넣어줘 형" /></small>
								</div>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="card shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg" role="img"
								aria-label="Placeholder: Thumbnail"
								preserveAspectRatio="xMidYMid slice" focusable="false">
									<title>Placeholder</title>
                                <rect width="100%" height="100%"
									fill="#55595c"></rect>
                                <text x="50%" y="50%" fill="#eceeef"
									dy=".3em">Thumbnail</text>
                            </svg>

							<div class="card-body">
								<p class="card-text">행복한 진거뉘</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
									</div>
									<small class="text-muted"><c:out value="게시날짜 넣어줘 형" /></small>
								</div>
							</div>
						</div>
					</div>

					<div class="col">
						<div class="card shadow-sm">
							<svg class="bd-placeholder-img card-img-top" width="100%"
								height="225" xmlns="http://www.w3.org/2000/svg" role="img"
								aria-label="Placeholder: Thumbnail"
								preserveAspectRatio="xMidYMid slice" focusable="false">
									<title>Placeholder</title>
                                <rect width="100%" height="100%"
									fill="#55595c"></rect>
                                <text x="50%" y="50%" fill="#eceeef"
									dy=".3em">Thumbnail</text>
                            </svg>

							<div class="card-body">
								<p class="card-text">행복한 진거뉘</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
									</div>
									<small class="text-muted"><c:out
											value="게시날짜 넣어줘 형. 좋아요 카운트 넣으실?" /></small>
								</div>
							</div>
						</div>
					</div>

				</div>
				<button type="submit" class="btn btn-primary mt-4 save-btn"
					onClick="location.href='/partyphoto/writeview?partyCode=${partyCode}&currPage=${pageMaker.cri.currPage}';">글쓰기</button>
			</div>
		</main>

	</div>

	<div class="bottom-menu-page">
		<div class="changePage">
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item active"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>

	<div class="container">
		<%--FOOTER--%>
		<jsp:include
			page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp" />
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
	<script
		src="${pageContext.request.contextPath}/resources/js/partyedit.js"></script>

</body>
</html>