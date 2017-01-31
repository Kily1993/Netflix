package netflix.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import netflix.modelo.entidades.Persona;

public interface UsuarioRepositorio extends CrudRepository<Persona, Long> {

	UserDetails findOneByLogin(String usuario);
	
	

}
