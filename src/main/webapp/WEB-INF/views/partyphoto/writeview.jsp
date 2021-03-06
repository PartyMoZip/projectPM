<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>파티포토갤러리 - 글 쓰기</title>
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/images/favicon.ico"
    />
    <link
      rel="icon"
      href="${pageContext.request.contextPath}/resources/images/favicon.ico"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <!-- 폰트어썸 -->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
      integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/partyMainPhoto.css"
    />
  </head>
  <body>
    <%--HEADER--%>
    <jsp:include
      page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp"
    />
    <jsp:include
      page="${pageContext.request.contextPath}/WEB-INF/views/include/partynav.jsp"
    />

    <div class="container mt-5 px-5 profile-box shadow-sm">
      <form
        enctype="multipart/form-data"
        action="/partyphoto/write"
        method="post"
      >
        <div class="container">
          <div class="col-md-6">
            <div class="form-group">
              <label for="writer">작성자</label>
              <div class="form-control" id="writer">
                ${sessionScope.__AUTH__.nickname}
              </div>
            </div>
          </div>
          <input
            type="hidden"
            id="id"
            name="email"
            value="${sessionScope.__AUTH__.email}"
          />
          <input type="hidden" name="partycode" value="${ldto.partyCode}" />

          <div class="form-group" style="margin-right: 70px">
            <label for="title">글제목</label>
            <input
              type="text"
              class="form-control"
              name="psubject"
              id="title"
              value=""
              required="required"
            />
          </div>

          <div class="form-group" style="margin-right: 70px">
            <label for="content">글내용</label>
            <textarea
              class="form-control"
              rows="10"
              name="pcontent"
              id="content"
              required="required"
            ></textarea>
          </div>

          <div class="fileUploadBtn">
            <div class="form-group">
              <label for="File">첨부파일 1</label>
              <input type="file" name="images" />
            </div>
            <div class="form-group">
              <label for="File">첨부파일 2</label>
              <input type="file" name="images" />
            </div>
            <div class="form-group">
              <label for="File">첨부파일 3</label>
              <input type="file" name="images" />
            </div>
          </div>

          <div class="container-btnGroup">
            <button type="submit" class="btn btn-primary btn-sm">
              <i class="fas fa-pen"></i> <span>등록</span>
            </button>
            <button
              type="button"
              class="btn btn-primary btn-sm"
              onclick="location.href='/partyphoto/list?partyCode=${ldto.partyCode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}';"
            >
              <i class="fas fa-list-ul"></i> <span>목록</span>
            </button>
          </div>
        </div>
      </form>
    </div>

    <%--FOOTER--%>
    <div class="container">
      <jsp:include
        page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp"
      />
    </div>

    <!-- 부트스트랩 js -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <!-- 제이쿼리 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
    <!-- 스윗알러트 -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  </body>
</html>
