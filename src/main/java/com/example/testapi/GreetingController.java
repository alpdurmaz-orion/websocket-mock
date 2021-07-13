package com.example.testapi;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@EnableScheduling
public class GreetingController {
    private final SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/")
    @SendTo("/topic")
    @Scheduled(fixedRate = 1000)
    public void greeting() throws Exception {
        Message message = new Message();
        message.setMessage("S.A.");
        this.messagingTemplate.convertAndSend("/topic", message);
    }

}