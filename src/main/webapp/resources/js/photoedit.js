const heartForm = document.querySelector('.form-heart');
const btnHit = document.querySelector('.btn-hit');
const thumb = document.querySelector('.fa-thumbs-up');
const totalHeart = document.querySelector('.totalHeart');

document.addEventListener('DOMContentLoaded', () => {

    const handleSubmitHeart = (e) => {
        e.preventDefault();

        let inputArr = heartForm.querySelectorAll('input');
        let dataArr = [];
        let data = {};

        inputArr.forEach((item, index) => {
            console.log(item.value, item.name);
            data[item.name] = item.value;
        })

        console.log(data);

        fetch('/partyphoto/heart', {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        }).then((res) => {
            res.json().then((data) => {
                console.log(data);

                if (data.myHeart === 1) {
                    btnHit.style.color = "#5E92FF";
                } else {
                    btnHit.style.color = "#212529";
                }
                totalHeart.innerHTML = data.totalHeart;
            }).catch((err) => {
                console.log(err);
            })
        })
    }

    btnHit.addEventListener('click', handleSubmitHeart);
})