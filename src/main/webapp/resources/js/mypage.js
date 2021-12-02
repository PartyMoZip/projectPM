const enterBtn = document.querySelector('.enter-btn');
const leaveBtns = document.querySelectorAll('.leave-btn');
const inputEmail = document.querySelector(".input-email");
const inputNickname = document.querySelector(".input-nickname");
const inputFile = document.querySelector(".input-file");
const profileImg = document.querySelector(".img-profile img");
const selectBtn = document.querySelector(".select-btn");
const saveBtn = document.querySelector(".save-btn");

const inputWithdrawal = document.querySelector('.input-withdrawal')
const withdrawalBtn = document.querySelector('.withdrawal-btn');
const spinner = document.querySelector(".spinner");
const formData = new FormData();

const formParty = document.querySelector('.form-party');
const createBtn = document.querySelector(".create-btn");

document.addEventListener("DOMContentLoaded", () => {
    // 파티 탈퇴 이벤트
    const handleLeaveParty = (e) => {
        e.preventDefault();
        console.log(e.target.nextElementSibling);

        const partyCode = e.target.nextElementSibling.value;

        let data = {};
        data.email = inputEmail.value;
        data.partyCode = partyCode;

        console.log(data);

        fetch("/my/profile/withdrawal-party", {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json;",
            },
            body: JSON.stringify(data),
        })
            .then((res) => {
                spinner.classList.remove('hide');

                res.json().then((data) => {
                    spinner.classList.add('hide');
                    console.log(data);

                    if (data.result) {
                        Swal.fire('성공', '파티 탈퇴가 완료되었습니다.', 'success');
                        setTimeout(function () {
                            location.href = "http://localhost:8090/my/profile";
                        }, 2000)

                    } else {
                        Swal.fire('실패', '에러가 발생했습니다.', 'error')
                    } // if
                })
                    .catch((err) => {
                        console.log(err);
                    });
            })

    } // handleLeaveParty

    // 프로필 수정 이벤트
    const handleProfileSubmit = (e) => {
        e.preventDefault();

        formData.append("email", inputEmail.value);

        if (inputNickname.value.includes(",")) {
            let value = inputNickname.value.split(',');
            formData.append("nickname", value[1]);
        } else {
            formData.append("nickname", inputNickname.value);
        } // if

        if (inputFile.files[0] !== undefined) {
            formData.append("fileLocation", inputFile.files[0]);
        } // if

        for (let pair of formData.entries()) {
            console.log(pair[0] + ', ' + pair[1]);
        }

        fetch(`/my/profile/edit-profile`, {
            method: "POST",
            headers: {},
            body: formData,
        })
            .then((res) => {
                spinner.classList.remove("hide");

                res.json().then((data) => {
                    spinner.classList.add("hide");
                    console.log(data);

                    if (!data.fileLocation === undefined) {
                        profileImg.setAttribute("src", data.fileLocation);
                    }
                    inputNickname.value = data.nickname;
                    Swal.fire("성공", "수정이 완료되었습니다.", "success")
                })

                    .catch((err) => {
                        console.log(err);
                        Swal.fire("실패", "다시 시도해주십시오.", "error")
                    });
            })

    } // handleProfileSubmit

    // 이미지 업로드 버튼
    const handleUploadClick = (e) => {
        e.preventDefault();
        inputFile.click();
    } // handleUploadClick

    // 이미지 업로드 시 미리보기
    inputFile.onchange = () => {
        let fileList = inputFile.files;

        const reader = new FileReader();
        reader.readAsDataURL(fileList[0]);

        reader.onload = function () {
            profileImg.src = reader.result;
        }
    } // onchange

    // 회원탈퇴
    const handleWithdrawalSubmit = (e) => {
        e.preventDefault();

        const withdrawal = "네, 탈퇴하겠습니다.";
        let answer = inputWithdrawal.value;

        if (withdrawal === answer) {
            let data = {
                email: inputEmail.value
            }

            fetch(`/my/profile/withdrawal`, {
                method: "PATCH",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(data),
            })
                .then((res) => {
                    spinner.classList.remove("hide");

                    res.json().then((data) => {
                        spinner.classList.add("hide");
                        console.log(data);

                        if (data.result) {
                            Swal.fire('성공', '그동안 감사했습니다.😂', 'success');
                            setTimeout(function () {
                                location.href = "http://localhost:8090/";
                            }, 2000);

                        } else {
                            Swal.fire('실패', '에러가 발생했습니다.', 'error')
                        } // if
                    })
                        .catch((err) => {
                            console.log(err);
                        });
                })

        } else {
            Swal.fire('실패', '입력값이 일치하지 않습니다.', 'error')
        } // if

    } // handleWithdrawalSubmit

    // 파티생성
    const handleCreateParty = (e) => {
        e.preventDefault();
        console.log("파티생성");

        let localSelect = document.querySelector('.form-select');
        let inputPartyName = document.querySelector('.input-partyName').value;
        let inputProfile = document.querySelector('.input-profile').value;
        let hobbyArr = document.querySelectorAll('input[type="radio"]');
        let radio = document.querySelector('input[type="radio"]:checked').getAttribute("id");
        let hobbyCode;
        let localCode = localSelect.options[localSelect.selectedIndex].value;
        let inputArr = document.querySelectorAll('.party-info');

        hobbyArr.forEach((ele, idx) => {
            if (ele.getAttribute("id") === radio) {
                hobbyCode = idx + 1;
            }
        });

        if (inputFile.value === "" || inputPartyName === "" || inputProfile === "") {
            Swal.fire("에러", "정보를 전부 기입해주세요.", "warning");
            return;
        }

        if (localCode === "지역") {
            Swal.fire("에러", "지역을 선택해주세요.", "warning");
            return;
        }

        console.log(inputFile.value);
        console.log(`${typeof inputPartyName, inputPartyName}`); // 파티이름
        console.log(`${typeof inputProfile, inputProfile}`); // 프로필
        console.log(`${typeof hobbyCode, hobbyCode}`); // 취미번호
        console.log(`${typeof localCode, localCode}`); // 지역번호

        if (!checkSpell(inputPartyName)) {
            Swal.fire("에러", "특수문자나 단순 자모음은 검색할 수 없습니다.", "warning");
            return;
        }

        fetch(`/party/checkparty`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                partyName: inputPartyName
            }),
        })
            .then((res) => {
                spinner.classList.remove("hide");

                res.json().then((data) => {
                    spinner.classList.add("hide");
                    console.log(data);

                    if (data.result) {

                        inputArr[0].setAttribute("value", localCode);
                        inputArr[1].setAttribute("value", hobbyCode);
                        formParty.submit();
                    } else {
                        Swal.fire('실패', '중복된 파티명입니다.', 'warning');
                    } // if
                })
                    .catch((err) => {
                        console.log(err);
                    });
            })

    }

    // 정규표현식
    const checkSpell = (word) => {
        const regExp = /[!?@#$%^&*():;+-=~{}<>\_\[\]\|\\\"\'\,\.\/\`\₩]/g;
        const regExp2 = /[ㄱ-ㅎㅏ-ㅣ]/g;
        let result = true;

        if (regExp.test(word) || regExp2.test(word)) {
            result = false;
        }

        return result;
    }

    // enterBtn.addEventListener("click")
    for (const leaveBtn of leaveBtns) {
        leaveBtn.addEventListener("click", handleLeaveParty)
    }
    createBtn.addEventListener("click", handleCreateParty);
    selectBtn.addEventListener("click", handleUploadClick);
    saveBtn.addEventListener("click", handleProfileSubmit);
    withdrawalBtn.addEventListener("click", handleWithdrawalSubmit);
})

