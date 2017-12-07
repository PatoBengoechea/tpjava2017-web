package controlers;
import entities.Elemento;
import entities.TipoElemento;
import util.AppDataException;

import java.util.ArrayList;

import data.DataElemento;


public class CtrlABMCElemento {
	private DataElemento de;
	public CtrlABMCElemento() {
		de = new DataElemento();
	}
	
	public void Add(Elemento elemento) throws AppDataException {
		de.add(elemento);
	}
	
	public Elemento buscarElemento(Elemento elemento)throws AppDataException{
		return de.getById(elemento);
	}
	
	public ArrayList<Elemento> getAll()throws Exception{
		return de.getAll();
	}
	
	public ArrayList<Elemento> getByTipo(TipoElemento te)throws AppDataException{
		return de.getByTipo(te);
	}
	public void deleteElemento(Elemento e) throws AppDataException
	{
		de.delete(e);
	}
	
	public Elemento getByID(Elemento el)throws AppDataException
	{
		return de.getById(el);
	}
	
	public void update(Elemento el)throws AppDataException
	{
		de.update(el);
	}
}
	
	

