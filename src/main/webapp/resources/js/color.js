const colorArr = ["#ffb6b9", "#fae3d9", "#bbded6", "#8ac6d1", "#515bd4", "#8134af", "#dd2a7b", "#feda77", "#7F95D1"];
const swiperItems = document.querySelectorAll('.swiper-item');


window.onload = () => {
    let numArr = [];

    while (numArr.length !== 9) {
        let num = Math.floor(Math.random() * 9);

        if (!numArr.includes(num)) {
            numArr.push(num);
        }
    }

    for (let num in numArr) {
        console.log(num);
        setColor(num);
    }
}

const setColor = (num) => {
    swiperItems[num].style.backgroundColor = colorArr[num];
}

