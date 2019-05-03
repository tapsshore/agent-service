package com.shoshore.agentservice.api.processor.api;

import com.shoshore.agentservice.api.messages.Response;
import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.messages.external.PropertyDto;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;

import java.util.Locale;

public interface PropertyProcessor {

    Response searchPropertyById(Long id, Locale locale);

    Response search(PropertyWrapper propertyWrapper, Locale locale, String username);

    Response retrieveAllProperties(Locale locale);

    Response searchPropertysByCity(String city, Locale locale);

    Response searchPropertysBySuburb(String suburb, Locale locale);

    Response searchPropertysByPropertyStatus(PropertyStatus propertyStatus, Locale locale);

    Response updateProperty(PropertyDto propertyDto, Locale locale, String username);

    Response deleteProperty(Long id, Locale locale, String username);
}
