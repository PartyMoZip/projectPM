const inputEmail = document.querySelector(".input-email");
const inputId = document.querySelector(".input-id");
const inputNickname = document.querySelector(".input-nickname");
const inputFile = document.querySelector(".input-file");
const profileImg = document.querySelector(".img-profile img");
const selectBtn = document.querySelector(".select-btn");
const saveBtn = document.querySelector(".save-btn");
const withdrawalBtn = document.querySelector(".withdrawal-btn");
const formData = new FormData();
const id = inputId.value;

// 프로필 수정 이벤트
const handleProfileSubmit = (e) => {
  e.preventDefault();

  formData.append("email", inputEmail.value);

  if (inputNickname.value.includes(",")) {
    let value = inputNickname.value.split(",");
    formData.append("nickname", value[1]);
  } else {
    formData.append("nickname", inputNickname.value);
  }

  if (inputFile.files[0] !== undefined) {
    formData.append("fileLocation", inputFile.files[0]);
  }

  fetch(`/users/${id}/edit-profile`, {
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
      Swal.fire("수정 성공", "수정이 완료되었습니다.", "success");
    })

    .catch((err) => {
      console.log(err);
    });
};

// 이미지 업로드 버튼
const handleUploadClick = (e) => {
  e.preventDefault();
  inputFile.click();
};

// 이미지 업로드 시 미리보기
inputFile.onchange = () => {
  let fileList = inputFile.files;

  const reader = new FileReader();
  reader.readAsDataURL(fileList[0]);

  reader.onload = function () {
    profileImg.src = reader.result;
  };
};

const handleWithdrawalSubmit = (e) => {
  e.preventDefault();

  let data = {
    email: inputEmail.value,
  };

  fetch(`/users/${id}/withdrawal`, {
    method: "POST",
    headers: {},
    body: JSON.stringify(data),
  })
    .then((res) => console.log(res))
    .catch((err) => {
      console.log(err);
    });
};

// inputFile.addEventListener("change", handleChange);
saveBtn.addEventListener("click", handleProfileSubmit);
selectBtn.addEventListener("click", handleUploadClick);
withdrawalBtn.addEventListener("click", handleWithdrawalSubmit);
