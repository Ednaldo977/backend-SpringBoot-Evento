package com.evento.backend.controllers;

import com.evento.backend.models.Telefone;
import com.evento.backend.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/telefones")
public class TelefoneController {

    private final TelefoneService telefoneService;

    @Autowired
    public TelefoneController(TelefoneService telefoneService) {
        this.telefoneService = telefoneService;
    }

    @GetMapping
    public ResponseEntity<List<Telefone>> getAllTelefones() {
        return ResponseEntity.ok(telefoneService.getAllTelefones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telefone> getTelefoneById(@PathVariable Long id) {
        Optional<Telefone> telefone = telefoneService.getTelefoneById(id);
        return telefone.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Telefone> createTelefone(@RequestBody Telefone telefone) {
        return ResponseEntity.ok(telefoneService.createTelefone(telefone));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Telefone> updateTelefone(@PathVariable Long id, @RequestBody Telefone telefone) {
        Optional<Telefone> existingTelefone = telefoneService.getTelefoneById(id);

        if (existingTelefone.isPresent()) {
            // Atualiza os atributos do telefone existente
            existingTelefone.get().setNumero(telefone.getNumero());

            // Salva o telefone atualizado
            Telefone updatedTelefone = telefoneService.createTelefone(existingTelefone.get());

            return ResponseEntity.ok(updatedTelefone);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelefone(@PathVariable Long id) {
        telefoneService.deleteTelefone(id);
        return ResponseEntity.noContent().build();
    }

    // Você pode adicionar endpoints adicionais conforme necessário

}
