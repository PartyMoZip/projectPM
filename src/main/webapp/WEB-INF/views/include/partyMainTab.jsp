<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<!-- 파티 관리페이지 상단 탭 -->
	<ul class="nav nav-pills">
		<li class="nav-item"><a class="nav-link" aria-current="page"
			href="/party/showmain?partyCode=${__PARTY__.partyCode}">메인</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/party/leaderpage?partyCode=${__PARTY__.partyCode}">파티관리</a></li>
		<li class="nav-item"><a class="nav-link" href="#">일정</a></li>
		<li class="nav-item"><a class="nav-link" href="/party/memberlist?partyCode=${__PARTY__.partyCode}">파티원</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/partyfree/getPFreeBoardList">자유게시판</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/partyphoto/list?partyCode=${__PARTY__.partyCode}">포토갤러리</a></li>
		<li class="nav-item"><a class="nav-link"
			href="/partyfunc/partychat?partyCode=${__PARTY__.partyCode}">채팅</a></li>
	</ul>
</div>

