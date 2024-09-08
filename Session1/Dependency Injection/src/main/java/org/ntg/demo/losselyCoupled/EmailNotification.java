package org.ntg.demo.losselyCoupled;

public class EmailNotification implements IMessage{

    @Override
    public void send(String username) {
        System.out.println("sending email notification to " + username);
    }

}
