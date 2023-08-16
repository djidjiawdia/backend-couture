package com.couture.backend.model;

import com.couture.backend.domain.Client;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientDTO {

    private Long id;

    @NotNull
    @Size(max = 50)
    private String prenom;

    @NotNull
    @Size(max = 50)
    private String nom;

    @NotNull
    @Size(max = 50)
    private String cni;

    @NotNull
    @Size(max = 15)
    private String telephone;

    private Sexe sexe;

    @Size(max = 50)
    private String email;

    public static ClientDTO mapToDTO(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDTO.builder()
                .id(client.getId())
                .prenom(client.getPrenom())
                .nom(client.getNom())
                .cni(client.getCni())
                .telephone(client.getTelephone())
                .sexe(client.getSexe())
                .email(client.getEmail())
                .build();
    }

    public static Client mapToEntity(ClientDTO dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(dto.getId());
        client.setPrenom(dto.getPrenom());
        client.setNom(dto.getNom());
        client.setCni(dto.getCni());
        client.setTelephone(dto.getTelephone());
        client.setSexe(dto.getSexe());
        client.setEmail(dto.getEmail());
        return client;
    }

}
