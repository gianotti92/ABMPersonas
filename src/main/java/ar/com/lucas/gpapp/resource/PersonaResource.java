package ar.com.lucas.gpapp.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ar.com.lucas.gpapp.Dao.PersonaDao;
import ar.com.lucas.gpapp.entities.Persona;
import ar.com.lucas.gpapp.exception.DataNotFoundException;

@Path("/personal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonaResource {
	PersonaDao dao;
	
	
	@GET
	@Path("/filter")
	public Persona getPersonaPorDni(@QueryParam("dni")String dni){
		Persona persona;
		if (!(dni.equals(null))) {
			try {
				dao=new PersonaDao();
				 persona = dao.getPersonasPorDni(dni);
				 return persona;
			} catch (Exception e) {
				throw new DataNotFoundException("el dni "+dni+" buscado no se encuentra en nuestros registros");
			}
		}
		return null;
		
	}

	@GET
	public List<Persona> getAllPersonas() {
		try {
			dao = new PersonaDao();
			List<Persona> personas = dao.getAll();
			return personas;

		} catch (Exception e) {
			throw new DataNotFoundException("No se encuentran datos en este momento");
		}
	}

	@GET
	@Path("/{idPersona}")
	public Persona getPersonaById(@PathParam("idPersona") int idPersona) {
		try {
			dao = new PersonaDao();
			Persona p = dao.getPersonaById(idPersona);
			return p;
		} catch (Exception e) {
			throw new DataNotFoundException("id:"+idPersona+" no se encuentra en nuestros registros");
		}

	}

	@POST
	public Persona savePersona(Persona p) {
		try {
			dao = new PersonaDao();
			dao.save(p);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return p;
	}

	@PUT
	@Path("/{idPersona}")
	public Persona updatePersona(@PathParam("idPersona") int idPersona, Persona p) {
		
		try {
			dao = new PersonaDao();
			dao.updatePersona(p, idPersona);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return p;
	}
	@DELETE
	public void deletePersona (Persona p){
		try{
			dao=new PersonaDao();
			dao.deletePersona(p);
		}catch(Exception e){
			throw new DataNotFoundException("id:"+p.getId()+" no se encuentra en nuestros registros");
		}
		
	}

}
