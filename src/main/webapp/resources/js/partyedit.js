const inputPartyCode = document.querySelector(".input-partycode");
const inputPartyName = document.querySelector(".input-partyname");
const inputFile = document.querySelector(".input-file");
const profileImg = document.querySelector(".img-profile img");
const inputProfile = document.querySelector(".input-partyprofile");
const selectBtn = document.querySelector(".select-btn");
const saveBtn = document.querySelector(".save-btn");
const inputWithdrawal = document.querySelector(".input-withdrawal");
const withdrawalBtn = document.querySelector(".withdrawal-btn");
const formAccept = document.querySelector(".form-accept");
const acceptBtn = document.querySelector(".btn-accept");
const rejectBtn = document.querySelector(".btn-reject");
const spinner = document.querySelector(".spinner");
const formData = new FormData();

// 프로필 수정 이벤트
const handleProfileSubmit = (e) => {
  e.preventDefault();

  formData.append("partyCode", inputPartyCode.value);
  formData.append("partyProfile", inputProfile.value);

  if (inputPartyName.value.includes(",")) {
    let value = inputPartyName.value.split(",");
    formData.append("partyName", value[1]);
  } else {
    formData.append("partyName", inputPartyName.value);
  } // if

  if (inputFile.files[0] !== undefined) {
    formData.append("fileLocation", inputFile.files[0]);
  } // if

  console.log(formData);

  fetch(`/party/edit-profile`, {
    method: "POST",
    headers: {},
    body: formData,
  }).then((res) => {
    spinner.classList.remove("hide");

    res
      .json()
      .then((data) => {
        spinner.classList.add("hide");
        console.log(data);

        if (!data.fileLocation === undefined || data.fileLocation != null) {
          profileImg.setAttribute("src", data.fileLocation);
        }

        inputPartyName.value = data.partyName;
        inputProfile.innerHTML = data.partyProfile;
        Swal.fire("수정 성공", "수정이 완료되었습니다.", "success");
      })
      .catch((err) => {
        console.log(err);
      });
  });
}; // handleProfileSubmit

// 이미지 업로드 버튼
const handleUploadClick = (e) => {
  e.preventDefault();
  inputFile.click();
}; // handleUploadClick

// 이미지 업로드 시 미리보기
inputFile.onchange = () => {
  let fileList = inputFile.files;

  const reader = new FileReader();
  reader.readAsDataURL(fileList[0]);

  reader.onload = function () {
    profileImg.src = reader.result;
  };
}; // onchange

// 승인 거절 이벤트 처리
const handleAccept = (e) => {
  e.preventDefault();

  formAccept.setAttribute("action", "/party/do-accept-join");
  formAccept.submit();
};

const handleReject = (e) => {
  e.preventDefault();

  formAccept.setAttribute("action", "/party/do-reject-join");
  formAccept.submit();
};

saveBtn.addEventListener("click", handleProfileSubmit);
selectBtn.addEventListener("click", handleUploadClick);
acceptBtn.addEventListener("click", handleAccept);
rejectBtn.addEventListener("click", handleReject);
