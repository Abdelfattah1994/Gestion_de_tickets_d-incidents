package gestionTickets.g4.devoir.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTickets.g4.devoir.models.Admin;
import gestionTickets.g4.devoir.models.Ticket;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	
}
