<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Party Chatting</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
	<script type="text/javascript">
		var webSocket = {
			init: function(param) {
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
			sendChat: function() {
				this._sendMessage('${param.partyCode}', 'CMD_MSG_SEND', $('#message').val());
				$('#message').val('');
			},
			sendEnter: function() {
				// 4) 입장 함수 시작
				this._sendMessage('${param.partyCode}', 'CMD_ENTER', $('#message').val());
				$('#message').val('');
			},
			receiveMessage: function(msgData) {

				// 정의된 CMD 코드에 따라서 분기 처리
				if(msgData.cmd == 'CMD_MSG_SEND') {		
					$('#divChatData').append('<div>' + '<img src="' + msgData.userpic + '" border="0" width="50" height="50"/>' + '</div>');						
					$('#divChatData').append('<div>' + '[' + msgData.user + ']' + '</div>');			
					$('#divChatData').append('<div>' + msgData.msg + '</div>');
				}
				// 입장
				else if(msgData.cmd == 'CMD_ENTER') {		
					$('#divChatData').append('<div>' + '<img src="' + msgData.userpic + '" border="0" width="50" height="50"/>' + '</div>');		
					$('#divChatData').append('<div>' + '[' + msgData.user + ']' + '</div>');	
					$('#divChatData').append('<div>' + msgData.msg + '</div>');
				}
				// 퇴장
				else if(msgData.cmd == 'CMD_EXIT') {		
					$('#divChatData').append('<div>' + '<img src="' + msgData.userpic + '" border="0" width="50" height="50"/>' + '</div>');			
					$('#divChatData').append('<div>' + '[' + msgData.user + ']' + '</div>');				
					$('#divChatData').append('<div>' + msgData.msg + '</div>');
				}
			},
			closeMessage: function(str) {
				$('#divChatData').append('<div>' + '연결 끊김 : ' + str + '</div>');
			},
			disconnect: function() {
				this._socket.close();
			},
			_initSocket: function() {
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
			_sendMessage: function(partyCode, cmd, msg) {
				// 5) 방 아이디 , 커맨드(명령), 메세지 가져옴
				console.log("partyCode : "+ partyCode);
				// 방 아이디 aa
				console.log("cmd : "+ cmd);
				// 커맨드 CMD_ENTER
				console.log("msg : "+ msg);
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
	<script type="text/javascript">
        $(window).on('load', function () {
			webSocket.init({ url: '<c:url value="/chat" />' });	
		});
		// 1) 페이지 로딩 전에 웹소켓 초기 세팅 시작
	</script>
</head>
<body>
	<div style="width: 800px; height: 700px; padding: 10px; border: solid 1px #e1e3e9;">
		<div id="divChatData"></div>
	</div>
	<div style="width: 100%; height: 10%; padding: 10px;">
		<input type="text" id="message" size="110" onkeypress="if(event.keyCode==13){webSocket.sendChat();}" />
		<input type="button" id="btnSend" value="채팅 전송" onclick="webSocket.sendChat()" />
	</div>
</body>
</html>