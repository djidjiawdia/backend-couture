package com.couture.backend.service;

import com.couture.backend.domain.Client;
import com.couture.backend.model.ClientDTO;
import com.couture.backend.repos.ClientRepository;
import com.couture.backend.util.NotFoundException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<ClientDTO> findAll() {
        final List<Client> clients = clientRepository.findAll(Sort.by("id"));
        return clients.stream()
                .map(ClientDTO::mapToDTO)
                .toList();
    }

    public ClientDTO get(final Long id) {
        return clientRepository.findById(id)
                .map(ClientDTO::mapToDTO)
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ClientDTO clientDTO) {
        final Client client = ClientDTO.mapToEntity(clientDTO);
        return clientRepository.save(client).getId();
    }

    public void update(final ClientDTO clientDTO) {
        final Client client = clientRepository.findById(clientDTO.getId())
                .orElseThrow(NotFoundException::new);
        client.setPrenom(clientDTO.getPrenom());
        client.setNom(clientDTO.getNom());
        client.setCni(clientDTO.getCni());
        client.setEmail(clientDTO.getEmail());
        client.setTelephone(clientDTO.getTelephone());
        clientRepository.save(client);
    }

    public void delete(final Long id) {
        clientRepository.deleteById(id);
    }

    public boolean cniExists(final String cni) {
        return clientRepository.existsByCniIgnoreCase(cni);
    }

    public boolean telephoneExists(final String telephone) {
        return clientRepository.existsByTelephoneIgnoreCase(telephone);
    }

}
