package org.ntg.demo.annotationBasedConfigurations;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;

public class AnnotationBasedMain {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

//        Iterator beans = context.getBeanFactory().getBeanNamesIterator();
//
//        while (beans.hasNext()) {
//            String beanName = (String) beans.next();
//            System.out.println(beanName);
//        }
        NotificationService notificationService = context.getBean("notificationService", NotificationService.class);
//        IMessage badgeGateway = context.getBean("badgeGatewayService", IMessage.class);
        notificationService.notify("Esraa");
    }
}
