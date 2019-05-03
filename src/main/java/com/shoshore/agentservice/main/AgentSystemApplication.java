package com.shoshore.agentservice.main;

import com.shoshore.agentservice.repository.config.DataConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DataConfig.class})
public class AgentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentSystemApplication.class, args);
    }
}
