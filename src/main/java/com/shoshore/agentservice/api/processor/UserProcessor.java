package com.shoshore.agentservice.api.processor.api;

import com.shoshore.agentservice.api.messages.Response;
import com.shoshore.agentservice.utils.enums.UserStatus;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import com.shoshore.agentservice.utils.wrapper.UserWrapper;

import java.util.Locale;

public interface UserProcessor {

    Response searchUserById(Long id, Locale locale);

    Response search(UserWrapper userWrapper, Locale locale);

    Response retrieveAllUsers(Locale locale);

    Response searchUsersByMobileNumber(String mobileNumber, Locale locale);

    Response searchUsersByIdNumber(String idNumber, Locale locale);

    Response searchUsersByCityOrGender(String city, String gender, Locale locale);

    Response searchUsersByUserStatus(UserStatus userStatus, Locale locale);

    Response updateUser(UserDto userDto, Locale locale, String username);

    Response deleteUser(Long id, Locale locale, String username);
}
