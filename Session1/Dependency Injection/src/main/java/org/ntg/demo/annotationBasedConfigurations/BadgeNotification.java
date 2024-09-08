package org.ntg.demo.annotationBasedConfigurations;

import org.springframework.stereotype.Component;

@Component("badgeGatewayService")
public class BadgeNotification implements IMessage {

    @Override
    public void send(String username) {
        System.out.println("sending badge notification to " + username);
    }
}
