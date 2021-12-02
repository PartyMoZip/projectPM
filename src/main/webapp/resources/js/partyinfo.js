const viewBtn = document.querySelectorAll("#showPartyBtn");
const partyName = document.querySelector(".modal-partyName");
const img = document.querySelector(".modal-img");
const count = document.querySelector(".modal-count");
const localName = document.querySelector(".modal-localName");
const hobbyName = document.querySelector(".modal-hobbyName");
const partyScore = document.querySelector(".modal-partyScore");
const profile = document.querySelector(".modal-profile");
const reqBtn = document.querySelector(".party-req-btn");
const spinner = document.querySelector(".spinner");
let partyCode;


// 파티 가입 신청
const handleRequest = (e) => {
    e.preventDefault();

    let email = document.querySelector(".user-email");

    // 로그인을 안한 상태면 로그인 창으로
    if (email.value === '') {
        location.href = "/login";
    }

    let data = {
        email: email.value,
        partyCode
    };

    console.log(data);

    fetch("/party/join", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data),
    })
        .then((res) => {
            // spinner.classList.remove("hide");
            res.json().then((data) => {
                // spinner.classList.add("hide");
                Swal.fire(
                    '성공',
                    '파티 가입이 신청되었습니다!',
                    'success'
                )
            }).catch((err) => {
                // spinner.classList.add("hide");
                console.log(err);
                Swal.fire(
                    '실패',
                    '이미 가입했거나 신청한 파티에요!',
                    'warning'
                )
            })
        })

}

// 파티 정보 모달팝업
const handleShowInfo = (e) => {
    e.preventDefault();

    // partycode 밸류 가져오기
    partyCode = e.currentTarget.nextElementSibling.value;

    // api 불러와서 modal 정보 입력
    fetch(`/party/detail?partyCode=${partyCode}`, {
        method: "GET",
    }).then((res) => {
        res.json().then((data) => {

            console.log(data);
            img.setAttribute("src", data.coverPic);
            count.innerHTML = `#${data.count}명`;
            partyName.innerHTML = data.partyName;
            localName.innerHTML = `#${data.localName}`;
            hobbyName.innerHTML = data.hobbyName;
            partyScore.innerHTML = `#${data.partyScore}점`;
            profile.innerHTML = data.partyProfile;
        })
            .catch((err) => console.log(err));
    })

}

for (let i = 0; i < viewBtn.length; i++) {
    viewBtn[i].addEventListener("click", handleShowInfo);
}

reqBtn.addEventListener("click", handleRequest);

