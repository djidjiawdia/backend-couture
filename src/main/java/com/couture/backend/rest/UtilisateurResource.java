package com.couture.backend.rest;

import com.couture.backend.model.UtilisateurDTO;
import com.couture.backend.service.UtilisateurService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/utilisateurs", produces = MediaType.APPLICATION_JSON_VALUE)
public class UtilisateurResource {

    private final UtilisateurService utilisateurService;

    public UtilisateurResource(final UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getAllUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateur(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(utilisateurService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createUtilisateur(
            @RequestBody @Valid final UtilisateurDTO utilisateurDTO) {
        final Long createdId = utilisateurService.create(utilisateurDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Long> updateUtilisateur(@RequestBody @Valid final UtilisateurDTO utilisateurDTO) {
        utilisateurService.update(utilisateurDTO);
        return ResponseEntity.ok(utilisateurDTO.getId());
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable(name = "id") final Long id) {
        utilisateurService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
