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
<title>파티메인페이지 - 메인</title>
</head>
<body>

	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />

	<main>
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page"
				href="/party/showmain?partyCode=${__PARTY__.partyCode}">메인</a></li>
			<li class="nav-item"><a class="nav-link"
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
		<div class="container">
			<div class="container-party">
				<div class="partyImage">
					<img alt="파티메인이미지" class="img-fluid" src="${__PARTY__.coverPic}">
				</div>

				<div class="partyInfo">
					<div class="partyInfo-content">
						<div class="partyInfo-content-title">
							<h5>파티명 : ${__PARTY__.partyName}</h5>
							<p>개설 날짜 : ${__PARTY__.createDate}</p>
							<p>파티인원 수:&nbsp;20명</p>
							<p>${__PARTY__.partyProfile}</p>
							<p>우리는 새로운 사람을 만나는 파티입니다.</p>
						</div>
					</div>
				</div>
			</div>
		</div>


	</main>




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


	<%-- fullcalendar --%>
	<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/fullcalendar.js"></script>


	<%--FOOTER--%>
	<jsp:include
			page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp" />
</body>
</html>