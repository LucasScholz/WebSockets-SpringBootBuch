package de.springbootbuch.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Part of springbootbuch.de.
 *
 * @author Michael J. Simons
 * @author @rotnroll666
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig 
	implements WebSocketConfigurer {
	
	@Override
	public void registerWebSocketHandlers(
		WebSocketHandlerRegistry registry)
	{
		registry.addHandler(
			new TextWebSocketHandler() {
			@Override
			protected void handleTextMessage(
				WebSocketSession session, 
				TextMessage message
			) throws Exception {
				session.sendMessage(
					new TextMessage(
						"Hello, " + message.getPayload()));
			}
		}, "/greeting");
	}
}