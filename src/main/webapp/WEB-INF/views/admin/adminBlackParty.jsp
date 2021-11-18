<%--
  Created by IntelliJ IDEA.
  User: EUN-Ng
  Date: 2021-11-13
  Time: 오후 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>

  <%--HEADER--%>
  <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"/>

  <!-- 부트스트랩 css -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin.css"/>

  <title>파티모집</title>
</head>

<body>
<div class="all-wrap">
  <!-- 탭 메뉴 -->
  <nav class="nav nav-pills flex-column flex-sm-row">
    <a class="flex-sm-fill text-sm-center nav-link" href="/admin/adminParty">파티관리</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/admin/adminPartyBreak">파티해체 승인 요청</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/admin/adminBlackMember">블랙회원리스트 관리</a>
    <a class="flex-sm-fill text-sm-center nav-link active" href="/admin/adminBlackParty">블랙파티리스트 관리</a>
  </nav>

  <!-- 블랙파티리스트 테이블 시작 -->
  <div class="table-responsive">
    <table class="table">
      <thead>
      <tr>
        <!-- 블랙파티리스트 체크박스 전체선택 -->
        <th scope="col">
          <div class="checkbox-group">
            <div class="checkbox-groupBlackParty">
              <input type="checkbox" id="check-allBlackParty" name="check-allBlackParty" class="bigCheck">
            </div>
          </div>
        </th>
        <!-- 블랙파티리스트 체크박스 전체선택 끝 -->
        <th scope="col">번호</th>
        <th scope="col">파티 이름</th>
        <th scope="col">파티장</th>
        <th scope="col">누적 신고 건수</th>
        <th scope="col">파티 생성 일자</th>
        <th scope="col">블랙리스트 추가 일자</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>
          <!-- 블랙파티리스트 체크박스 개별선택 -->
          <div class="checkbox-group">
            <div class="blackPartyCheckboxGroup">
              <input type="checkbox" class="bigCheck" name="bpc">
            </div>
          </div>
          <!-- 블랙파티리스트 체크박스 개별선택 끝 -->
        </td>
        <th scope="row">1</th>
        <td>민진건의 방탈출 조기축구</td>
        <td>민진건</td>
        <td>2</td>
        <td>2021.11.09</td>
        <td>2021.11.10</td>
      </tr>
      <tr>
        <td>
          <!-- 블랙파티리스트 체크박스 개별선택 -->
          <div class="checkbox-group">
            <div class="blackPartyCheckboxGroup">
              <input type="checkbox" class="bigCheck" name="bpc">
            </div>
          </div>
          <!-- 블랙파티리스트 체크박스 개별선택 끝 -->
        </td>
        <th scope="row">2</th>
        <td>민진건의 방탈출 조기축구</td>
        <td>민진건</td>
        <td>2</td>
        <td>2021.11.09</td>
        <td>2021.11.10</td>
      </tr>
      <tr>
        <td>
          <!-- 블랙파티리스트 체크박스 개별선택 -->
          <div class="checkbox-group">
            <div class="blackPartyCheckboxGroup">
              <input type="checkbox" class="bigCheck" name="bpc">
            </div>
          </div>
          <!-- 블랙파티리스트 체크박스 개별선택 끝 -->
        </td>
        <th scope="row">3</th>
        <td>민진건의 방탈출 조기축구</td>
        <td>민진건</td>
        <td>2</td>
        <td>2021.11.09</td>
        <td>2021.11.10</td>
      </tr>
      </tbody>
    </table>
  </div>
  <!-- 블랙파티리스트 테이블 끝-->

  <!-- 하단메뉴 -->
  <!-- 버튼 -->
  <div class="bottom-menu">
    <div class="d-grid gap-2 d-md-block">
      <button class="btn btn-primary" type="button">파티 해체</button>
    </div>

    <!-- 검색창 -->
    <div class="container-sm search-wrapper">
      <form action="/search" method="get" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
        <input type="search" name="searchWord" class="form-control" placeholder="검색어를 입력해주세요." aria-label="Search">
        <button class="search-btn">
            <span>
              <i class="fas fa-search"></i>
            </span>
        </button>
      </form>
    </div>
  </div>
</div>

<%--FOOTER--%>
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"/>

<!-- 부트스트랩 js -->
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/admin.js"></script>

</body>

</html>