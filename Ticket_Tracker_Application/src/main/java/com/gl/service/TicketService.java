package com.gl.service;

import java.util.List;
import com.gl.Entity.Ticket;

public interface TicketService {

	public void addTicket(Ticket t);

	public List<Ticket> getTicketList();

	public void updateTicket(Ticket t, int id);

	public void deleteById(int id);

	public Ticket getById(int id);

	public List<Ticket> searchTickets(String query);
}
