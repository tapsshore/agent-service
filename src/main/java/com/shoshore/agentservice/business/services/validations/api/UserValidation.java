package com.shoshore.agentservice.business.services.validations.api;

import com.shoshore.agentservice.domain.User;
import com.shoshore.agentservice.utils.commonResponse.CommonResponse;
import com.shoshore.agentservice.utils.enums.UserAction;

import java.util.Locale;

public interface UserValidation {
    CommonResponse validate(User user, UserAction userAction, Locale locale, String username);

    CommonResponse validateById(Long id, Locale locale, String username);
}
