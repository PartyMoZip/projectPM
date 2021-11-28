<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
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

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/partyMain.css"/>
    <title>파티모집 - ${__PARTY__.partyName}</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
</head>
<body>

<%--HEADER--%>
<jsp:include
        page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>
<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/partyMainTab.jsp" />
<main>
    <div class="container">
        <div class="container-party">
            <div class="partyImage">
                <img alt="파티메인이미지" class="img-fluid" src="${__PARTY__.coverPic}">
            </div>

            <div class="partyInfo">
                <div class="partyInfo-content">
                    <div class="partyInfo-content-title">
                        <h5>${__PARTY__.partyName}</h5>
                        <p>개설 날짜 : ${__PARTY__.createDate}</p>
                        <p>파티인원 :&nbsp;${__PARTY__.count}명</p>
                        <p>${__PARTY__.partyProfile}</p>
                    </div>
                </div>
            </div>
        </div>
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
<script
        src="${pageContext.request.contextPath}/resources/js/party.js"></script>

</body>
</html>