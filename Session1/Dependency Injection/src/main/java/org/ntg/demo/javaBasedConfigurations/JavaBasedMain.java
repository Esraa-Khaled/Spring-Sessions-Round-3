package org.ntg.demo.javaBasedConfigurations;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;

public class JavaBasedMain {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        Iterator beans = context.getBeanFactory().getBeanNamesIterator();
//
//        while (beans.hasNext()) {
//            String beanName = (String) beans.next();
//            System.out.println(beanName);
//        }


        NotificationService notificationService = (NotificationService) context.getBean("notificationService", );
        IMessage smsObject = context.getBean("smsNotification", IMessage.class);


//        notificationService.setMessageGateway(smsObject);
        notificationService.notify("Ola");



    }
}
