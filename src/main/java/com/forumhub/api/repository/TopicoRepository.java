package com.forumhub.api.repository;

import com.forumhub.api.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime; // Importación necesaria
import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByCursoAndFechaCreacionBetween(String curso, LocalDateTime startDate, LocalDateTime endDate);
}
