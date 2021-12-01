<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	href="${pageContext.request.contextPath}/resources/css/partyMain.css?after" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/leaderpage.css?after" />
<title>파티모집 - 파티관리</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
</head>
<body>

	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/partynav.jsp" />
  
  <%--SPINNER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/spinner.jsp"/>

	<%-- <h1>/WEB-INF/views/party/showLeaderPage.jsp</h1>
      <hr>
      <hr>
      <form action="/party/editleader" method="post">
        <input type="hidden" name="leaderEmail" value="test1@test.com">
        <input type="hidden" name="memberEmail" value="test24@test.com">
        <input type="hidden" name="partyCode" value="${__PARTY__.partyCode}">
        <input type="submit" value="파티장 위임">
      </form>--%>

	<main>

		<!-- 파티프로필 설정 -->
		<div class="container mt-5 px-5 profile-box shadow-sm">
			<div class="header">
				<h4>파티프로필 설정</h4>
			</div>

			<form class="form-data" enctype="multipart/form-data">
				<input type="hidden" class="input-partycode" name="partyCode"
					value="${__PARTY__.partyCode}"> <input type="hidden"
					class="input-partycode" name="currPage" value="${cri.currPage}">
				<div
					class="container-lg d-flex justify-content-center align-items-center">
					<div
						class="d-flex flex-column justify-content-center align-items-center">
						<div class="img-profile justify-content-center align-items-center">
							<img src="${__PARTY__.coverPic}" alt="파티 프로필 사진" width="700px"
								height="auto">
						</div>
						<div class="mt-2">
							<button type="button" class="btn btn-outline-primary select-btn">
								이미지 업로드</button>
							<input type="file"
								class="form-control input-file visually-hidden"
								name="fileLocation" accept="image/*">
						</div>
						<div
							class="d-flex flex-column justify-content-center align-items-center w-100 col-3 mt-4">
							<span class="align-self-baseline label-name"
								style="font-weight: bold">파티 이름</span> <input type="text"
								class="form-control input-partyname mt-2" name="partyName"
								value="${__PARTY__.partyName}">
						</div>
						<div
							class="d-flex flex-column justify-content-center align-items-center w-100 col-3 mt-4">
							<span class="align-self-baseline label-name"
								style="font-weight: bold">파티 소개글</span>
							<textarea class="form-control input-partyprofile mt-2"
								name="partyProfile">${__PARTY__.partyProfile}</textarea>
						</div>

						<button type="submit" class="btn btn-primary mt-4 save-btn">저장하기</button>
					</div>
				</div>
			</form>
		</div>

		<!-- 파티승인요청 관리 -->
		<div class="container mt-5 px-5 profile-box shadow-sm">
			<div class="header">
				<h4>파티승인 요청</h4>
			</div>
			<div class="all-wrap">
				<!-- 파티승인요청 테이블 시작 -->
				<div class="table-responsive">
					<form class="form-accept" method="post">
						<input type="hidden" class="input-partycode" name="partyCode"
							value="${__PARTY__.partyCode}"> <input type="hidden"
							class="input-partycode" name="currPage" value="${cri.currPage}">
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
									<!-- 파티승인요청 체크박스 전체선택 끝 -->
									<th scope="col">번호</th>
									<th scope="col">닉네임</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${__MEMBER__}" var="member">
									<tr>
										<td>
											<!-- 파티승인요청 체크박스 개별선택 -->
											<div class="checkbox-group">
												<div class="partyCheckboxGroup">
													<input type="checkbox" class="bigCheck" name="email"
														value="${member.email}">
												</div>
											</div> <!-- 파티승인요청 체크박스 개별선택 끝 -->
										</td>
										<th scope="row">${member.rownum}</th>
										<td>${member.nickname}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="d-flex justify-content-center">
							<div class="bottom-menu-btn btn-group">
								<button class="btn btn-primary btn-accept" type="submit">승인</button>
								<button class="btn btn-primary btn-reject" type="submit">거절</button>
							</div>
						</div>
					</form>
				</div>

				

				<div class="bottom-menu-page">
					<div class="changePage">
						<nav aria-label="Page navigation example">
							<c:choose>
								<c:when test="${not empty __MEMBER__}">
									<div id="pagination">
										<form id="paginationForm">
											<ul class="pagination justify-content-center">
												<c:if test="${pageMaker.prev}">
													<li class="prev page-item"><a class="prev page-link"
														href="/party/leaderpage?partyCode=${ldto.partyCode}&currPage=${pageMaker.startPage-1}">◀</a>
													</li>
												</c:if>

												<c:forEach begin="${pageMaker.startPage}"
													end="${pageMaker.endPage}" var="pageNum">
													<li class="page-item"><a id="page-curr"
														class="page-link"
														href="/party/leaderpage?partyCode=${ldto.partyCode}&currPage=${pageNum}">
															${pageNum} </a></li>
												</c:forEach>

												<c:if test="${pageMaker.next}">
													<li class="next page-item"><a class="next page-link"
														href="/party/leaderpage?partyCode=${ldto.partyCode}&currPage=${pageMaker.endPage+1}">▶</a>
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
			</div>
		</div>
		<!-- 파티승인요청 관리 끝 -->

		<!-- 파티 해체 신청 -->
		<div
			class="accordion accordion-flush container profile-box mt-5 shadown-sm"
			id="accordionFlushExample">
			<div class="accordion-item">
				<h2 class="accordion-header" id="flush-headingOne">
					<button class="accordion-button collapsed" type="button"
						data-bs-toggle="collapse" data-bs-target="#flush-collapseOne"
						aria-expanded="false" aria-controls="flush-collapseOne">
						<div class="header d-flex justify-content-between">
							<h4>파티 해체</h4>
						</div>
					</button>
				</h2>
				<div id="flush-collapseOne" class="accordion-collapse collapse"
					aria-labelledby="flush-headingOne"
					data-bs-parent="#accordionFlushExample">
					<div
						class="accordion-body d-flex justify-content-center align-items-center">
						<div class="">
							<div class="h5 d-block">해체 안내 사항</div>
							<p>파티를 해체하려 하시나요? 파티가 필요한 파티원들이 아직 있을수도 있어요!</p>
							<br>
							<p>그래도 해체하시겠다면 다음 유의사항을 꼭 읽어주세요.</p>
							<p>
								1. 해체 후 해체된 파티의 복구는 불가능합니다.<br>
								2. 그래도 해체하시겠다면 아래 버튼을 클릭해주세요. <br><br>
								<span class="h5">그동안 파티를 이용해주셔서 감사합니다.😂</span>
							</p>

							<form action="/party/dobreak" method="post">
								<input type="hidden" name="partyCode" value="${__PARTY__.partyCode}">
								<div class="d-flex justify-content-center mt-3">
									<button type="submit"
										class="btn btn-danger align-self-center withdrawal-btn"
										name="partyCode">해체하기</button>
								</div>
							</form>
						</div>
					</div>
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
	<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
	<!-- 스윗알러트 -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/partyMain.js?after"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/partyedit.js?after"></script>

</body>
</html>