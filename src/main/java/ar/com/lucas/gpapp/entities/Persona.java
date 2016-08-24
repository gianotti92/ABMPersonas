package ar.com.lucas.gpapp.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {
private Long id;
private String dni;
private String nombre;
private String apellido;

public Persona() {

}

public Persona(String dni, String nombre, String apellido) {
	this.dni = dni;
	this.nombre = nombre;
	this.apellido = apellido;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}


}
