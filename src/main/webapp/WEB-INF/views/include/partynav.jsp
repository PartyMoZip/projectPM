<%-- Created by IntelliJ IDEA. User: chico Date: 2021-11-27 Time: 오후 2:51 To
change this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <body>
    <ul class="nav nav-pills">
      <li class="nav-item">
        <a
          class="nav-link"
          aria-current="page"
          href="/party/showmain?partyCode=${partyCode}"
          >메인</a
        >
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/party/leaderpage?partyCode=${partyCode}"
          >파티관리</a
        >
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/partyfunc/calendar?partyCode=${partyCode}"
          >일정</a
        >
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/party/memberlist?partyCode=${partyCode}"
          >파티원</a
        >
      </li>
      <li class="nav-item">
        <a
          class="nav-link"
          href="/partyfree/getPFreeBoardList?partyCode=${partyCode}"
          >자유게시판</a
        >
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/partyphoto/list?partyCode=${partyCode}"
          >포토갤러리</a
        >
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/partyfunc/partychat?partyCode=${partyCode}"
          >채팅</a
        >
      </li>
    </ul>
  </body>
</html>
