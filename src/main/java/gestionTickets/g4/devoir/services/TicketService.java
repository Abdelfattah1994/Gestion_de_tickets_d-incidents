package gestionTickets.g4.devoir.services;

import java.util.List;

import gestionTickets.g4.devoir.models.Ticket;
import gestionTickets.g4.devoir.models.User;


public interface TicketService {

	public void creerTicket(int idClient, Ticket ticket);

	public void ajouter(Ticket Ticket);

	public List<Ticket> lesTickets();
	
	public List<Ticket> lesTicketsByUser(User user);

	public void supprimer(int idTicket);

	public void modifier(Ticket Ticket);

	public Ticket getTicket(int idTicket);
	

	
}
