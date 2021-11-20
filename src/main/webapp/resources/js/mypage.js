const inputEmail = document.querySelector(".input-email");
const inputId = document.querySelector(".input-id");
const inputNickname = document.querySelector(".input-nickname");
const inputFile = document.querySelector(".input-file");
const profileImg = document.querySelector(".img-profile img");
const selectBtn = document.querySelector(".select-btn");
const saveBtn = document.querySelector(".save-btn");
const formData = new FormData();

const handleSubmit = (e) => {
    e.preventDefault();
    const id = inputId.value;

    formData.append("email", inputEmail.value);

    if (inputNickname.value.includes(",")) {
        let value = inputNickname.value.split(',');
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
        })

        .catch((err) => {
            console.log(err);
        });
};

const handleClick = (e) => {
    e.preventDefault();

    inputFile.click();
}


inputFile.onchange = () => {
    let fileList = inputFile.files;

    const reader = new FileReader();
    reader.readAsDataURL(fileList[0]);

    reader.onload= function(){
        profileImg.src = reader.result;
    }
}
console.log(inputFile);
// inputFile.addEventListener("change", handleChange);
saveBtn.addEventListener("click", handleSubmit);
selectBtn.addEventListener("click", handleClick);