
package com.wms.repository;

import com.wms.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDto, Long> {

    Optional<UserDto> findByUsername(String username);
}