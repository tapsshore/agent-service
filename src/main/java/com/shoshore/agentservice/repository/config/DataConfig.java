package com.shoshore.agentservice.repository.config;

import com.shoshore.agentservice.domain.DomainMarkerInterface;
import com.shoshore.agentservice.repository.api.DataRepositoryMarkerInterface;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.shoshore.agentservice.repository.api")
@EntityScan(basePackages = {"com.shoshore.agentservice.domain"})
public class DataConfig {
}
