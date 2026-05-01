package com.sanjeeban.CoreApartmentService.repository;

import com.sanjeeban.CoreApartmentService.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    @Query(value = "SELECT apt_core.get_user_sequence()", nativeQuery = true)
    String getNextUserSequence();

    boolean existsByEmail(String email);

    boolean existsByMobile(String mobile);

    boolean existsByAadhar(String aadhar);

    Optional<UserInfo> findByUniqueUserNumber(String uniqueUserNumber);

}
