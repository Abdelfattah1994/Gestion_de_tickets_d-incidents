package gestionTickets.g4.devoir.services;

import java.util.List;

import gestionTickets.g4.devoir.models.Developpeur;


public interface DevService {

	List<Developpeur> getDevs();

	void ajouter(Developpeur dev);


	void supprimer(int idDev);

	void modifier(Developpeur dev);

	Developpeur getDeveloppeur(int idDev);
	
	
}
