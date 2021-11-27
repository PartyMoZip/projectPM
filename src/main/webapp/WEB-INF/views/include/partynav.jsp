<%--
  Created by IntelliJ IDEA.
  User: chico
  Date: 2021-11-27
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<ul class="nav nav-pills">
    <li class="nav-item"><a class="nav-link active"
                            aria-current="page"
                            href="/party/showmain?partyCode=${__PARTY__.partyCode}">메인</a></li>
    <li class="nav-item"><a class="nav-link"
                            href="/party/leaderpage?partyCode=${__PARTY__.partyCode}">파티관리</a></li>
    <li class="nav-item"><a class="nav-link" href="#">일정</a></li>
    <li class="nav-item"><a class="nav-link" href="#">파티원</a></li>
    <li class="nav-item"><a class="nav-link"
                            href="/partyfree/">자유게시판</a></li>
    <li class="nav-item"><a class="nav-link"
                            href="/partyphoto/list?partyCode=${__PARTY__.partyCode}">포토갤러리</a></li>
    <li class="nav-item"><a class="nav-link"
                            href="/partyfunc/partychat?partyCode=${__PARTY__.partyCode}">채팅</a></li>
</ul>
</body>
</html>
