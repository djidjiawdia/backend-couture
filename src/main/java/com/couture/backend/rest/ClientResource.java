package com.couture.backend.rest;

import com.couture.backend.model.ClientDTO;
import com.couture.backend.service.ClientService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(final ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(clientService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createClient(@RequestBody @Valid final ClientDTO clientDTO) {
        final Long createdId = clientService.create(clientDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Long> updateClient(@RequestBody @Valid final ClientDTO clientDTO) {
        clientService.update(clientDTO);
        return ResponseEntity.ok(clientDTO.getId());
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteClient(@PathVariable(name = "id") final Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
