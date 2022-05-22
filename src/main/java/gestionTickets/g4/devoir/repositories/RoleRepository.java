package gestionTickets.g4.devoir.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import gestionTickets.g4.devoir.models.Role;


@Repository
public interface  RoleRepository  extends JpaRepository<Role,Integer>{
	public Role findByNom(String nom);

}
