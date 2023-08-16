package com.couture.backend.service;

import com.couture.backend.domain.Utilisateur;
import com.couture.backend.repos.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final Utilisateur user = utilisateurRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User " + username + " not found"));

        List<SimpleGrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN")
        );
        return new User(username, user.getPassword(), authorities);
    }

}
