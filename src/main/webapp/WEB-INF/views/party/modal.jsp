<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- 부트스트랩 css -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
  <!-- 폰트어썸 -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
    integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modal.css" />
  <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico"/>
  <title>파티모집 - 파티정보</title>

</head>

<body>
  <!-- Modal -->
  <button type="button" class="btn btn-primary" id="showPartyBtn" data-bs-toggle="modal" data-bs-target="#exampleModal"
    data-bs-whatever="">view</button>

  <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
      <div class="modal-content">
        <!-- 모달 헤더 -->
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalCenteredScrollableTitle">
            지금 바로 가입해보세요!
          </h5>
          <button type="button" class="btn-close" id="closeBtnIcon" data-bs-dismiss="modal"></button>
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
          <button type="submit" class="btn btn-secondary" id="partyRequestBtn" data-bs-toggle="button">
            파티신청
          </button>
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
            닫기
          </button>
        </div>
      </div>
    </div>
  </div>

  <!-- 부트스트랩 js -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
  <!-- 제이쿼리 -->
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <!-- 스윗알러트 -->
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.10/dist/sweetalert2.all.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/partyModal.js"></script>

</body>

</html>