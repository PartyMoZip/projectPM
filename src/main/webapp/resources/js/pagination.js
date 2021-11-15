const pageItem = document.querySelectorAll(".page-item");
const currPage = document.querySelector(".d-none");

// 현재 페이지에 active 속성 추가
pageItem.forEach(
    e =>
        e.innerText === currPage.textContent ? e.classList.add('active') : false
);

