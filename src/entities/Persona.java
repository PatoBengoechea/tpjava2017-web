package entities;

import java.io.Serializable;

public class Persona implements Serializable {
	
	private String nombre;
	private String apellido;
	private String dni;
	private boolean habilitado;
	private int idPersona;
	private String usuario;
	private String password;
	private boolean encargado;
	private boolean admin;


	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public boolean isEncargado() {
		return encargado;
	}

	public void setEncargado(boolean habilitado) {
		this.encargado = habilitado;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean habilitado) {
		this.admin = habilitado;
	}
	
	public boolean estaVacio()
		{
		if(this.getUsuario().equals("vacio") &&
		this.getPassword().equals("vacio")){
			return true;
		}
	return false;		
	}
	
	
	public Persona() {
		
	}
	
	public Persona(String usu, String contra) {
		this.nombre = "";
		this.apellido = "";
		this.dni = "";
		this.habilitado = true;
		this.usuario = usu;
		this.password = contra;
	}
	
	public Persona(String nom, String ape, String dni, String usu, String contra) {
		this.nombre = nom;
		this.apellido = ape;
		this.dni = dni;
		this.habilitado = true;
		this.usuario = usu;
		this.password = contra;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getIdPersona() {
		return idPersona;
	}
	
	public String getIdPersonaString() {
		return String.valueOf(idPersona);
	}
	
	public void setIdPersona(int id) {
		this.idPersona = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
