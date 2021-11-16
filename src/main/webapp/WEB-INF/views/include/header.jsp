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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<header class="p-4 border-bottom">
    <div class="box"></div>
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
            </ul>

            <form action="/search" method="get" class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                <input type="search" name="searchWord" class="form-control" placeholder="Search..." aria-label="Search">
            </form>


            <div class="dropdown text-end">
                <c:choose>
                    <c:when test="${sessionScope.__AUTH__ == null}">
                    &nbsp;&nbsp;<button type="button" data-toggle="modal" data-target="#myModal">
                        로그인</button>
                    </c:when>

                    <c:otherwise>
                        <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="${sessionScope.__AUTH__.userPic}" alt="mdo" width="32" height="32" class="rounded-circle">
                        </a>
                        <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
                            <li><a class="dropdown-item" href="/mypage">프로필</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="/login/doLogout">로그아웃</a></li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>


    <div class="modal fade" id="myModal" role="dialog">
        <!-- 사용자 지정 부분① : id명 -->

        <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">로그인</h4> <!-- 사용자 지정 부분② : 타이틀 -->

                </div>

                <div class="modal-body">
                    <div class="kakaoLogin">
                        <a href="/login/loginPage" data-content="Sing up">
                            <img src="/resources/images/kakao_login_image.png" /></a>
                    </div>
                    <div class="naverLogin">
                        hi
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

</header>