package com.couture.backend.rest;

import com.couture.backend.model.AuthenticationRequest;
import com.couture.backend.model.AuthenticationResponse;
import com.couture.backend.model.UtilisateurDTO;
import com.couture.backend.repos.UtilisateurRepository;
import com.couture.backend.service.JwtTokenService;
import com.couture.backend.service.JwtUserDetailsService;
import com.couture.backend.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationResource {

    private final AuthenticationManager authenticationManager;
    private final UtilisateurService utilisateurService;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final JwtTokenService jwtTokenService;

    @PostMapping("/api/authenticate")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
            );
        } catch (final BadCredentialsException ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(request.getLogin());
        final AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setAccessToken(jwtTokenService.generateToken(userDetails));
        return authenticationResponse;
    }

    @GetMapping("/api/mon-profil")
    public UtilisateurDTO getProfil() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return utilisateurService.findByUsername(authentication.getName());
    }

}
