<%--
  Created by IntelliJ IDEA.
  User: chico
  Date: 2021-11-08
  Time: 오후 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="shadow p-4 border-bottom">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">

                <img src="${pageContext.request.contextPath}/resources/images/logo.svg" alt="logo" width="169"
                     height="50">
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0" style="margin-left: 10px">
                <li><a href="#" class="nav-link px-2 link-dark">파티</a></li>
                <li><a href="#" class="nav-link px-2 link-dark">자유</a></li>
                <li><a href="#" class="nav-link px-2 link-dark">공지</a></li>
                <li><a href="#" class="nav-link px-2 link-dark">문의</a></li>
                <li><a href="/admin/adminParty" class="nav-link px-2 link-dark">관리자</a></li>
            </ul>

            <form action="/search/searchList" method="get" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                <input type="search" name="word" class="form-control" aria-label="Search" value="${searchWord}">
            </form>

            <div class="dropdown text-end">
                <c:choose>
                    <c:when test="${sessionScope.__AUTH__ == null}">
                        &nbsp;&nbsp; <!-- Button trigger modal -->
                        <button type="button" class="btn btn-outline-success" data-bs-toggle="modal"
                                data-bs-target="#exampleModal">
                            로그인
                        </button>
                    </c:when>

                    <c:otherwise>
                        <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="${sessionScope.__AUTH__.userPic}" alt="mdo" width="32" height="32"
                                 class="rounded-circle">
                        </a>
                        <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
                            <li><a class="dropdown-item" href="/users/${sessionScope.__AUTH__.hashCode()}">프로필</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="/login/doLogout">로그아웃</a></li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header"><h5 class="modal-title" id="exampleModalLabel">로그인</h5>

                    </div>
                    <div class="modal-body">
                        <div class="kakaoLogin">
                            <a href="/login/loginPage" data-content="Sing up">
                                <img src="/resources/images/kakao_login_image.png"/></a>
                        </div>
                        <div class="naverLogin">
                            네이버 로그인
                        </div>
                    </div>
                    <%--<div class="modal-footer">--%>
                    <%--    <button type="button" class="close btn btn-outline-danger" data-dismiss="modal">닫기</button>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>

    </div>


</header>