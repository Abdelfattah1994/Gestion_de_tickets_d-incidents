package gestionTickets.g4.devoir.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import gestionTickets.g4.devoir.models.Developpeur;
import gestionTickets.g4.devoir.repositories.DeveloppeurRepository;



@Service
public class DevServiceImpl implements DevService {

	@Autowired
	DeveloppeurRepository devRepository;

	@Override
	public void ajouter(Developpeur dev) {
		devRepository.save(dev);

		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String username=auth.getName();



	}

	@Override
	public List<Developpeur> getDevs() {
		return devRepository.findAll();

	}

	@Override
	public void supprimer(int idDev) {
		devRepository.deleteById(idDev);

	}

	@Override
	public void modifier(Developpeur dev) {
		
		if (devRepository.existsById(dev.getId())) {
			Developpeur d = devRepository.getById(dev.getId());
			d.setNom(dev.getNom());
			d.setDateEmbauche(dev.getDateEmbauche());
			d.setEmail(dev.getEmail());
			d.setGithubLink(dev.getGithubLink());
			devRepository.save(d);
			
		}
		else
			devRepository.save(dev);

	}

	@Override
	public Developpeur getDeveloppeur(int idDev) {
		return devRepository.getById(idDev);
	}

}
