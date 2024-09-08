package org.ntg.demo.coupled;

public class NotificationService {

    public void notify(String user) {

        EmailNotification emailNotification = new EmailNotification();
        emailNotification.send(user);

        SMSNotification smsNotification = new SMSNotification();
        smsNotification.send(user);

    }
}
