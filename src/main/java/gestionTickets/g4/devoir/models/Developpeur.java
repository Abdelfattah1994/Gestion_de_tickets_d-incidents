package gestionTickets.g4.devoir.models;


import java.util.List;

import javax.persistence.Entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Developpeur extends User {

	private String githubLink;
	private String DateEmbauche;




	public Developpeur(int id, String userName, String password, String email, String phone, String nom, String prenom,
			List<Role> roles, String githubLink, String dateEmbauche) {
		super(id, userName, password, email, phone, nom, prenom, roles);
		this.githubLink = githubLink;
		DateEmbauche = dateEmbauche;
	}

	public String getDateEmbauche() {
		return DateEmbauche;
	}

	public void setDateEmbauche(String dateEmbauche) {
		DateEmbauche = dateEmbauche;
	}

	public Developpeur() {

	}

	public String getGithubLink() {
		return githubLink;
	}

	public void setGithubLink(String githubLink) {
		this.githubLink = githubLink;
	}


	

}
