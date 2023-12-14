package com.evento.backend.repository;

import com.evento.backend.models.TipoFuncao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFuncaoRepository extends JpaRepository<TipoFuncao, Long> {
}
