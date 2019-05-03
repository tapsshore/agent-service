package com.shoshore.agentservice.business.config;

import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.services.auditables.api.JobAuditableService;
import com.shoshore.agentservice.business.services.auditables.api.PropertyAuditableService;
import com.shoshore.agentservice.business.services.auditables.api.UserAuditableService;
import com.shoshore.agentservice.business.services.auditables.api.VehicleAuditableService;
import com.shoshore.agentservice.business.services.auditables.impl.JobAuditableServiceImpl;
import com.shoshore.agentservice.business.services.auditables.impl.PropertyAuditableServiceImpl;
import com.shoshore.agentservice.business.services.auditables.impl.UserAuditableServiceImpl;
import com.shoshore.agentservice.business.services.auditables.impl.VehicleAuditableServiceImpl;
import com.shoshore.agentservice.business.services.logic.api.UserService;
import com.shoshore.agentservice.business.services.validations.api.UserValidation;
import com.shoshore.agentservice.repository.api.JobRepository;
import com.shoshore.agentservice.repository.api.PropertyRepository;
import com.shoshore.agentservice.repository.api.UserRepository;
import com.shoshore.agentservice.repository.api.VehicleRepository;
import com.shoshore.agentservice.repository.config.DataConfig;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.messages.external.UserDto;
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
    VehicleAuditableService vehicleAuditableService(VehicleRepository vehicleRepository){
        return new VehicleAuditableServiceImpl(vehicleRepository);
    }
    @Bean
    PropertyAuditableService propertyAuditableService(PropertyRepository propertyRepository){
        return new PropertyAuditableServiceImpl(propertyRepository);
    }
    @Bean
    JobAuditableService jobAuditableService(JobRepository jobRepository){
        return new JobAuditableServiceImpl(jobRepository);
    }
    @Bean
    public DtoMapper dtoMapper() {
        return Mappers.getMapper(DtoMapper.class);
    }


}
