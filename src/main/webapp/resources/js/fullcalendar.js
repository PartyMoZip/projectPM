var calendar = null;
var all_events = null;
all_events = loadingEvents();


document.addEventListener('DOMContentLoaded', function () {
    var calendarEl = document.getElementById('calendar'); // new FullCalendar.Calendar(대상 DOM객체, {속성:속성값, 속성2:속성값2..})
    calendar = new FullCalendar.Calendar(calendarEl, {
        timeZone: 'Asia/Seoul',
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },
        events: all_events,
        editable: true,
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
            if (confirm('삭제 하시겠습니까?')) {
                console.log(arg.event._def.publicId);
                let id = arg.event._def.publicId;
                let result = removeData(id);
                console.log("여기 = ", result);
                if (result) {
                    arg.event.remove();
                } else {
                    alert("오류");
                }
            }
        },
        editable: true,
        dayMaxEvents: true, // allow "more" link when too many events
    });
    calendar.render();
});


//조회
function loadingEvents() {
    var return_value = null;

    $.ajax({
        type: 'GET',
        url: '/partyfunc/calendar/data?partyCode=${partyCode}',
        data: {},
        dataType: 'json',
        async: false
    })
        .done(function (result) {
            console.log(result);
            return_value = result;
        })
        .fail(function (request, status, error) {
            alert("에러발생: " + error);
        })
    return return_value;
}


//저장
function allSave() {
    alert("저장 되었습니다!!");
    var allEvent = calendar.getEvents();
    //console.log(allEvent);
    var events = new Array();
    for (var i = 0; i < allEvent.length; i++) {
        var obj = new Object();

        if (allEvent[i]._def.publicId == "") {

            console.log(allEvent[i]);
            obj.title = allEvent[i]._def.title; //이벤트 명칭
            obj.allDay= allEvent[i]._def.allDay; //하루 종일의 이벤트인지 알려주는 Boolean값
            obj.startDate = allEvent[i]._instance.range.start; //시작 날짜 및 시간
            obj.endDate = allEvent[i]._instance.range.end; //마친 날짜 및 시간
            obj.partyCode = 1;
            events.push(obj);
        }
    }
    savedata(events);
}

//저장
function savedata(events) {
    fetch("/partyfunc/calendar/post", {
        method: "POST",
        headers: {
            "Content-type": "application/json",
        },
        body: JSON.stringify(events)
    })
        .then((res) => console.log(""))
        // .then((data) => console.log(data))
        .catch((err) => console.log(err))
}


//삭제
function removeData(id) {
    let return_value = null;
    var dataObj = {
        "id": id,
    }
    $.ajax({
        type: 'DELETE',
        url: '/partyfunc/calendar/data',
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(dataObj),
        async: false
    }).done(function (result) {
        return_value = result;
    }).fail(function (request, status, error) {
        alert("에러발생: " + error);
    });
    console.log(return_value);
    return return_value;
}