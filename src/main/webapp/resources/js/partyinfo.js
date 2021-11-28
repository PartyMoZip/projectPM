const viewBtn = document.querySelectorAll("#showPartyBtn");

const handleShowInfo = (e) => {
    let partyCode = e.currentTarget.nextElementSibling.value;

    fetch(`/party/detail?partyCode=${partyCode}`, {
        method: "GET",
    }).then((res) => res.json())
        .then((data) => console.log(data))
        .catch((err) => console.dir(err));
}

for (let i = 0; i < viewBtn.length; i++) {
    viewBtn[i].addEventListener("click", handleShowInfo);
}
