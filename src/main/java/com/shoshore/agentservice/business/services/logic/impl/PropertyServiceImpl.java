package com.shoshore.agentservice.business.services.logic.impl;

import com.shoshore.agentservice.business.criteria.mapper.DtoMapper;
import com.shoshore.agentservice.business.services.auditables.api.PropertyAuditableService;
import com.shoshore.agentservice.business.services.logic.api.PropertyService;
import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.repository.api.PropertyRepository;
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
    private PropertyRepository propertyRepository;

    public PropertyServiceImpl(MessageService messageService,
                               PropertyAuditableService propertyAuditableService,
                               DtoMapper dtoMapper, PropertyRepository propertyRepository) {
        this.messageService = messageService;
        this.propertyAuditableService = propertyAuditableService;
        this.dtoMapper = dtoMapper;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public ServiceResponse findPropertyById(Long id, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final Optional<Property> propertySearched = propertyRepository.findPropertyById(id);

        final boolean isAlertFound = propertySearched.isPresent();
        if (!isAlertFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale));

        }
        return serviceResponse;

    }

    @Override
    public ServiceResponse findPropertiesByPropertyStatus(PropertyStatus propertyStatus, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final List<Property> propertyList = propertyAuditableService.findByPropertyStatus(propertyStatus, locale);

        final boolean isPropertyFound = propertyList.isEmpty();
        if (isPropertyFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }

        serviceResponse.setSuccess(true);

        serviceResponse.setResult(propertyList);

        serviceResponse.setList(propertyList);

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_SUCCESSFULLY_RETRIEVED.getCode(),
                new String[]{}, locale));

        return serviceResponse;
    }

    @Override
    public ServiceResponse findPropertiesByCity(String city, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final List<Property> propertyList = propertyAuditableService.findPropertiesByCity(city, locale);

        final boolean isPropertyFound = propertyList.isEmpty();
        if (isPropertyFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }

        serviceResponse.setSuccess(true);

        serviceResponse.setResult(propertyList);

        serviceResponse.setList(propertyList);

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_SUCCESSFULLY_RETRIEVED.getCode(),
                new String[]{}, locale));

        return serviceResponse;
    }

    @Override
    public ServiceResponse findPropertiesBySuburb(String suburb, Locale locale) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final List<Property> propertyList = propertyAuditableService.findPropertiesBySuburb(suburb, locale);

        final boolean isPropertyFound = propertyList.isEmpty();
        if (isPropertyFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }

        serviceResponse.setSuccess(true);

        serviceResponse.setResult(propertyList);

        serviceResponse.setList(propertyList);

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_SUCCESSFULLY_RETRIEVED.getCode(),
                new String[]{}, locale));

        return serviceResponse;
    }

    @Override
    public ServiceResponse create(PropertyDto propertyDto, Locale locale, String username) {
        final ServiceResponse response = save(propertyDto, locale, username);
        final boolean hasSavedProperty = response != null;
        if (hasSavedProperty) {
            return populatePropertyResponse(true, response.getProperty(), messageService.getMessage(I18Code.MESSAGE_PROPERTY_CREATED_SUCCESSFULLY.getCode(),
                    new String[]{String.valueOf(propertyDto.getId())}, locale));
        }
        return populatePropertyResponse(false, response.getProperty(), messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_CREATED.getCode(),
                new String[]{String.valueOf(propertyDto.getId())}, locale));

    }

    @Override
    public ServiceResponse edit(PropertyDto propertyDto, Locale locale, String username) {
        final ServiceResponse savedProperty = save(propertyDto, locale, username);
        final boolean hasSavedProperty = savedProperty != null;
        if (hasSavedProperty) {
            return populatePropertyResponse(true, savedProperty.getProperty(), messageService.getMessage(I18Code.MESSAGE_PROPERTY_EDITED_SUCCESSFULLY.getCode(),
                    new String[]{String.valueOf(propertyDto.getId())}, locale));
        }
        return populatePropertyResponse(false, savedProperty.getProperty(), messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_EDITED.getCode(),
                new String[]{String.valueOf(propertyDto.getId())}, locale));
    }

    @Override
    public ServiceResponse search(PropertyWrapper propertyWrapper, Locale locale, String username) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        Stream streams = (Stream) propertyAuditableService.search(propertyWrapper, locale, username);

        Page pageStream = propertyRepository.findAll((Pageable) streams);

        serviceResponse.setSuccess(true);

        serviceResponse.setResult(pageStream);

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_SUCCESSFULLY_RETRIEVED.getCode(),
                new String[]{}, locale));

        return serviceResponse;
    }

    @Override
    public ServiceResponse delete(Long id, Locale locale, String username) {
        final ServiceResponse serviceResponse = new ServiceResponse();

        final Optional<Property> propertySearched;

        propertySearched = propertyRepository.findPropertyById(id);

        final boolean isPropertyFound = propertySearched.isPresent();
        if (!isPropertyFound) {
            serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_NOT_FOUND.getCode(),
                    new String[]{}, locale));

            return serviceResponse;

        }

        Property property = new Property();

        PropertyDto propertyDto = dtoMapper.map(property);

        property.setId(propertyDto.getId());
        property.setDescription(propertyDto.getDescription());
        property.setDateCreated(propertyDto.getDateCreated());
        property.setPropertyStatus(PropertyStatus.VACANT);
        property.setId(propertyDto.getId());
        propertyAuditableService.save(property, locale, username);

        serviceResponse.setSuccess(true);
        serviceResponse.setResult(dtoMapper.map(propertyDto));

        serviceResponse.setMessage(messageService.getMessage(I18Code.MESSAGE_PROPERTY_DELETE_SUCCESS.getCode(),
                new String[]{property.getId().toString()}, locale));

        return serviceResponse;
    }

    @Override
    public ServiceResponse findAllProperties(Locale locale) {
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