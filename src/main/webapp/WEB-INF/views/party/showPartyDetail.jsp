<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>showPartyDetail.jsp</title>
  </head>
  <body>
    <h1>/WEB-INF/views/party/showPartyDetail.jsp</h1>
    <hr>
    <h3>${__PARTY__}</h3>
    <form action="/party/doPartyJoin" method="post">
      <input type="hidden" name="email" value="test1@test.com">
      <input type="hidden" name="partyCode" value="22222">
      <input type="submit" value="파티가입신청">
    </form>
    <hr>
    <form action="/party/undoPartyJoin" method="post">
      <input type="hidden" name="email" value="test1@test.com">
      <input type="hidden" name="partyCode" value="22222">
      <input type="submit" value="파티가입취소">
    </form>
    <hr>
    <a href="/party/showPartyMain?partyCode=${__PARTY__.partyCode}">파티 메인페이지</a>
  </body>
</html>
