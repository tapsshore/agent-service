package com.shoshore.agentservice.business.services.logic.api;

import com.shoshore.agentservice.utils.enums.UserStatus;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import com.shoshore.agentservice.utils.wrapper.UserWrapper;

import java.util.Locale;

public interface UserService {

    ServiceResponse create(UserDto userDto, Locale locale, String username);

    ServiceResponse findUserByIdNumber(String idNumber, Locale locale);

    ServiceResponse findUserById(String id, Locale locale);

    ServiceResponse findUserByMobileNumber(String mobileNumber, Locale locale);

    ServiceResponse findUsersByCityOrGender(String city, String gender, Locale locale);

    ServiceResponse edit(UserDto userDto, Locale locale, String username);

    ServiceResponse delete(String id, Locale locale, String username);

    ServiceResponse search(UserWrapper userWrapper, Locale locale);

    ServiceResponse findAllUsers(Locale locale);

    ServiceResponse save(UserDto userDto, Locale locale, String username);

    ServiceResponse findUsersByStatus(UserStatus userStatus, Locale locale);


}
