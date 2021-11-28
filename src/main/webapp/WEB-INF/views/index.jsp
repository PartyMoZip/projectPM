<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>파티모집</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>

    <%--CSS--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css?after">

</head>

<body>

<%--HEADER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>

<main>
    <!-- Carousel -->
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="${pageContext.request.contextPath}/resources/images/main_1.jpg" class="d-block w-100 h-50"
                     alt="...">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/resources/images/main_2.jpg" class="d-block w-100 h-50"
                     alt="...">
            </div>
            <div class="carousel-item">
                <img src="${pageContext.request.contextPath}/resources/images/main_3.jpg" class="d-block w-100 h-50"
                     alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>

    <div class="container">

        <%--검색창--%>
        <div class="container-sm d-flex justify-content-center align-items-center">
            <div class="search-wrapper">
                <form action="/search/list" method="get" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                    <div class="container-sm p-0">
                        <input type="text" name="word" id="search-bar" class="form-control"
                               placeholder="찾고 있는 파티를 입력해보세요."
                               aria-label="Search">
                        <button class="search-btn">
                            <span>
                                <i class="fas fa-search"></i>
                            </span>
                        </button>
                    </div>
                    <div class="search-box hide">
                        <ul class="search-ul p-0"></ul>
                    </div>
                </form>
            </div>
        </div>


        <%--내 파티 목록--%>
        <%--파티 리스트--%>
        <div class="album py-5">
            <div class="header">
                <c:choose>
                    <c:when test="${list != null && sessionScope.__AUTH__.email != null && result == true}">
                        <h4>나의 파티</h4>

                        <span class="icon">
                            <i class="fas fa-angle-right"></i>
                        </span>
                    </c:when>
                    <c:otherwise>
                        <h4>이 파티는 어떠세요?</h4>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                <c:forEach items="${list}" var="party">
                    <div class="col">
                        <div class="card shadow-sm">
                            <svg class="bd-placeholder-img card-img-top" width="100%" height="225"
                                 xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail"
                                 preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                                <rect width="100%" height="100%" fill="#55595c"></rect>
                                <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                            </svg>

                            <div class="card-body">
                                <p class="card-text"><c:out value="${party.partyName}"/></p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div>
                                        <button type="button" class="btn btn-outline-success" id="showPartyBtn"
                                                data-bs-toggle="modal" data-bs-target="#exampleModal"
                                                data-bs-whatever="">View
                                        </button>
                                        <input type="hidden" class="input-partycode" value="${party.partyCode}">
                                    </div>
                                    <small class="text-muted"><c:out value="${party.hobbyName}"/></small>
                                    <small class="text-muted"><c:out value="${party.localName}"/></small>
                                    <small class="text-muted"><c:out value="${party.partyScore}"/></small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                            <div class="modal-content">
                                <!-- 모달 헤더 -->
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalCenteredScrollableTitle">
                                        지금 바로 가입해보세요!
                                    </h5>
                                    <button type="button" class="btn-close" id="closeBtnIcon"
                                            data-bs-dismiss="modal"></button>
                                </div>
                                <!-- 모달 중단부 -->
                                <div class="modal-body">
                                    <div class="partyMainImg">
                                        <img src="./파티모집_파비콘.png" alt="파티메인이미지">
                                    </div>
                                    <div class="partyContents">
                                        <div class="partyName">
                                            <img src="./파티모집_파비콘.png" alt="파티로고" class="partyLogo">
                                            <div class="partyHeader">파티 제목</div>
                                        </div>
                                        <div class="partyInfo">
                                            <div class="partyLocation">
                                                파티 지역:&nbsp;
                                                <div class="partyLocationContent">
                                                    서울
                                                </div>
                                            </div>
                                            <div class="partyCategory">
                                                파티 카테고리:&nbsp;
                                                <div class="partyCategoryContent">
                                                    김진건 멘탈 치유
                                                </div>
                                            </div>
                                            <div class="partyMemberPoint">
                                                파티 활동 점수:&nbsp;
                                                <div class="partyMemberPointContent">
                                                    30점
                                                </div>
                                            </div>
                                        </div>
                                        <div class="partyIntro">
                                            <p>우리 파티는 김진건 멘탈 치유 파티입니다.<br>
                                                진건이형의 멘탈 치유를 위해 다방면으로 노력하고 있으며, 진건의형의 재활을 위해 야외활동을 적극 권유하고 있습니다.<br>
                                                진건이형의 멘탈 회복을 위해 다들 힘을 모아주세요.<br>에이멘
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <!-- 모달 하단부 -->
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-secondary" id="partyRequestBtn"
                                            data-bs-toggle="button">
                                        파티신청
                                    </button>
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                        닫기
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <%--더 둘러보기 스와이퍼--%>
        <div class="py-5">
            <div class="header">
                <h4>더 둘러보기</h4>
            </div>
            <div class="swiper mySwiper">
                <div class="swiper-wrapper">
                    <div class="swiper-slide swiper-item"><span>축구</span></div>
                    <div class="swiper-slide swiper-item"><span>야구</span></div>
                    <div class="swiper-slide swiper-item"><span>컴퓨터게임</span></div>
                    <div class="swiper-slide swiper-item"><span>등산</span></div>
                    <div class="swiper-slide swiper-item"><span>공부</span></div>
                    <div class="swiper-slide swiper-item"><span>당구</span></div>
                    <div class="swiper-slide swiper-item"><span>보드게임</span></div>
                    <div class="swiper-slide swiper-item"><span>DIY</span></div>
                    <div class="swiper-slide swiper-item"><span>요리</span></div>
                </div>
                <div class="swiper-pagination"></div>
            </div>
        </div>
    </div>


</main>

<%--FOOTER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"/>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.10/dist/sweetalert2.all.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/modal.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/swiper.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/autocomplete.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/mainpage.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/partyinfo.js"></script>

</body>
</html>
