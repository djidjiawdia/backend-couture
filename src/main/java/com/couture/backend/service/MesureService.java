package com.couture.backend.service;

import com.couture.backend.domain.Client;
import com.couture.backend.domain.Mesure;
import com.couture.backend.model.MesureDTO;
import com.couture.backend.repos.ClientRepository;
import com.couture.backend.repos.MesureRepository;
import com.couture.backend.util.NotFoundException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MesureService {

    private final MesureRepository mesureRepository;

    public List<MesureDTO> findAll() {
        final List<Mesure> mesures = mesureRepository.findAll(Sort.by("id"));
        return mesures.stream()
                .map(MesureDTO::mapToDTO)
                .toList();
    }

    public MesureDTO getByClient(final Long id) {
        return mesureRepository.findByClient(id)
                .map(MesureDTO::mapToDTO)
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final MesureDTO mesureDTO) {
        final Mesure mesure = MesureDTO.mapToEntity(mesureDTO);
        return mesureRepository.save(mesure).getId();
    }

    public void update(final MesureDTO mesureDTO) {
        final Mesure mesure = mesureRepository.findById(mesureDTO.getId())
                .orElseThrow(NotFoundException::new);

        mesureRepository.save(MesureDTO.mapToEntity(mesureDTO));
    }

    public void delete(final Long id) {
        mesureRepository.deleteById(id);
    }


}
