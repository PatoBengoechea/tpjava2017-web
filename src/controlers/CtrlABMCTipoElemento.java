package controlers;

import java.util.ArrayList;

import data.DataTipoElemento;
import entities.TipoElemento;

public class CtrlABMCTipoElemento {
	
	private DataTipoElemento datatipo;
	public CtrlABMCTipoElemento() {
		datatipo = new DataTipoElemento();
	}
	
	public void Add(TipoElemento tipoe)throws Exception {
		datatipo.add(tipoe);
	}
	
	public TipoElemento buscarTipoElemento(TipoElemento tipoe)throws Exception{
		return datatipo.getById(tipoe);
	}
	
	public ArrayList<TipoElemento> getAll()throws Exception{
		return datatipo.getAll();
	}
	
	public ArrayList<TipoElemento> getAllTiposUser()throws Exception{
		return datatipo.getAllTipoUser();
	}
	public void editar(TipoElemento tipo)throws Exception {
		datatipo.update(tipo);		
	}

	public void eliminoTip(TipoElemento tipo) throws Exception {
		datatipo.delete(tipo);
	}
	public TipoElemento getByID(TipoElemento te)throws Exception
	{
		return datatipo.getById(te);
	}


}