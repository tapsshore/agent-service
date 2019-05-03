package com.shoshore.agentservice.business.criteria.builder;

import com.shoshore.agentservice.domain.User;
import com.shoshore.agentservice.utils.constants.Constants;
import com.shoshore.agentservice.utils.criteria.CriteriaUtils;
import com.shoshore.agentservice.utils.dates.DateUtils;
import com.shoshore.agentservice.utils.wrapper.UserWrapper;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.engine.spi.Status;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

import static com.shoshore.agentservice.utils.criteria.CriteriaConstants.*;

@SuppressWarnings("Duplicates")
public class UserCriteriaBuilder {

    private static UserCriteriaBuilder instance;
    private final CriteriaUtils<User> criteriaUtils = new CriteriaUtils<>();

    public static UserCriteriaBuilder getInstance() {
        if (instance == null) {
            instance = new UserCriteriaBuilder();
        }
        return instance;
    }

    private static void resetStatusAllValues(final UserWrapper userWrapper) {
        if (Constants.STATUS_ALL.equalsIgnoreCase(userWrapper.getUserStatus())) {
            userWrapper.setUserStatus(null);
        }
    }

    public Predicate buildConjunctionPredicate(final Root<User> root, final CriteriaBuilder criteriaBuilder, final UserWrapper userWrapper) {
        Predicate predicate = criteriaBuilder.conjunction();
        if (userWrapper == null) {
            return buildAllRecordsConjunctionPredicate(predicate, root, criteriaBuilder);
        }
        resetStatusAllValues(userWrapper);
        predicate = buildEntitySpecificConjunctionPredicateForCurrency(predicate, root, criteriaBuilder, userWrapper);
        predicate = buildEntityDatesConjunctionPredicate(predicate, root, criteriaBuilder, userWrapper);
        return buildAllRecordsConjunctionPredicate(predicate, root, criteriaBuilder);
    }

    private Predicate buildAllRecordsConjunctionPredicate(final Predicate conjunctionPredicate, final Root<User> fromRoot, final CriteriaBuilder criteriaBuilder) {
        final Status statusValue = Status.DELETED;
        return criteriaUtils.buildConjunctionPredicate(conjunctionPredicate, criteriaBuilder,
                criteriaBuilder.notEqual(fromRoot.get(STATUS), statusValue), statusValue.name());
    }

    private Predicate buildEntitySpecificConjunctionPredicateForCurrency(final Predicate conjunctionPredicate, final Root<User> fromRoot, final CriteriaBuilder criteriaBuilder, UserWrapper userWrapper) {

        Predicate entityConjunctionPredicate = criteriaUtils.buildConjunctionPredicate(conjunctionPredicate, criteriaBuilder,
                criteriaBuilder.equal(fromRoot.get(ID), userWrapper.getId()), userWrapper.getId());

        if (userWrapper.getUserStatus() != null) {
            entityConjunctionPredicate = criteriaUtils.buildConjunctionPredicate(entityConjunctionPredicate, criteriaBuilder,
                    criteriaBuilder.equal(fromRoot.get(STATUS), userWrapper.getUserStatus()), userWrapper.getUserStatus());
        }

        if (!(Constants.STATUS_ALL.equalsIgnoreCase(userWrapper.getUserStatus()) || StringUtils.isEmpty(userWrapper.getUserStatus()))) {
            entityConjunctionPredicate = criteriaUtils.buildConjunctionPredicate(entityConjunctionPredicate, criteriaBuilder,
                    criteriaBuilder.equal(fromRoot.get(STATUS), Status.valueOf(userWrapper.getUserStatus())), userWrapper.getUserStatus());
        }

        return entityConjunctionPredicate;

    }

    private Predicate buildEntityDatesConjunctionPredicate(final Predicate conjunctionPredicate, Root<User> fromRoot, CriteriaBuilder criteriaBuilder, UserWrapper userWrapper) {
        if (userWrapper.getDateCreated() != null) {
            userWrapper.setFromDate(userWrapper.getDateCreated());
            userWrapper.setToDate(userWrapper.getDateCreated());
        }
        Predicate datesConjunctionPredicate = criteriaUtils.buildConjunctionPredicate(conjunctionPredicate, criteriaBuilder,
                criteriaBuilder.greaterThanOrEqualTo(fromRoot.<Date>get(CREATION_DATE), DateUtils.getStartOfDay(userWrapper.getFromDate())), userWrapper.getFromDate());

        return criteriaUtils.buildConjunctionPredicate(datesConjunctionPredicate, criteriaBuilder,
                criteriaBuilder.lessThanOrEqualTo(fromRoot.<Date>get(CREATION_DATE), DateUtils.getEndOfDay(userWrapper.getToDate())), userWrapper.getToDate());


    }
}
