package com.shoshore.agentservice.api.resource;


import com.shoshore.agentservice.api.messages.Response;
import com.shoshore.agentservice.api.processor.api.UserProcessor;
import com.shoshore.agentservice.utils.constants.Constants;
import com.shoshore.agentservice.utils.messages.external.UserDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@CrossOrigin
@RequestMapping(path = "/users")

public class UserResource {
    @Autowired
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

    @ApiOperation(value = "Create User Record", response = Response.class)
    @PostMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Response response(@RequestBody final UserDto userDto,
                             @RequestHeader(value = Constants.SOURCE_NAME_NARRATIVE) final String username,
                             @ApiParam(value = Constants.LOCALE_LANGUAGE_NARRATIVE) @RequestHeader(value = Constants.LOCALE_LANGUAGE,
                                     defaultValue = Constants.DEFAULT_LOCALE) final Locale locale) {

        LOGGER.info("Received User: {}", userDto.toString());

        return userProcessor.updateUser(userDto, locale, username);
    }


}
