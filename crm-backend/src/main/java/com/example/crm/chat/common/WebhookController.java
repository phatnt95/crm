package com.example.crm.chat.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {
    @PostMapping("/zalo")
    public ResponseEntity<String> handleZaloWebhook(@RequestBody MessageEvent messageEvent) {
        // Process the received MessageEvent
        System.out.println("Received webhook event: " + messageEvent);

        // Example: Log the message text
        if (messageEvent.getMessage() != null) {
            System.out.println("Message Text: " + messageEvent.getMessage().getText());
        }

        // You can add your business logic here
        // ...

        return ResponseEntity.ok("Webhook received successfully");
    }
    @PostMapping("/meta")
    public ResponseEntity<String> handleMetaWebhook(@RequestBody MessageEvent messageEvent) {
        // Process the received MessageEvent
        System.out.println("Received webhook event: " + messageEvent);

        // Example: Log the message text
        if (messageEvent.getMessage() != null) {
            System.out.println("Message Text: " + messageEvent.getMessage().getText());
        }

        // You can add your business logic here
        // ...

        return ResponseEntity.ok("Webhook received successfully");
    }
}
