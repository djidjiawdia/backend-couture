package com.couture.backend.repos;

import com.couture.backend.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCniIgnoreCase(String cni);

    boolean existsByTelephoneIgnoreCase(String telephone);

}
