package gestionTickets.g4.devoir.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTickets.g4.devoir.models.Developpeur;
import gestionTickets.g4.devoir.models.Ticket;
import gestionTickets.g4.devoir.models.User;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	public List<Ticket> findByUser(User user);
	public List<Ticket> findByDeveloppeur(Developpeur developpeur);

}
