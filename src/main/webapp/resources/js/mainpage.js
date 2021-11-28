const colorArr = ["#ffb6b9", "#fae3d9", "#bbded6", "#8ac6d1", "#515bd4", "#8134af", "#dd2a7b", "#feda77", "#7F95D1"];
const swiperItems = document.querySelectorAll('.swiper-item');

window.onload = () => {
    let numArr = [];

    // 중복 제거
    while (numArr.length !== 9) {
        let num = Math.floor(Math.random() * 9);

        if (!numArr.includes(num))
            numArr.push(num);

    }

    /*  for (let num in numArr) {
          console.log(num);
          setColor(num);
      }*/
    for (let i = 0; i < numArr.length; i++) {
        setColor(i, numArr[i]);
    }
}

// 배경색 설정
const setColor = (idx, num) => {
    swiperItems[idx].style.backgroundColor = colorArr[num];
}

// 스와이프 아이템 링크
const handleSwipeLink = (e) => {
    e.preventDefault();

    const word = e.currentTarget.querySelector('span').innerHTML;
    location.href = `/search/list?word=${word}`;
}

// 배열 이벤트리스너
for (let i = 0; i < swiperItems.length; i++) {
    swiperItems[i].addEventListener("click", handleSwipeLink);
}