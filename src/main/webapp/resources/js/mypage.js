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
            .then((res) => res.json())
            .then((data) => {
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

    // enterBtn.addEventListener("click")
    for (const leaveBtn of leaveBtns) {
        leaveBtn.addEventListener("click", handleLeaveParty)
    }
    saveBtn.addEventListener("click", handleProfileSubmit);
    selectBtn.addEventListener("click", handleUploadClick);
    withdrawalBtn.addEventListener("click", handleWithdrawalSubmit);

})

