const myModal = document.getElementById('myModal');
const myInput = document.getElementById('myInput');
const closeBtn = document.querySelector(".close");


myModal.addEventListener('shown.bs.modal', function () {
    myInput.focus()
})
