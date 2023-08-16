package com.couture.backend.service;

import com.couture.backend.domain.Role;
import com.couture.backend.domain.Utilisateur;
import com.couture.backend.model.UtilisateurDTO;
import com.couture.backend.repos.RoleRepository;
import com.couture.backend.repos.UtilisateurRepository;
import com.couture.backend.util.NotFoundException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public List<UtilisateurDTO> findAll() {
        final List<Utilisateur> utilisateurs = utilisateurRepository.findAll(Sort.by("id"));
        return utilisateurs.stream()
                .map(UtilisateurDTO::mapToDTO)
                .toList();
    }

    public UtilisateurDTO get(final Long id) {
        return utilisateurRepository.findById(id)
                .map(UtilisateurDTO::mapToDTO)
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final UtilisateurDTO utilisateurDTO) {
        final Utilisateur utilisateur = UtilisateurDTO.mapToEntity(utilisateurDTO);
        utilisateur.setPassword(new BCryptPasswordEncoder().encode("test@123"));
        return utilisateurRepository.save(utilisateur).getId();
    }

    public void update(final UtilisateurDTO utilisateurDTO) {
        final Utilisateur utilisateur = utilisateurRepository.findById(utilisateurDTO.getId())
                .orElseThrow(NotFoundException::new);
        utilisateur.setEmail(utilisateurDTO.getEmail());
        utilisateur.setUsername(utilisateurDTO.getUsername());
        utilisateurRepository.save((utilisateur));
    }

    public void delete(final Long id) {
        utilisateurRepository.deleteById(id);
    }

    public boolean usernameExists(final String username) {
        return utilisateurRepository.existsByUsernameIgnoreCase(username);
    }

    public boolean emailExists(final String email) {
        return utilisateurRepository.existsByEmailIgnoreCase(email);
    }

    public UtilisateurDTO findByUsername(String name) {
        return utilisateurRepository.findByUsername(name)
                .map(UtilisateurDTO::mapToDTO)
                .orElseThrow(NotFoundException::new);
    }
}
