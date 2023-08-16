package com.couture.backend.config;

import com.couture.backend.domain.Role;
import com.couture.backend.domain.Utilisateur;
import com.couture.backend.repos.RoleRepository;
import com.couture.backend.repos.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationLoader implements CommandLineRunner {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count() <= 0) {
            System.out.println("Load fixtures");
            loadRoles();
            utilisateurRepository.save(new Utilisateur(
                    null,
                    "admin",
                    "admin@admin.com",
                    new BCryptPasswordEncoder().encode("admin"),
                    roleRepository.findByLibelle("admin").orElseThrow()
            ));
        }
    }

    private void loadRoles() {
        List<Role> roles = List.of(
                new Role(null, "admin"),
                new Role(null, "agent")
        );
        roleRepository.saveAll(roles);
    }

}
