package modelo.negocio;

import java.util.List;

import modelo.entidad.Coche;
import modelo.persistencia.DaoCocheMySql;
import modelo.persistencia.interfaces.DaoCoche;


public class GestorCoche {
	

	private DaoCoche daoCoche = (DaoCoche) new DaoCocheMySql();

	public boolean alta(Coche c){
			boolean alta = daoCoche.alta(c);
			return alta;
	}
	
	public boolean baja(int id){
		boolean baja = daoCoche.baja(id);
		return baja;
	}

	public Coche obtener(int id){
		Coche coche = daoCoche.obtener(id);
		return coche;
	}
	
	public boolean modificar(Coche c){
		boolean modificar = daoCoche.modificar(c);
		return modificar;
	}
	
	public List<Coche> listar(){
		List<Coche> listaPersonas = daoCoche.listar();
		return listaPersonas;
	}
	
}
