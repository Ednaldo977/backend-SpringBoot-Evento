package com.evento.backend.controllers;

import com.evento.backend.models.TipoFuncao;
import com.evento.backend.service.TipoFuncaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipofuncoes")
public class TipoFuncaoController {

    private final TipoFuncaoService tipoFuncaoService;

    @Autowired
    public TipoFuncaoController(TipoFuncaoService tipoFuncaoService) {
        this.tipoFuncaoService = tipoFuncaoService;
    }

    @GetMapping
    public ResponseEntity<List<TipoFuncao>> getAllTipoFuncoes() {
        return ResponseEntity.ok(tipoFuncaoService.getAllTipoFuncoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoFuncao> getTipoFuncaoById(@PathVariable Long id) {
        Optional<TipoFuncao> tipoFuncao = tipoFuncaoService.getTipoFuncaoById(id);
        return tipoFuncao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoFuncao> createTipoFuncao(@RequestBody TipoFuncao tipoFuncao) {
        return ResponseEntity.ok(tipoFuncaoService.createTipoFuncao(tipoFuncao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoFuncao> updateTipoFuncao(@PathVariable Long id, @RequestBody TipoFuncao tipoFuncao) {
        Optional<TipoFuncao> existingTipoFuncao = tipoFuncaoService.getTipoFuncaoById(id);

        if (existingTipoFuncao.isPresent()) {
            // Atualiza os atributos do tipoFuncao existente
            existingTipoFuncao.get().setFuncao(tipoFuncao.getFuncao());

            // Salva o tipoFuncao atualizado
            TipoFuncao updatedTipoFuncao = tipoFuncaoService.createTipoFuncao(existingTipoFuncao.get());

            return ResponseEntity.ok(updatedTipoFuncao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoFuncao(@PathVariable Long id) {
        tipoFuncaoService.deleteTipoFuncao(id);
        return ResponseEntity.noContent().build();
    }

    // Adicione aqui os endpoints adicionais conforme necessário
}
