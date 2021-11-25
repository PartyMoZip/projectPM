let calendar = null;
document.addEventListener('DOMContentLoaded', function () {
    let calendarEl = document.getElementById('calendar'); // new FullCalendar.Calendar(대상 DOM객체, {속성:속성값, 속성2:속성값2..})
    calendar = new FullCalendar.Calendar(calendarEl, {
        timeZone: 'UTC',
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },

        navLinks: true, // can click day/week names to navigate views
        selectable: true,
        selectMirror: true, // 이벤트명 : function(){} : 각 날짜에 대한 이벤트를 통해 처리할 내용..
        select: function (arg) {
            console.log(arg);
            var title = prompt('입력할 일정:'); // title 값이 있을때, 화면에 calendar.addEvent() json형식으로 일정을 추가
            if (title) {
                console.log("arg.start", arg.start);
                calendar.addEvent({
                    title: title,
                    start: arg.start,
                    end: arg.end,
                    allDay: arg.allDay
                })
            }
            calendar.unselect()
        },
        eventClick: function (arg) { // 있는 일정 클릭시,
            console.log("#등록된 일정 클릭#");
            console.log(arg.event);
            if (confirm('삭제하시겠습니까?')) {
                arg.event.remove()
            }
        },
        editable: true,
        dayMaxEvents: true, // allow "more" link when too many events
    });
    calendar.render();
});

function allSave() {
    let allEvent = calendar.getEvents();
    //console.log(allEvent);
    let events = new Array();
    for (let i = 0; i < allEvent.length; i++) {
        let obj = new Object();
        console.log(allEvent[i]);
        obj.title = allEvent[i]._def.title; //이벤트 명칭
        obj.allDay = allEvent[i]._def.allDay; //하루 종일의 이벤트인지 알려주는 Boolean값
        obj.start = allEvent[i]._instance.range.start.toUTCString(); //시작 날짜 및 시간
        obj.end = allEvent[i]._instance.range.end.toUTCString(); //마친 날짜 및 시간
        console.log(obj.start);
        events.push(obj);
    }
    savedata(events);
}

function savedata(events) {
    fetch("/partyfunc/calendar/post", {
        method: "POST",
        headers: {
            "Content-type": "application/json",
        },
        body: JSON.stringify(events)
    })
        .then((res) => console.log(res))
        .catch((err) => console.log(err))
}