package com.shoshore.agentservice.business.services.auditables.api;

import com.shoshore.agentservice.domain.User;
import com.shoshore.agentservice.repository.api.UserRepository;
import com.shoshore.agentservice.utils.audit.trail.utils.Auditable;
import com.shoshore.agentservice.utils.wrapper.UserWrapper;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserAuditableService {

    @Auditable(repositoryClass = UserRepository.class, entityClass = User.class)

    User save(User user, Locale locale, String username);

    Optional<User> findUserByIdNumber(String idNumber, Locale locale);

    Optional<User> findUserByMobileNumber(String mobileNumber, Locale locale);

    List<User> findUsersByCityOrGender(String city, String gender, Locale locale);

    Optional<User> findUserById(Long id, Locale locale);

    void delete(Long id, Locale locale, String username);

    Stream<User> search(UserWrapper userWrapper, Locale locale);

    List<User> findAllUsers(Locale locale);

    

}
