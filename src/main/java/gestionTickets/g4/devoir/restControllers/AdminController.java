package gestionTickets.g4.devoir.restControllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionTickets.g4.devoir.models.Developpeur;
import gestionTickets.g4.devoir.models.Ticket;
import gestionTickets.g4.devoir.repositories.AdminRepository;
import gestionTickets.g4.devoir.repositories.DeveloppeurRepository;
import gestionTickets.g4.devoir.repositories.TicketRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private DeveloppeurRepository developpeurRepository;

	// liste des bugs non attribués
	@GetMapping("/tickets")
	public List<Ticket> ticketsNonAttribues() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		List<Ticket> allTickets = ticketRepository.findAll();
		for (Ticket t : allTickets) {
			if (t.getDeveloppeur() == null) {
				tickets.add(t);
			}
		}
		return tickets;
	}

	// attribuer un ticket à un développeur
	@PostMapping("/attribuerTicket/{idDev}/{idTicket}")
	public void attribuerTicket(@PathVariable int idDev, @PathVariable int idTicket) {
		Developpeur dev = developpeurRepository.getById(idDev);
		Ticket ticket = ticketRepository.getById(idTicket);
		List<Ticket> tickets = ticketRepository.findAll();
		if (dev != null && ticket != null) {
			for (Ticket t : tickets) {
				if (ticket.getId() == t.getId()) {
					ticket.setDeveloppeur(dev);
					ticketRepository.save(ticket);
				}
			}

		}

	}

}
