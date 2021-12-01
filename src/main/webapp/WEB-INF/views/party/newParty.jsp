<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>파티모집 - 파티생성</title>
    <!-- 부트스트랩 css -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous"/>
    <!-- 폰트어썸 -->
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
          crossorigin="anonymous"/>
    <link rel="icon"
          href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/newParty.css?after"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/global.css?after"/>
</head>

<body>

<%--HEADER--%>
<jsp:include
        page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>

<%--SPINNER--%>
<jsp:include
        page="${pageContext.request.contextPath}/WEB-INF/views/include/spinner.jsp"/>

<main>

    <!-- 파티 생성 -->

    <div class="container mt-5 d-flex flex-column profile-box shadow-sm">
        <div class="header">
            <h4>파티생성</h4>
        </div>
        <form class="form-data" enctype="multipart/form-data">
            <div class="container mt-5 px-5 ">
                <div class="container-lg d-flex justify-content-center">
                    <div class="d-flex flex-column justify-content-center align-items-center">
                        <div class="img-profile justify-content-center align-items-center">
                            <img src="${pageContext.request.contextPath}/resources/images/noimage.png" alt="파티 프로필 사진">
                        </div>

                        <div class="mt-2">
                            <button type="button" class="btn btn-outline-primary select-btn">
                                이미지 업로드
                            </button>
                            <input type="file" class="form-control input-file visually-hidden"
                                   name="fileLocation">
                        </div>
                    </div>
                </div>

                <div class="container-lg d-flex justify-content-center">
                    <div
                            class="d-flex flex-column justify-content-center align-items-center">
                        <div
                                class="d-flex flex-column justify-content-center align-items-left w-100 col-3 mt-3">
                            <span class="align-self-baseline label-partyLoc">활동지역</span> <select
                                class="form-select form-select-sm"
                                aria-label=".form-select-sm example">
                            <option selected>지역</option>
                            <option value="1">강남</option>
                            <option value="2">강동</option>
                            <option value="3">강북</option>
                            <option value="4">강서</option>
                        </select>
                        </div>

                        <div
                                class="d-flex flex-column justify-content-center align-items-left w-100 col-3 mt-3">
                            <span class="align-self-baseline label-partyName">파티이름</span>
                            <input
                                    type="text" class="form-control input-newParty mt-2"
                                    name="newParty">
                        </div>

                        <span class="align-self-baseline label-partyCategory">취미
						카테고리</span>
                        <div class="container-categoryBtn flex-wrap">

                            <input type="radio" class="btn-check" name="options-outlined"
                                   id="btn-check-soccer" checked autocomplete="off"> <label
                                class="btn btn-outline-secondary" for="btn-check-soccer">축구</label><br>

                            <input type="radio" class="btn-check" name="options-outlined"
                                   id="btn-check-baseball" checked autocomplete="off"> <label
                                class="btn btn-outline-secondary" for="btn-check-baseball">야구</label><br>

                            <input type="radio" class="btn-check" name="options-outlined"
                                   id="btn-check-game" checked autocomplete="off"> <label
                                class="btn btn-outline-secondary" for="btn-check-game">컴퓨터게임</label><br>

                            <input type="radio" class="btn-check" name="options-outlined"
                                   id="btn-check-mountain" checked autocomplete="off"> <label
                                class="btn btn-outline-secondary" for="btn-check-mountain">등산</label><br>

                            <input type="radio" class="btn-check" name="options-outlined"
                                   id="btn-check-study" checked autocomplete="off"> <label
                                class="btn btn-outline-secondary" for="btn-check-study">공부</label><br>

                            <input type="radio" class="btn-check" name="options-outlined"
                                   id="btn-check-billiards" checked autocomplete="off"> <label
                                class="btn btn-outline-secondary" for="btn-check-billiards">당구</label><br>

                            <input type="radio" class="btn-check" name="options-outlined"
                                   id="btn-check-boardGame" checked autocomplete="off"> <label
                                class="btn btn-outline-secondary" for="btn-check-boardGame">보드게임</label><br>

                            <input type="radio" class="btn-check" name="options-outlined"
                                   id="btn-check-DIY" checked autocomplete="off"> <label
                                class="btn btn-outline-secondary" for="btn-check-DIY">DIY</label><br>

                            <input type="radio" class="btn-check" name="options-outlined"
                                   id="btn-check-cooking" checked autocomplete="off"> <label
                                class="btn btn-outline-secondary" for="btn-check-cooking">요리</label><br>

                        </div>

                    </div>

                </div>

            </div>
            <div>
                <button type="submit" class="btn btn-primary mt-4 save-btn">저장하기</button>
            </div>
        </form>
    </div>
</main>

<%--FOOTER--%>
<jsp:include
        page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"/>

<!-- 부트스트랩 js -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 스윗알러트 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script src="${pageContext.request.contextPath}/resources/js/mypage.js"></script>

</body>
</html>