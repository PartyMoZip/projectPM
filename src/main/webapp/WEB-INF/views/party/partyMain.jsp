<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 css -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous" />
  <!-- 폰트어썸 -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
    integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />

  <link rel="stylesheet" href="./partyMain.css" />
  <title>파티메인페이지</title>
</head>
<body>
<!-- partial:index.partial.html -->
  <div class="container">
    <div class="row">

      <div class="page-wrapper chiller-theme toggled">
        <a id="show-sidebar" class="btn btn-sm btn-dark" href="#">
          <i class="fas fa-bars">&nbsp; &nbsp;MENU</i>
        </a>
        <nav id="sidebar" class="sidebar-wrapper">
          <div class="sidebar-content">
            <div class="sidebar-brand">
              <a href="#">PARTY MENU</a>
              <div id="close-sidebar">
                <i class="fas fa-times"></i>
              </div>
            </div>
            <div class="sidebar-header">
              <div class="partyMember-pic">
                <img class="img-responsive img-rounded" src="./img.jpg" alt="partyMember picture">
              </div>
              <div class="partyMember-info">
                <span class="partyMember-name">민진건</span>
                <span class="partyMember-role">파티장</span>
                <span class="partyMember-status">
                  <i class="fa fa-circle"></i>
                  <span>Online</span>
                </span>
              </div>
            </div>
            <!-- sidebar-header  -->
            <div class="sidebar-search">
              <div>
                <div class="input-group">
                  <input type="text" class="form-control search-menu" placeholder="Search...">
                  <div class="input-group-append">
                    <span class="input-group-text">
                      <i class="fa fa-search" aria-hidden="true"></i>
                    </span>
                  </div>
                </div>
              </div>
            </div>
            <!-- sidebar-search  -->
            <div class="sidebar-menu">
              <ul>
                <li class="sidebar-dropdown">
                  <a href="#">
                    <i class="fa fa-users"></i>
                    <span>파티</span>
                  </a>
                  <div class="sidebar-submenu">
                    <ul>
                      <li>
                        <a href="#">파티 관리</a>
                      </li>
                      <li>
                        <a href="#">파티원</a>
                      </li>
                    </ul>
                  </div>
                </li>
                <li class="sidebar-dropdown">
                  <a href="#">
                    <i class="fa fa-chalkboard"></i>
                    <span>게시판</span>
                  </a>
                  <div class="sidebar-submenu">
                    <ul>
                      <li>
                        <a href="#">자유게시판</a>
                      </li>
                    </ul>
                  </div>
                </li>
                <li class="sidebar-dropdown">
                  <a href="#">
                    <i class="fa fa-camera"></i>
                    <span>갤러리</span>
                  </a>
                  <div class="sidebar-submenu">
                    <ul>
                      <li>
                        <a href="#">포토갤러리</a>
                      </li>
                    </ul>
                  </div>
                </li>
                <li class="sidebar-dropdown">
                  <a href="#">
                    <i class="fa fa-comments"></i>
                    <span>채팅</span>
                  </a>
                  <div class="sidebar-submenu">
                    <ul>
                      <li>
                        <a href="#">채팅</a>
                      </li>
                    </ul>
                  </div>
                </li>
            </div>
            <!-- sidebar-menu  -->
          </div>
          <!-- sidebar-content  -->
          <div class="sidebar-footer">
            <a href="#">
              <i class="fa fa-bell"></i>
              <span class="badge badge-pill badge-warning notification">3</span>
            </a>
            <a href="#">
              <i class="fa fa-comments"></i>
            </a>
            <a href="#">
              <i class="fa fa-cog"></i>
            </a>
          </div>
        </nav>
        <!-- sidebar-wrapper  -->
        <main class="page-content">
          <div class="container">
            <h2>Pro Sidebar</h2>
            <hr>
            <div class="row">
              <div class="form-group col-md-12">
                <img src="./KakaoTalk_20211122_103257759.svg" alt="루피 어얼굴">
              </div>
              <!-- <div class="form-group col-md-12">
            <div class="alert alert-success" role="alert">
              <h4 class="alert-heading">New !</h4>
              <p>New react pro sidebar library is now available on <a
                  href="https://www.npmjs.com/package/react-pro-sidebar" target="_blank">npm</a> <a
                  href="https://github.com/azouaoui-med/react-pro-sidebar" target="_blank">
                  <img alt="GitHub stars"
                    src="https://img.shields.io/github/stars/azouaoui-med/react-pro-sidebar?style=social" />
                </a></p>
              <a href="https://github.com/azouaoui-med/react-pro-sidebar" target="_blank"
                class="btn btn-sm btn-primary mr-2">
                Github</a>
              <a href="https://azouaoui-med.github.io/react-pro-sidebar" target="_blank" class="btn btn-sm btn-success">
                Demo</a>
            </div>
          </div> -->
            </div>
            <!-- <h5>More templates</h5>
        <hr>
        <div class="row">
          <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
            <div class="card rounded-0 p-0 shadow-sm">
              <img
                src="https://user-images.githubusercontent.com/25878302/58369568-a49b2480-7efc-11e9-9ca9-2be44afacda1.png"
                class="card-img-top rounded-0" alt="Angular pro sidebar">
              <div class="card-body text-center">
                <h6 class="card-title">Angular Pro Sidebar</h6>
                <a href="https://github.com/azouaoui-med/angular-pro-sidebar" target="_blank"
                  class="btn btn-primary btn-sm">Github</a>
                <a href="https://azouaoui-med.github.io/angular-pro-sidebar/demo/" target="_blank"
                  class="btn btn-success btn-sm">Demo</a>
                <hr>
                <a href="https://github.com/azouaoui-med/react-pro-sidebar" target="_blank">
                  <img alt="GitHub stars"
                    src="https://img.shields.io/github/stars/azouaoui-med/angular-pro-sidebar?style=social" />
                </a>
                <a href="https://github.com/azouaoui-med/react-pro-sidebar" target="_blank">
                  <img alt="GitHub stars"
                    src="https://img.shields.io/github/forks/azouaoui-med/angular-pro-sidebar?style=social" />
                </a>
              </div>
            </div>
          </div>
          <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
            <div class="card rounded-0 p-0 shadow-sm">
              <img
                src="https://user-images.githubusercontent.com/25878302/58369258-33f20900-7ef8-11e9-8ff3-b277cb7ed7b4.PNG"
                class="card-img-top rounded-0" alt="Angular pro sidebar">
              <div class="card-body text-center">
                <h6 class="card-title">Angular Dashboard</h6>
                <a href="https://github.com/azouaoui-med/lightning-admin-angular" target="_blank"
                  class="btn btn-primary btn-sm">Github</a>
                <a href="https://azouaoui-med.github.io/lightning-admin-angular/demo/" target="_blank"
                  class="btn btn-success btn-sm">Demo</a>
                <hr>
                <a href="https://github.com/azouaoui-med/react-pro-sidebar" target="_blank">
                  <img alt="GitHub stars"
                    src="https://img.shields.io/github/stars/azouaoui-med/lightning-admin-angular?style=social" />
                </a>
                <a href="https://github.com/azouaoui-med/react-pro-sidebar" target="_blank">
                  <img alt="GitHub stars"
                    src="https://img.shields.io/github/forks/azouaoui-med/lightning-admin-angular?style=social" />
                </a>
              </div>
            </div>
          </div>
        </div> -->
          </div>
        </main>
        <!-- page-content" -->
      </div>

    </div>
  </div>
  <!-- page-wrapper -->

  <!-- 부트스트랩 js -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous"></script>
  <!-- 제이쿼리 -->
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <!-- 스윗알러트 -->
  <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <script src="./partyMain.js"></script>
</body>
</html>