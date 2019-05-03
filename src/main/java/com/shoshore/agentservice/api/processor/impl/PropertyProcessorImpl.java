package com.shoshore.agentservice.api.processor.impl;

import com.shoshore.agentservice.api.messages.Response;
import com.shoshore.agentservice.api.processor.api.PropertyProcessor;
import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.services.logic.api.PropertyService;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

@SuppressWarnings("Duplicates")
public class PropertyProcessorImpl implements PropertyProcessor {

    private final PropertyService propertyService;
    private final DtoMapper dtoMapper;
    private final MessageService messageService;

    public PropertyProcessorImpl(PropertyService propertyService, DtoMapper dtoMapper, MessageService messageService) {
        this.propertyService = propertyService;
        this.dtoMapper = dtoMapper;
        this.messageService = messageService;
    }

    Logger log = LoggerFactory.getLogger(PropertyProcessorImpl.class.getName());

    @Override
    public Response searchPropertyById(Long id, Locale locale) {

        log.info("Property Search Request in: {}", id);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.findPropertyById(id, locale);


        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setPropertyDto(serviceResponse.getResult());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response search(PropertyWrapper propertyWrapper, Locale locale, String username) {

        log.info("Search Request: {}", propertyWrapper);

        ServiceResponse serviceResponse = propertyService.search(propertyWrapper, locale, username);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        return response;
    }

    @Override
    public Response retrieveAllProperties(Locale locale) {

        log.info("Property Search Request to Find All Properties");
        ServiceResponse<PropertyDto> serviceResponse = propertyService.findAllProperties(locale);

        Response response = new Response();

        response.setSuccess(true);
        response.setMessage(serviceResponse.getMessage());
        response.setPropertyDtoList(serviceResponse.getList());
        log.info("Response out: {}", response);
        return response;
    }

    @Override
    public Response searchPropertysByCity(String city, Locale locale) {

        log.info("Property Search Request by City: {}", city);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.findPropertiesByCity(city, locale);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setPropertyDtoList(serviceResponse.getList());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response searchPropertysBySuburb(String suburb, Locale locale) {


        log.info("Property Search Request by Suburb: {}", suburb);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.findPropertiesBySuburb(suburb, locale);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setPropertyDtoList(serviceResponse.getList());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response searchPropertysByPropertyStatus(PropertyStatus propertyStatus, Locale locale) {

        log.info("Property Search Request by Property Status: {}", propertyStatus);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.findPropertiesByPropertyStatus(propertyStatus, locale);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setPropertyDtoList(serviceResponse.getList());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response updateProperty(PropertyDto propertyDto, Locale locale, String username) {

        log.info("Update Property Request in : {}", propertyDto);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.edit(propertyDto, locale, username);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setPropertyDto(serviceResponse.getResult());

        log.info("Response out: {}", response);

        return response;
    }

    @Override
    public Response deleteProperty(Long id, Locale locale, String username) {

        log.info("Delete Property Request: {}", id);

        ServiceResponse<PropertyDto> serviceResponse  = propertyService.delete(id , locale,username);

        Response response = new Response();

        response.setSuccess(serviceResponse.isSuccess());
        response.setMessage(serviceResponse.getMessage());
        response.setPropertyDto(serviceResponse.getResult());

        log.info("Response out: {}", response);

        return response;
    }
    }

