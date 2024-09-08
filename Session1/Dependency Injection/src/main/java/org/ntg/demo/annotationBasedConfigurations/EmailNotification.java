package org.ntg.demo.annotationBasedConfigurations;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements IMessage {

    @Override
    public void send(String username) {
        System.out.println("sending email notification to " + username);
    }

}
