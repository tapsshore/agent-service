package com.shoshore.agentservice.api.processor.impl;

import com.shoshore.agentservice.api.processor.api.PropertyProcessor;
import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.messages.PropertyResponse;
import com.shoshore.agentservice.business.services.logic.api.PropertyService;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

@SuppressWarnings("Duplicates")
public class PropertyProcessorImpl implements PropertyProcessor {
    @Autowired
    private final PropertyService propertyService;
    private final DtoMapper dtoMapper;
    @Autowired
    private final MessageService messageService;

    public PropertyProcessorImpl(PropertyService propertyService, DtoMapper dtoMapper, MessageService messageService) {
        this.propertyService = propertyService;
        this.dtoMapper = dtoMapper;
        this.messageService = messageService;
    }

    Logger log = LoggerFactory.getLogger(PropertyProcessorImpl.class.getName());

    @Override
    public PropertyResponse searchPropertyById(Long id, Locale locale) {

        log.info("Property Search Request in: {}", id);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.findPropertyById(id, locale);


        PropertyResponse propertyResponse = new PropertyResponse();

        propertyResponse.setSuccess(serviceResponse.isSuccess());
        propertyResponse.setMessage(serviceResponse.getMessage());
        propertyResponse.setPropertyDto(serviceResponse.getResult());

        log.info("Response out: {}", propertyResponse);

        return propertyResponse;
    }

    @Override
    public PropertyResponse search(PropertyWrapper propertyWrapper, Locale locale, String username) {

        log.info("Search Request: {}", propertyWrapper);

        PropertyResponse serviceResponse = propertyService.search(propertyWrapper, locale, username);
        PropertyResponse propertyResponse = new PropertyResponse();

        propertyResponse.setSuccess(serviceResponse.isSuccess());
        propertyResponse.setMessage(serviceResponse.getMessage());
        return propertyResponse;
    }

    @Override
    public PropertyResponse retrieveAllProperties(Locale locale) {

        log.info("Property Search Request to Find All Properties");
        ServiceResponse<PropertyDto> serviceResponse = propertyService.findAllProperties(locale);

        PropertyResponse propertyResponse = new PropertyResponse();

        propertyResponse.setSuccess(true);
        propertyResponse.setMessage(serviceResponse.getMessage());
        propertyResponse.setPropertyDtoList(serviceResponse.getList());
        log.info("Response out: {}", propertyResponse);
        return propertyResponse;
    }

    @Override
    public PropertyResponse searchPropertysByCity(String city, Locale locale) {

        log.info("Property Search Request by City: {}", city);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.findPropertiesByCity(city, locale);

        PropertyResponse propertyResponse = new PropertyResponse();

        propertyResponse.setSuccess(serviceResponse.isSuccess());
        propertyResponse.setMessage(serviceResponse.getMessage());
        propertyResponse.setPropertyDtoList(serviceResponse.getList());

        log.info("Response out: {}", propertyResponse);

        return propertyResponse;
    }

    @Override
    public PropertyResponse searchPropertysBySuburb(String suburb, Locale locale) {


        log.info("Property Search Request by Suburb: {}", suburb);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.findPropertiesBySuburb(suburb, locale);

        PropertyResponse propertyResponse = new PropertyResponse();

        propertyResponse.setSuccess(serviceResponse.isSuccess());
        propertyResponse.setMessage(serviceResponse.getMessage());
        propertyResponse.setPropertyDtoList(serviceResponse.getList());

        log.info("Response out: {}", propertyResponse);

        return propertyResponse;
    }

    @Override
    public PropertyResponse searchPropertysByPropertyStatus(PropertyStatus propertyStatus, Locale locale) {

        log.info("Property Search Request by Property Status: {}", propertyStatus);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.findPropertiesByPropertyStatus(propertyStatus, locale);

        PropertyResponse propertyResponse = new PropertyResponse();

        propertyResponse.setSuccess(serviceResponse.isSuccess());
        propertyResponse.setMessage(serviceResponse.getMessage());
        propertyResponse.setPropertyDtoList(serviceResponse.getList());

        log.info("Response out: {}", propertyResponse);

        return propertyResponse;
    }

    @Override
    public PropertyResponse updateProperty(PropertyDto propertyDto, Locale locale, String username) {

        log.info("Update Property Request in : {}", propertyDto);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.edit(propertyDto, locale, username);

        PropertyResponse propertyResponse = new PropertyResponse();

        propertyResponse.setSuccess(serviceResponse.isSuccess());
        propertyResponse.setMessage(serviceResponse.getMessage());
        propertyResponse.setPropertyDto(serviceResponse.getResult());

        log.info("Response out: {}", propertyResponse);

        return propertyResponse;
    }

    @Override
    public PropertyResponse deleteProperty(Long id, Locale locale, String username) {

        log.info("Delete Property Request: {}", id);

        ServiceResponse<PropertyDto> serviceResponse = propertyService.delete(id, locale, username);

        PropertyResponse propertyResponse = new PropertyResponse();

        propertyResponse.setSuccess(serviceResponse.isSuccess());
        propertyResponse.setMessage(serviceResponse.getMessage());
        propertyResponse.setPropertyDto(serviceResponse.getResult());

        log.info("Response out: {}", propertyResponse);

        return propertyResponse;
    }
    }

