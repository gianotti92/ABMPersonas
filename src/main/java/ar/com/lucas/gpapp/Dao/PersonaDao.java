package ar.com.lucas.gpapp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.lucas.gpapp.connection.ConnectionManager;
import ar.com.lucas.gpapp.entities.Persona;



public class PersonaDao {
	private Connection connection;

	public PersonaDao() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		ConnectionManager cm = new ConnectionManager();
		connection = cm.getConnection();
	}

	public List<Persona> getAll() {
		try {
			Statement smt = connection.createStatement();
			ResultSet resu = smt.executeQuery("SELECT * FROM PERSONA");
			List<Persona> listaPersona = new ArrayList<>();
			while (resu.next()) {
				String nombre = resu.getString("nombre");
				String apellido = resu.getString("apellido");
				String dni = resu.getString("dni");
				Persona p = new Persona(dni,nombre,apellido);
				listaPersona.add(p);
			}
			return listaPersona;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}
	
	public void save(Persona p){
		try{
			PreparedStatement psmt = connection.prepareStatement("INSERT INTO PERSONA (NOMBRE,APELLIDO,DNI) values(?,?,?)");	
			psmt.setString(1, p.getNombre());
            psmt.setString(2,p.getApellido());
            psmt.setString(3,p.getDni());
            psmt.execute();
			
		}catch(Exception ex){
			throw new RuntimeException (ex);
		}
	}
	
	public Persona getPersonaById(int id){

		try{
			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM PERSONA WHERE IDPERSONA=?");
			psmt.setInt(1, id);
			ResultSet resu = psmt.executeQuery();
			resu.next();
			Persona persona = new Persona(resu.getString("DNI"),resu.getString("NOMBRE"),resu.getString("APELLIDO"));
			return persona;
			
		}catch(Exception ex){
			throw new RuntimeException (ex);
		}
		
	}
	
	public Persona updatePersona(Persona p,int id){
		try{
			PreparedStatement psmt = connection.prepareStatement("UPDATE PERSONA SET NOMBRE = ? , APELLIDO = ?, DNI = ? where IDPERSONA = 15");
			psmt.setString(1, p.getNombre());
			psmt.setString(2, p.getApellido());
			psmt.setString(3, p.getDni());
			psmt.setLong(4, id);
			psmt.execute();
		return p;	
		
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}
		
	}
	
	public Persona deletePersona(Persona p){
		try{
			PreparedStatement psmt = connection.prepareStatement("DELETE FROM PERSONA WHERE IDPERSONA = ?");
			psmt.setLong(1, p.getId());
			psmt.execute();
			return p;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	
	}

	public Persona getPersonasPorDni(String dni) {
		try{
			PreparedStatement psmt = connection.prepareStatement("SELECT * FROM PERSONA WHERE DNI=?");
			psmt.setString(1, dni);
			ResultSet resu = psmt.executeQuery();
			resu.next();
			Persona persona = new Persona(resu.getString("DNI"),resu.getString("NOMBRE"),resu.getString("APELLIDO"));
			return persona;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}



}
