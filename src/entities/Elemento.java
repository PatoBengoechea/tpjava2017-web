package entities;

import java.io.Serializable;
import java.util.ArrayList;
import controlers.CtrlABMCTipoElemento;

import entities.Reserva;

public class Elemento implements Serializable {
	private int idElemento;
	private String ubicacion;
	private String descripcion;
	private int capacidad;
	private TipoElemento tipo;
	CtrlABMCTipoElemento ctrl;
	private ArrayList<Reserva> reservas;
	private static int ult = 0;
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public CtrlABMCTipoElemento getCtrl() {
		return ctrl;
	}

	public void setCtrl(CtrlABMCTipoElemento ctrl) {
		this.ctrl = ctrl;
	}

	public static int getUlt() {
		return ult;
	}

	public static void setUlt(int ult) {
		Elemento.ult = ult;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Elemento(){
		ctrl = new CtrlABMCTipoElemento();
	}
	
	public Elemento(String desc, int cap,String ubi,TipoElemento tip  ){
		this.setDescripcion(desc);
		this.setCapacidad(cap);
		this.setUbicacion(ubi);
		this.setTipo(tip);
		this.reservas = new ArrayList<Reserva>();
		}
	
	public TipoElemento getTipo() {
		return tipo;
	}
	public void setTipo(TipoElemento tipo) {
		this.tipo = tipo;
	}
	public void setTipo(int idtipo) throws Exception {
		TipoElemento tipoe = new TipoElemento(idtipo);
		TipoElemento tiponuevo = new TipoElemento();
		tiponuevo = ctrl.buscarTipoElemento(tipoe);
		this.tipo = tiponuevo;
	}
	public int getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(int i) {
		this.idElemento = i;
	}
	public void setIdElemento(String i) {
		this.idElemento = Integer.parseInt(i);
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

}
