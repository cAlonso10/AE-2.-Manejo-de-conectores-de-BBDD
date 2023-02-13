package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;


public interface DaoCoche {
	boolean alta(Coche c);
	boolean baja(int id);
	Coche obtener(int id);
	boolean modificar(Coche c);
	List<Coche> listar();
}
