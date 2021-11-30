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
							<th scope="col">가입일자</th>
						</tr>
					</thead>

					<tbody>

						<tr>
							<td>
								<!-- 파티관리 체크박스 개별선택 -->
								<div class="checkbox-group">
									<div class="partyCheckboxGroup">
										<input type="checkbox" class="bigCheck" name="amk">
									</div>
								</div> <!-- 파티관리 체크박스 개별선택 끝 -->
							</td>

							<td><img
								src="${pageContext.request.contextPath}/resources/images/logo.svg"
								alt="파티원 이미지"></td>
							<td>sexypeople</td>
							<td>2021.01.01</td>

						</tr>

						<tr>
							<td>
								<!-- 파티관리 체크박스 개별선택 -->
								<div class="checkbox-group">
									<div class="partyCheckboxGroup">
										<input type="checkbox" class="bigCheck" name="amk">
									</div>
								</div> <!-- 파티관리 체크박스 개별선택 끝 -->
							</td>

							<td><img
								src="${pageContext.request.contextPath}/resources/images/logo.svg"
								alt="파티원 이미지"></td>
							<td>sexypeople</td>
							<td>2021.01.01</td>

						</tr>

					</tbody>
				</table>
			</div>
			<!-- 파티관리 테이블 끝-->

			<!-- 하단메뉴 -->
			<!-- 버튼 -->
			<div class="bottom-menu-btn">
				<div class="d-grid gap-2 d-md-block">
					<button class="btn btn-primary" type="button">추방</button>
				</div>
			</div>

			<div class="bottom-menu-page">
				<div class="changePage">
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<li class="page-item"><a class="page-link active" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>

			<!-- 검색창 -->

			<div class="container-sm search-wrapper">
				<form action="/search" method="get"
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
	<script
		src="${pageContext.request.contextPath}/resources/js/partyMain.js"></script>

</body>
</html>