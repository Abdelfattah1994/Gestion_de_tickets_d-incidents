package gestionTickets.g4.devoir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gestionTickets.g4.devoir.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String name);

}
