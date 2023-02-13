package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
/*Añadir nuevo pasajero
Borrar pasajero por id
Consulta pasajero por id
Listar todos los pasajeros*/

public interface DaoPasajero {
	boolean alta(Pasajero p);
	boolean baja(int id);
	Pasajero obtener(int id);
	Pasajero obtenerPenC(int idCoche);
	List<Pasajero> listar();
	boolean altaC(Pasajero p);
	boolean bajaC(Pasajero p);
	List<Pasajero> listarC(Pasajero p);
	
}
