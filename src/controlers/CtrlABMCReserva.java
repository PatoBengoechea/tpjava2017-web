package controlers;

import java.io.Console;
import java.sql.Date;
import java.util.ArrayList;

import data.DataReserva;
import entities.Reserva;
import util.AppDataException;
import util.Emailer;
import entities.Elemento;
import entities.Persona;

public class CtrlABMCReserva {
	
	private DataReserva datar;
	public CtrlABMCReserva()
	{
		datar = new DataReserva();
	}
	
	
	public String addReserva(Reserva r, int diasmaxres, int diasmaxanti, String mail)throws AppDataException{
		String message = "";
		Date fechaFin = r.getFechaFin();
		Date fechaIni = r.getFechaInicio();
		java.util.Date fechaHoy = new java.util.Date();
		int diasreserva =(int)((fechaFin.getTime()-fechaIni.getTime())/86400000);
		int diasanticipo =(int)((fechaIni.getTime()-fechaHoy.getTime())/86400000);
		int band = 0;
		if(fechaIni.after(fechaFin) || fechaIni.before(fechaHoy)){
			message = "Ingrese nuevamente las fechas por fechas validas. ";
		}
		else{
			if(diasmaxres >= diasreserva && diasmaxanti >= diasanticipo){
				ArrayList<Reserva> reservas = new ArrayList<Reserva>();
				reservas = datar.getAllByIdElem(r);
				for (Reserva res : reservas) {
					if(r.getFechaInicio().after(res.getFechaFin()) || r.getFechaFin().before(res.getFechaInicio()))
					{
						datar.add(r);
						message = "Reserva realizada" ;
						if(mail.isEmpty()){
						message = "Reserva realizada sin mail de comfirmacion";	
						}
						else{
						System.out.println(mail);
						Emailer.getInstance().send(mail,"Reservas", message + "Numero de Reserva: " + r.getIdReserva() +
								" Fecha de Inicio: " + r.getFechaInicio() + " Fecha de Fin: " + r.getFechaFin() + " en el lugar " + r.getElemento().getDescripcion());
						break;
						}
					}
					else
					{
						message = "No se puede realizar la reserva porque ya esta en uso en esa fecha. ";
					}
				}
			}
			else if (diasmaxres < diasreserva){
				message = message + "Sobre pasa los dias  de reserva maximos";
				band = 1;
			}
			else if (diasmaxanti < diasanticipo){
				if(band==0) {
					message = message + "Sobre pasa los dias  de anticipacion";
				}
				else {
					message = message + "Sobre pasa los dias  de anticipacion y los dias reserva max";
				}
			}
		}
		return message;
	}
	
	public ArrayList<Reserva> getAll()throws AppDataException
	{
		return datar.getAll();
	}
	public ArrayList<Reserva> getAll(Elemento e)throws AppDataException
	{
		return datar.getAll(e);
	}
	
	public void delete(Reserva r)throws AppDataException
	{
		datar.delete(r);
	}
	
	public ArrayList<Reserva> getAll(Persona per)throws AppDataException
	{
		return datar.getAll(per);
	}
}
