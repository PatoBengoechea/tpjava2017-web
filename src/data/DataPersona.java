package data;

import java.util.ArrayList;
import java.sql.*;
import entities.*;

public class DataPersona {

	public ArrayList<Persona> getAll(){
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Persona> Personas = new ArrayList<Persona>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from persona");
			if(rs!=null){
				while(rs.next()){
					Persona p=new Persona();
					p.setIdPersona(rs.getInt("idPersona"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.setUsuario(rs.getString("usuario"));
					p.setPassword(rs.getString("password"));
					p.setEncargado(rs.getBoolean("encargado"));
					p.setAdmin(rs.getBoolean("admin"));
					Personas.add(p);
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
	return Personas;
	}
	
	public Persona getByDni(Persona per){
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idPersona, nombre, apellido, dni, habilitado, usuario, password from persona where dni=?");
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					p=new Persona();
					p.setIdPersona(rs.getInt("idPersona"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.setUsuario(rs.getString("usuario"));
					p.setPassword(rs.getString("password"));
					
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
		
		return p;
	}
	
	public Persona getById(Persona per){
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idPersona, nombre, apellido, dni, habilitado, usuario, password, encargado, admin from persona where idPersona = ? ");
			stmt.setInt(1, per.getIdPersona());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					p=new Persona();
					p.setIdPersona(rs.getInt("idPersona"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.setUsuario(rs.getString("usuario"));
					p.setPassword(rs.getString("password"));
					p.setEncargado(rs.getBoolean("encargado"));
					p.setAdmin(rs.getBoolean("admin"));
					return p;
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
		
		return p;
	}

	
	
	
	public void add(Persona p){
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into persona(dni, nombre, apellido, habilitado, usuario, password, encargado, admin) values (?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setBoolean(4, p.isHabilitado());
			stmt.setString(5, p.getUsuario());
			stmt.setString(6, p.getPassword());
			stmt.setBoolean(7, p.isEncargado());
			stmt.setBoolean(8, p.isAdmin());
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

	public void delete(int idper) {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"delete from persona where idPersona = ?");
			stmt.setInt(1, idper);
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
	
	public void update(Persona per) {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"update persona set nombre = ?, apellido = ?, habilitado = ?, usuario=?, password=?, encargado=?, admin=?  where idPersona = ?");
			stmt.setString(1, per.getNombre());
			stmt.setString(2, per.getApellido());	
			stmt.setBoolean(3, per.isHabilitado());
			stmt.setString(4, per.getUsuario());
			stmt.setString(5, per.getPassword());
			stmt.setBoolean(6, per.isEncargado());
			stmt.setBoolean(7, per.isAdmin());
			stmt.setInt(8, per.getIdPersona());
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
	
	
	
//	public Persona getById(Persona per){
//		Persona p=null;
//		PreparedStatement stmt=null;
//		ResultSet rs=null;
//		try {
//			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
//					"select idPersona, nombre, apellido, dni, habilitado from Persona where id=?");
//			stmt.setInt(1, per.getIdPersona());
//			rs=stmt.executeQuery();
//			if(rs!=null && rs.next()){
//					p=new Persona();
//					p.setIdPersona(rs.getInt("idPersona"));
//					p.setNombre(rs.getString("nombre"));
//					p.setApellido(rs.getString("apellido"));
//					p.setDni(rs.getString("dni"));
//					p.setHabilitado(rs.getBoolean("habilitado"));
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			if(rs!=null)rs.close();
//			if(stmt!=null)stmt.close();
//			FactoryConexion.getInstancia().releaseConn();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return p;
//	}
	
	
}
