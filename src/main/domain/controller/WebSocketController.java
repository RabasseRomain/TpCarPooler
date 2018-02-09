package main.domain.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import main.domain.data.Ride;

public class WebSocketController {
	
	@MessageMapping("/rideListUp")		// Listen Here
	@SendTo("/topic/ride")				// Answer Here
	public Ride send(Ride ride) throws Exception {
		System.out.println("Hello From Web Controller");
    return ride;
	}
	
}
