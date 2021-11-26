package br.ifpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.model.AgendaEventos;
import br.ifpe.service.AgendaEventosService;

@Controller
public class AgendaEventosController {

	@Autowired
	private AgendaEventosService agendaEventosService;

	@GetMapping("/cadastrarEvento")
	public String cadastrarEvento(AgendaEventos agendaEventos) {
		return "eventoForm";
	}

	@PostMapping("/salvarEvento")
	public String salvarEvento(AgendaEventos agendaEventos) {
		agendaEventosService.salvar(agendaEventos);

		return "index";
	}

	@GetMapping("/listarEvento")
	public String listarEvento(Model model) {
		model.addAttribute("lista", this.agendaEventosService.buscarTodos());

		return "eventoLista";
	}

	@GetMapping("/removerEvento")
	public String removerEvento(Integer id) {
		this.agendaEventosService.deletar(id);

		return "redirect:/listarEvento";
	}

	@GetMapping("/editarEvento")
	public String editarEvento(Integer id, Model model) {

		AgendaEventos eventoParaEditar = this.agendaEventosService.buscaPorId(id).orElse(null);
		model.addAttribute("agendaEventos", eventoParaEditar);

		return "eventoForm";
	}

}
