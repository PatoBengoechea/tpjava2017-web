package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Persona;
import entities.TipoElemento;
import util.AppDataException;

public class DataTipoElemento {
	

	public ArrayList<TipoElemento> getAll() throws AppDataException{
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TipoElemento> tipoelementos = new ArrayList<TipoElemento>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipoelemento");
			if(rs!=null){
				while(rs.next()){
					TipoElemento te = new TipoElemento();
					te.setIdTipo(rs.getInt("idTipo"));
					te.setDescTipo(rs.getString("descripcion"));
					te.setCantdiasMax(rs.getInt("cantDiasMax"));
					te.setSoloEnc(rs.getBoolean("soloenc"));
					te.setDiasmaxanti(rs.getInt("diasmaxanti"));
					tipoelementos.add(te);
				}
			} 
		}catch (Exception e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
	return tipoelementos;
	}

	public TipoElemento getById(TipoElemento t) throws AppDataException{
		TipoElemento tipoelemento = new TipoElemento();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idTipo, descripcion, cantDiasMax, soloenc, diasmaxanti from tipoelemento where idTipo = ?");
			stmt.setInt(1, t.getIdTipo());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){	
				tipoelemento.setIdTipo(rs.getInt("idTipo"));
				tipoelemento.setDescTipo(rs.getString("descripcion"));
				tipoelemento.setCantdiasMax(rs.getInt("cantDiasMax"));
				tipoelemento.setSoloEnc(rs.getBoolean("soloenc"));
				tipoelemento.setDiasmaxanti(rs.getInt("diasmaxanti"));
			}
		} catch (SQLException e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
		return tipoelemento;
	}
	
	public void add(TipoElemento tipoe) throws AppDataException{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into tipoelemento(descripcion, cantDiasMax, soloenc, diasmaxanti) values (?,?,?,?)"
					);
			stmt.setString(1, tipoe.getDescTipo().toString());
			stmt.setInt(2, tipoe.getCantdiasMax());
			stmt.setBoolean(3, tipoe.isSoloEnc());
			stmt.setInt(4, tipoe.getDiasmaxanti());
			stmt.executeUpdate();
		} catch (SQLException e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
	}

	
	public void update(TipoElemento tipo) throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"update tipoelemento set descripcion = ?, cantDiasMax = ?, soloenc= ?, diasmaxanti = ? where idTipo = ?");
			stmt.setString(1, tipo.getDescTipo());
			stmt.setInt(2, tipo.getCantdiasMax());
			stmt.setBoolean(3, tipo.isSoloEnc());
			stmt.setInt(4, tipo.getDiasmaxanti());
			stmt.setInt(5, tipo.getIdTipo());
			stmt.executeUpdate();
			}
		catch (SQLException e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
	
	}
	public void delete(TipoElemento tipo) throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"delete from tipoelemento where idTipo = ?");
			stmt.setInt(1, tipo.getIdTipo());
			stmt.executeUpdate();			
			}
		catch (Exception e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (Exception e) {
			AppDataException ape2 = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape2;
		}
	}

	public ArrayList<TipoElemento> getAllTipoUser() throws AppDataException{
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TipoElemento> tipoelementos = new ArrayList<TipoElemento>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipoelemento where soloenc = 0");
			if(rs!=null){
				while(rs.next()){
					TipoElemento te = new TipoElemento();
					te.setIdTipo(rs.getInt("idTipo"));
					te.setDescTipo(rs.getString("descripcion"));
					te.setCantdiasMax(rs.getInt("cantDiasMax"));
					te.setSoloEnc(rs.getBoolean("soloenc"));
					te.setDiasmaxanti(rs.getInt("diasmaxanti"));
					tipoelementos.add(te);
				}
			} 
		}catch (Exception e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
	return tipoelementos;
	}
}
