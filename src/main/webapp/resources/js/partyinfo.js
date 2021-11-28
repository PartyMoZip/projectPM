const viewBtn = document.querySelectorAll("#showPartyBtn");
const partyName = document.querySelector(".modal-partyName");
const img = document.querySelector(".modal-img");
const count = document.querySelector(".modal-count");
const localName = document.querySelector(".modal-localName");
const hobbyName = document.querySelector(".modal-hobbyName");
const partyScore = document.querySelector(".modal-partyScore");
const profile = document.querySelector(".modal-profile");

const handleShowInfo = (e) => {
    // partycode 밸류 가져오기
    let partyCode = e.currentTarget.nextElementSibling.value;

    // api 불러와서 modal 정보 입력
    fetch(`/party/detail?partyCode=${partyCode}`, {
        method: "GET",
    }).then((res) => res.json())
        .then((data) => {
            console.log(data);
            img.setAttribute("src", data.coverPic);
            count.innerHTML = data.count;
            partyName.innerHTML = data.partyName;
            localName.innerHTML = data.localName;
            hobbyName.innerHTML = data.hobbyName;
            partyScore.innerHTML = data.partyScore;
            profile.innerHTML = data.partyProfile;
        })
        .catch((err) => console.dir(err));
}

for (let i = 0; i < viewBtn.length; i++) {
    viewBtn[i].addEventListener("click", handleShowInfo);
}
