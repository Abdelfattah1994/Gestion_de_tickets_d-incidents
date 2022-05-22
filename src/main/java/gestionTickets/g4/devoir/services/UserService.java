package gestionTickets.g4.devoir.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import gestionTickets.g4.devoir.models.User;


public interface UserService extends UserDetailsService {

	void save(User user);

	List<User> liste();

	void supprimer(int id);

	void ajouter(User user);

	void modifier(User user);

	User getUser(int id);
}
