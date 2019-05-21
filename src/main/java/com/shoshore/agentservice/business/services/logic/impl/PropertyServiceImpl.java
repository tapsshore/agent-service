package com.shoshore.agentservice.business.services.logic.impl;

import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.messages.PropertyResponse;
import com.shoshore.agentservice.business.services.auditables.api.PropertyAuditableService;
import com.shoshore.agentservice.business.services.logic.api.PropertyService;
import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.repository.api.HomePropertyRepository;
import com.shoshore.agentservice.utils.common.i18.api.MessageService;
import com.shoshore.agentservice.utils.enums.I18Code;
import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

@SuppressWarnings("Duplicates")
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private MessageService messageService;
    @Autowired
    private PropertyAuditableService propertyAuditableService;
    private DtoMapper dtoMapper;
    @Autowired
    private HomePropertyRepository propertyRepository;

    public PropertyServiceImpl(MessageService messageService,
                               PropertyAuditableService propertyAuditableService,
                               DtoMapper dtoMapper, HomePropertyRepository propertyRepository) {
        this.messageService = messageService;
        this.propertyAuditableService = propertyAuditableService;
        this.dtoMapper = dtoMapper;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public ServiceResponse<PropertyDto> findPropertyById(String  id, Locale locale) {

        final ServiceResponse serviceResponse = new ServiceResponse();

        final Optional<Property> userSearched = propertyRepository.findPropertyById(id);

        final boolean isUserFound = userSearched.isPresent();
        if (!isUserFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }
        serviceResponse.setSuccess(true);

        serviceResponse.setResult(dtoMapper.map(serviceResponse));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_SUCCESSFULLY_RETRIEVED.getCode(),
                new String [] {}, locale));


        return  serviceResponse;

    }

    @Override
    public ServiceResponse<PropertyDto> findPropertiesByPropertyStatus(PropertyStatus propertyStatus, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final List<Property> propertySearched = propertyRepository.findByPropertyStatus(propertyStatus);

        final boolean isPropertyFound = propertySearched.isEmpty();
        if (!isPropertyFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }
        serviceResponse.setSuccess(true);

        serviceResponse.setResult(dtoMapper.map(serviceResponse));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_SUCCESSFULLY_RETRIEVED.getCode(),
                new String [] {}, locale));


        return  serviceResponse;
    }

    @Override
    public ServiceResponse<PropertyDto> findPropertiesByCity(String city, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final List<Property> propertySearched = propertyRepository.findPropertiesByCity(city);

        final boolean isPropertyFound = propertySearched.isEmpty();
        if (!isPropertyFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }
        serviceResponse.setSuccess(true);

        serviceResponse.setResult(dtoMapper.map(serviceResponse));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_SUCCESSFULLY_RETRIEVED.getCode(),
                new String [] {}, locale));


        return  serviceResponse;
    }

    @Override
    public ServiceResponse<PropertyDto> findPropertiesBySuburb(String suburb, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final List<Property> propertySearched = propertyRepository.findPropertiesBySuburb(suburb);

        final boolean isPropertyFound = propertySearched.isEmpty();
        if (!isPropertyFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }
        serviceResponse.setSuccess(true);

        serviceResponse.setResult(dtoMapper.map(serviceResponse));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_SUCCESSFULLY_RETRIEVED.getCode(),
                new String [] {}, locale));


        return  serviceResponse;
    }

    @Override
    public ServiceResponse<PropertyDto> create(PropertyDto propertyDto, Locale locale, String username) {
        final ServiceResponse serviceResponse = save(propertyDto, locale, username);
        final boolean hasSavedProperty = serviceResponse != null;
        if (hasSavedProperty) {
            return populatePropertyResponse(true, serviceResponse.getProperty(), messageService.getMessage(I18Code.MESSAGE_PROPERTY_CREATED_SUCCESSFULLY.getCode(),
                    new String[]{String.valueOf(propertyDto.getId())}, locale));
        }
        return populatePropertyResponse(false, serviceResponse.getProperty(), messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_CREATED.getCode(),
                new String[]{String.valueOf(propertyDto.getId())}, locale));

    }

    @Override
    public ServiceResponse<PropertyDto> edit(PropertyDto propertyDto, Locale locale, String username) {
        final ServiceResponse savedProperty = save(propertyDto, locale, username);
        final boolean hasSavedProperty = savedProperty != null;
        if (hasSavedProperty) {
            return populatePropertyResponse(true, savedProperty.getProperty(), messageService.getMessage(I18Code.MESSAGE_USER_EDITED_SUCCESSFULLY.getCode(),
                    new String[]{String.valueOf(propertyDto.getId())}, locale));
        }
        return populatePropertyResponse(false, savedProperty.getProperty(), messageService.getMessage(I18Code.MESSAGE_USER_NOT_EDITED.getCode(),
                new String[]{String.valueOf(propertyDto.getId())}, locale));
    }

    @Override
    public PropertyResponse search(PropertyWrapper propertyWrapper, Locale locale, String username) {
        final PropertyResponse propertyResponse = new PropertyResponse();

        Stream streams = (Stream) propertyAuditableService.search(propertyWrapper, locale, username);

        Page pageStream = propertyRepository.findAll((Pageable) streams);

        propertyResponse.setSuccess(true);

        propertyResponse.setResult(pageStream);

        propertyResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_SUCCESSFULLY_RETRIEVED.getCode(),
                new String[]{}, locale));

        return propertyResponse;
    }

    @Override
    public ServiceResponse<PropertyDto> delete(String id, Locale locale, String username) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final Optional<Property> usersSearched;

        usersSearched = propertyRepository.findPropertyById(id);

        final boolean isUserFound = usersSearched.isPresent();
        if (!isUserFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }

        Property property = new Property();

        PropertyDto propertyDto = dtoMapper.map(property);

        property.setId(propertyDto.getId());
        property.setCity(propertyDto.getCity());
        property.setDateCreated(propertyDto.getDateCreated());
        property.setPropertyStatus(PropertyStatus.TAKEN);
        property.setId(propertyDto.getId());
        propertyAuditableService.save(property, locale, username);

        serviceResponse.setSuccess(true);
        serviceResponse.setResult(dtoMapper.map(serviceResponse));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_DELETE_SUCCESS.getCode(),
                new String[]{propertyDto.getId().toString()}, locale));

        return serviceResponse;
    }

    @Override
    public ServiceResponse<PropertyDto> findAllProperties(Locale locale) {
        return (ServiceResponse) propertyRepository.findAll();
    }

    private ServiceResponse populatePropertyResponse(boolean success,
                                                                  Property property,
                                                                  String narrative) {
        ServiceResponse response = new ServiceResponse();
        response.setSuccess(success);
        response.setMessage(narrative);
        response.setProperty(property);
        return response;
    }

    private ServiceResponse save(PropertyDto propertyDto, Locale locale, String username) {

        final ServiceResponse response = new ServiceResponse();
        final Property property = dtoMapper.map(propertyDto);
        final Property propertyEntity = propertyAuditableService.save(property, locale, username);
        response.setSuccess(true);
        response.setMessage(propertyEntity.getCity());
        response.setProperty(propertyEntity);

        return response;
    }
}