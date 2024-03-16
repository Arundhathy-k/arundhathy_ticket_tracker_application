package com.gl.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.Entity.Ticket;
import com.gl.dao.TicketDAO;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketDAO dao;

	@Override
	public void addTicket(Ticket t) {
		dao.save(t);

	}

	@Override
	public List<Ticket> getTicketList() {

		return dao.findAll();
	}

	@Override
	public void updateTicket(Ticket t, int id) {
		if (dao.findById(id).isPresent()) {
			Ticket t1 = dao.findById(id).get();
			t1.setContent(t.getContent());
			t1.setDescription(t.getDescription());
			t1.setTitle(t.getTitle());
			dao.save(t1);
		}

	}

	@Override
	public void deleteById(int id) {
		dao.deleteById(id);
	}

	@Override
	public Ticket getById(int id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Ticket> searchTickets(String query) {

		return dao.findByTitleOrDescription(query, query);
	}

}
