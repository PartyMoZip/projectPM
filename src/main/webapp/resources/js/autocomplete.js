const searchBar = document.querySelector("#search-bar");
const searchBox = document.querySelector(".search-box");
const searchUl = document.querySelector(".search-ul");
let cache = "";

// 검색어 자동완성 리스트 채우기
const fillSearch = (data) => {
    searchUl.innerHTML = "";
    data.forEach((el, idx) => {
        console.log(el);
        const li = document.createElement("li");
        li.innerHTML = el.partyName;
        searchUl.appendChild(li);
    })
}

// 검색어 불러오기
const loadData = (word) => {
    let url = `/search/${word}`;

    if (cache !== url) {
        cache = url;
        let data = {};

        data.word = word;
        console.log(data); // {word = "축구"}


        fetch(cache, {
            method: "POST",
            headers: {
                "Content-Type": "application/json;",
            },
            body: JSON.stringify(data),
        })
            .then((res) => res.json())
            .then((data) => {
                console.log(data);
                fillSearch(data);
            })
            .catch((err) => {
                console.log(err);
            });
    }
}

// 타이머
const timer = (beforeInput) => {
    setTimeout(() => {

        if (searchBar.value === beforeInput) {
            loadData(searchBar.value);
            checkInput();
        } else {
            checkInput();
        }

        if (searchBar.value !== "") {
            searchBox.classList.remove("hide");
        } else {
            searchBox.classList.add("hide");
        }
    }, 500);
}

// 일정 시간 간격으로 조회
const checkInput = () => {
    const beforeInput = searchBar.value;
    timer(beforeInput);
}

searchBar.addEventListener('change', checkInput);
searchBar.addEventListener('keyup', checkInput);