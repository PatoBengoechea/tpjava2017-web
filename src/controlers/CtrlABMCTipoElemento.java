package controlers;

import java.util.ArrayList;

import data.DataTipoElemento;
import entities.TipoElemento;
import util.AppDataException;

public class CtrlABMCTipoElemento {
	
	private DataTipoElemento datatipo;
	public CtrlABMCTipoElemento() {
		datatipo = new DataTipoElemento();
	}
	
	public void Add(TipoElemento tipoe)throws Exception {
		datatipo.add(tipoe);
	}
	
	public TipoElemento buscarTipoElemento(TipoElemento tipoe)throws AppDataException{
		return datatipo.getById(tipoe);
	}
	
	public ArrayList<TipoElemento> getAll()throws AppDataException{
		return datatipo.getAll();
	}
	
	public ArrayList<TipoElemento> getAllTiposUser()throws AppDataException{
		return datatipo.getAllTipoUser();
	}
	public void editar(TipoElemento tipo)throws AppDataException {
		datatipo.update(tipo);		
	}

	public void eliminoTip(TipoElemento tipo) throws AppDataException {
		datatipo.delete(tipo);
	}
	public TipoElemento getByID(TipoElemento te)throws AppDataException
	{
		return datatipo.getById(te);
	}


}