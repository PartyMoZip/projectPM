<%--
  Created by IntelliJ IDEA.
  User: EUN-Ng
  Date: 2021-11-13
  Time: 오후 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<!-- 부트스트랩 css --><link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
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
	href="${pageContext.request.contextPath}/resources/css/admin.css" />

<title>관리자페이지 - 파티해체 승인 요청</title>
</head>

<body>

	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />

	<main>
		<div class="all-wrap">
			<!-- 탭 메뉴 -->
			<ul class="nav nav-pills">
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="/admin/getPartyList">파티관리</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/admin/adminPartyBreak">파티해체 승인 요청</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/admin/adminBlackParty">블랙파티리스트 관리</a></li>
			</ul>

			<!-- 파티해체요청 테이블 시작 -->
			<form action="/admin/breakparty" method="post">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<!-- 파티해체요청 체크박스 전체선택 -->
							<th scope="col">
								<div class="checkbox-group">
									<div class="checkbox-groupPartyBreak">
										<input type="checkbox" id="check-allPartyBreak"
											name="check-allPartyBreak" class="bigCheck">
									</div>
								</div> <!-- 파티해체요청 체크박스 전체선택 끝 -->
							</th>
							<th scope="col">번호</th>
							<th scope="col">파티 이름</th>
							<th scope="col">파티장</th>
							<th scope="col">파티 인원 수</th>
							<th scope="col">파티 생성 일자</th>
							<th scope="col">활동점수</th>
							<th scope="col">파티해체 요청</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${__PartyList__}" var="list">
							<tr>
								<td>
									<!-- 파티해체요청 체크박스 개별선택 -->
									<div class="checkbox-group">
										<div class="partyBreakCheckboxGroup">
											<input type="checkbox" class="bigCheck" name="partyCode" value="${list.partyCode}">
										</div>
									</div> <!-- 파티해체요청 체크박스 개별선택 끝 -->
								</td>
								<th scope="row">${list.rownum}</th>
								<td>${list.partyName}</td>
								<td>${list.nickname}</td>
								<td>${list.partyMember}</td>
								<td>${list.createDate}</td>
								<td>${list.partyScore}</td>
								<td>파티해체요청이 들어왔습니다.</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- 파티해체요청 테이블 끝-->

			<!-- 하단메뉴 -->
			<!-- 버튼 -->
			<div class="bottom-menu-btn">

				<div class="d-grid gap-2 d-md-block">
					<button class="btn btn-primary" type="submit">해체 승인</button>
				</div>
			</div>
			</form>
			<div class="bottom-menu-page">
				<div class="changePage">
					<nav aria-label="Page navigation example">
						<c:choose>
							<c:when test="${not empty __PartyList__}">
								<div id="pagination">
									<form id="paginationForm">
										<ul class="pagination justify-content-center">
											<c:if test="${pageMaker.prev}">
												<li class="prev page-item"><a class="prev page-link"
																			  href="/admin/adminPartyBreak?currPage=${pageMaker.startPage-1}&searchWord=${searchWord}">◀</a>
												</li>
											</c:if>
			
											<c:forEach begin="${pageMaker.startPage}"
													   end="${pageMaker.endPage}" var="pageNum">
												<li class="page-item"><a id="page-curr" class="page-link"
																		 href="/admin/adminPartyBreak?currPage=${pageNum}&searchWord=${searchWord}">
														${pageNum} </a></li>
											</c:forEach>
			
											<c:if test="${pageMaker.next}">
												<li class="next page-item"><a class="next page-link"
																			  href="/admin/adminPartyBreak?currPage=${pageMaker.endPage+1}&searchWord=${searchWord}">▶</a>
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
				<form action="/admin/adminPartyBreak" method="get"
					class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="search" name="searchWord" class="form-control"
						placeholder="검색어를 입력해주세요." aria-label="Search">
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

	<script src="${pageContext.request.contextPath}/resources/js/admin.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>

</body>

</html>