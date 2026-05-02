package com.sanjeeban.CoreApartmentService.repository;

import com.sanjeeban.CoreApartmentService.entity.UserMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMappingRepository extends JpaRepository<UserMapping,Long> {

    Optional<UserMapping> findByUniqueUserNumber(String uniqueUserNumber);
}
