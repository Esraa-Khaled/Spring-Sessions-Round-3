package org.ntg.demo.annotationBasedConfigurations;

import org.springframework.stereotype.Component;

@Component
public class SMSNotification  {

    public void send(String username) {
        System.out.println("sending sms notification to " + username);
    }
}
