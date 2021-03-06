package data;

import entities.TipoElemento;
import util.AppDataException;
import entities.Elemento;
import entities.Persona;

import java.sql.*;
import java.util.ArrayList;


public class DataElemento {
	
	public void add(Elemento el) throws AppDataException{
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into elemento(ubicacion, descripcion, capacidad, idTipo) values (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, el.getUbicacion());
			stmt.setString(2, el.getDescripcion());
			stmt.setInt(3, el.getCapacidad());
			stmt.setInt(4, el.getTipo().getIdTipo());
			stmt.executeUpdate();
		} catch (SQLException  e) {
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

	public ArrayList<Elemento> getAll() throws AppDataException{
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Elemento> elementos = new ArrayList<Elemento>();
		try {
			stmt =  FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from elemento");
			if(rs!=null){
				while(rs.next()){
					Elemento t = new Elemento();
					TipoElemento te = new TipoElemento();
					DataTipoElemento dt = new DataTipoElemento();
					t.setIdElemento(rs.getInt("idElemento"));
					t.setUbicacion(rs.getString("ubicacion"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setCapacidad(rs.getInt("capacidad"));
					te.setIdTipo(rs.getInt("idTipo"));
					TipoElemento te2 = new TipoElemento();
					te2 = dt.getById(te);
					t.setTipo(te2);
					elementos.add(t);
					}	
				}
			}catch (Exception e) {
				AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
				throw ape;
			}try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
					throw ape;
					}
			return elementos;
		}
	
	/*public ArrayList<Reserva> getReservas(int idElemento){
	PreparedStatement stmt=null;
	ResultSet rs = null;
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	try{
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement
				("select idReserva, fechaInicio, fechaFin, idElemento  from Reservas where idElemento = ?");
		stmt.setFloat(1, idElemento);
		rs = stmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				Reserva t = new Reserva();
				t.setIdReserva(rs.getInt("idReserva"));
				t.setFechaInicio(rs.getDate("fechaInicio"));
				t.setFechaFin(rs.getDate("fechaFin"));
				t.setIdElemento(rs.getInt("idElemento"));
				reservas.add(t);
				}	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
				}
		return reservas;

	}*/
	
	public Elemento getById(Elemento ele) throws AppDataException{
		Elemento t = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement
			("select idElemento, descripcion, ubicacion, capacidad, idTipo from elemento where idElemento = ?");
			stmt.setInt(1, ele.getIdElemento());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
					t = new Elemento();
					t.setIdElemento(rs.getInt("idElemento"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setUbicacion(rs.getString("ubicacion"));
					t.setCapacidad(rs.getInt("capacidad"));
					t.setTipo(rs.getInt("idTipo"));
					}
			
			
		} catch (SQLException e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			AppDataException ape = new AppDataException(e, "Ha ocurrido un error al eliminar el Tipo.");
			throw ape;
		}
		
		return t;
	}
	
	public ArrayList<Elemento> getByTipo(TipoElemento tipo) throws AppDataException{
		ArrayList<Elemento> listaElementos = new ArrayList<Elemento>();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select idElemento, ubicacion, descripcion, capacidad, idTipo from elemento where idTipo = ?");
			stmt.setInt(1, tipo.getIdTipo());
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Elemento t = new Elemento();
					TipoElemento te = new TipoElemento();
					DataTipoElemento dt = new DataTipoElemento();
					t.setIdElemento(rs.getInt("idElemento"));
					t.setUbicacion(rs.getString("ubicacion"));
					t.setDescripcion(rs.getString("descripcion"));
					t.setCapacidad(rs.getInt("capacidad"));
					te.setIdTipo(rs.getInt("idTipo"));
					TipoElemento te2 = new TipoElemento();
					te2 = dt.getById(te);
					t.setTipo(te2);
					listaElementos.add(t);
					}	
				}
		} catch (SQLException ex) {
			AppDataException ape = new AppDataException(ex, "Ha ocurrido un error al recuperar el Tipo");
			throw ape;
		}
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException ex) {
			AppDataException ape = new AppDataException(ex, "Ha ocurrido un error al recuperar el Tipo");
			throw ape;
		}
		return listaElementos;
	}
	
	
	
	public void delete(Elemento el)throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"delete from elemento where idElemento = ?");
			stmt.setInt(1, el.getIdElemento());
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
	
	
	public void update(Elemento el) throws AppDataException {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"update elemento set ubicacion = ?, descripcion = ?, capacidad = ?, idTipo=? where idElemento = ?");
			stmt.setString(1, el.getUbicacion());
			stmt.setString(2, el.getDescripcion());	
			stmt.setInt(3, el.getCapacidad());
			stmt.setInt(4, el.getTipo().getIdTipo());
			stmt.setInt(5, el.getIdElemento());
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
}