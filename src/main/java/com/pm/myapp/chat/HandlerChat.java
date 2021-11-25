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

@Component
public class HandlerChat extends TextWebSocketHandler {

	// (<"bang_id", 방ID>, <"session", 세션>) - (<"bang_id", 방ID>, <"session", 세션>) - (<"bang_id", 방ID>, <"session", 세션>) 형태 
	private List<Map<String, Object>> sessionList = new ArrayList<Map<String, Object>>();
	
	// 클라이언트가 서버로 메세지 전송 처리
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		super.handleTextMessage(session, message);
        System.out.println("session : " + session);
        // WebSocketServerSockJsSession[id=5bx2ikig]
		
        // JSON --> Map으로 변환
		ObjectMapper objectMapper = new ObjectMapper();
		
		// payload 로 {"bang_id":"aa","cmd":"CMD_ENTER","msg":""} 받음
		Map<String, String> mapReceive = objectMapper.readValue(message.getPayload(), Map.class);
		// 접속하거나, 말한 사람의 정보가 담기는 Map
		
		switch (mapReceive.get("cmd")) {
		
		// CLIENT 입장하는 경우
		case "CMD_ENTER":
			// 세션 리스트에 저장
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("bang_id", mapReceive.get("bang_id"));
			map.put("session", session);
			
			// 방이름-세션 추가 : 처음 방을 들어온것이라
			sessionList.add(map);
			
			// 같은 채팅방에 입장 메세지 전송
			// 방이름 - 세션 :: 개수 = 접속한 사람의 인원수
			for (int i = 0; i < sessionList.size(); i++) {
				// 접속한 인원만큼 MapSessionList에 정보 추가
				Map<String, Object> mapSessionList = sessionList.get(i);
				String bang_id = (String) mapSessionList.get("bang_id");
				// 접속한 사람의 방 이름
				WebSocketSession ws = (WebSocketSession) mapSessionList.get("session");
				// 접속한 사람의 세션
				
				if(bang_id.equals(mapReceive.get("bang_id"))) {
					// bang_id = 세션에 있는 사람들의 방이름
					// mapReceive.get("bang_id") 접속한 사람의 방이름
					// 그 둘이 같다면 아래와 같은 메세지를 만들어서 출력
					Map<String, String> mapToSend = new HashMap<String, String>();
					mapToSend.put("bang_id", bang_id);
					mapToSend.put("cmd", "CMD_ENTER");
					mapToSend.put("msg", session.getId() +  "님이 입장 했습니다.");
					
					String jsonStr = objectMapper.writeValueAsString(mapToSend);
					System.out.println("jsonStr : " + jsonStr);
					// jsonStr : {"msg":"5bx2ikig님이 입장 했습니다.","bang_id":"aa","cmd":"CMD_ENTER"}
					
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
				String bang_id = (String) mapSessionList.get("bang_id");
				WebSocketSession ws = (WebSocketSession) mapSessionList.get("session");

				if (bang_id.equals(mapReceive.get("bang_id"))) {
					Map<String, String> mapToSend = new HashMap<String, String>();
					mapToSend.put("bang_id", bang_id);
					mapToSend.put("cmd", "CMD_MSG_SEND");
					mapToSend.put("msg", session.getId() + " : " + mapReceive.get("msg"));

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

		super.afterConnectionClosed(session, status);
        
		ObjectMapper objectMapper = new ObjectMapper();
		String now_bang_id = "";
		
		// 사용자 세션을 리스트에서 제거
		for (int i = 0; i < sessionList.size(); i++) {
			Map<String, Object> map = sessionList.get(i);
			String bang_id = (String) map.get("bang_id");
			WebSocketSession ws = (WebSocketSession) map.get("session");
			
			if(session.equals(ws)) {
				now_bang_id = bang_id;
				sessionList.remove(map);
				break;
			} // if
			
		} // for
		
		// 같은 채팅방에 퇴장 메세지 전송 
		for (int i = 0; i < sessionList.size(); i++) {
			Map<String, Object> mapSessionList = sessionList.get(i);
			String bang_id = (String) mapSessionList.get("bang_id");
			WebSocketSession ws = (WebSocketSession) mapSessionList.get("session");

			if (bang_id.equals(now_bang_id)) {
				// 나간 사람들의 방 번호
				Map<String, String> mapToSend = new HashMap<String, String>();
				mapToSend.put("bang_id", bang_id);
				mapToSend.put("cmd", "CMD_EXIT");
				mapToSend.put("msg", session.getId() + "님이 퇴장 했습니다.");

				String jsonStr = objectMapper.writeValueAsString(mapToSend);
				ws.sendMessage(new TextMessage(jsonStr));
			} // if
			
		} // for
		
	} // afterConnectionClosed
}
