package com.shoshore.agentservice.business.services.auditables.impl;

import com.shoshore.agentservice.business.criteria.specs.PropertySpecification;
import com.shoshore.agentservice.business.services.auditables.api.PropertyAuditableService;
import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.repository.api.HomePropertyRepository;
import com.shoshore.agentservice.utils.enums.PropertyStatus;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public class PropertyAuditableServiceImpl implements PropertyAuditableService {

    private HomePropertyRepository propertyRepository;
    public PropertyAuditableServiceImpl(HomePropertyRepository propertyRepository){
        this.propertyRepository = propertyRepository;
    }


    @Override
    public Property save(Property property, Locale locale, String username) {
        return propertyRepository.save(property);
    }

    @Override
    public Optional<Property> findPropertyById(String id, Locale locale) {
        return propertyRepository.findPropertyById(id);
    }

    @Override
    public List<Property> findByPropertyStatus(PropertyStatus propertyStatus, Locale locale) {
        return propertyRepository.findByPropertyStatus(propertyStatus);
    }

    @Override
    public void delete(String id, Locale locale, String username) {
        propertyRepository.deleteById(id);
    }

    @Override
    public Stream<Property> search(PropertyWrapper propertyWrapper, Locale locale, String username) {
        Specification<Property> page = PropertySpecification.filterByWrapper(propertyWrapper);
        return (Stream<Property>) page;
    }

    @Override
    public List<Property> findAllProperties(Locale locale) {
        return propertyRepository.findAll();
    }

    @Override
    public List<Property> findPropertiesByCity(String city, Locale locale) {
        return propertyRepository.findPropertiesByCity(city);
    }

    @Override
    public List<Property> findPropertiesBySuburb(String suburb, Locale locale) {
        return propertyRepository.findPropertiesBySuburb(suburb);
    }
}

