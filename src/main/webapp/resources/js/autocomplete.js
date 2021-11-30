const searchBar = document.querySelector("#search-bar");
const searchBox = document.querySelector(".search-box");
const searchUl = document.querySelector(".search-ul");
let cache = "";

document.addEventListener('DOMContentLoaded', () => {
    const badgeClass = (element) => {
        element.classList.add("badge");
        element.classList.add("rounded-pill");
        element.classList.add("bg-secondary");
    } // badgeClass

    // 검색어 자동완성 리스트 채우기
    const fillSearch = (data) => {
        searchUl.innerHTML = "";

        // 데이터 가공하기
        data.forEach((el, idx) => {

            // html 요소 생성
            const li = document.createElement("li");
            const leftBox = document.createElement("div");
            const thumbBox = document.createElement("div");
            const thumbnail = document.createElement("img");
            const party = document.createElement("span");

            const rightBox = document.createElement("div");
            const hobby = document.createElement("span");
            const local = document.createElement("span");
            const link = document.createElement("a");

            // 요소에 필요한 class, 속성 정의하기
            leftBox.classList.add("left-box");
            thumbBox.classList.add("thumb-box");
            party.classList.add("mx-3");
            thumbnail.setAttribute("src", el.coverPic);
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

            link.setAttribute("href", `/search/list?word=${el.partyName}`);

            link.appendChild(leftBox);
            link.appendChild(rightBox);
            li.appendChild(link);
            searchUl.appendChild(li);
        })
    } // fillSearch

    // 검색어 불러오기
    const loadData = (word) => {
        let url = `/search/${word}`;

        // 검색어를 입력하면 url 값이 변경된다
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
                // response 객체를 json 변환
                .then((res) => res.json())
                .then((data) => {
                    console.log(data);
                    fillSearch(data); // data로 list 만드는 함수 실행
                })
                .catch((err) => {
                    console.log(err);
                });
        }
    } // loadData

    // 타이머
    const timer = (beforeInput) => {

        // 0.5초마다 검색어를 확인
        // 하나하나 변경될때마다 데이터를 넘기는 것보다 딜레이가 있는 것이 낫다 판단
        setTimeout(() => {
            if (searchBar.value === beforeInput) {
                loadData(searchBar.value);
                checkInput();
            } else {
                checkInput();
            } // if-else

            // 검색어가 없으면 요소를 숨김
            if (searchBar.value !== "") {
                searchBox.classList.remove("hide");
            } else {
                searchBox.classList.add("hide");
            } // if-else
        }, 500);
    } // timer

    // 일정 시간 간격으로 조회
    const checkInput = () => {
        const beforeInput = searchBar.value;
        timer(beforeInput);
    } // checkInput

    searchBar.addEventListener('change', checkInput);
    searchBar.addEventListener('keyup', checkInput);
})
