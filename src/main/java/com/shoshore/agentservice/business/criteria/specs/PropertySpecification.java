package com.shoshore.agentservice.business.criteria.specs;

import com.shoshore.agentservice.business.criteria.builder.PropertyCriteriaBuilder;
import com.shoshore.agentservice.domain.entities.Property;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;
import org.springframework.data.jpa.domain.Specification;

public interface PropertySpecification {

    public static Specification<Property> filterByWrapper(final PropertyWrapper propertyWrapper) {
        return (fromRoot, criteriaDefinition, criteriaBuilder) -> PropertyCriteriaBuilder.getInstance().buildConjunctionPredicate(fromRoot, criteriaBuilder, propertyWrapper);
    }
}
