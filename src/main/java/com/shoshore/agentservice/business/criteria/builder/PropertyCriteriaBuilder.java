package com.shoshore.agentservice.business.criteria.builder;

import com.shoshore.agentservice.domain.Property;
import com.shoshore.agentservice.utils.constants.Constants;
import com.shoshore.agentservice.utils.criteria.CriteriaUtils;
import com.shoshore.agentservice.utils.dates.DateUtils;
import com.shoshore.agentservice.utils.wrapper.PropertyWrapper;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.spi.Status;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

import static com.shoshore.agentservice.utils.criteria.CriteriaConstants.*;

@SuppressWarnings("Duplicates")
public class PropertyCriteriaBuilder {

    private static PropertyCriteriaBuilder instance;
    private final CriteriaUtils<Property> criteriaUtils = new CriteriaUtils<>();

    public static PropertyCriteriaBuilder getInstance() {
        if (instance == null) {
            instance = new PropertyCriteriaBuilder();
        }
        return instance;
    }

    private static void resetStatusAllValues(final PropertyWrapper propertyWrapper) {
        if (Constants.STATUS_ALL.equalsIgnoreCase(propertyWrapper.getPropertyStatus())) {
            propertyWrapper.setPropertyStatus(null);
        }
    }

    public Predicate buildConjunctionPredicate(final Root<Property> root, final CriteriaBuilder criteriaBuilder, final PropertyWrapper propertyWrapper) {
        Predicate predicate = criteriaBuilder.conjunction();
        if (propertyWrapper == null) {
            return buildAllRecordsConjunctionPredicate(predicate, root, criteriaBuilder);
        }
        resetStatusAllValues(propertyWrapper);
        predicate = buildEntitySpecificConjunctionPredicateForCurrency(predicate, root, criteriaBuilder, propertyWrapper);
        predicate = buildEntityDatesConjunctionPredicate(predicate, root, criteriaBuilder, propertyWrapper);
        return buildAllRecordsConjunctionPredicate(predicate, root, criteriaBuilder);
    }

    private Predicate buildAllRecordsConjunctionPredicate(final Predicate conjunctionPredicate, final Root<Property> fromRoot, final CriteriaBuilder criteriaBuilder) {
        final Status statusValue = Status.DELETED;
        return criteriaUtils.buildConjunctionPredicate(conjunctionPredicate, criteriaBuilder,
                criteriaBuilder.notEqual(fromRoot.get(STATUS), statusValue), statusValue.name());
    }

    private Predicate buildEntitySpecificConjunctionPredicateForCurrency(final Predicate conjunctionPredicate, final Root<Property> fromRoot, final CriteriaBuilder criteriaBuilder, PropertyWrapper propertyWrapper) {

        Predicate entityConjunctionPredicate = criteriaUtils.buildConjunctionPredicate(conjunctionPredicate, criteriaBuilder,
                criteriaBuilder.equal(fromRoot.get(ID), propertyWrapper.getId()), propertyWrapper.getId());

        if (propertyWrapper.getPropertyStatus() != null) {
            entityConjunctionPredicate = criteriaUtils.buildConjunctionPredicate(entityConjunctionPredicate, criteriaBuilder,
                    criteriaBuilder.equal(fromRoot.get(STATUS), propertyWrapper.getPropertyStatus()), propertyWrapper.getPropertyStatus());
        }

        if (!(Constants.STATUS_ALL.equalsIgnoreCase(propertyWrapper.getPropertyStatus()) || StringUtils.isEmpty(propertyWrapper.getPropertyStatus()))) {
            entityConjunctionPredicate = criteriaUtils.buildConjunctionPredicate(entityConjunctionPredicate, criteriaBuilder,
                    criteriaBuilder.equal(fromRoot.get(STATUS), Status.valueOf(propertyWrapper.getPropertyStatus())), propertyWrapper.getPropertyStatus());
        }

        return entityConjunctionPredicate;

    }

    private Predicate buildEntityDatesConjunctionPredicate(final Predicate conjunctionPredicate, Root<Property> fromRoot, CriteriaBuilder criteriaBuilder, PropertyWrapper propertyWrapper) {
        if (propertyWrapper.getDateCreated() != null) {
            propertyWrapper.setFromDate(propertyWrapper.getDateCreated());
            propertyWrapper.setToDate(propertyWrapper.getDateCreated());
        }
        Predicate datesConjunctionPredicate = criteriaUtils.buildConjunctionPredicate(conjunctionPredicate, criteriaBuilder,
                criteriaBuilder.greaterThanOrEqualTo(fromRoot.<Date>get(CREATION_DATE), DateUtils.getStartOfDay(propertyWrapper.getFromDate())), propertyWrapper.getFromDate());

        return criteriaUtils.buildConjunctionPredicate(datesConjunctionPredicate, criteriaBuilder,
                criteriaBuilder.lessThanOrEqualTo(fromRoot.<Date>get(CREATION_DATE), DateUtils.getEndOfDay(propertyWrapper.getToDate())), propertyWrapper.getToDate());


    }
}
