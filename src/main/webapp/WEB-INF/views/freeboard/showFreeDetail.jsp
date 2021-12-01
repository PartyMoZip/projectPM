<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2021-11-20
  Time: 오후 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
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
	href="${pageContext.request.contextPath}/resources/css/home.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/boardDetail.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">


<title>파티모집 - 자유</title>
</head>
<body>
	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />
	<div class="board_main">
		<main>
			<div class="container-sm">
				<ul class="nav nav-pills">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">자유게시판</a></li>
				</ul>
				<div class="table-Detail">
					<!--product details-->
					<div class="content">
						<div class="title_area">
							<h5 class="title_text">${boardDetail.FSubject}</h5>
						</div>
						<div class="info_desc">
							<div class="profile_thumb">
								<img src="${boardDetail.userpic}" alt width="50" height="50"
									class="img_thumb">
							</div>
							<div class="cover_info">
								<div>${boardDetail.nickname}<br> <span>${boardDetail.FDate}</span>
									<span>조회 ${boardDetail.readnum}</span>
								</div>
							</div>
						</div>
						<hr>
						<span style="text-align: left;">${boardDetail.FContent}</span>
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
											<!-- 수정 + 상세-->
											<form action="/freeboard/editComment" method="post">
												<input type="hidden" name="currPage" value="${cri.currPage}">
												<input type="hidden" name="reCurrPage"
													value="${recri.reCurrPage}"> <input type="hidden"
													name="frefer" value="${comment.frefer}"> <input
													type="hidden" name="frerefer" value="${comment.frerefer}">

												<div class="freeBoardCommentInfo">
													<div class="freeBoardCommentWriter">
														<c:out value="${comment.nickname}" />
													</div>
													&nbsp;&nbsp;
													<div>
														<fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss"
															value="${comment.fredate}" />
													</div>
												</div>

												<div class="freeBoardCommentContent">
													<div><c:out value="${comment.frecontent}" /></div>
													<input type="hidden" id="${comment.frerefer}totext"
														name="frecontent" value="${comment.frecontent}">
												</div>

												<div class="freeBoardCommentEdit">
													<input type="hidden" name="email"
														value="${sessionScope.__AUTH__.email}">
													<c:if
														test="${sessionScope.__AUTH__.email eq comment.email}">
														<input type="button" id="${comment.frerefer}" name="mod"
															value="수정">
														<input type="hidden" id="${comment.frerefer}tosubmit"
															value="수정완료">
													</c:if>
												</div>

											</form>
											<!-- 삭제 버튼 -->

											<c:if test="${sessionScope.__AUTH__.email eq comment.email}">
												<form action="/freeboard/deleteComment" method="post">
													<input type="hidden" name="currPage"
														value="${cri.currPage}"> <input type="hidden"
														name="reCurrPage" value="${recri.reCurrPage}"> <input
														type="hidden" name="frefer" value="${comment.frefer}">
													<input type="hidden" name="frerefer"
														value="${comment.frerefer}"> <input type="submit"
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
											<c:if test="${replyPageMaker.prev}">4
                                            <li class="prev page-item">
													<a class="prev page-link"
													href="/freeboard/showFreeDetail?frefer=${boardDetail.FRefer}&currPage=${cri.currPage}&reCurrPage=${replyPageMaker.startPage-1}">◀</a>
												</li>
											</c:if>
											<c:forEach begin="${replyPageMaker.startPage}"
												end="${replyPageMaker.endPage}" var="pageNum">
												<li class="page-item"><a id="page-curr"
													class="page-link"
													href="/freeboard/showFreeDetail?frefer=${boardDetail.FRefer}&currPage=${cri.currPage}&reCurrPage=${pageNum}">
														${pageNum} </a></li>
											</c:forEach>

											<c:if test="${replyPageMaker.next}">
												<li class="next page-item"><a class="next page-link"
													href="/freeboard/showFreeDetail?frefer=${boardDetail.FRefer}&currPage=${cri.currPage}&reCurrPage=${replyPageMaker.endPage+1}">▶</a>
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
						<form action="/freeboard/writeComment" method="POST">
							<input type="hidden" name="currPage" value="${cri.currPage}">
							<input type="hidden" name="reCurrPage"
								value="${recri.reCurrPage}"> <input type="hidden"
								name="frefer" value="${boardDetail.FRefer}">
							<%--<h6>${boardDetail.nickname}</h6>--%>
							<input type="hidden" name="email"
								value="${sessionScope.__AUTH__.email}">
							<div class="commentWrite_Wrap">
								<textarea name="frecontent" id="commentContent"
									placeholder=" [${sessionScope.__AUTH__.nickname}] 님,  댓글을 남겨보세요"
									class="comment_inbox" rows="4" cols="140"></textarea>
								<button type="submit" class="btn btn-outline-warning">등록</button>
							</div>
						</form>
					</div>

					<div class="container-btnGroup d-flex justify-content-end">
						<c:set value="${sessionScope.__AUTH__.nickname}" var="nickname" />
						<c:if test="${boardDetail.nickname eq nickname}">
							<button type="button" class="btn btn-primary btn-sm"
								onclick="location.href='/freeboard/editFreeBoardView?frefer=${boardDetail.FRefer}'">
								<i class="fas fa-pen"></i> <span>수정</span>
							</button>
							<form action="/freeboard/deleteFreeBoard" method="post">
								<button type="submit" class="btn btn-primary btn-sm">
									<input type="hidden" name="frefer"
										value="${boardDetail.FRefer}"> <i
										class="fas fa-trash-alt"></i> <span>삭제</span>
								</button>
							</form>
						</c:if>
						<button type="button" class="btn btn-primary btn-sm"
							onclick="location.href='/freeboard/getFreeBoardList?currPage=${cri.currPage}'">
							<i class="fas fa-list-ul"></i> <span>목록</span>
						</button>
					</div>
				</div>
			</div>
		</main>
	</div>
	
	<%--FOOTER--%>
	<div class="container">
		<jsp:include
			page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp" />
	</div>
	
	<!-- 부트스트랩 js -->
	<script defer
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<!-- 제이쿼리 -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
	<!--<script src="${pageContext.request.contextPath}/resources/js/comment.js"></script>-->
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
</body>
</html>
