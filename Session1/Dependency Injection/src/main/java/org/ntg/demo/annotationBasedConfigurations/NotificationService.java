package org.ntg.demo.annotationBasedConfigurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    @Autowired
    private IMessage messageGateway;

    NotificationService() {}

    NotificationService(IMessage messageGateway) {
        this.messageGateway = messageGateway;
    }

    public void notify(String user) {
        messageGateway.send(user);
    }

    public void setMessageGateway(IMessage messageGateway) {
        this.messageGateway = messageGateway;
    }
}
