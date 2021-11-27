package com.pm.myapp.chat;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.myapp.controller.join.LoginController;
import com.pm.myapp.domain.UserDTO;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Component
public class HandlerChat extends TextWebSocketHandler {

	// (<"partyCode", 방ID>, <"session", 세션>) - (<"partyCode", 방ID>, <"session", 세션>) - (<"partyCode", 방ID>, <"session", 세션>) 형태 
	private List<Map<String, Object>> sessionList = new ArrayList<Map<String, Object>>();
	
	// 클라이언트가 서버로 메세지 전송 처리
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		Map<String,Object> sessionmap = session.getAttributes();
		UserDTO dto = (UserDTO) sessionmap.get(LoginController.authKey);
		String nickname = dto.getNickname();
		String userPic = dto.getUserPic();
		
		super.handleTextMessage(session, message);
        log.info("\t+ session : {}", session);
        // WebSocketServerSockJsSession[id=5bx2ikig]
		
        // JSON --> Map으로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		
		// payload 로 {"partyCode":"aa","cmd":"CMD_ENTER","msg":""} 받음
		Map<String, String> mapReceive = objectMapper.readValue(message.getPayload(), Map.class);
		// 접속하거나, 말한 사람의 정보가 담기는 Map
		log.info("\t+ message.getPayload() : {}", message.getPayload());
		
		switch (mapReceive.get("cmd")) {
		
		// CLIENT 입장하는 경우
		case "CMD_ENTER":
			// 세션 리스트에 저장
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("partyCode", mapReceive.get("partyCode"));
			map.put("session", session);
			
			// 방이름-세션 추가 : 처음 방을 들어온것이라
			sessionList.add(map);
			
			// 같은 채팅방에 입장 메세지 전송
			// 방이름 - 세션 :: 개수 = 접속한 사람의 인원수
			for (int i = 0; i < sessionList.size(); i++) {
				// 접속한 인원만큼 MapSessionList에 정보 추가
				Map<String, Object> mapSessionList = sessionList.get(i);
				String partyCode = (String) mapSessionList.get("partyCode");
				// 접속한 사람의 방 이름
				WebSocketSession ws = (WebSocketSession) mapSessionList.get("session");
				// 접속한 사람의 세션
				
				if(partyCode.equals(mapReceive.get("partyCode"))) {
					// partyCode = 세션에 있는 사람들의 방이름
					// mapReceive.get("partyCode") 접속한 사람의 방이름
					// 그 둘이 같다면 아래와 같은 메세지를 만들어서 출력
					Map<String, String> mapToSend = new HashMap<String, String>();
					mapToSend.put("partyCode", partyCode);
					mapToSend.put("cmd", "CMD_ENTER");
					mapToSend.put("user", nickname);
					mapToSend.put("msg", "[ " + nickname + " ] 님이 파티 채팅방에 [ 입장 ] 하셨습니다.");
					mapToSend.put("userpic", userPic);
					
					String jsonStr = objectMapper.writeValueAsString(mapToSend);
					System.out.println("jsonStr : " + jsonStr);
					// jsonStr : {"msg":"5bx2ikig님이 입장 했습니다.","partyCode":"aa","cmd":"CMD_ENTER"}
					
					ws.sendMessage(new TextMessage(jsonStr));
					// 위의 내용으로 chat jsp로 전달 : this._socket.onmessage = function(evt)
				} // if
			
			} // for
			break;
			
		// CLIENT 메세지 보낼 때
		case "CMD_MSG_SEND":
			// 같은 채팅방에 메세지 전송
			for (int i = 0; i < sessionList.size(); i++) {
				Map<String, Object> mapSessionList = sessionList.get(i);
				String partyCode = (String) mapSessionList.get("partyCode");
				WebSocketSession ws = (WebSocketSession) mapSessionList.get("session");

				if (partyCode.equals(mapReceive.get("partyCode"))) {
					Map<String, String> mapToSend = new HashMap<String, String>();
					mapToSend.put("partyCode", partyCode);
					mapToSend.put("cmd", "CMD_MSG_SEND");
					mapToSend.put("user", nickname);
					mapToSend.put("msg",  mapReceive.get("msg"));
					mapToSend.put("userpic", userPic);

					String jsonStr = objectMapper.writeValueAsString(mapToSend);
					ws.sendMessage(new TextMessage(jsonStr));
				} // if
			
			} // for
			break;
			
		} // switch
		
	} // handleTextMessage

	// 클라이언트가 연결을 끊음 처리
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

		Map<String,Object> sessionmap = session.getAttributes();
		UserDTO dto = (UserDTO) sessionmap.get(LoginController.authKey);
		String nickname = dto.getNickname();
		String userPic = dto.getUserPic();
		
		super.afterConnectionClosed(session, status);
        
		ObjectMapper objectMapper = new ObjectMapper();
		String now_partyCode = "";
		
		// 사용자 세션을 리스트에서 제거
		for (int i = 0; i < sessionList.size(); i++) {
			Map<String, Object> map = sessionList.get(i);
			String partyCode = (String) map.get("partyCode");
			WebSocketSession ws = (WebSocketSession) map.get("session");
			
			if(session.equals(ws)) {
				now_partyCode = partyCode;
				sessionList.remove(map);
				break;
			} // if
			
		} // for
		
		// 같은 채팅방에 퇴장 메세지 전송 
		for (int i = 0; i < sessionList.size(); i++) {
			Map<String, Object> mapSessionList = sessionList.get(i);
			String partyCode = (String) mapSessionList.get("partyCode");
			WebSocketSession ws = (WebSocketSession) mapSessionList.get("session");

			if (partyCode.equals(now_partyCode)) {
				// 나간 사람들의 방 번호
				Map<String, String> mapToSend = new HashMap<String, String>();
				mapToSend.put("partyCode", partyCode);
				mapToSend.put("cmd", "CMD_EXIT");
				mapToSend.put("user", nickname);
				mapToSend.put("msg",  "[ " + nickname + " ] 님이 파티 채팅방에서 [ 퇴장 ]하셨습니다.");
				mapToSend.put("userpic", userPic);
				
				String jsonStr = objectMapper.writeValueAsString(mapToSend);
				ws.sendMessage(new TextMessage(jsonStr));
			} // if
			
		} // for
		
	} // afterConnectionClosed
	
} // end class
