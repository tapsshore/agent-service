package com.shoshore.agentservice.business.services.validations.impl;

import com.shoshore.agentservice.business.services.auditables.api.PropertyAuditableService;
import com.shoshore.agentservice.business.services.validations.api.PropertyValidation;
import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.commonResponse.CommonResponse;
import com.shoshore.agentservice.utils.enums.I18Code;
import com.shoshore.agentservice.utils.enums.UserAction;

import java.util.Locale;
import java.util.Optional;

@SuppressWarnings("Duplicates")

public class PropertyValidationImpl implements PropertyValidation {

    final MessageService messageService;
    final PropertyAuditableService propertyAuditableService;

    public PropertyValidationImpl(MessageService messageService, PropertyAuditableService propertyAuditableService) {
        this.messageService = messageService;
        this.propertyAuditableService = propertyAuditableService;
    }

    @Override
    public CommonResponse validate(Property property, UserAction userAction, Locale locale, String username) {
        final CommonResponse response;
        switch (userAction) {
            case CREATE:
                response = validatePropertyCreation(property,
                        locale);
                break;
            case EDIT:
                response = validatePropertyEdit(property, locale);
                break;

            default:
                response = new CommonResponse();
                response.setNarrative(messageService.getMessage(I18Code.MESSAGE_REQUEST_NOT_SUPPORTED.getCode(),
                        new String[]{}, locale));
        }
        final boolean isSuccess = response.isSuccess();
        if (isSuccess) {
            response.setNarrative(messageService.getMessage(I18Code.MESSAGE_VALIDATION_SUCCESS.getCode(),
                    new String[]{}, locale));
        }
        return response;
    }

    @Override
    public CommonResponse validateById(String id, Locale locale, String username) {
        final CommonResponse response;


        response = validatePropertyDelete(id, locale);

        final boolean isSuccess = response.isSuccess();
        if (isSuccess) {
            response.setNarrative(messageService.getMessage(I18Code.MESSAGE_VALIDATION_SUCCESS.getCode(),
                    new String[]{}, locale));
        }
        return response;
    }


    private CommonResponse validatePropertyEdit(final Property entity, Locale locale) {
        final CommonResponse response = new CommonResponse();
        final Optional<Property> existingProperty = propertyAuditableService.findPropertyById(entity.getId(),locale);
        final boolean isPropertyNotFound = !existingProperty.isPresent();
        if (isPropertyNotFound) {
            final String message = messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale);
            response.setNarrative(message);
            return response;
        }
        response.setSuccess(true);
        return response;
    }

    private CommonResponse validatePropertyDelete(final String id, Locale locale) {
        final CommonResponse response = new CommonResponse();
        final Optional<Property> existingProperty = propertyAuditableService.findPropertyById(id,locale);
        final boolean isPropertyNotFound = !existingProperty.isPresent();
        if (isPropertyNotFound) {
            final String message = messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale);
            response.setNarrative(message);
            return response;
        }
        response.setSuccess(true);
        return response;
    }

    private CommonResponse validatePropertyCreation(Property entity, Locale locale) {
        final CommonResponse response = new CommonResponse();
        final String id = entity.getId();
        final Optional<Property> existingProperty = propertyAuditableService.findPropertyById(entity.getId(),locale);
        final boolean isExistingProperty = existingProperty.isPresent();
        if (isExistingProperty) {
            final String message = messageService.getMessage(I18Code.MESSAGE_PROPERTY_EXISTS.getCode(),
                    new String[]{id.toString()}, locale);
            response.setNarrative(message);
            return response;
        }
        response.setSuccess(true);

        return response;
    }
}
