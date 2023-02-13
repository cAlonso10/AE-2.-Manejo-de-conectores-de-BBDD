package modelo.entidad;

public class Pasajero {
	private int id;
	private String nombre;
	private int edad;
	private double peso;
	private int cocheId;
	
	public Pasajero(int id, String nombre, int edad, double peso, int cocheId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.cocheId = cocheId;
	}
	
	public Pasajero() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public int getCocheId() {
		return cocheId;
	}
	public void setCocheId(int cocheId) {
		this.cocheId = cocheId;
	}



	@Override
	public String toString() {
		return "Pasajeros [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", idCoche="
				+ cocheId + "]";
	}
	
	
	
	
}
