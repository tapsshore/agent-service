package com.shoshore.agentservice.api.processor.impl;

import com.shoshore.agentservice.api.processor.api.UserProcessor;
import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.messages.UserResponse;
import com.shoshore.agentservice.business.services.logic.api.UserService;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.enums.UserStatus;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import com.shoshore.agentservice.utils.wrapper.UserWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;


@SuppressWarnings("Duplicates")
public class UserProcessorImpl implements UserProcessor {
    @Autowired
    private final UserService userService;
    private final DtoMapper dtoMapper;
    @Autowired
    private final MessageService messageService;

    public UserProcessorImpl(UserService userService, DtoMapper dtoMapper, MessageService messageService) {
        this.userService = userService;
        this.dtoMapper = dtoMapper;
        this.messageService = messageService;
    }

    Logger log = LoggerFactory.getLogger(UserProcessorImpl.class.getName());

    @Override
    public UserResponse searchUserById(Long id, Locale locale) {
        log.info("User Search Request in: {}", id);

        ServiceResponse<UserDto> serviceResponse = userService.findUserById(id, locale);


        UserResponse userResponse = new UserResponse();

        userResponse.setSuccess(serviceResponse.isSuccess());
        userResponse.setMessage(serviceResponse.getMessage());
        userResponse.setUserDto(dtoMapper.map(serviceResponse.getUser()));

        log.info("Response out: {}", userResponse);

        return userResponse;
    }

    @Override
    public UserResponse search(UserWrapper userWrapper, Locale locale) {
        log.info("Search Request: {}", userWrapper);

        ServiceResponse serviceResponse = userService.search(userWrapper, locale);

        UserResponse userResponse = new UserResponse();

        userResponse.setSuccess(serviceResponse.isSuccess());
        userResponse.setMessage(serviceResponse.getMessage());
        return userResponse;
    }

    @Override
    public UserResponse retrieveAllUsers(Locale locale) {
        log.info("User Search Request to Find All Users");
        ServiceResponse<UserDto> serviceResponse = userService.findAllUsers(locale);

        UserResponse userResponse = new UserResponse();

        userResponse.setSuccess(true);
        userResponse.setMessage(serviceResponse.getMessage());
        userResponse.setUserDtoList(serviceResponse.getList());
        log.info("Response out: {}", userResponse);
        return userResponse;
    }

    @Override
    public UserResponse searchUsersByMobileNumber(String mobileNumber, Locale locale) {
        log.info("User Search Request in: {}", mobileNumber);

        ServiceResponse<UserDto> serviceResponse = userService.findUserByMobileNumber(mobileNumber, locale);


        UserResponse userResponse = new UserResponse();

        userResponse.setSuccess(serviceResponse.isSuccess());
        userResponse.setMessage(serviceResponse.getMessage());
        userResponse.setUserDto(dtoMapper.map(serviceResponse.getUser()));

        log.info("Response out: {}", userResponse);

        return userResponse;
    }

    @Override
    public UserResponse searchUsersByIdNumber(String idNumber, Locale locale) {
        log.info("User Search Request in: {}", idNumber);

        ServiceResponse<UserDto> serviceResponse = userService.findUserByIdNumber(idNumber, locale);


        UserResponse userResponse = new UserResponse();

        userResponse.setSuccess(serviceResponse.isSuccess());
        userResponse.setMessage(serviceResponse.getMessage());
        userResponse.setUserDto(dtoMapper.map(serviceResponse.getUser()));

        log.info("Response out: {}", userResponse);

        return userResponse;
    }

    @Override
    public UserResponse searchUsersByCityOrGender(String city, String gender, Locale locale) {
        log.info("User Search Request by City or Gender: {}", city, gender);

        ServiceResponse<UserDto> serviceResponse = userService.findUsersByCityOrGender(city, gender, locale);

        UserResponse userResponse = new UserResponse();

        userResponse.setSuccess(serviceResponse.isSuccess());
        userResponse.setMessage(serviceResponse.getMessage());
        userResponse.setUserDtoList(serviceResponse.getList());

        log.info("Response out: {}", userResponse);

        return userResponse;
    }

    @Override
    public UserResponse searchUsersByUserStatus(UserStatus userStatus, Locale locale) {
        log.info("User Search Request by Status: {}", userStatus);

        ServiceResponse<UserDto> serviceResponse = userService.findUsersByStatus(userStatus, locale);

        UserResponse userResponse = new UserResponse();

        userResponse.setSuccess(serviceResponse.isSuccess());
        userResponse.setMessage(serviceResponse.getMessage());
        userResponse.setUserDtoList(serviceResponse.getList());

        log.info("Response out: {}", userResponse);

        return userResponse;
    }

    @Override
    public UserResponse updateUser(UserDto userDto, Locale locale, String username) {
        log.info("Update User Request in : {}", userDto);

        ServiceResponse<UserDto> serviceResponse = userService.edit(userDto, locale, username);

        UserResponse userResponse = new UserResponse();

        userResponse.setSuccess(serviceResponse.isSuccess());
        userResponse.setMessage(serviceResponse.getMessage());
        userResponse.setUserDto(dtoMapper.map(serviceResponse.getUser()));

        log.info("Response out: {}", userResponse);

        return userResponse;
    }

    @Override
    public UserResponse createUser(UserDto userDto, Locale locale, String username) {
        log.info("Create Request in : {}", userDto);

        ServiceResponse<UserDto> serviceResponse = userService.create(userDto, locale, username);

        UserResponse userResponse = new UserResponse();

        userResponse.setSuccess(serviceResponse.isSuccess());
        userResponse.setMessage(serviceResponse.getMessage());
        userResponse.setUserDto(dtoMapper.map(serviceResponse.getUser()));

        log.info("Response out: {}", userResponse);

        return userResponse;
    }

    @Override
    public UserResponse deleteUser(Long id, Locale locale, String username) {
        log.info("Delete User Request: {}", id);

        ServiceResponse<UserDto> serviceResponse  = userService.delete(id , locale, username);

        UserResponse userResponse = new UserResponse();

        userResponse.setSuccess(serviceResponse.isSuccess());
        userResponse.setMessage(serviceResponse.getMessage());
        userResponse.setUserDto(dtoMapper.map(serviceResponse.getUser()));

        log.info("Response out: {}", userResponse);

        return userResponse;
    }
}
