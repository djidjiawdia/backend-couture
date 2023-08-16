package com.couture.backend.service;

import com.couture.backend.model.RoleDTO;
import com.couture.backend.repos.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream().map(RoleDTO::mapToDTO).collect(Collectors.toList());
    }

}
