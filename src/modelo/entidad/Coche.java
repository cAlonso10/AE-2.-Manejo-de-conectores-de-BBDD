package modelo.entidad;

public class Coche {
	private int id;
	private String marca;
	private String modelo;
	private int pasajeros;
	
	public Coche(int id, String marca, String modelo, int pasajeros) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.pasajeros = pasajeros;
	}

	public Coche() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}

	@Override
	public String toString() {
		return "Coches [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", pasajeros=" + pasajeros + "]";
	}
	
	
	
	
}
