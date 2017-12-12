package entities;

import java.awt.Component;
import java.io.Serializable;

public class TipoElemento implements Serializable {
	private int idTipo;
	private String descTipo;
	private int cantdiasMax;
	private boolean soloEnc;
	private int diasmaxanti;
	
	public TipoElemento(){}
	
	public boolean isSoloEnc(){
		return soloEnc;
	}
	
	public int getDiasmaxanti() {
		return diasmaxanti;
	}

	public void setDiasmaxanti(int diasmaxanti) {
		this.diasmaxanti = diasmaxanti;
	}

	public String getSoloEnc(){
		if(soloEnc){
			return "Solo Encargado";
		}
		else{
			return "Usuario/Encargado";
		}
	}

	public void setSoloEnc(boolean soloEnc) {
		this.soloEnc = soloEnc;
	}

	public int getCantdiasMax() {
		return cantdiasMax;
	}

	public void setCantdiasMax(int cant) {
		this.cantdiasMax = cant;
	}

	public TipoElemento(int idtipo){
		this.idTipo = idtipo;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idtipo) {
		this.idTipo = idtipo;
	}

	public String getDescTipo() {
		return descTipo;
	}

	public void setDescTipo(String descTipo) {
		this.descTipo = descTipo;
	}

}


