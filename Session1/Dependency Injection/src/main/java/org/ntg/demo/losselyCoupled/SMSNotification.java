package org.ntg.demo.losselyCoupled;

public class SMSNotification implements IMessage{

    @Override
    public void send(String username) {
        System.out.println("sending sms notification to " + username);
    }
}
