package com.shoshore.agentservice.api.config;

import com.shoshore.agentservice.api.processor.api.PropertyProcessor;
import com.shoshore.agentservice.api.processor.api.UserProcessor;
import com.shoshore.agentservice.api.processor.impl.PropertyProcessorImpl;
import com.shoshore.agentservice.api.processor.impl.UserProcessorImpl;
import com.shoshore.agentservice.business.config.BusinessConfig;
import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.services.logic.api.PropertyService;
import com.shoshore.agentservice.business.services.logic.api.UserService;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(BusinessConfig.class)
@ComponentScan(basePackages = "com.shoshore.agentservice")
public class ApiServiceConfig {


    @Bean
    UserProcessor userProcessor(UserService userService, DtoMapper dtoMapper, MessageService messageService){
        return new UserProcessorImpl(userService, dtoMapper, messageService);
    }

    @Bean
    PropertyProcessor propertyProcessor(PropertyService propertyService, DtoMapper dtoMapper, MessageService messageService){
        return new PropertyProcessorImpl(propertyService, dtoMapper, messageService);
    }

}
