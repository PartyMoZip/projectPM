<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showLeaderPage.jsp</title>
</head>
<body>
    <h1>/WEB-INF/views/party/showLeaderPage.jsp</h1>
    <hr>
    <h3>${__PARTY__}</h3>
    <form action="/party/editparty" method="post">
        <input type="hidden" name="partyCode" value="${__PARTY__.partyCode}">
        <input type="text" name="partyName" value="${__PARTY__.partyName}">
        <input type="text" name="partyProfile" value="${__PARTY__.partyProfile}">
        <input type="text" name="localCode" value="${__PARTY__.localName}">
        <input type="text" name="hobbyCode" value="${__PARTY__.hobbyName}">
        <input type="submit" value="파티정보수정">
      </form>
      <hr>
      <form action="/party/dobreak" method="post">
        <input type="hidden" name="partyCode" value="${__PARTY__.partyCode}">
        <input type="submit" value="파티해체신청">
      </form>
      <hr>
      <form action="/party/editleader" method="post">
        <input type="hidden" name="leaderEmail" value="test1@test.com">
        <input type="hidden" name="memberEmail" value="test24@test.com">
        <input type="hidden" name="partyCode" value="${__PARTY__.partyCode}">
        <input type="submit" value="파티장 위임">
      </form>
      <hr>
      <form action="/party/editpl" method="post" enctype="multipart/form-data">
        <input type="hidden" name="partyCode" value=10>
        <input type="file" multiple="multiple" name="image"/>
        <button type="submit">전송</button>
      </form>
      <h1>${logoresult}</h1>
      <img src="/logoImages/${__PARTY__.logoPic}" alt="" />
      <hr>
      <form action="/party/editpi" method="post" enctype="multipart/form-data">
        <input type="hidden" name="partyCode" value=10>
        <input type="file" multiple="multiple" name="image"/>
        <button type="submit">전송</button>
      </form>
      <h1>${mainresult}</h1>
      <img src="/mainImages/${__PARTY__.coverPic}" alt="" />

</body>
</html>