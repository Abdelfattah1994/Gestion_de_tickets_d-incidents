package gestionTickets.g4.devoir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTickets.g4.devoir.models.Developpeur;

public interface DeveloppeurRepository extends JpaRepository<Developpeur, Integer> {

	
}
