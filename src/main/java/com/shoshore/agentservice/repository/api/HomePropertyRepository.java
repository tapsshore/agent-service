package com.shoshore.agentservice.repository.api;

import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.utils.enums.PropertyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface HomePropertyRepository extends JpaRepository<Property, Long>{

    Optional<Property> findPropertyById(Long id);

    List<Property> findByPropertyStatus(PropertyStatus propertyStatus);

    List<Property> findAll();

    List<Property> findPropertiesByCity(String city);

    List<Property> findPropertiesBySuburb(String suburb);

    Property save(Property property);
}
