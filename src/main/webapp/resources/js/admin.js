// 파티관리 체크박스
$(document).ready(function () {
  $("#check-allParty").click(function () {
    if ($("#check-allParty").is(":checked"))
      $("input[name=pc]").prop("checked", true);
    else $("input[name=pc]").prop("checked", false);
  });

  $("input[name=pc]").click(function () {
    var total = $("input[name=pc]").length;
    var checked = $("input[name=pc]:checked").length;

    if (total != checked) $("#check-allParty").prop("checked", false);
    else $("#check-allParty").prop("checked", true);
  });
});

// 파티해체요청 체크박스
$(document).ready(function () {
  $("#check-allPartyBreak").click(function () {
    if ($("#check-allPartyBreak").is(":checked"))
      $("input[name=apbc]").prop("checked", true);
    else $("input[name=apbc]").prop("checked", false);
  });

  $("input[name=apbc]").click(function () {
    var total = $("input[name=apbc]").length;
    var checked = $("input[name=apbc]:checked").length;

    if (total != checked) $("#check-allPartyBreak").prop("checked", false);
    else $("#check-allPartyBreak").prop("checked", true);
  });
});

// 블랙회원리스트 관리 체크박스
$(document).ready(function () {
  $("#check-allBlackMember").click(function () {
    if ($("#check-allBlackMember").is(":checked"))
      $("input[name=bmc]").prop("checked", true);
    else $("input[name=bmc]").prop("checked", false);
  });

  $("input[name=bmc]").click(function () {
    var total = $("input[name=bmc]").length;
    var checked = $("input[name=bmc]:checked").length;

    if (total != checked) $("#check-allBlackMember").prop("checked", false);
    else $("#check-allBlackMember").prop("checked", true);
  });
});

// 블랙파티리스트 관리 체크박스
$(document).ready(function () {
  $("#check-allBlackParty").click(function () {
    if ($("#check-allBlackParty").is(":checked"))
      $("input[name=bpc]").prop("checked", true);
    else $("input[name=bpc]").prop("checked", false);
  });

  $("input[name=bpc]").click(function () {
    var total = $("input[name=bpc]").length;
    var checked = $("input[name=bpc]:checked").length;

    if (total != checked) $("#check-allBlackParty").prop("checked", false);
    else $("#check-allBlackParty").prop("checked", true);
  });
});

// 검색창 active 효과 추가
const searchEl = document.querySelector(".search");

const searchInputEl = searchEl.querySelector("input");

searchEl.addEventListener("click", function () {
  // Logic
  searchInputEl.focus();
});

searchInputEl.addEventListener("focus", function () {
  searchEl.classList.add("focused");
  searchInputEl.setAttribute("placeholder", "검색");
});

searchInputEl.addEventListener("blur", function () {
  searchEl.classList.remove("focused");
  searchInputEl.setAttribute("placeholder", "");
});
