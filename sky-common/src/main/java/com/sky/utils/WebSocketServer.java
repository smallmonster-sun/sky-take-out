package com.sky.utils;

/**
 * @Project: sky-take-out
 * @Package: com.sky.utils
 * @Author: SUN
 * @Date: 2026/8/2 16:58
 * @Version: v1.0.0
 * @Description:
 **/

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * WebSocket服务，用于向商家后台推送来单提醒
 */
@ServerEndpoint("/ws")
public class WebSocketServer {
	// 存放全部客户端连接，key=sessionId，value=WebSocketServer对象
	private static Map<String, WebSocketServer> clientMap = new HashMap<>();
	private Session session;

	// 客户端建立连接触发
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		clientMap.put(session.getId(), this);
	}

	// 客户端断开连接触发
	@OnClose
	public void onClose() {
		clientMap.remove(session.getId());
	}

	// 收到客户端消息
	@OnMessage
	public void onMessage(String msg) {
	}

	// 群发消息给所有在线客户端
	public static void sendToAllClient(String message) {
		Collection<WebSocketServer> values = clientMap.values();
		for (WebSocketServer server : values) {
			try {
				server.session.getBasicRemote().sendText(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
