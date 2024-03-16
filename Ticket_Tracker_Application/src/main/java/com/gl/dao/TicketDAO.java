package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.Entity.Ticket;

public interface TicketDAO extends JpaRepository<Ticket, Integer> {

	List<Ticket> findByTitleOrDescription(String title, String description);
}
