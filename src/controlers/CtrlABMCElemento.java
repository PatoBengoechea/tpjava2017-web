package controlers;
import entities.Elemento;
import entities.TipoElemento;

import java.util.ArrayList;

import data.DataElemento;


public class CtrlABMCElemento {
	private DataElemento de;
	public CtrlABMCElemento() {
		de = new DataElemento();
	}
	
	public void Add(Elemento elemento) throws Exception {
		de.add(elemento);
	}
	
	public Elemento buscarElemento(Elemento elemento)throws Exception{
		return de.getById(elemento);
	}
	
	public ArrayList<Elemento> getAll()throws Exception{
		return de.getAll();
	}
	
	public ArrayList<Elemento> getByTipo(TipoElemento te)throws Exception{
		return de.getByTipo(te);
	}
	public void deleteElemento(Elemento e) throws Exception
	{
		de.delete(e);
	}
	
	public Elemento getByID(Elemento el)throws Exception
	{
		return de.getById(el);
	}
	
	public void update(Elemento el)throws Exception
	{
		de.update(el);
	}
}
	
	

