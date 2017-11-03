package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Persona;
import entities.TipoElemento;

public class DataTipoElemento {
	
	public ArrayList<TipoElemento> getAll(){
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
					tipoelementos.add(te);
				}
			} 
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return tipoelementos;
	}

	public TipoElemento getById(TipoElemento t){
		TipoElemento tipoelemento = new TipoElemento();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idTipo, descripcion, cantDiasMax from tipoelemento where idTipo = ?");
			stmt.setInt(1, t.getIdTipo());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){	
				tipoelemento.setIdTipo(rs.getInt("idTipo"));
				tipoelemento.setDescTipo(rs.getString("descripcion"));
				tipoelemento.setCantdiasMax(rs.getInt("cantDiasMax"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tipoelemento;
	}
	
	public void add(TipoElemento tipoe){
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into tipoelemento(descripcion, cantDiasMax) values (?,?)"
					);
			stmt.setString(1, tipoe.getDescTipo().toString());
			stmt.setInt(2, tipoe.getCantdiasMax());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void update(TipoElemento tipo) {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"update tipoelemento set descripcion = ?, cantDiasMax = ? where idTipo = ?");
			stmt.setString(1, tipo.getDescTipo());
			stmt.setInt(2, tipo.getCantdiasMax());	
			stmt.setInt(3, tipo.getIdTipo());
			stmt.executeUpdate();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	public void delete(TipoElemento tipo) {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"delete from tipoelemento where idTipo = ?");
			stmt.setInt(1, tipo.getIdTipo());
			stmt.executeUpdate();			
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
