package com.shoshore.agentservice.business.criteria.specs;

import com.shoshore.agentservice.business.criteria.builder.UserCriteriaBuilder;
import com.shoshore.agentservice.domain.User;
import com.shoshore.agentservice.utils.wrapper.UserWrapper;
import org.springframework.data.jpa.domain.Specification;

public interface UserSpecification {

    public static Specification<User> filterByWrapper(final UserWrapper userWrapper) {
        return (fromRoot, criteriaDefinition, criteriaBuilder) -> UserCriteriaBuilder.getInstance().buildConjunctionPredicate(fromRoot, criteriaBuilder, userWrapper);
    }
}
