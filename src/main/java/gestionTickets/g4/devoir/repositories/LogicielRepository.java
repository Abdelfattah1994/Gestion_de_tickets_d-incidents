package gestionTickets.g4.devoir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTickets.g4.devoir.models.Logiciel;

public interface LogicielRepository extends JpaRepository<Logiciel, Integer> {

}
