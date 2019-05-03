package com.shoshore.agentservice.api.processor.impl;

import com.shoshore.agentservice.api.messages.Response;
import com.shoshore.agentservice.api.processor.api.UserProcessor;
import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.services.logic.api.UserService;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.enums.UserStatus;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import com.shoshore.agentservice.utils.wrapper.UserWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;


@SuppressWarnings("Duplicates")
public class UserProcessorImpl implements UserProcessor {

    private final UserService userService;
    private final DtoMapper dtoMapper;
    private final MessageService messageService;

    public UserProcessorImpl(UserService userService, DtoMapper dtoMapper, MessageService messageService) {
        this.userService = userService;
        this.dtoMapper = dtoMapper;
        this.messageService = messageService;
    }

    Logger log = LoggerFactory.getLogger(UserProcessorImpl.class.getName());

    @Override
    public Response searchUserById(Long id, Locale locale) {
        log.info("User Search Request in: {}", id);

        ServiceResponse<UserDto> serviceResponse = userService.findUserById(id, locale);


        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setUserDto(serviceResponse.getResult());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response search(UserWrapper userWrapper, Locale locale) {
        log.info("Search Request: {}", userWrapper);

        ServiceResponse serviceResponse = userService.search(userWrapper, locale);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        return response;
    }

    @Override
    public Response retrieveAllUsers(Locale locale) {
        log.info("User Search Request to Find All Users");
        ServiceResponse<UserDto> serviceResponse = userService.findAllUsers(locale);

        Response response = new Response();

        response.setSuccess(true);
        response.setMessage(serviceResponse.getMessage());
        response.setUserDtoList(serviceResponse.getList());
        log.info("Response out: {}", response);
        return response;
    }

    @Override
    public Response searchUsersByMobileNumber(String mobileNumber, Locale locale) {
        log.info("User Search Request in: {}", mobileNumber);

        ServiceResponse<UserDto> serviceResponse = userService.findUserByMobileNumber(mobileNumber, locale);


        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setUserDto(serviceResponse.getResult());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response searchUsersByIdNumber(String idNumber, Locale locale) {
        log.info("User Search Request in: {}", idNumber);

        ServiceResponse<UserDto> serviceResponse = userService.findUserByIdNumber(idNumber, locale);


        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setUserDto(serviceResponse.getResult());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response searchUsersByCityOrGender(String city, String gender, Locale locale) {
        log.info("User Search Request by City or Gender: {}", city, gender);

        ServiceResponse<UserDto> serviceResponse = userService.findUsersByCityOrGender(city, gender, locale);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setUserDtoList(serviceResponse.getList());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response searchUsersByUserStatus(UserStatus userStatus, Locale locale) {
        log.info("User Search Request by Status: {}", userStatus);

        ServiceResponse<UserDto> serviceResponse = userService.findUsersByStatus(userStatus, locale);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setUserDtoList(serviceResponse.getList());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response updateUser(UserDto userDto, Locale locale, String username) {
        log.info("Update User Request in : {}", userDto);

        ServiceResponse<UserDto> serviceResponse = userService.edit(userDto, locale, username);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setUserDto(serviceResponse.getResult());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response deleteUser(Long id, Locale locale, String username) {
        log.info("Delete User Request: {}", id);

        ServiceResponse<UserDto> serviceResponse  = userService.delete(id , locale, username);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setUserDto(serviceResponse.getResult());

        log.info("Response out: {}", response);

        return response;
    }
}
