// 변수 선언
const title = document.querySelector(".title");
const hobbyMenu = document.querySelector(".menu-hobby");
const localMenu = document.querySelector(".menu-local");
const hobbySearchBar = document.querySelector(".select-hobby");
const localSelectInput = document.querySelector(".select-local");
const searchInput = document.querySelector(".input-search");
const selectForm = document.querySelector(".select-form");
const paginationForm = document.querySelector("#paginationForm");

// 취미 메뉴 검색 창 클릭 이벤트 막기
const handlePrevent = (e) => {
    e.stopPropagation();
}

// 취미, 지역 카테고리 선택
const handleClickCategory = (e) => {
    e.preventDefault();

    if (e.target.parentNode === hobbyMenu) {
        if (e.target.innerText !== "전체") {
            hobbySearchBar.setAttribute('value', e.target.innerText);
        } else {
            hobbySearchBar.removeAttribute('value');
        }
    }

    if (e.target.parentNode === localMenu) {
        if (e.target.innerText !== "전체") {
            localSelectInput.setAttribute('value', e.target.innerText);
        } else {
            localSelectInput.removeAttribute('value');
        }
    }

    selectForm.submit();
}

hobbySearchBar.addEventListener('click', handlePrevent);
hobbyMenu.addEventListener("click", handleClickCategory);
localMenu.addEventListener("click", handleClickCategory);
