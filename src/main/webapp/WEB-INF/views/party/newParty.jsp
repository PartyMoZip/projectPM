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
<title>파티모집 - 파티관리</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
</head>
<body>

	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />

	<%--SPINNER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/spinner.jsp" />

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

</body>
</html>