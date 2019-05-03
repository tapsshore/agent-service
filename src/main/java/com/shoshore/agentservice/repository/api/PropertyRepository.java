package com.shoshore.agentservice.repository.api;

import com.shoshore.agentservice.domain.entities.Property;
import com.shoshore.agentservice.utils.enums.PropertyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.lang.management.LockInfo;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long>, JpaSpecificationExecutor<Property>{

    Optional<Property> findPropertyById(Long id);

    List<Property> findPropertiesByPropertyStatus(PropertyStatus propertyStatus, Locale locale);

    List<Property> findAll();

    List<Property> findPropertiesByCity(String city);

    List<Property> findPropertiesBySuburb(String suburb);

    Property save(Property property);
}
