// 변수 선언
const title = document.querySelector(".title");
const hobbyMenu = document.querySelector(".menu-hobby");
const localMenu = document.querySelector(".menu-local");
const hobbySearchBar = document.querySelector(".select-hobby");
const localSelectInput = document.querySelector(".select-local");
const wordInput = document.querySelector(".word-input");
const searchInput = document.querySelector(".input-search");
const selectForm = document.querySelector(".select-form");
const headerForm = document.querySelector(".header-form");
const headerSearch = document.querySelector(".header-search");
const paginationForm = document.querySelector("#paginationForm");

const checkSpell = (word) => {
    const regExp = /[!?@#$%^&*():;+-=~{}<>\_\[\]\|\\\"\'\,\.\/\`\₩]/g;
    const regExp2 = /[ㄱ-ㅎㅏ-ㅣ]/g;
    let result = "true";

    if (regExp.test(word) || regExp2.test(word)) {
        result = false;
    }

    return result;
}

// 취미 메뉴 검색 창 클릭 이벤트 막기
const handlePrevent = (e) => {
    e.stopPropagation();
}

// 헤더 검색창 이벤트
const handleHeaderSubmit = (e) => {
    e.preventDefault();

    if (!checkSpell(headerSearch.value)) {
        Swal.fire(
            "입력 오류",
            "특수문자나 단순 자모음은 검색할 수 없습니다.",
            "warning"
        )

    } else {
        headerForm.submit();
    }
}

// 검색창 입력값 설정
const handleChangeWord = (e) => {
    console.log(headerSearch.value);
    let word = headerSearch.value;
    wordInput.setAttribute('value', word);
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

headerSearch.addEventListener('change', handleChangeWord);
headerSearch.addEventListener('keyup', handleChangeWord);
headerForm.addEventListener('submit', handleHeaderSubmit);
hobbySearchBar.addEventListener('click', handlePrevent);
hobbyMenu.addEventListener("click", handleClickCategory);
localMenu.addEventListener("click", handleClickCategory);
