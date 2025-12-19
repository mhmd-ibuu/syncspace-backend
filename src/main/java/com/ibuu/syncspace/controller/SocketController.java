package com.ibuu.syncspace.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {

    // Frontend sends data to "/app/edit"
    // We receive it here, processing it, and send it to "/topic/updates"
    @MessageMapping("/edit")
    @SendTo("/topic/updates")
    public String handleEdit(String delta) {
        System.out.println("Received update: " + delta);
        return delta; // Broadcasts the update to everyone listening on /topic/updates
    }
}