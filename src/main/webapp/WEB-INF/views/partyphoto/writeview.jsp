<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action = "/partyphoto/write" method="post" enctype="multipart/form-data">
        <input type="text" name="partycode" value="${ldto.partyCode}" readonly>
        <input type="text" name="pcontent">
        <input type="text" name="psubject">
        <input type="text" name="email">

        <input type="file" multiple="multiple" name="images"/>

        <button type="submit">글쓰기</button>
    </form>
    <hr>
    <a href="/partyphoto/list?partyCode=${ldto.partyCode}&currPage=${cri.currPage}&searchWord=${ldto.searchWord}&option=${ldto.option}"></option>목록</a>

</body>
</html>