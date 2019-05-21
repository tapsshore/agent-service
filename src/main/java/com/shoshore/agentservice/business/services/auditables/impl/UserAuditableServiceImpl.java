package com.shoshore.agentservice.business.services.auditables.impl;

import com.shoshore.agentservice.business.criteria.specs.UserSpecification;
import com.shoshore.agentservice.business.services.auditables.api.UserAuditableService;
import com.shoshore.agentservice.domain.User;
import com.shoshore.agentservice.repository.api.UserRepository;
import com.shoshore.agentservice.utils.wrapper.UserWrapper;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public class UserAuditableServiceImpl implements UserAuditableService {
    private UserRepository userRepository;

    public UserAuditableServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user, Locale locale, String username) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByIdNumber(String idNumber, Locale locale) {
        return userRepository.findUserByIdNumber(idNumber);
    }

    @Override
    public Optional<User> findUserByMobileNumber(String mobileNumber, Locale locale) {
        return userRepository.findUserByMobileNumber(mobileNumber);
    }

    @Override
    public List<User> findUsersByCityOrGender(String city, String gender, Locale locale) {
        return userRepository.findUsersByCityOrGender(city, gender);
    }

    @Override
    public Optional<User> findUserById(String id, Locale locale) {
        return userRepository.findUserById(id);
    }

    @Override
    public void delete(Long id, Locale locale, String username) {
        userRepository.deleteById(id);
    }

    @Override
    public Stream<User> search(UserWrapper userWrapper, Locale locale) {
        Specification<User> page = UserSpecification.filterByWrapper(userWrapper);
        return (Stream<User>) page;
    }

    @Override
    public List<User> findAllUsers(Locale locale) {
        return userRepository.findAll();
    }
}
