<%--
  Created by IntelliJ IDEA.
  User: Hwang
  Date: 2021-11-24
  Time: 오후 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>파티모집 - 캘린더</title>
<!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
<link rel="icon"
	href="${pageContext.request.contextPath}resources/images/favicon.ico" />
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
<!-- full Calendar css -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/fullcalendar.css?after">
</head>

<body>
	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />

	<ul class="nav nav-pills">
		<li class="nav-item"><a class="nav-link" aria-current="page"
			href="/party/showmain?partyCode=${__PARTY__.partyCode}">메인</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/party/leaderpage?partyCode=${__PARTY__.partyCode}">파티관리</a></li>
		<li class="nav-item"><a class="nav-link active"
			href="/partyfunc/calendar?partyCode=${__PARTY__.partyCode}">일정</a></li>
		<li class="nav-item"><a class="nav-link" href="#">파티원</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/partyfree/getPFreeBoardList">자유게시판</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/partyphoto/list?partyCode=${__PARTY__.partyCode}">포토갤러리</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/partyfunc/partychat?partyCode=${__PARTY__.partyCode}">채팅</a></li>
	</ul>

	<div id="calendar-container">
		<div id="calendar"></div>
		<div class="calendarSaveBtn">
			<button type="button" class="btn btn-outline-primary"
				onclick="allSave();">전체저장</button>
		</div>
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
		src="${pageContext.request.contextPath}/resources/js/partyMain.js"></script>

	<%-- fullcalendar --%>
	<script
		src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/locales-all.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/fullcalendar.js"></script>

	<%--FOOTER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp" />

</body>
</html>
