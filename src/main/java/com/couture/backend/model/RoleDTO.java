package com.couture.backend.model;

import com.couture.backend.domain.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDTO {

    private Long id;
    private String libelle;

    public static RoleDTO mapToDTO(Role role) {
        if (role == null) {
            return null;
        }
        return RoleDTO.builder()
                .id(role.getId())
                .libelle(role.getLibelle())
                .build();
    }

    public static Role mapToEntity(RoleDTO dto) {
        if (dto == null) {
            return null;
        }
        Role role = new Role();
        role.setId(dto.getId());
        role.setLibelle(role.getLibelle());
        return role;
    }

}
