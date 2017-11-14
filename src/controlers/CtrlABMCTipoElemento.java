package controlers;

import java.util.ArrayList;

import data.DataTipoElemento;
import entities.TipoElemento;

public class CtrlABMCTipoElemento {
	
	private DataTipoElemento datatipo;
	public CtrlABMCTipoElemento() {
		datatipo = new DataTipoElemento();
	}
	
	public void Add(TipoElemento tipoe) {
		datatipo.add(tipoe);
	}
	
	public TipoElemento buscarTipoElemento(TipoElemento tipoe){
		return datatipo.getById(tipoe);
	}
	
	public ArrayList<TipoElemento> getAll(){
		return datatipo.getAll();
	}

	public void editar(TipoElemento tipo) {
		datatipo.update(tipo);		
	}

	public void eliminoTip(TipoElemento tipo) throws Exception {
		datatipo.delete(tipo);
	}
	public TipoElemento getByID(TipoElemento te)
	{
		return datatipo.getById(te);
	}


}