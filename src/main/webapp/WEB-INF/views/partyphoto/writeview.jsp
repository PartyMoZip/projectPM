<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<title>파티포토갤러리 - 글쓰기</title>
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

	<%-- <form action="/partyphoto/write" method="post"
		enctype="multipart/form-data">
		<input type="text" name="partycode" value="${ldto.partyCode}" readonly>
		<input type="text" name="pcontent"> <input type="text"
			name="psubject"> <input type="text" name="email"> <input
			type="file" multiple="multiple" name="images" />

		<button type="submit">글쓰기</button>
	</form>
	<hr>
	<a
		href="/partyphoto/list?partyCode=${ldto.partyCode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}"></option>목록</a>
 --%>

	<div class="container mt-5 px-5 profile-box shadow-sm">
		<form enctype="multipart/form-data" action="" method="post">
			<div class="container">
				<div class="col-md-6">
					<div class="form-group">
						<label for="writer">작성자</label> <input type="text"
							class="form-control" name="writer" id="writer" value="" readonly>
					</div>
				</div>
				<input type="hidden" id="id" name="id" value="">


				<div class="form-group" style="margin-right: 70px">
					<label for="title">글제목</label> <input type="text"
						class="form-control" name="title" id="title" value=""
						required="required">
				</div>

				<div class="form-group" style="margin-right: 70px">
					<label for="content">글내용</label>
					<textarea class="form-control" rows="10" name="content"
						id="content" required="required"></textarea>
				</div>


				<div class="fileUploadBtn">
					<div class="form-group">
						<label for="File">첨부파일 1</label> <input type="file" name="file[0]">
					</div>
					<div class="form-group">
						<label for="File">첨부파일 2</label> <input type="file" name="file[1]">
					</div>
					<div class="form-group">
						<label for="File">첨부파일 3</label> <input type="file" name="file[2]">
					</div>
				</div>

				<div class="container-btnGroup">
					<button type="submit" class="btn btn-primary btn-sm">
						<i class="fas fa-pen"></i> <span>등록</span>
					</button>
					<button type="button" class="btn btn-primary btn-sm" onclick="location.href='/partyphoto/list?partyCode=${ldto.partyCode}&currPage=${cri.currPage}';">
						<i class="fas fa-list-ul"></i> <span>목록</span>
					</button>
				</div>
			</div>
		</form>
	</div>

	<%--FOOTER--%>
	<div class="container">
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