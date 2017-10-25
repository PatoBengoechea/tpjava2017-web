package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import controlers.*;


public class Reserva implements Serializable {
	int idReserva;
	Date fechaInicio;
	Date fechaFin;
	Elemento elemento;
	Persona persona;
	
	public Reserva(Elemento t1, Date datei, Date datef) {
		this.elemento = t1;
		this.fechaInicio = datei;
		this.fechaFin = datef;
	}

	public Reserva(){}
	
	
	public Persona getPersona() {
		return persona;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fInicio) {
		this.fechaInicio = fInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fFin) {
		this.fechaFin = fFin;
	}
	public Elemento getElemento() {
		return elemento;
	}
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
