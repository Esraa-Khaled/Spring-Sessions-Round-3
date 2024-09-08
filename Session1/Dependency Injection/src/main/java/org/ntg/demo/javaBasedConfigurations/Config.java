package org.ntg.demo.javaBasedConfigurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean("emailGateway")
    public EmailNotification emailNotification() {
        return new EmailNotification();
    }

    @Bean
    public SMSNotification smsNotification() {
        return new SMSNotification();
    }

    @Bean
    BadgeNotification badgeNotification() {
        return new BadgeNotification();
    }

    @Bean
    NotificationService notificationService() {
        return new NotificationService(emailNotification());
    }
}
