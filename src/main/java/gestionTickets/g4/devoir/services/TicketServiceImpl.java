package gestionTickets.g4.devoir.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionTickets.g4.devoir.models.Ticket;
import gestionTickets.g4.devoir.models.User;
import gestionTickets.g4.devoir.repositories.TicketRepository;
import gestionTickets.g4.devoir.repositories.UserRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	public void creerTicket(int idUser, Ticket ticket) {
		User user = userRepository.getById(idUser);
		if(user != null) {
			ticket.setUser(user);
			ticketRepository.save(ticket);
		}
		
	}
	@Override
	public List<Ticket> lesTickets() {
		return ticketRepository.findAll();

	}

	@Override
	public void supprimer(int idTicket) {
		ticketRepository.deleteById(idTicket);

	}

	@Override
	public void ajouter(Ticket Ticket) {
		ticketRepository.save(Ticket);

	}

	@Override
	public void modifier(Ticket ticket) {
		Ticket t = getTicket(ticket.getId());
		if (t != null) {
			t.setDescription(ticket.getDescription());
			t.setDateOuverture(ticket.getDateOuverture());
			t.setDateCloture(ticket.getDateCloture());
			t.setDeveloppeur(ticket.getDeveloppeur());
			t.setEnvironement(ticket.getEnvironement());
			t.setLogiciel(ticket.getLogiciel());
			t.setStatut(ticket.getStatut());
			t.setUrgence(ticket.getUrgence());
			t.setUser(ticket.getUser());
			ticketRepository.save(t);
		}
	}

	@Override
	public Ticket getTicket(int idTicket) {
		if (ticketRepository.existsById(idTicket))
			return ticketRepository.findById(idTicket).get();
		else
			return null;

	}
	
	@Override
	public List<Ticket> lesTicketsByUser(User user) {
		return ticketRepository.findByUser(user);
	}


	
	

}
