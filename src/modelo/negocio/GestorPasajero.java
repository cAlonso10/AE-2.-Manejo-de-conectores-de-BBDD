package modelo.negocio;

import java.util.List;

import modelo.entidad.Pasajero;
import modelo.persistencia.DaoPasajeroMySql;
import modelo.persistencia.interfaces.DaoPasajero;


public class GestorPasajero {
	/*Añadir nuevo pasajero
	Borrar pasajero por id
	Consulta pasajero por id
	Listar todos los pasajeros*/


	private DaoPasajero daoPasajero = (DaoPasajero) new DaoPasajeroMySql();

	public boolean alta(Pasajero p){
		boolean alta = daoPasajero.alta(p);
		return alta;
	}

	public boolean baja(int id){
		boolean baja = daoPasajero.baja(id);
		return baja;
	}

	public Pasajero obtener(int id){
		Pasajero coche = daoPasajero.obtener(id);
		return coche;
	}

	public List<Pasajero> listar(){
		List<Pasajero> listaPersonas = daoPasajero.listar();
		return listaPersonas;
	}
	
	public boolean altaC(Pasajero p) {
		boolean altaC = daoPasajero.altaC(p);
		return altaC;
	}
	
	public boolean bajaC(Pasajero p){
		boolean bajaC = daoPasajero.bajaC(p);
		return bajaC;
	}
	
	public List<Pasajero> listarC(Pasajero p){
		List<Pasajero> listaPersonas = daoPasajero.listarC(p);
		return listaPersonas;
	}
	
}
