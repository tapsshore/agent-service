package com.shoshore.agentservice.api.resource;


import com.shoshore.agentservice.api.processor.api.UserProcessor;
import com.shoshore.agentservice.business.messages.UserResponse;
import com.shoshore.agentservice.utils.constants.Constants;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@CrossOrigin
@RequestMapping(path = "/users")

public class UserResource {

    private final UserProcessor userProcessor;

    public UserResource(UserProcessor userProcessor) {
        this.userProcessor = userProcessor;
    }

    private static Logger LOGGER = LoggerFactory.getLogger(UserResource.class);


    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Resource successfully created"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    @ApiOperation(value = "Create User Record", response = UserResponse.class)
    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse create(@RequestBody final UserDto userDto,
                             @RequestHeader(value = Constants.SOURCE_NAME_NARRATIVE, required = false) final String username,
                             @ApiParam(value = Constants.LOCALE_LANGUAGE_NARRATIVE) @RequestHeader(value = Constants.LOCALE_LANGUAGE,
                                     defaultValue = Constants.DEFAULT_LOCALE, required = false) final Locale locale) {

        LOGGER.info("Received User: {}", userDto.toString());

        return userProcessor.createUser(userDto, locale, username);
    }


    @ApiOperation(value = "Find User by id", response = UserResponse.class)
    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE},
    consumes = {MediaType.APPLICATION_JSON_VALUE})
    public  UserResponse findUserRecordById(@PathVariable("id") final Long id,
                                                 @ApiParam(value = Constants.SOURCE_TYPE_NARRATIVE) @RequestHeader(value =  Constants.SOURCE_TYPE, required = false) final String username,
                                                 @ApiParam(value = Constants.LOCALE_LANGUAGE_NARRATIVE) @RequestHeader(value = Constants.LOCALE_LANGUAGE,
                                                         defaultValue = Constants.DEFAULT_LOCALE) final Locale locale){

        return userProcessor.searchUserById(id, locale);

    }

    @ApiOperation(value = "Delete User", response = UserResponse.class)
    @DeleteMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse deleteUser(@PathVariable("userId") final Long id,
                                                   @ApiParam(value = Constants.SOURCE_TYPE_NARRATIVE) @RequestHeader(value = Constants.SOURCE_TYPE, required = false) final String sourceType,
                                                   @ApiParam(value = Constants.SOURCE_NAME_NARRATIVE) @RequestHeader(value = Constants.SOURCE_NAME, required = false) final String sourceName,
                                                   @RequestHeader(value = Constants.SOURCE_NAME_NARRATIVE, required = false) final String username,
                                                   @ApiParam(value = Constants.LOCALE_LANGUAGE_NARRATIVE) @RequestHeader(value = Constants.LOCALE_LANGUAGE,
                                                           defaultValue = Constants.DEFAULT_LOCALE, required = false) final Locale locale) {

        return userProcessor.deleteUser(id, locale, username);
    }



}
