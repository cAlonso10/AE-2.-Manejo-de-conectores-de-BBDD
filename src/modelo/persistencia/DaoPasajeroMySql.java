package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.persistencia.interfaces.DaoPasajero;

public class DaoPasajeroMySql implements DaoPasajero{
	/*Añadir nuevo pasajero
	Borrar pasajero por id
	Consulta pasajero por id
	Listar todos los pasajeros*/
	private Connection conexion;
	public int opcion;
	
	
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://localhost:3306/coches?serverTimezone=UTC";
		String user = "root";
		String pass = "your_password";
		try {
			conexion = DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean alta(Pasajero p) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "INSERT INTO pasajeros (nombre, edad, peso)"
				+ "VALUES (?, ?, ?);";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getNombre());
			ps.setInt(2, p.getEdad());
			ps.setDouble(3, p.getPeso());

			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				alta = false;
			}
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + p);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}

	@Override
	public boolean baja(int id) {
		if(!abrirConexion()){
			return false;
		}
		boolean borrado = true;
		
		String query = "delete from pasajeros where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);

	
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			System.out.println("No se ha podido dar de baja"
					+ " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado;
	}

	@Override
	public Pasajero obtener(int id) {
		if(!abrirConexion()){
			return null;
		}		
		Pasajero pasajero = null;
		
		String query = "select ID,nombre,edad,peso,coche_id from pasajeros "
				+ "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				pasajero = new Pasajero();
				pasajero.setId(rs.getInt(1));
				pasajero.setNombre(rs.getString(2));
				pasajero.setEdad(rs.getInt(3));
				pasajero.setPeso(rs.getDouble(4));
				pasajero.setCocheId(rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener la "
					+ "persona con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return pasajero;
	}
	
	public Pasajero obtenerPenC(int idCoche) {
		if(!abrirConexion()){
			return null;
		}		
		Pasajero pasajero = null;
		
		String query = "select id,nombre,edad,peso,coche_id from coches.pasajeros" +
				" where coche_id=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, idCoche);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				pasajero = new Pasajero();
				pasajero.setId(rs.getInt(1));
				pasajero.setNombre(rs.getString(2));
				pasajero.setEdad(rs.getInt(3));
				pasajero.setPeso(rs.getDouble(4));
				pasajero.setCocheId(rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener la "
					+ "persona en coche ID " + idCoche);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return pasajero;
	}

	@Override
	public List<Pasajero> listar() {
		if(!abrirConexion()){
			return null;
		}		
		List<Pasajero> listaPasajeros = new ArrayList<>();
		
		String query = "select ID,nombre,edad,peso,coche_id from pasajeros";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Pasajero pasajero = new Pasajero();
				pasajero.setId(rs.getInt(1));
				pasajero.setId(rs.getInt(1));
				pasajero.setNombre(rs.getString(2));
				pasajero.setEdad(rs.getInt(3));
				pasajero.setPeso(rs.getDouble(4));
				pasajero.setCocheId(rs.getInt(5));
				
				listaPasajeros.add(pasajero);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las "
					+ "personas");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaPasajeros;
	}

	@Override
	public boolean altaC(Pasajero p) {
		if(!abrirConexion()){
			return false;
		}
		boolean altaC = true;
		String query = "update pasajeros set coche_id=?" + 
	               " WHERE id=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, p.getCocheId());
			ps.setInt(2, p.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				altaC = false;
			else
				altaC = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al añadir");
			altaC = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return altaC;
	}

	@Override
	public boolean bajaC(Pasajero p) {
		if(!abrirConexion()){
			return false;
		}
		boolean bajaC = true;
		String query = "update pasajeros set coche_id=null" + 
	               " WHERE id=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, p.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				bajaC = false;
			else
				bajaC = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al añadir");
			bajaC = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return bajaC;
	}

	@Override
	public List<Pasajero> listarC(Pasajero p) {
		if(!abrirConexion()){
			return null;
		}		
		List<Pasajero> listaPasajeros = new ArrayList<>();
		
		String query = "select id,nombre,edad,peso,coche_id from coches.pasajeros" +
				" where coche_id=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, p.getCocheId());
			System.out.println(p.getCocheId());
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()){
				Pasajero pasajero = new Pasajero();
				pasajero.setId(rs.getInt(1));
				pasajero.setNombre(rs.getString(2));
				pasajero.setEdad(rs.getInt(3));
				pasajero.setPeso(rs.getDouble(4));
				pasajero.setCocheId(rs.getInt(5));
				
				listaPasajeros.add(pasajero);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las "
					+ "personas");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaPasajeros;
	}



	
	}


	
	
	

	



