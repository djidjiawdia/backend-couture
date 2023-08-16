package com.couture.backend.repos;

import com.couture.backend.domain.Mesure;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface MesureRepository extends JpaRepository<Mesure, Long> {
    @Query("SELECT m FROM Mesure m WHERE m.client.id = :id")
    Optional<Mesure> findByClient(Long id);
}
