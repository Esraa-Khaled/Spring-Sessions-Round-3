package org.ntg.demo.losselyCoupled;

public class LosselyCoupledMain {
    public static void main(String[] args) {

        EmailNotification emailNotification = new EmailNotification();
        NotificationService notificationService = new NotificationService();
//        notificationService.messageGateway = emailNotification;

        notificationService.notify("Ahmed");

        NotificationService notificationService1 = new NotificationService(new SMSNotification());
        notificationService1.notify("Ahmed");

        notificationService1.setMessageGateway(new BadgeNotification());
        notificationService1.notify("Sara");
    }
}
