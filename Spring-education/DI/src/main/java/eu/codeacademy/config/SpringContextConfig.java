package eu.codeacademy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"eu.codeacademy.dao", "eu.codeacademy.service"})
public class SpringContextConfig {

}
