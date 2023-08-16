package com.couture.backend.model;

import com.couture.backend.domain.Role;
import com.couture.backend.domain.Utilisateur;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
public class UtilisateurDTO {

    private Long id;

    private String username;

    private String email;

    private String password;

    private RoleDTO role;

    public static UtilisateurDTO mapToDTO(final Utilisateur utilisateur) {
        return UtilisateurDTO.builder()
            .id(utilisateur.getId())
            .username(utilisateur.getUsername())
            .email(utilisateur.getEmail())
            .role(utilisateur.getRole() == null ? null : RoleDTO.mapToDTO(utilisateur.getRole()))
                .build();
    }

    public static Utilisateur mapToEntity(final UtilisateurDTO dto) {
        if (dto == null) {
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(dto.getUsername());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setPassword(dto.getPassword());
        utilisateur.setRole(dto.getRole() == null ? null : RoleDTO.mapToEntity(dto.getRole()));
        return utilisateur;
    }

}
