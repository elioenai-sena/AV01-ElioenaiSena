package br.ifpe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifpe.model.AgendaEventos;

public interface AgendaEventosDAO extends JpaRepository<AgendaEventos, Integer> {

}
