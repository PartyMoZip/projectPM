<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>파티모집 - 파티원 목록</title>

<!-- 부트스트랩 css -->
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
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
	href="${pageContext.request.contextPath}/resources/css/partyMemberList.css" />
</head>

<body>

	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />

	<!-- 파티탭 -->
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/partynav.jsp" />

	<main>
		<div class="all-wrap">

			<!-- 파티관리 테이블 시작 -->
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
						<tr>
							<!-- 파티관리 체크박스 전체선택 -->
							<th scope="col">
								<div class="checkbox-group">
									<div class="checkbox-groupParty">
										<input type="checkbox" id="check-allMemberKick"
											name="check-allMemberKick" class="bigCheck">
									</div>
								</div>
							</th>
							<!-- 파티관리 체크박스 전체선택 끝 -->
							<th scope="col">이미지</th>
							<th scope="col">닉네임</th>
							<th scope="col">파티장 위임</th>
						</tr>
					</thead>

					<tbody>
						<form action="/party/dokick" method="post" id="dokick">
							<input type="hidden" name="partyCode" value="${partyCode}">
							<input type="hidden" name="currPage" value="${cri.currPage}">
						</form>
							<c:forEach items="${__USER__}" var="user">
								<tr>
									<td>
										<!-- 파티관리 체크박스 개별선택 -->
										<div class="checkbox-group">
											<div class="partyCheckboxGroup">
												<input type="checkbox" class="bigCheck" name="email" form="dokick"
													value="${user.email}">
											</div>
										</div> <!-- 파티관리 체크박스 개별선택 끝 -->
									</td>

									<td><img src="${user.userpic}" alt="파티원 이미지"></td>
									<td>${user.nickname}</td>
									<td><c:if test="${__AUTHCHECK__}">
											<c:if test="${user.email ne sessionScope.__AUTH__.email}">
												<form action="/party/editleader" method="post">
													<input type="hidden" name="partyCode" value="${partyCode}">
													<input type="hidden" name="leaderEmail" value="${sessionScope.__AUTH__.email}">
													<input type="hidden" name="memberEmail" value="${user.email}">
													<button class="btn btn-primary" type="submit">파티장 위임</button>
												</form>
											</c:if>
										</c:if></td>
								</tr>
							</c:forEach>


					</tbody>
				</table>
			</div>
			<!-- 파티관리 테이블 끝-->

			<!-- 하단메뉴 -->
			<!-- 버튼 -->


			<div class="bottom-menu-page">
				<div class="bottom-menu-btn">
					<button class="btn btn-primary" type="submit" form="dokick">추방</button>
				</div>
				<div class="changePage">
					<nav aria-label="Page navigation example">
						<c:choose>
							<c:when test="${not empty __USER__}">
								<div id="pagination">
									<form id="paginationForm">
										<ul class="pagination justify-content-center">
											<c:if test="${pageMaker.prev}">
												<li class="prev page-item"><a class="prev page-link"
													href="/party/memberlist?partyCode=${partyCode}&currPage=${pageMaker.startPage-1}&searchWord=${searchWord}">◀</a>
												</li>
											</c:if>

											<c:forEach begin="${pageMaker.startPage}"
												end="${pageMaker.endPage}" var="pageNum">
												<li class="page-item"><a id="page-curr"
													class="page-link"
													href="/party/memberlist?partyCode=${partyCode}&currPage=${pageNum}&searchWord=${searchWord}">
														${pageNum} </a></li>
											</c:forEach>

											<c:if test="${pageMaker.next}">
												<li class="next page-item"><a class="next page-link"
													href="/party/memberlist?partyCode=${partyCode}&currPage=${pageMaker.endPage+1}&searchWord=${searchWord}">▶</a>
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

			<!-- 검색창 -->

			<div class="container-sm search-wrapper">
				<form action="/party/memberlist" method="get"
					class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="hidden" name="partyCode" value="${partyCode}">
					<input type="search" name="searchWord" class="form-control"
						placeholder="닉네임을 입력해주세요." aria-label="Search">
					<button class="search-btn">
						<span> <i class="fas fa-search"></i>
						</span>
					</button>
				</form>
			</div>

		</div>
	</main>

	<%--FOOTER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp" />

	<!-- 부트스트랩 js -->
	<script defer
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<!-- 제이쿼리 -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/partyMain.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>

</body>
</html>