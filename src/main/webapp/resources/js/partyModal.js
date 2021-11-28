const partyRequest = document.getElementById("partyRequestBtn");

partyRequest.addEventListener("click", function () {
  if (partyRequest.innerText === "파티신청") {
    partyRequest.innerText = "신청취소";
    Swal.fire({
      icon: "success",
      title: "파티 신청이 전송되었습니다!",
      text: "즐거운 파티 생활되세요!!",
    });
  } else {
    partyRequest.innerText = "파티신청";
    Swal.fire({
      icon: "warning",
      title: "파티 신청이 취소되었습니다.",
      text: "다음에 또 만나요 ㅠㅠ",
    });
  }
});

"btn.btn-secondary".addEventListener("click", function () {
  if (("btn.btn-secondary".classList = "active")) {
    "btn.btn-secondary".classList.remove("active");
  } else {
    "btn.btn-secondary".classList.add("active");
  }
});
