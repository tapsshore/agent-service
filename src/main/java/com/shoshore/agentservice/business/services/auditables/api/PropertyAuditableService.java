package com.shoshore.agentservice.business.services.auditables.api;

import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.repository.api.PropertyRepository;
import com.shoshore.agentservice.utils.audit.trail.utils.Auditable;
import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public interface PropertyAuditableService {

    @Auditable(repositoryClass = PropertyRepository.class, entityClass = Property.class)

    Property save(Property property, Locale locale, String username);

    Optional<Property> findPropertyById(Long id, Locale locale);

    List<Property> findAllByPropertyStatus(PropertyStatus propertyStatus, Locale locale);

    void delete(Long id, Locale locale, String username);

    Stream<Property> search(PropertyWrapper propertyWrapper, Locale locale, String username);

    List<Property> findAllProperties(Locale locale);

    List<Property> findPropertiesByCity(String city, Locale locale);

    List<Property> findPropertiesBySuburb(String suburb, Locale locale);
}
