package gestionTickets.g4.devoir.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date dateOuverture;
	private Date dateCloture;
	private Statut statut;
	private Urgence urgence;
	private String description;
	private String environement;
	@ManyToOne  
	private Logiciel logiciel;
	@ManyToOne
	private User user;
	@ManyToOne
	private Developpeur developpeur;

	public Ticket(int id, Date dateOuverture, Date dateCloture, Statut statut, Urgence urgence, String description,
			String environement, Logiciel logiciel, User user, Developpeur developpeur) {
		this.id = id;
		this.dateOuverture = dateOuverture;
		this.dateCloture = dateCloture;
		this.statut = statut;
		this.urgence = urgence;
		this.description = description;
		this.environement = environement;
		this.logiciel = logiciel;
		this.user = user;
		this.developpeur = developpeur;
	}

	public Logiciel getLogiciel() {
		return logiciel;
	}

	public void setLogiciel(Logiciel logiciel) {
		this.logiciel = logiciel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Developpeur getDeveloppeur() {
		return developpeur;
	}

	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}

	public Ticket() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Date getDateCloture() {
		return dateCloture;
	}

	public void setDateCloture(Date dateCloture) {
		this.dateCloture = dateCloture;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Urgence getUrgence() {
		return urgence;
	}

	public void setUrgence(Urgence urgence) {
		this.urgence = urgence;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnvironement() {
		return environement;
	}

	public void setEnvironement(String environement) {
		this.environement = environement;
	}

}
