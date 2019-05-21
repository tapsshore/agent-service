package com.shoshore.agentservice.api.processor.api;

import com.shoshore.agentservice.business.messages.UserResponse;
import com.shoshore.agentservice.utils.enums.UserStatus;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import com.shoshore.agentservice.utils.wrapper.UserWrapper;

import java.util.Locale;

public interface UserProcessor {

    UserResponse searchUserById(String id, Locale locale);

    UserResponse search(UserWrapper userWrapper, Locale locale);

    UserResponse retrieveAllUsers(Locale locale);

    UserResponse searchUsersByMobileNumber(String mobileNumber, Locale locale);

    UserResponse searchUsersByIdNumber(String idNumber, Locale locale);

    UserResponse searchUsersByCityOrGender(String city, String gender, Locale locale);

    UserResponse searchUsersByUserStatus(UserStatus userStatus, Locale locale);

    UserResponse updateUser(UserDto userDto, Locale locale, String username);

    UserResponse createUser(UserDto userDto, Locale locale, String username);

    UserResponse deleteUser(String id, Locale locale, String username);
}
