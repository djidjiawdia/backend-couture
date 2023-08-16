package com.couture.backend.repos;

import com.couture.backend.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    boolean existsByUsernameIgnoreCase(String username);

    boolean existsByEmailIgnoreCase(String email);

    Optional<Utilisateur> findByUsername(String username);
}
