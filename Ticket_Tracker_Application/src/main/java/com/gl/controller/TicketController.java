package com.gl.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gl.Entity.Ticket;
import com.gl.service.TicketService;

@Controller
@RequestMapping("/admin")
public class TicketController {

	@Autowired
	TicketService service;

	@GetMapping("/tickets")
	public String showListOfTickets(Model m) {
		List<Ticket> list = service.getTicketList();
		m.addAttribute("list", list);
		return "home";
	}

	@GetMapping("/newTicket")
	public String addTickets(Model m) {
		m.addAttribute("t", new Ticket());
		return "addTicket";
	}

	@PostMapping("/saveTicket")
	public String saveTickets(@ModelAttribute("t") Ticket t) {
		service.addTicket(t);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") int id, Model m) {
		Ticket t = service.getById(id);
		m.addAttribute("t", t);
		return "updateTicket";
	}

	@PostMapping("/processUpdate/{id}")
	public String processUpdate(@ModelAttribute("t") Ticket t) {
		int id = t.getId();
		service.updateTicket(t, id);
		return "redirect:/admin/tickets";
	}

	@GetMapping("/view/{id}")
	public String viewTicketById(@PathVariable("id") int id, Model m) {
		Ticket t = service.getById(id);
		m.addAttribute("t", t);
		return "viewTicket";

	}

	@GetMapping("/search")
	public String search(@RequestParam String query, Model m) {
		List<Ticket> searchResults = service.searchTickets(query);
		m.addAttribute("searchResults", searchResults);
		return "searchResults";
	}

}
