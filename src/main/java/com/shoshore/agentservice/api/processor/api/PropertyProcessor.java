package com.shoshore.agentservice.api.processor.api;

import com.shoshore.agentservice.business.messages.PropertyResponse;
import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;

import java.util.Locale;

public interface PropertyProcessor {

    PropertyResponse searchPropertyById(String id, Locale locale);

    PropertyResponse search(PropertyWrapper propertyWrapper, Locale locale, String username);

    PropertyResponse retrieveAllProperties(Locale locale);

    PropertyResponse searchPropertysByCity(String city, Locale locale);

    PropertyResponse searchPropertysBySuburb(String suburb, Locale locale);

    PropertyResponse searchPropertysByPropertyStatus(PropertyStatus propertyStatus, Locale locale);

    PropertyResponse updateProperty(PropertyDto propertyDto, Locale locale, String username);

    PropertyResponse deleteProperty(String id, Locale locale, String username);
}
