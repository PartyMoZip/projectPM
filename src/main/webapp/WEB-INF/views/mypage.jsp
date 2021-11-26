<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>파티모집 - 프로필</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>

    <%--CSS--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypage.css?after">

</head>

<body>

<%--HEADER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>

<main>
    <%--내 파티 목록--%>
    <div class="container mt-5 px-5 profile-box shadow-sm">
        <div class="header">
            <h4>나의 파티</h4>
        </div>

        <%-- 수정 필요 --%>
        <c:choose>
            <c:when test="${list != null}">
                <c:forEach items="${list}" var="party">
                    <div class="party-container container-sm d-flex justify-content-between align-items-center shadow-sm">
                        <h5>
                                ${party.partyName}
                        </h5>

                        <div class="d-grid gap-2 d-md-flex justify-content-end">
                            <div class="btn-wrapper">
                                <button type="button" class="btn mypage-btn btn-primary px-4 me-md-2">
                                    <a href="/party/showmain?partyCode=3" class="enter-btn">파티입장</a>
                                </button>
                                <input type="hidden" class="input-partycode" value="${party.partyCode}">
                            </div>
                            <div class="btn-wrapper">
                                <button type="button" class="btn mypage-btn btn-outline-danger px-4 leave-btn">
                                    파티탈퇴
                                </button>
                                <input type="hidden" class="input-partycode" value="${party.partyCode}">
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h4>
                    아직 가입하신 파티가 없어요!
                </h4>
            </c:otherwise>
        </c:choose>
    </div>


    <%--프로필 설정--%>
    <div class="container mt-5 px-5 profile-box shadow-sm">
        <div class="header">
            <h4>프로필 설정</h4>
        </div>

        <form action="/users/${sessionScope.__AUTH__.hashCode()}/edit-profile" class="form-data"
              enctype="multipart/form-data">
            <input type="hidden" class="input-email" name="email" value="${sessionScope.__AUTH__.email}"/>
            <input type="hidden" name="id" class="input-id" value="${sessionScope.__AUTH__.hashCode()}">
            <div class="container-lg d-flex justify-content-center">
                <div class="d-flex flex-column justify-content-center align-items-center">
                    <div class="img-profile justify-content-center align-items-center">
                        <img src="${sessionScope.__AUTH__.userPic}" alt="프로필 사진">
                    </div>
                    <div class="mt-2">
                        <button type="button" class="btn btn-outline-primary select-btn">
                            이미지 업로드
                        </button>
                        <input type="file" class="form-control input-file visually-hidden" name="fileLocation">
                    </div>
                    <div class="d-flex flex-column justify-content-center align-items-center w-100 col-3 mt-3">
                        <span class="align-self-baseline label-nickname">닉네임</span>
                        <input type="text" class="form-control input-nickname mt-2" name="nickname"
                               value="${sessionScope.__AUTH__.nickname}">
                    </div>

                    <button type="submit" class="btn btn-primary mt-4 save-btn">저장하기</button>
                </div>
            </div>
        </form>
    </div>

    <%--회원 탈퇴--%>
    <div class="accordion accordion-flush container profile-box mt-5 shadown-sm" id="accordionFlushExample">
        <div class="accordion-item">
            <h2 class="accordion-header" id="flush-headingOne">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                    <div class="header d-flex justify-content-between">
                        <h4>회원 탈퇴</h4>
                    </div>
                </button>
            </h2>
            <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne"
                 data-bs-parent="#accordionFlushExample">
                <div class="accordion-body d-flex justify-content-center align-items-center">
                    <div class="">
                        <div class="h5 d-block">탈퇴 안내 사항</div>
                        <p>
                            파티모집에 만족하지 못하셨나요? 당신이 필요한 파티가 아직 있어요!
                        </p>
                        <br>
                        <p>그래도 탈퇴하시겠다면 다음 유의사항을 꼭 읽어주세요.</p>
                        <p>1. 작성한 컨텐츠는 완전히 삭제되지 않으며, 삭제를 원하시면 탈퇴 전에 직접 삭제를 해주셔야 합니다.<br>
                            2. 탈퇴 후 동일한 카카오 계정으로 가입이 불가능합니다.<br>
                            3. 탈퇴하시겠다면 아래 입력창에 "네, 탈퇴하겠습니다."를 입력해주세요. <br><br>
                            <span class="h5">그동안 이용해주셔서 감사합니다.😂</span>
                        </p>

                        <input type="text" class="w-100 form-control input-withdrawal" placeholder="진짜 탈퇴하실거에요?">

                        <div class="d-flex justify-content-center mt-3">
                            <button type="button" class="btn btn-danger align-self-center withdrawal-btn">탈퇴하기</button>
                        </div>
                    </div>
                </div>
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
<script src="${pageContext.request.contextPath}/resources/js/mypage.js"></script>


</body>
</html>
