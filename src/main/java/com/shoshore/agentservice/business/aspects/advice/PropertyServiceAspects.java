package com.shoshore.agentservice.business.aspects.advice;

import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.services.logic.api.PropertyService;
import com.shoshore.agentservice.business.services.validations.api.PropertyValidation;
import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.commonResponse.CommonResponse;
import com.shoshore.agentservice.utils.enums.I18Code;
import com.shoshore.agentservice.utils.enums.UserAction;
import com.shoshore.agentservice.utils.exceptions.BusinessException;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Aspect
@Component
public class PropertyServiceAspects {

    private final PropertyValidation propertyValidation;
    private final DtoMapper dtoMapper;
    private MessageService messageService;

    public PropertyServiceAspects(PropertyValidation propertyValidation,
                                  DtoMapper dtoMapper,
                                  MessageService messageService) {
        this.propertyValidation = propertyValidation;
        this.dtoMapper = dtoMapper;
        this.messageService = messageService;
    }
    private Logger log = LoggerFactory.getLogger(PropertyService.class.getName());

    @Around("execution(* com.shoshore.agentservice.business.services.logic.api.PropertyService.save(..)) && args(propertyDto, locale, username)")
    public Object handlePropertyCreationRequest(final ProceedingJoinPoint joinPoint, PropertyDto propertyDto, Locale locale, String username) throws Throwable {

        ServiceResponse response = new ServiceResponse();
        try {
            log.info("Property Creation Request:: {}, Username:: {}", propertyDto, username);
            response = handleCreate(joinPoint, propertyDto, locale, username);
        } catch (BusinessException be) {
            log.error("Handle Property  Creation Exception: ", be);
            if (be.getFriendlyMessage().isPresent()) {
                String message = be.getFriendlyMessage().get();
                response.setMessage(message);
            } else {
                response.setMessage(I18Code.MESSAGE_ERROR_ENCOUNTERED.getCode());
            }
        } catch (Exception e) {
            log.error("Handle Roll Call Creation Error: ", e);
            response.setMessage(messageService.getMessage(I18Code.MESSAGE_REQUEST_FAILED.getCode(),
                    new String[]{}, locale));
        }
        log.info("Create Property  [{}]:: {}, Username:: {}", response.isSuccess() ? "SUCCESS" : "FAILED", response, username);
        return response;
    }

    @SuppressWarnings("Duplicates")
    private ServiceResponse handleCreate(final ProceedingJoinPoint joinPoint,
                                         PropertyDto propertyDto, Locale locale, String username) throws Throwable {
        ServiceResponse response = new ServiceResponse();

        Property property = dtoMapper.map(propertyDto);

        final CommonResponse commonResponse = propertyValidation.validate(property,
                UserAction.CREATE, locale, username);
        final boolean isSuccessfulValidation = commonResponse.isSuccess();
        if (isSuccessfulValidation) {
            response = (ServiceResponse) joinPoint.proceed();
        } else {
            response.setMessage(commonResponse.getNarrative());
        }
        return response;
    }
}