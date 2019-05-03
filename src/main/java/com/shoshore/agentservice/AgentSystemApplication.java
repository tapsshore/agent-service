package com.shoshore.agentservice;

import com.shoshore.agentservice.repository.config.DataConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DataConfig.class})
@ComponentScan(basePackages = "com.shoshore.agentservice.api.resource")
public class AgentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentSystemApplication.class, args);
    }
}
