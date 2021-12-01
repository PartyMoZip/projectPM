// 파티승인요청 승인 체크박스
$(document).ready(function () {
  $("#check-allPartyAccept").click(function () {
    if ($("#check-allPartyAccept").is(":checked"))
      $("input[name=email]").prop("checked", true);
    else $("input[name=email]").prop("checked", false);
  });

  $("input[name=emailAccept]").click(function () {
    var total = $("input[name=email]").length;
    var checked = $("input[name=email]:checked").length;

    if (total != checked) $("#check-allPartyAccept").prop("checked", false);
    else $("#check-allPartyAccept").prop("checked", true);
  });
});


// 파티원 목록 추방 체크박스
$(document).ready(function () {
  $("#check-allMemberKick").click(function () {
    if ($("#check-allMemberKick").is(":checked"))
      $("input[name=amk]").prop("checked", true);
    else $("input[name=amk]").prop("checked", false);
  });

  $("input[name=amk]").click(function () {
    var total = $("input[name=amk]").length;
    var checked = $("input[name=amk]:checked").length;

    if (total != checked) $("#check-allMemberKick").prop("checked", false);
    else $("#check-allMemberKick").prop("checked", true);
  });
});