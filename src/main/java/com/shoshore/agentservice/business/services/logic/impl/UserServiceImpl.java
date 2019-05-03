package com.shoshore.agentservice.business.services.logic.impl;

import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.services.auditables.api.UserAuditableService;
import com.shoshore.agentservice.business.services.logic.api.UserService;
import com.shoshore.agentservice.domain.User;
import com.shoshore.agentservice.repository.api.UserRepository;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.enums.I18Code;
import com.shoshore.agentservice.utils.enums.UserStatus;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import com.shoshore.agentservice.utils.wrapper.UserWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

@SuppressWarnings("Duplicates")

public class UserServiceImpl implements UserService {
    private MessageService messageService;
    private UserAuditableService userAuditableService;
    private DtoMapper dtoMapper;
    private UserRepository userRepository;
    
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());

    public UserServiceImpl(MessageService messageService, UserAuditableService userAuditableService,
                           DtoMapper dtoMapper, UserRepository userRepository) {
        this.messageService = messageService;
        this.userAuditableService = userAuditableService;
        this.dtoMapper = dtoMapper;
        this.userRepository = userRepository;
        this.logger = logger;
    }

    @Override
    public ServiceResponse create(UserDto userDto, Locale locale, String username) {
        final ServiceResponse response = save(userDto, locale, username);
        final boolean hasSavedUser = response != null;
        if (hasSavedUser) {
            return populateUserResponse(true, response.getUser(), messageService.getMessage(I18Code.MESSAGE_USER_CREATED_SUCCESSFULLY.getCode(),
                    new String[]{String.valueOf(userDto.getId())}, locale));
        }
        return populateUserResponse(false, response.getUser(), messageService.getMessage(I18Code.MESSAGE_USER_NOT_CREATED.getCode(),
                new String[]{String.valueOf(userDto.getId())}, locale));
    }

    @Override
    public ServiceResponse findUserByIdNumber(String idNumber, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final Optional<User> userSearched = userRepository.findUserByIdNumber(idNumber);

        final boolean isUserFound = userSearched.isPresent();
        if (!isUserFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }
        serviceResponse.setSuccess(true);

        serviceResponse.setResult(dtoMapper.map(serviceResponse));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_SUCCESSFULLY_RETRIEVED.getCode(),
                new String [] {}, locale));


        return  serviceResponse;
    }

    @Override
    public ServiceResponse findUserById(Long id, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final Optional<User> userSearched = userRepository.findUserById(id);

        final boolean isUserFound = userSearched.isPresent();
        if (!isUserFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }
        serviceResponse.setSuccess(true);

        serviceResponse.setResult(dtoMapper.map(serviceResponse));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_SUCCESSFULLY_RETRIEVED.getCode(),
                new String [] {}, locale));


        return  serviceResponse;
    }

    @Override
    public ServiceResponse findUserByMobileNumber(String mobileNumber, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final Optional<User> userSearched = userRepository.findUserByMobileNumber(mobileNumber);

        final boolean isUserFound = userSearched.isPresent();
        if (!isUserFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }
        serviceResponse.setSuccess(true);

        serviceResponse.setResult(dtoMapper.map(serviceResponse));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_SUCCESSFULLY_RETRIEVED.getCode(),
                new String [] {}, locale));


        return  serviceResponse;
    }

    @Override
    public ServiceResponse findUsersByCityOrGender(String city, String gender, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final List<User> userSearched = userRepository.findUsersByCityOrGender(city, gender);

        final boolean isUserFound = userSearched.isEmpty();
        if (!isUserFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }
        serviceResponse.setSuccess(true);

        serviceResponse.setResult(dtoMapper.map(serviceResponse));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_SUCCESSFULLY_RETRIEVED.getCode(),
                new String [] {}, locale));


        return  serviceResponse;
    }

    @Override
    public ServiceResponse edit(UserDto userDto, Locale locale, String username) {
        final ServiceResponse savedUser = save(userDto, locale, username);
        final boolean hasSavedUser = savedUser != null;
        if (hasSavedUser) {
            return populateUserResponse(true, savedUser.getUser(), messageService.getMessage(I18Code.MESSAGE_USER_EDITED_SUCCESSFULLY.getCode(),
                    new String[]{String.valueOf(userDto.getId())}, locale));
        }
        return populateUserResponse(false, savedUser.getUser(), messageService.getMessage(I18Code.MESSAGE_USER_NOT_EDITED.getCode(),
                new String[]{String.valueOf(userDto.getId())}, locale));
    }

    @Override
    public ServiceResponse delete(Long id, Locale locale, String username) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final Optional<User> usersSearched;

        usersSearched = userRepository.findUserById(id);

        final boolean isUserFound = usersSearched.isPresent();
        if (!isUserFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }

        User user = new User();

        UserDto userDto = dtoMapper.map(serviceResponse);

        user.setId(userDto.getId());
        user.setGender(userDto.getGender());
        user.setDateCreated(userDto.getDateCreated());
        user.setUserStatus(UserStatus.ACTIVE);
        user.setId(userDto.getId());
        userAuditableService.save(user, locale, username);

        serviceResponse.setSuccess(true);
        serviceResponse.setResult(dtoMapper.map(serviceResponse));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_DELETE_SUCCESS.getCode(),
                new String[]{userDto.getId().toString()}, locale));

        return serviceResponse;
    }

    @Override
    public ServiceResponse search(UserWrapper userWrapper, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        Stream streams = (Stream) userAuditableService.search(userWrapper, locale);

        Page pageStream = userRepository.findAll((Pageable) streams);

        serviceResponse.setSuccess(true);

        serviceResponse.setResult(pageStream);

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_SUCCESSFULLY_RETRIEVED.getCode(),
                new String[]{}, locale));

        return serviceResponse;
    }

    @Override
    public ServiceResponse findAllUsers(Locale locale) {
        return (ServiceResponse) userRepository.findAll();
    }

    @Override
    public ServiceResponse findUsersByStatus(UserStatus userStatus, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final List<User> userSearched = userRepository.findByUserStatus(userStatus);

        final boolean isUserFound = userSearched.isEmpty();
        if (!isUserFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }
        serviceResponse.setSuccess(true);

//        serviceResponse.setResult(dtoMapper.map());

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_USER_SUCCESSFULLY_RETRIEVED.getCode(),
                new String [] {}, locale));


        return  serviceResponse;
    }

    private ServiceResponse save(UserDto userDto, Locale locale, String username) {

        final ServiceResponse response = new ServiceResponse();
        final User user = dtoMapper.map(userDto);
        final User userEntity = userAuditableService.save(user, locale, username);
        response.setSuccess(true);
        response.setMessage(userEntity.getGender());
        response.setUser(userEntity);

        return response;
    }
    private ServiceResponse populateUserResponse(boolean success,
                                                User user,
                                                String narrative) {
        ServiceResponse response = new ServiceResponse();
        response.setSuccess(success);
        response.setMessage(narrative);
        response.setUser(user);
        return response;
    }
}
