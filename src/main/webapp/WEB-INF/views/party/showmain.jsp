<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showPartyMain.jsp</title>
</head>
<body>
    <h1>/WEB-INF/views/party/showPartyMain.jsp</h1>
    <hr>
    <h3>${__PARTY__}</h3>
    <a href="/party/showLeaderPage?partyCode=${__PARTY__.partyCode}">파티 관리페이지</a>
    <a href="/party/showMemberList?partyCode=${__PARTY__.partyCode}">파티 멤버페이지</a>
</body>
</html>