package com.shoshore.agentservice.api.config;

import com.shoshore.agentservice.business.config.BusinessConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BusinessConfig.class)
@ComponentScan(basePackages = "com.shoshore.agentservice")
public class ApiServiceConfig {
}
x