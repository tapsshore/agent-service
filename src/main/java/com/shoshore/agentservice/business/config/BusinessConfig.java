package com.shoshore.agentservice.business.config;

import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.services.auditables.api.PropertyAuditableService;
import com.shoshore.agentservice.business.services.auditables.api.UserAuditableService;
import com.shoshore.agentservice.business.services.auditables.impl.PropertyAuditableServiceImpl;
import com.shoshore.agentservice.business.services.auditables.impl.UserAuditableServiceImpl;
import com.shoshore.agentservice.business.services.logic.api.PropertyService;
import com.shoshore.agentservice.business.services.logic.api.UserService;
import com.shoshore.agentservice.business.services.logic.impl.PropertyServiceImpl;
import com.shoshore.agentservice.business.services.logic.impl.UserServiceImpl;
import com.shoshore.agentservice.business.services.validations.api.PropertyValidation;
import com.shoshore.agentservice.business.services.validations.api.UserValidation;
import com.shoshore.agentservice.business.services.validations.impl.PropertyValidationImpl;
import com.shoshore.agentservice.business.services.validations.impl.UserValidationImpl;
import com.shoshore.agentservice.repository.api.HomePropertyRepository;
import com.shoshore.agentservice.repository.api.UserRepository;
import com.shoshore.agentservice.repository.config.DataConfig;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.common.i18.impl.MessageServiceImpl;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@Import({DataConfig.class})
public class BusinessConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(BusinessConfig.class);


    @Bean
    UserAuditableService userAuditableService(UserRepository userRepository) {

        return new UserAuditableServiceImpl(userRepository);

    }

    @Bean
    PropertyAuditableService propertyAuditableService(HomePropertyRepository homePropertyRepository) {
        return new PropertyAuditableServiceImpl(homePropertyRepository);
    }

    @Bean
    public DtoMapper dtoMapper() {
        return Mappers.getMapper(DtoMapper.class);
    }

    @Bean
    UserService userService(MessageService messageService, UserAuditableService userAuditableService,
                            DtoMapper dtoMapper, UserRepository userRepository) {
        return new UserServiceImpl(messageService, userAuditableService, dtoMapper, userRepository);
    }


    @Bean
    PropertyService propertyService(MessageService messageService,
                                    PropertyAuditableService propertyAuditableService,
                                    DtoMapper dtoMapper, HomePropertyRepository propertyRepository) {
        return new PropertyServiceImpl(messageService, propertyAuditableService, dtoMapper, propertyRepository);
    }
    @Bean(name = "customMessageSource")
    public MessageSource customMessageSource(){
        final ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }



    @Bean
    @DependsOn("customMessageSource")
    MessageService messageService(MessageSource customMessageSource) {
            LOGGER.info("Setting up Message service, message-source:: {}", customMessageSource);
        return new MessageServiceImpl(customMessageSource);
    }


    @Bean
    PropertyValidation propertyValidation(MessageService messageService, PropertyAuditableService propertyAuditableService) {
        return new PropertyValidationImpl(messageService, propertyAuditableService);
    }

    @Bean
    UserValidation userValidation(MessageService messageService, UserAuditableService userAuditableService) {
        return new UserValidationImpl(messageService, userAuditableService);
    }

}
