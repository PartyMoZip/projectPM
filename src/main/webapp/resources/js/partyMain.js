// 파티승인요청 체크박스
$(document).ready(function () {
  $("#check-allPartyAccept").click(function () {
    if ($("#check-allPartyAccept").is(":checked"))
      $("input[name=apa]").prop("checked", true);
    else $("input[name=apa]").prop("checked", false);
  });

  $("input[name=apa]").click(function () {
    var total = $("input[name=apa]").length;
    var checked = $("input[name=apa]:checked").length;

    if (total != checked) $("#check-allPartyAccept").prop("checked", false);
    else $("#check-allPartyAccept").prop("checked", true);
  });
});