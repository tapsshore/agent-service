package com.shoshore.agentservice.business.services.validations.impl;

import com.shoshore.agentservice.business.services.auditables.api.UserAuditableService;
import com.shoshore.agentservice.business.services.validations.api.UserValidation;
import com.shoshore.agentservice.domain.User;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.commonResponse.CommonResponse;
import com.shoshore.agentservice.utils.enums.I18Code;
import com.shoshore.agentservice.utils.enums.UserAction;

import java.util.Locale;
import java.util.Optional;

@SuppressWarnings("Duplicates")
public class UserValidationImpl implements UserValidation {

    final MessageService messageService;
    final UserAuditableService userAuditableService;

    public UserValidationImpl(MessageService messageService, UserAuditableService userAuditableService) {
        this.messageService = messageService;
        this.userAuditableService = userAuditableService;
    }

    @Override
    public CommonResponse validate(User user, UserAction userAction, Locale locale, String username) {
        final CommonResponse response;
        switch (userAction) {
            case CREATE:
                response = validateUserCreation(user,
                        locale);
                break;
            case EDIT:
                response = validateUserEdit(user, locale);
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


        response = validateUserDelete(id, locale);

        final boolean isSuccess = response.isSuccess();
        if (isSuccess) {
            response.setNarrative(messageService.getMessage(I18Code.MESSAGE_VALIDATION_SUCCESS.getCode(),
                    new String[]{}, locale));
        }
        return response;
    }

    private CommonResponse validateUserEdit(final User entity, Locale locale) {
        final CommonResponse response = new CommonResponse();
        final Optional<User> existingUser = userAuditableService.findUserById(entity.getId(),locale);
        final boolean isUserNotFound = !existingUser.isPresent();
        if (isUserNotFound) {
            final String message = messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                    new String[]{}, locale);
            response.setNarrative(message);
            return response;
        }
        response.setSuccess(true);
        return response;
    }

    private CommonResponse validateUserDelete(final String id, Locale locale) {
        final CommonResponse response = new CommonResponse();
        final Optional<User> existingUser = userAuditableService.findUserById(id,locale);
        final boolean isUserNotFound = !existingUser.isPresent();
        if (isUserNotFound) {
            final String message = messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                    new String[]{}, locale);
            response.setNarrative(message);
            return response;
        }
        response.setSuccess(true);
        return response;
    }

    private CommonResponse validateUserCreation(User entity, Locale locale) {
        final CommonResponse response = new CommonResponse();
        final String id = entity.getId();
        final Optional<User> existingUser = userAuditableService.findUserById(entity.getId(),locale);
        final boolean isExistingUser = existingUser.isPresent();
        if (isExistingUser) {
            final String message = messageService.getMessage(I18Code.MESSAGE_USER_EXISTS.getCode(),
                    new String[]{id.toString()}, locale);
            response.setNarrative(message);
            return response;
        }
        response.setSuccess(true);

        return response;
    }

}
