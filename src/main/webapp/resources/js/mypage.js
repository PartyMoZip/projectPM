const inputEmail = document.querySelector(".input-email");
const inputNickname = document.querySelector(".input-nickname");
const inputFile = document.querySelector(".input-file");
const profileImg = document.querySelector(".img-profile img");
const selectBtn = document.querySelector(".select-btn");
const saveBtn = document.querySelector(".save-btn");
const inputWithdrawal = document.querySelector('.input-withdrawal')
const withdrawalBtn = document.querySelector('.withdrawal-btn');
const formData = new FormData();


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
        .then((res) => res.json())
        .then((data) => {
            console.log(data);

            if (!data.fileLocation === undefined) {
                profileImg.setAttribute("src", data.fileLocation);
            }
            inputNickname.value = data.nickname;
            Swal.fire("수정 성공", "수정이 완료되었습니다.", "success")
        })

        .catch((err) => {
            console.log(err);
        });
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
            headers: {},
            body: JSON.stringify(data),
        })
            .then((res) => res.json())
            .then((data) => {
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
    } else {
        Swal.fire('실패', '입력값이 일치하지 않습니다.', 'error')
    } // if

} // handleWithdrawalSubmit

// inputFile.addEventListener("change", handleChange);
saveBtn.addEventListener("click", handleProfileSubmit);
selectBtn.addEventListener("click", handleUploadClick);
withdrawalBtn.addEventListener("click", handleWithdrawalSubmit);