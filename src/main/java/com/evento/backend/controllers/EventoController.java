package com.evento.backend.controllers;

import com.evento.backend.models.Evento;
import com.evento.backend.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<Evento>> getAllEventos() {
        return ResponseEntity.ok(eventoService.getAllEventos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Optional<Evento> evento = eventoService.getEventoById(id);
        return evento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
        return ResponseEntity.ok(eventoService.createEvento(evento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento evento) {
        Optional<Evento> existingEvento = eventoService.getEventoById(id);

        if (existingEvento.isPresent()) {
            // Atualiza os atributos do evento existente
            existingEvento.get().setTitulo(evento.getTitulo());
            existingEvento.get().setDescricao(evento.getDescricao());
            existingEvento.get().setCategoria(evento.getCategoria());
            existingEvento.get().setEndereco(evento.getEndereco());
            existingEvento.get().setTelefone(evento.getTelefone());

            // Salva o evento atualizado
            Evento updatedEvento = eventoService.createEvento(existingEvento.get());

            return ResponseEntity.ok(updatedEvento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
        return ResponseEntity.noContent().build();
    }

    // Você pode adicionar endpoints adicionais conforme necessário

}
