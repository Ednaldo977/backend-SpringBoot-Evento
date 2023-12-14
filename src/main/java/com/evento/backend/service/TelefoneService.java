package com.evento.backend.service;

import com.evento.backend.models.Telefone;
import com.evento.backend.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;

    @Autowired
    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    public List<Telefone> getAllTelefones() {
        return telefoneRepository.findAll();
    }

    public Optional<Telefone> getTelefoneById(Long id) {
        return telefoneRepository.findById(id);
    }

    public Telefone createTelefone(Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    public void deleteTelefone(Long id) {
        telefoneRepository.deleteById(id);
    }

    // Você pode adicionar métodos adicionais conforme necessário

}

