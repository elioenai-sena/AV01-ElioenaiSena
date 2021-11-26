package br.ifpe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.dao.AgendaEventosDAO;
import br.ifpe.model.AgendaEventos;

@Service
public class AgendaEventosService {
	
	@Autowired
	AgendaEventosDAO agendaEventosDAO;

	public <S extends AgendaEventos> S salvar(S entity) {
		return agendaEventosDAO.save(entity);
	}

	public List<AgendaEventos> buscarTodos() {
		return agendaEventosDAO.findAll();
	}

	public Optional<AgendaEventos> buscaPorId(Integer id) {
		return agendaEventosDAO.findById(id);
	}

	public void deletar(Integer id) {
		agendaEventosDAO.deleteById(id);
	}
	
	

}
