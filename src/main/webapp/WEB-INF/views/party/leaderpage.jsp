<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 css -->
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
	href="${pageContext.request.contextPath}/resources/css/partyMain.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin.css" />
<title>파티모집 - 파티관리</title>
</head>
<body>

	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />

	<%-- <h1>/WEB-INF/views/party/showLeaderPage.jsp</h1>
    <hr>
    <h3>${__PARTY__}</h3>
    <form action="/party/editparty" method="post">
        <input type="hidden" name="partyCode" value="${__PARTY__.partyCode}">
        <input type="text" name="partyName" value="${__PARTY__.partyName}">
        <input type="text" name="partyProfile" value="${__PARTY__.partyProfile}">
        <input type="text" name="localCode" value="${__PARTY__.localName}">
        <input type="text" name="hobbyCode" value="${__PARTY__.hobbyName}">
        <input type="submit" value="파티정보수정">
      </form>
      <hr>
      <form action="/party/dobreak" method="post">
        <input type="hidden" name="partyCode" value="${__PARTY__.partyCode}">
        <input type="submit" value="파티해체신청">
      </form>
      <hr>
      <form action="/party/editleader" method="post">
        <input type="hidden" name="leaderEmail" value="test1@test.com">
        <input type="hidden" name="memberEmail" value="test24@test.com">
        <input type="hidden" name="partyCode" value="${__PARTY__.partyCode}">
        <input type="submit" value="파티장 위임">
      </form>
      <hr>
      <form action="/party/editpl" method="post" enctype="multipart/form-data">
        <input type="hidden" name="partyCode" value=10>
        <input type="file" multiple="multiple" name="image"/>
        <button type="submit">전송</button>
      </form>
      <h1>${logoresult}</h1>
      <img src="${__PARTY__.logoPic}" alt="" />
      <hr>
      <form action="/party/editpi" method="post" enctype="multipart/form-data">
        <input type="hidden" name="partyCode" value=10>
        <input type="file" multiple="multiple" name="image"/>
        <button type="submit">전송</button>
      </form>
      <h1>${mainresult}</h1>
      <img src="${__PARTY__.coverPic}" alt="" /> --%>

	<!-- 파티 관리페이지 상단 탭 -->
	<ul class="nav nav-pills">
		<li class="nav-item"><a class="nav-link" aria-current="page"
			href="/party/showmain?partyCode=${__PARTY__.partyCode}">메인</a></li>
		<li class="nav-item"><a class="nav-link active"
			href="/party/leaderpage?partyCode=${__PARTY__.partyCode}">파티관리</a></li>
		<li class="nav-item"><a class="nav-link" href="#">일정</a></li>
		<li class="nav-item"><a class="nav-link" href="#">파티원</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/partyfree/getPFreeBoardList">자유게시판</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/partyphoto/list?partyCode=${__PARTY__.partyCode}">포토갤러리</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/partyfunc/partychat?partyCode=${__PARTY__.partyCode}">채팅</a></li>
	</ul>
	<main>

		<!-- 파티프로필 설정 -->
		<div class="container mt-5 px-5 profile-box shadow-sm">
			<div class="header">
				<h4>파티프로필 설정</h4>
			</div>
			<div class="container-lg d-flex justify-content-center">
				<div
					class="d-flex flex-column justify-content-center align-items-center">
					<div class="container-partyProfileImg">
						<svg class="bd-placeholder-img bd-placeholder-img-lg img-fluid"
							width="100%" height="250" xmlns="http://www.w3.org/2000/svg"
							role="img" aria-label="Placeholder: Responsive image"
							preserveAspectRatio="xMidYMid slice" focusable="false">
              <rect width="100%" height="100%" fill="#868e96"></rect>
              <text x="45%" y="50%" fill="#dee2e6" dy=".3em">파티메인이미지</text>
            </svg>
					</div>
					<button type="button" class="btn btn-outline-primary">업로드</button>
				</div>

				<div
					class="d-flex flex-column justify-content-center align-items-center">
					<div class="container-partyProfileName">
						<span class="align-self-baseline label-partyname">파티이름</span> <input
							type="text" class="form-control input-partyname mt-2"
							name="partyname" value="진건이와 아이들">
					</div>
					<button type="submit" class="btn btn-primary mt-4 save-btn">저장</button>
				</div>
			</div>
		</div>

		<div class="container mt-5 px-5 profile-box shadow-sm">

			<div class="header">
				<h4>파티정보 변경</h4>
			</div>

			<div class="container-lg d-flex justify-content-center">
				<div
					class="d-flex flex-column justify-content-center align-items-center">
					<div class="container-partyInfoChange">
						<div class="container-partyInfoHobby">
							<div class="container-sm search-wrapper">
								<form action="/search" method="get"
									class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
									<input type="search" name="searchWord" class="form-control"
										placeholder="취미 카테고리를 검색해 주세요." aria-label="Search">
									<button class="search-btn">
										<span> <i class="fas fa-search"></i>
										</span>
									</button>
								</form>
							</div>
						</div>

						<div class="container-partyInfoCategory">
							<div class="container-partyInfoMember">
								<select class="form-select" aria-label="Default select example">
									<option selected>인원</option>
									<option value="1">10명</option>
									<option value="2">30명</option>
									<option value="3">50명</option>
									<option value="4">100명</option>
								</select>
							</div>

							<div class="container-partyInfoLocation">

								<select class="form-select" aria-label="Default select example">
									<option selected>지역</option>
									<option value="1">강남</option>
									<option value="2">강동</option>
									<option value="3">강북</option>
									<option value="4">강서</option>
								</select>
							</div>
						</div>

					</div>
					<button type="submit" class="btn btn-primary mt-4 save-btn">설정</button>
				</div>
			</div>
		</div>

		<div class="container mt-5 px-5 profile-box shadow-sm">
			<div class="header">
				<h4>파티승인 요청</h4>
			</div>
			<div class="all-wrap">
				<!-- 파티승인요청 테이블 시작 -->
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
							<tr>
								<!-- 파티승인요청 체크박스 전체선택 -->
								<th scope="col">
									<div class="checkbox-group">
										<div class="checkbox-groupParty">
											<input type="checkbox" id="check-allPartyAccept"
												name="check-allPartyAccept" class="bigCheck">
										</div>
									</div>
								</th>
								<!-- 파티관리 체크박스 전체선택 끝 -->
								<th scope="col">번호</th>
								<th scope="col">파티 이름</th>
								<th scope="col">파티장</th>
								<th scope="col">파티인원 수</th>
								<th scope="col">창설일자</th>
								<th scope="col">
									<div class="nav-item dropdown">
										<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown"
											href="#" role="button" aria-expanded="false">활동점수 정렬</a>
										<div class="dropdown-menu">
											<li><a class="dropdown-item" href="#">활동점수 최소 순</a></li>
											<li>
												<hr class="dropdown-divider">
											</li>
											<li><a class="dropdown-item" href="#">활동점수 최대 순</a></li>
										</div>
									</div>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<!-- 파티관리 체크박스 개별선택 -->
									<div class="checkbox-group">
										<div class="partyCheckboxGroup">
											<input type="checkbox" class="bigCheck" name="apa">
										</div>
									</div> <!-- 파티관리 체크박스 개별선택 끝 -->
								</td>
								<th scope="row">1</th>
								<td>sexypeople</td>
								<td>sexyjingun</td>
								<td>10</td>
								<td>2021.11.10</td>
								<td>50</td>
							</tr>
							<tr>
								<td>
									<!-- 파티관리 체크박스 개별선택 -->
									<div class="checkbox-group">
										<div class="partyCheckboxGroup">
											<input type="checkbox" class="bigCheck" name="apa">
										</div>
									</div> <!-- 파티관리 체크박스 개별선택 끝 -->
								</td>
								<th scope="row">2</th>
								<td>sexypeople</td>
								<td>sexyjingun</td>
								<td>10</td>
								<td>2021.11.10</td>
								<td>50</td>
							</tr>
							<tr>
								<td>
									<!-- 파티관리 체크박스 개별선택 -->
									<div class="checkbox-group">
										<div class="partyCheckboxGroup">
											<input type="checkbox" class="bigCheck" name="apa">
										</div>
									</div> <!-- 파티관리 체크박스 개별선택 끝 -->
								</td>
								<th scope="row">3</th>
								<td>sexypeople</td>
								<td>sexyjingun</td>
								<td>10</td>
								<td>2021.11.10</td>
								<td>50</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- 파티관리 테이블 끝-->

				<!-- 하단메뉴 -->
				<!-- 버튼 -->
				<div class="bottom-menu-btn">

					<div class="d-grid gap-2 d-md-block">
						<button class="btn btn-primary" type="button">파티 해체</button>
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

				<div class="container-sm partyMain-search-wrapper">
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
		</div>

	</main>

	<%--FOOTER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp" />

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
		src="${pageContext.request.contextPath}/resources/js/partyMain.js"></script>

</body>
</html>