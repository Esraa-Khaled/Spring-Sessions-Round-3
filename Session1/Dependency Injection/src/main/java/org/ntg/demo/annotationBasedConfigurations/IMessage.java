package org.ntg.demo.annotationBasedConfigurations;

import org.springframework.stereotype.Component;

@Component
public interface IMessage {
    public void send(String username);
}
