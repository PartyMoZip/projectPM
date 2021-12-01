<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파티모집 - 파티채팅</title>

<link rel="icon"
	href="${pageContext.request.contextPath}/resources/images/favicon.ico" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<!-- 폰트어썸 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/partyMainChat.css" />

</head>

<body>

	<main>
		<div class="container mt-5 px-5 profile-box shadow-lg">
			<img
				src="${pageContext.request.contextPath}/resources/images/logo.svg"
				alt="logo" width=150; height=50;
				style="float: right">
			<div class="container-lg-chatData">
				<div id="divChatData"></div>
			</div>
		</div>
		<div class="container-chatReply">
				<input type="text" id="message" size="60"
					onkeypress="if(event.keyCode==13){webSocket.sendChat();}" />
				<input class="btn btn-outline-primary" type="submit" id="btnSend"
					value="채팅 전송" onclick="webSocket.sendChat()" />
		</div>
	</main>

	<!-- 부트스트랩 js -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<!-- 제이쿼리 -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- 스윗알러트 -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
	<script type="text/javascript">
		$(window).on('load', function() {
			webSocket.init({
				url : '<c:url value="/chat" />'
			});
		});

		// 1) 페이지 로딩 전에 웹소켓 초기 세팅 시작
	</script>

	<script type="text/javascript">
		var webSocket = {
			init : function(param) {
				// 2) /chat라는 url 을 담은 Object를 받고 웹소켓의 url로 정해줌
				console.log(param);
				// Object object
				console.log('param : ' + param);
				// {url : '/chat'}
				this._url = param.url;
				console.log('param.url : ' + param.url);
				// this.url = /chat
				console.log('${param}');
				// {bang_id=aa}
				// ${param.bang_id} = aa

				this._initSocket();
			},
			sendChat : function() {
				this._sendMessage('${param.partyCode}', 'CMD_MSG_SEND', $(
						'#message').val());
				$('#message').val('');
			},
			sendEnter : function() {
				// 4) 입장 함수 시작
				this._sendMessage('${param.partyCode}', 'CMD_ENTER', $(
						'#message').val());
				$('#message').val('');
			},
			receiveMessage : function(msgData) {
				
				// 정의된 CMD 코드에 따라서 분기 처리
				if (msgData.cmd == 'CMD_MSG_SEND') {
					$('#divChatData')
							.append(
									'<div class="chatImg">'
											+ '<img src="' + msgData.userpic + '" border="0" width="50" height="50"/>'
											+ '</div>');
					$('#divChatData').append(
							'<div class="chatUser">' + '[' + msgData.user + ']'
									+ '</div>');
					$('#divChatData').append(
							'<div class="chatInfo">' + msgData.msg + '</div>');
				}
				// 입장
				else if (msgData.cmd == 'CMD_ENTER') {
					$('#divChatData')
							.append(
									'<div>'
											+ '<img src="' + msgData.userpic + '" border="0" width="50" height="50"/>'
											+ '</div>');
					$('#divChatData').append(
							'<div>' + '[' + msgData.user + ']' + '</div>');
					$('#divChatData').append('<div>' + msgData.msg + '</div>');
					$('#divChatData').append('<br>');
				}
				// 퇴장
				else if (msgData.cmd == 'CMD_EXIT') {
					$('#divChatData')
							.append(
									'<div>'
											+ '<img src="' + msgData.userpic + '" border="0" width="50" height="50"/>'
											+ '</div>');
					$('#divChatData').append(
							'<div>' + '[' + msgData.user + ']' + '</div>');
					$('#divChatData').append('<div>' + msgData.msg + '</div>');
					$('#divChatData').append('<br>');
				}
			},
			closeMessage : function(str) {
				$('#divChatData').append('<div>' + '연결 끊김 : ' + str + '</div>');
			},
			disconnect : function() {
				this._socket.close();
			},
			_initSocket : function() {
				// 3) socket에 url을 인자로 받는 SockJS 객체 형성
				this._socket = new SockJS(this._url); // handshake
				this._socket.onopen = function(evt) { // handshake 완료
					console.log(evt);
					// type : open
					// 열리면 webSocket의 sendEnter 메서드 실행
					webSocket.sendEnter();
				};
				// 7) chatHandler에서 보낸 {"msg":"5bx2ikig님이 입장 했습니다.","bang_id":"aa","cmd":"CMD_ENTER"} 받음
				this._socket.onmessage = function(evt) { // socket에서 정보를 수신했을 때 실행됨
					console.log('evt.data : ' + evt.data);
					webSocket.receiveMessage(JSON.parse(evt.data))

				};
				this._socket.onclose = function(evt) {
					webSocket.closeMessage(JSON.parse(evt.data));
				}
			},
			_sendMessage : function(partyCode, cmd, msg) {
				// 5) 방 아이디 , 커맨드(명령), 메세지 가져옴
				console.log("partyCode : " + partyCode);
				// 방 아이디 aa
				console.log("cmd : " + cmd);
				// 커맨드 CMD_ENTER
				console.log("msg : " + msg);
				// msg 공백
				var msgData = {
					partyCode : partyCode,
					cmd : cmd,
					msg : msg
				};
				// 제이슨 데이터를 스트링화 시킴
				var jsonData = JSON.stringify(msgData);
				this._socket.send(jsonData);
				console.log('jsonData : ' + jsonData);
				// payload 로 보내면 채팅핸들러가 받음

				// 6) chatHandler에서 세션과 비교하며 전달메세지를 뿌릴 작업을 함
			}
		};
		
	</script>

</body>
</html>