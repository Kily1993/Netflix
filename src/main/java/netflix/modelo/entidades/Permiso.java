package netflix.modelo.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Permiso {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPer;
	
	
	private String nombrePer;
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="permisos")
	private Set<Persona> persona;

	public Long getIdPer() {
		return idPer;
	}

	public void setIdPer(Long idPer) {
		this.idPer = idPer;
	}

	public String getNombrePer() {
		return nombrePer;
	}

	public void setNombrePer(String nombrePer) {
		this.nombrePer = nombrePer;
	}

	public Set<Persona> getPersona() {
		return persona;
	}

	public void setPersona(Set<Persona> persona) {
		this.persona = persona;
	}
	
	
	
}
