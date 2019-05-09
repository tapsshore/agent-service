package com.shoshore.agentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AgentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentSystemApplication.class, args);
    }
}
