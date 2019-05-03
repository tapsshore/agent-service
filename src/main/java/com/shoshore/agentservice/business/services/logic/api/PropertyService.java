package com.shoshore.agentservice.business.services.logic.api;

import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.messages.internal.ServiceResponse;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;

import java.util.Locale;

public interface PropertyService {


    ServiceResponse findPropertyById(Long id, Locale locale);

    ServiceResponse findPropertiesByPropertyStatus(PropertyStatus propertyStatus, Locale  locale);

    ServiceResponse findPropertiesByCity(String city, Locale locale);

    ServiceResponse findPropertiesBySuburb(String suburb, Locale locale);

    ServiceResponse create(PropertyDto propertyDto, Locale locale, String username);

    ServiceResponse edit(PropertyDto propertyDto, Locale locale, String username);

    ServiceResponse search(PropertyWrapper propertyWrapper, Locale locale, String username);

    ServiceResponse delete(Long id, Locale locale, String username);

    ServiceResponse findAllProperties(Locale locale);


}
