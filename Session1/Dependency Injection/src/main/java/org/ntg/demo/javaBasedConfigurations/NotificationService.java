package org.ntg.demo.javaBasedConfigurations;

public class NotificationService {

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
