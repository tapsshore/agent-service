package com.shoshore.agentservice.business.services.validations.api;

import com.shoshore.agentservice.domain.entities.Property;
import com.shoshore.agentservice.utils.commonResponse.CommonResponse;
import com.shoshore.agentservice.utils.enums.UserAction;

import java.util.Locale;

public interface PropertyValidation {
    CommonResponse validate(Property property, UserAction userAction, Locale locale, String username);

    CommonResponse validateById(Long id, Locale locale, String username);
}
