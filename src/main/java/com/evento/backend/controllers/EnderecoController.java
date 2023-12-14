package com.evento.backend.controllers;

import com.evento.backend.models.Endereco;
import com.evento.backend.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos() {
        return ResponseEntity.ok(enderecoService.getAllEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {
        Optional<Endereco> endereco = enderecoService.getEnderecoById(id);
        return endereco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.createEndereco(endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Optional<Endereco> existingEndereco = enderecoService.getEnderecoById(id);

        if (existingEndereco.isPresent()) {
            // Atualiza os atributos do endereco existente
            existingEndereco.get().setRua(endereco.getRua());
            existingEndereco.get().setNumero(endereco.getNumero());
            existingEndereco.get().setCidade(endereco.getCidade());

            // Salva o endereco atualizado
            Endereco updatedEndereco = enderecoService.createEndereco(existingEndereco.get());

            return ResponseEntity.ok(updatedEndereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        enderecoService.deleteEndereco(id);
        return ResponseEntity.noContent().build();
    }

    // endpoints do controlador

}
