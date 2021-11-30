// 파티승인요청 승인 체크박스
$(document).ready(function () {
  $("#check-allPartyAccept").click(function () {
    if ($("#check-allPartyAccept").is(":checked"))
      $("input[name=emailAccept]").prop("checked", true);
    else $("input[name=emailAccept]").prop("checked", false);
  });

  $("input[name=emailAccept]").click(function () {
    var total = $("input[name=emailAccept]").length;
    var checked = $("input[name=emailAccept]:checked").length;

    if (total != checked) $("#check-allPartyAccept").prop("checked", false);
    else $("#check-allPartyAccept").prop("checked", true);
  });
});

// 파티승인요청 거절 체크박스
$(document).ready(function () {
  $("#check-allPartyReject").click(function () {
    if ($("#check-allPartyReject").is(":checked"))
      $("input[name=emailReject]").prop("checked", true);
    else $("input[name=emailReject]").prop("checked", false);
  });

  $("input[name=emailReject]").click(function () {
    var total = $("input[name=emailReject]").length;
    var checked = $("input[name=emailReject]:checked").length;

    if (total != checked) $("#check-allPartyReject").prop("checked", false);
    else $("#check-allPartyReject").prop("checked", true);
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