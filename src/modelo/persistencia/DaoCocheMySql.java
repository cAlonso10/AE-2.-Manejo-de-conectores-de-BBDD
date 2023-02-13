package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.interfaces.DaoCoche;

public class DaoCocheMySql implements DaoCoche{

	private Connection conexion;
	public int opcion;
	
	
	
	public boolean abrirConexion(){
		String url = "jdbc:mysql://127.0.0.1:3306/coches?serverTimezone=UTC";
		String user = "root";
		String pass = "admin";
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
	public boolean alta(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "INSERT INTO coches (marca, modelo, pasajeros)"
				+ "VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setInt(3, c.getPasajeros());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0) {
				alta = false;
			}
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + c);
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
		
		String query = "delete from coches where id = ?";
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
	public Coche obtener(int id) {
		if(!abrirConexion()){
			return null;
		}		
		Coche coche = null;
		
		String query = "select ID,MARCA,MODELO from coches "
				+ "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener la "
					+ "persona con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return coche;
	}



	@Override
	public boolean modificar(Coche c) {
		if(!abrirConexion()){
			return false;
		}
		boolean modificado = true;
		String query = "update coches set marca=?, modelo=? " + 
	               "WHERE ID=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getMarca());
			ps.setString(2, c.getModelo());
			ps.setInt(3, c.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				modificado = false;
			else
				modificado = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al modificar");
			modificado = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return modificado;
	}



	@Override
	public List<Coche> listar() {
		if(!abrirConexion()){
			return null;
		}		
		List<Coche> listaPersonas = new ArrayList<>();
		
		String query = "select ID,MARCA,MODELO from coches";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Coche coche = new Coche();
				coche.setId(rs.getInt(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
				
				listaPersonas.add(coche);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las "
					+ "personas");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaPersonas;
	}


	
	
	

	


}
