package com.shoshore.agentservice.business.config;

import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.services.auditables.api.PropertyAuditableService;
import com.shoshore.agentservice.business.services.auditables.api.UserAuditableService;
import com.shoshore.agentservice.business.services.auditables.impl.PropertyAuditableServiceImpl;
import com.shoshore.agentservice.business.services.auditables.impl.UserAuditableServiceImpl;
import com.shoshore.agentservice.repository.api.PropertyRepository;
import com.shoshore.agentservice.repository.api.UserRepository;
import com.shoshore.agentservice.repository.config.DataConfig;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataConfig.class})
public class BusinessConfig {

    @Bean
    UserAuditableService userAuditableService(UserRepository userRepository) {

        return new UserAuditableServiceImpl(userRepository);

    }

    @Bean
    PropertyAuditableService propertyAuditableService(PropertyRepository propertyRepository){
        return new PropertyAuditableServiceImpl(propertyRepository);
    }

    @Bean
    public DtoMapper dtoMapper() {
        return Mappers.getMapper(DtoMapper.class);
    }


}
