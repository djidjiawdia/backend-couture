package com.couture.backend.rest;

import com.couture.backend.model.MesureDTO;
import com.couture.backend.service.MesureService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(value = "/api/mesures", produces = MediaType.APPLICATION_JSON_VALUE)
public class MesureResource {

    private final MesureService mesureService;
    @GetMapping("/client/{id}")
    public ResponseEntity<MesureDTO> getMesureByClient(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(mesureService.getByClient(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createMesure(@RequestBody @Valid final MesureDTO mesureDTO) {
        final Long createdId = mesureService.create(mesureDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Long> updateMesure(@RequestBody @Valid final MesureDTO mesureDTO) {
        mesureService.update(mesureDTO);
        return ResponseEntity.ok(mesureDTO.getId());
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteMesure(@PathVariable(name = "id") final Long id) {
        mesureService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
