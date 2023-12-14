package com.evento.backend.service;

import com.evento.backend.models.TipoFuncao;
import com.evento.backend.repository.TipoFuncaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoFuncaoService {

    private final TipoFuncaoRepository tipoFuncaoRepository;

    @Autowired
    public TipoFuncaoService(TipoFuncaoRepository tipoFuncaoRepository) {
        this.tipoFuncaoRepository = tipoFuncaoRepository;
    }

    public List<TipoFuncao> getAllTipoFuncoes() {
        return tipoFuncaoRepository.findAll();
    }

    public Optional<TipoFuncao> getTipoFuncaoById(Long id) {
        return tipoFuncaoRepository.findById(id);
    }

    public TipoFuncao createTipoFuncao(TipoFuncao tipoFuncao) {
        return tipoFuncaoRepository.save(tipoFuncao);
    }

    public void deleteTipoFuncao(Long id) {
        tipoFuncaoRepository.deleteById(id);
    }

    // Adicione métodos adicionais conforme necessário
}
