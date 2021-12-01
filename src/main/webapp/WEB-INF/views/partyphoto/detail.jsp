<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>파티모집 - 포토갤러리</title>
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
	href="${pageContext.request.contextPath}/resources/css/partyPhotoDetail.css" />


<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.ico" />


<style>
.btn-hit {
	cursor: pointer;
	border: unset;
	outline: none;
	background-color: inherit;
}
</style>
</head>

<body>


	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />

	<div class="board_main">
		<main>
			<div class="container-sm">
				<div class="table-Detail">
					<!--product details-->
					<div class="content">
						<div class="title_area">
							<h5 class="title_text">${__DETAIL__.psubject}</h5>
						</div>
						<div class="info_desc">
							<div class="profile_thumb">
								<img src="${__DETAIL__.userpic}" alt width="50" height="50"
									class="img_thumb">
							</div>
							<div class="cover_info">
								<div>${__DETAIL__.nickname}<br> <span>${__DETAIL__.pdate}</span>
									<span>조회 ${__DETAIL__.readnum}</span>
								</div>
							</div>
						</div>
						<hr>
						<!--product details-->

						<div class="partyPhotoContents">
							<div class="partyPhotoImg">
								<c:forEach items="${__PHOTO__}" var="photo">
									<img src="${photo}" class="mt-3">
								</c:forEach>
							</div>

							<div class="partyPhotoText">
								<span>${__DETAIL__.pcontent}</span>
							</div>

							<div class="likeBtn d-flex justify-content-center">
								<form class="form-heart" action="/partyphoto/heart"
									method="post">
									<input type="hidden" name="currPage" value="${cri.currPage}">
									<input type="hidden" name="reCurrPage"
										value="${recri.reCurrPage}"> <input type="hidden"
										name="partyCode" value="${__DETAIL__.partycode}"> <input
										type="hidden" name="prefer" value="${__DETAIL__.prefer}">
									<input type="hidden" name="email"
										value="${sessionScope.__AUTH__.email}">
									<button class="btn-hit">
										<span> <c:choose>
												<c:when test="${__MYHEART__ == 1}">
													<i class="far fa-thumbs-up"
														style="font-size: 2rem; color: #5E92FF"></i>
												</c:when>
												<c:otherwise>
													<i class="far fa-thumbs-up" style="font-size: 2rem;"></i>
												</c:otherwise>
											</c:choose>
										</span>
									</button>
								</form>

								<div class="totalLikeCount">${__TOTALHEART__}</div>
							</div>
							<hr>
						</div>

					</div>

					<!--댓글-->
					<div class="comment_area">
						<div class="comment_text">
							<i class="far fa-comment-dots"></i> <span>댓글</span>
						</div>
						<hr>
						<!--댓글 리스트-->
						<div class="commentList_wrap">
							<div class="commentList">

								<c:choose>
									<c:when test="${not empty __COMMENT__}">
										<c:forEach items="${__COMMENT__}" var="comment">
											<form action="/partyphoto/editcomment" method="post">
												<input type="hidden" name="currPage" value="${cri.currPage}">
												<input type="hidden" name="reCurrPage"
													value="${recri.reCurrPage}"> <input type="hidden"
													name="partyCode" value="${__DETAIL__.partycode}"> <input
													type="hidden" name="prefer" value="${__DETAIL__.prefer}">
												<input type="hidden" name="prerefer"
													value="${comment.prerefer}">

												<div class="photoCommentInfo">
													<div class="photoCommentNickName">${comment.nickname}&nbsp;&nbsp;</div>
													<input type="hidden" name="email"
														value="${sessionScope.__AUTH__.email}">
													<div>${comment.predate}</div>
												</div>

												<div class="photoCommentContent">
													<div>${comment.precontent}</div>
													<input type="hidden" id="${comment.prerefer}totext"
														name="precontent" value="${comment.precontent}">
												</div>

												<div class="photoCommentEdit">
													<c:if
														test="${sessionScope.__AUTH__.email eq comment.email}">
														<input type="button" id="${comment.prerefer}" name="mod"
															value="수정">
														<input type="hidden" id="${comment.prerefer}tosubmit"
															value="수정완료">
													</c:if>
												</div>
											</form>

											<c:if test="${sessionScope.__AUTH__.email eq comment.email}">
												<form action="/partyphoto/deletecomment" method="post">
													<input type="hidden" name="currPage"
														value="${cri.currPage}"> <input type="hidden"
														name="reCurrPage" value="${recri.reCurrPage}"> <input
														type="hidden" name="partyCode"
														value="${__DETAIL__.partycode}"> <input
														type="hidden" name="prefer" value="${__DETAIL__.prefer}">
													<input type="hidden" name="prerefer"
														value="${comment.prerefer}"> <input type="submit"
														value="삭제">
												</form>
											</c:if>
										</c:forEach>

									</c:when>
									<c:otherwise>
										<td>등록된 글이 없습니다</td>
									</c:otherwise>
								</c:choose>

								<div id="pagination">
									<form id="paginationForm">
										<ul class="pagination justify-content-center">
											<c:if test="${replyPageMaker.prev}">
												<li class="prev page-item"><a class="prev page-link"
													href="/partyphoto/detail?partyCode=${__DETAIL__.partycode}&prefer=${__DETAIL__.prefer}&currPage=${cri.currPage}&reCurrPage=${recri.reCurrPage-1}&searchWord=${ldto.searchWord}&option=${ldto.option}">◀</a>
												</li>
											</c:if>
											<c:forEach begin="${replyPageMaker.startPage}"
												end="${replyPageMaker.endPage}" var="pageNum">
												<li class="page-item"><a id="page-curr"
													class="page-link"
													href="/partyphoto/detail?partyCode=${__DETAIL__.partycode}&prefer=${__DETAIL__.prefer}&currPage=${cri.currPage}&reCurrPage=${pageNum}&searchWord=${ldto.searchWord}&option=${ldto.option}">
														${pageNum} </a></li>
											</c:forEach>

											<c:if test="${replyPageMaker.next}">
												<li class="next page-item"><a class="next page-link"
													href="/partyphoto/detail?partyCode=${__DETAIL__.partycode}&prefer=${__DETAIL__.prefer}&currPage=${cri.currPage}&reCurrPage=${recri.reCurrPage+1}&searchWord=${ldto.searchWord}&option=${ldto.option}">▶</a>
												</li>
											</c:if>
										</ul>
									</form>
								</div>
							</div>
						</div>
						<!-- replylist_wrap END -->
						<!--reply write-->
						<!--댓글내용-->


						<form action="/partyphoto/writecomment" method="POST">
							<input type="hidden" name="currPage" value="${cri.currPage}">
							<input type="hidden" name="reCurrPage"
								value="${recri.reCurrPage}"> <input type="hidden"
								name="partyCode" value="${__DETAIL__.partycode}"> <input
								type="hidden" name="prefer" value="${__DETAIL__.prefer}">
							<input type="hidden" name="email"
								value="${sessionScope.__AUTH__.email}">
							<div class="commentWrite_Wrap">
								<textarea name="precontent" id="commentContent"
									placeholder=" [${sessionScope.__AUTH__.nickname}] 님,  댓글을 남겨보세요"
									class="comment_inbox" rows="4" cols="140"></textarea>
								<button type="submit" class="btn btn-outline-warning">등록</button>
							</div>
						</form>
					</div>
				</div>

				<div class="container-btnGroup d-flex justify-content">
					<c:set value="${sessionScope.__AUTH__.nickname}" var="nickname" />
					<form action="/partyphoto/editview" method="get">
						<button type="submit" class="btn btn-primary btn-sm">
							<input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
							<input type="hidden" name="partyCode"
								value="${__DETAIL__.partycode}"> <i class="fas fa-pen"></i>
							<span>수정</span>
					</form>
					</button>
					</form>
					<form action="/partyphoto/delete" method="post">
						<button type="submit" class="btn btn-primary btn-sm">
							<input type="hidden" name="prefer" value="${__DETAIL__.prefer}">
							<input type="hidden" name="partyCode"
								value="${__DETAIL__.partycode}"> <i
								class="fas fa-trash-alt"></i> <span>삭제</span>
						</button>
					</form>
					<button type="button" class="btn btn-primary btn-sm"
						onclick="location.href='/partyphoto/list?partyCode=${__DETAIL__.partycode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}'">
						<i class="fas fa-list-ul"></i> <span>목록</span>
					</button>
				</div>

			</div>
		</main>
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

</body>
<script
	src="${pageContext.request.contextPath}/resources/js/photoedit.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
<script>
	$(document).ready(function() {
		$(document).on("click", function(e) {
			var click_val_1 = e.target.getAttribute('id');
			console.log(click_val_1);
			$('#' + click_val_1 + 'totext').attr("type", "text");
			$('#' + click_val_1 + 'tosubmit').attr("type", "submit");
		});
	});
</script>

</html>