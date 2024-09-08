package org.ntg.demo.annotationBasedConfigurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "org.ntg.demo.annotationBasedConfigurations")
public class Config {
}
