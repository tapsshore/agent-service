package com.shoshore.agentservice.business.services.logic.api;

import com.shoshore.agentservice.business.messages.PropertyResponse;
import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;

import java.util.Locale;

public interface PropertyService {


    ServiceResponse<PropertyDto> findPropertyById(Long id, Locale locale);

    ServiceResponse<PropertyDto> findPropertiesByPropertyStatus(PropertyStatus propertyStatus, Locale locale);

    ServiceResponse<PropertyDto> findPropertiesByCity(String city, Locale locale);

    ServiceResponse<PropertyDto> findPropertiesBySuburb(String suburb, Locale locale);

    ServiceResponse<PropertyDto> create(PropertyDto propertyDto, Locale locale, String username);

    ServiceResponse<PropertyDto> edit(PropertyDto propertyDto, Locale locale, String username);

    PropertyResponse search(PropertyWrapper propertyWrapper, Locale locale, String username);

    ServiceResponse<PropertyDto> delete(Long id, Locale locale, String username);

    ServiceResponse<PropertyDto> findAllProperties(Locale locale);


}
