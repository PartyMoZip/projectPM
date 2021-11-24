const searchBar = document.querySelector("#search-bar");
const searchBox = document.querySelector(".search-box");
const searchUl = document.querySelector(".search-ul");
let cache = "";

const badgeClass = (element) => {
    element.classList.add("badge");
    element.classList.add("rounded-pill");
    element.classList.add("bg-secondary");
}

// 검색어 자동완성 리스트 채우기
const fillSearch = (data) => {
    searchUl.innerHTML = "";
    data.forEach((el, idx) => {
        console.log(el);
        const li = document.createElement("li");
        const leftBox = document.createElement("div");
        const thumbBox = document.createElement("div");
        const thumbnail = document.createElement("img");
        const party = document.createElement("span");

        const rightBox = document.createElement("div");
        const hobby = document.createElement("span");
        const local = document.createElement("span");
        const link = document.createElement("a");

        leftBox.classList.add("left-box");
        thumbBox.classList.add("thumb-box");
        party.classList.add("mx-3");
        thumbnail.setAttribute("src", el.logoPic);
        party.innerHTML = el.partyName;
        thumbBox.appendChild(thumbnail);
        leftBox.appendChild(thumbBox);
        leftBox.appendChild(party);

        rightBox.classList.add("right-box");
        badgeClass(hobby);
        badgeClass(local);
        rightBox.appendChild(hobby);
        rightBox.appendChild(local);
        hobby.innerHTML = el.hobbyName;
        local.innerHTML = el.localName;

        link.setAttribute("href", `/`);

        link.appendChild(leftBox);
        link.appendChild(rightBox);
        li.appendChild(link);
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

        fetch(cache,
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json;",
                },
                body: JSON.stringify(data),
            }
        )
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