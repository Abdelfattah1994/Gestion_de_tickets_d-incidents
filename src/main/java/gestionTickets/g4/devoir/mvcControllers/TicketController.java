package gestionTickets.g4.devoir.mvcControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gestionTickets.g4.devoir.models.Ticket;
import gestionTickets.g4.devoir.services.TicketService;
import gestionTickets.g4.devoir.services.UserService;



@Controller("mvcTicket")
@RequestMapping("/mvctickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private UserService userService;


	@GetMapping
	public ModelAndView liste() {
		ModelAndView m = new ModelAndView("tickets/tickets");
		m.addObject("tickets", ticketService.lesTickets());
		return m;
	}
	
	@GetMapping("/mesticket/{id}") 
	public ModelAndView liste(@PathVariable int id) {
		ModelAndView m = new ModelAndView("tickets/tickets");
		m.addObject("tickets", ticketService.lesTickets());
		return m;
	}

	@GetMapping("/test/{nom}")
	public String action(Model m, @PathVariable String nom) {
		Ticket t = new Ticket();
		t.setId(55);
		t.setDescription("ticket 55");
		m.addAttribute("ticket", t);
		m.addAttribute("nom", nom);
		//m.addAttribute("tache", new Tache());
		return "test";
	}

	@GetMapping("/add")
	public String ajout(Model model) {
		Ticket t = new Ticket();
		model.addAttribute("ticket", t);
		return "tickets/ajout";

	}

	@PostMapping("/add")
	public String enregistrer(@ModelAttribute("ticket") Ticket ticket) {
		Ticket t = ticketService.getTicket(ticket.getId());
		if (t != null)
			ticketService.modifier(ticket);
		else
			ticketService.ajouter(ticket);
		return "redirect:/mvctickets";
	}

	@GetMapping("/edit/{id}")
	public String modifier(@PathVariable int id, Model model) {
		Ticket t = ticketService.getTicket(id);
		if (t != null) {
			model.addAttribute("ticket", t);
			return "tickets/ajout";
		}

		return "redirect:/mvctickets";
	}

	@GetMapping("/delete/{id}")
	public String suppr(@PathVariable int id) {
		ticketService.supprimer(id);
		return "redirect:/mvctickets";
	}

}
