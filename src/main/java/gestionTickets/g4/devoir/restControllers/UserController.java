package gestionTickets.g4.devoir.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionTickets.g4.devoir.models.User;
import gestionTickets.g4.devoir.models.Ticket;
import gestionTickets.g4.devoir.repositories.UserRepository;
import gestionTickets.g4.devoir.repositories.TicketRepository;
import gestionTickets.g4.devoir.services.TicketServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	TicketRepository ticketRepository;
	TicketServiceImpl ticketService;

	// liste des tickets du user
	@GetMapping("/{iduser}/tickets")
	public List<Ticket> afficherTickets(@PathVariable int idUser) {
		User user = userRepository.getById(idUser);
		if (user != null) {
			List<Ticket> tickets = ticketRepository.findByUser(user);
			return tickets;
		}
		return null;
	}

	// créer un ticket
	@PostMapping("/{iduser}/ticket")
	public void creerTicket(@PathVariable int idUser, @RequestBody Ticket ticket) {
		ticketService.creerTicket(idUser, ticket);
	}

}
