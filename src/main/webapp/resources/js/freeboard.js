// 자유게시판 게시글 체크박스
$(document).ready(function () {
    $("#check-allFreeBoard").click(function () {
        if ($("#check-allFreeBoard").is(":checked"))
            $("input[name=fbc]").prop("checked", true);
        else $("input[name=fbc]").prop("checked", false);
    });

    $("input[name=fbc]").click(function () {
        var total = $("input[name=fbc]").length;
        var checked = $("input[name=fbc]:checked").length;

        if (total != checked) $("#check-allFreeBoard").prop("checked", false);
        else $("#check-allFreeBoard").prop("checked", true);
    });
});

$('#menu li > a').on('click', function () {
    $('#mystatus').text($(this).text());
})