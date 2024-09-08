package org.ntg.demo.javaBasedConfigurations;

public class BadgeNotification implements IMessage {

    @Override
    public void send(String username) {
        System.out.println("sending badge notification to " + username);
    }
}
