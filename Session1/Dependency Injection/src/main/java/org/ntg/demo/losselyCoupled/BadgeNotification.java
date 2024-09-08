package org.ntg.demo.losselyCoupled;

public class BadgeNotification implements IMessage{

    @Override
    public void send(String username) {
        System.out.println("sending badge notification to " + username);
    }
}
