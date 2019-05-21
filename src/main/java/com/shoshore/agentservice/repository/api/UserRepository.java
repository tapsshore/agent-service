package com.shoshore.agentservice.repository.api;

import com.shoshore.agentservice.domain.User;
import com.shoshore.agentservice.utils.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findUserById(String id);

    Optional<User> findUserByIdNumber(String idNumber);

    Optional<User> findUserByMobileNumber(String mobileNumber);

    List<User> findByUserStatus(UserStatus userStatus);

    List<User> findAll();

    List<User> findUsersByCityOrGender(String city, String gender);

    User save(User user);

}
