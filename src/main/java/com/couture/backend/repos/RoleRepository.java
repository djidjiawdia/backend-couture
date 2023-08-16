package com.couture.backend.repos;

import com.couture.backend.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByLibelle(String admin);
}
