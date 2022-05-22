package gestionTickets.g4.devoir.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionTickets.g4.devoir.models.Developpeur;
import gestionTickets.g4.devoir.models.Statut;
import gestionTickets.g4.devoir.models.Ticket;
import gestionTickets.g4.devoir.repositories.DeveloppeurRepository;
import gestionTickets.g4.devoir.repositories.TicketRepository;

@RestController
@RequestMapping("/developpeur")
public class DeveloppeurController {

	@Autowired
	DeveloppeurRepository developpeurRepository;
	@Autowired
	TicketRepository ticketRepository;

	// lister les tickets attribués au développeur
	@GetMapping("/{idDeveloppeur}/tickets")
	public List<Ticket> afficherTickets(@PathVariable int idDeveloppeur) {
		Developpeur dev = developpeurRepository.getById(idDeveloppeur);
		if (dev != null) {
			List<Ticket> tickets = ticketRepository.findByDeveloppeur(dev);
			return tickets;
		}
		return null;
	}

	
	//mettre à jour le statut d’un ticket (en cours de traitement, résolu)
	@PostMapping("/{idDev}/{idTicket}/{statut}")
	public void updateStatut(@PathVariable int idDev, @PathVariable int idTicket, @PathVariable int statut) {
		Developpeur dev = developpeurRepository.getById(idDev);
		Ticket ticket = ticketRepository.getById(idTicket);
		if (dev != null && ticket != null) {
			if (ticket.getDeveloppeur().getId() == idDev) {
				if (statut == 0)
					ticket.setStatut(Statut.ENCOURS);
				if (statut == 1)
					ticket.setStatut(Statut.RESOLU);
			}
		}
		ticketRepository.save(ticket);

	}
}
