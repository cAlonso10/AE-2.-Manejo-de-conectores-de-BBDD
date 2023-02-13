package vista;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.negocio.GestorCoche;
import modelo.negocio.GestorPasajero;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		GestorCoche gc = new GestorCoche();
		GestorPasajero gp = new GestorPasajero();
		
		 while (opcion != 3) {
		        System.out.println("1- Gestion de coches");
		        System.out.println("2- Gestion de pasajeros");
		        System.out.println("3- Salir");
		        System.out.print("Seleccione una opcion: ");
		        opcion = sc.nextInt();

		        switch (opcion) {
		            case 1:
		                int opcionCoche = 0;
		                while (opcionCoche != 6) {
		                    System.out.println("1- Añadir coche");
		                    System.out.println("2- Borrar coche");
		                    System.out.println("3- Consultar coche");
		                    System.out.println("4- Modificar coche");
		                    System.out.println("5- Listado de coches");
		                    System.out.println("6- Volver al menú");
		                    System.out.print("Seleccione una opcion: ");
		                    opcionCoche = sc.nextInt();

		                    switch (opcionCoche) {
		                        case 1:
		                        	System.out.println("Introduzca los datos del coche (marca/modelo/pasajeros)");
		            				String marca = sc.next();
		            				String modelo = sc.next();
		            				int pasajeros = sc.nextInt();
		            				Coche c = new Coche();
		            				c.setMarca(marca);
		            				c.setModelo(modelo);
		            				c.setPasajeros(pasajeros);
		            				
		            				boolean alta = gc.alta(c);
		            				if(alta) {
		            					System.out.println("Coche dado de alta");
		            				}
		            				break;
		                        case 2:
		                        	System.out.println("Introduzca la ID a borrar");
		            				int id = sc.nextInt();
		            				boolean baja = gc.baja(id);
		            				if(baja) {
		            					System.out.println("Coche dado de baja");
		            				}
		                            break;
		                        case 3:
		                        	System.out.println("Introduzca la ID a consultar");
		          				  int id2 = sc.nextInt();
		          				  Coche obtener = gc.obtener(id2);
		          				  if (obtener != null) {
		          				    System.out.println("ID: " + obtener.getId() + ", Marca: " + obtener.getMarca() + ", Modelo: " + obtener.getModelo());
		          				  } else {
		          				    System.out.println("No se ha encontrado un coche con esa ID");
		          				  }
		                            break;
		                        case 4:
		                        	 System.out.println("Introduzca la ID del coche a modificar");
		           				  int id3 = sc.nextInt();
		           				  Coche cocheModificar = gc.obtener(id3);
		           				  if (cocheModificar != null) {
		           				    System.out.println("Introduzca la nueva marca");
		           				    String nuevaMarca = sc.next();
		           				    System.out.println("Introduzca el nuevo modelo");
		           				    String nuevoModelo = sc.next();
		           				    cocheModificar.setMarca(nuevaMarca);
		           				    cocheModificar.setModelo(nuevoModelo);
		           				    boolean resultado = gc.modificar(cocheModificar);
		           				    if (resultado) {
		           				      System.out.println("Coche modificado correctamente");
		           				    } else {
		           				      System.out.println("Error al modificar el coche");
		           				    }
		           				  } else {
		           				    System.out.println("No se ha encontrado un coche con esa ID");
		           				  }
		                            break;
		                        case 5:
		                        	List<Coche> listaCoches = gc.listar();
		          				  if(listaCoches != null) {
		          				    for(Coche c1 : listaCoches) {
		          				      System.out.println("ID: " + c1.getId() + ", Marca: " + c1.getMarca() + ", Modelo: " + c1.getModelo());
		          				    }
		          				  } else {
		          				    System.out.println("No se ha podido listar los coches");
		          				  }
		                            break;
		                    }
		                }
		                break;
		            case 2:
		                int opcionPasajero = 0;
		                while (opcionPasajero != 8) {
		                    System.out.println("1- Añadir pasajero");
		                    System.out.println("2- Borrar pasajero");
		                    System.out.println("3- Consultar pasajero");
		                    System.out.println("4- Listado de pasajeros");
		                    System.out.println("5- Añadir pasajero a coche");
		                    System.out.println("6- Eliminar pasajero de coche");
		                    System.out.println("7- Listar pasajeros de coche");
		                    System.out.println("8- Volver al menu");
		                    System.out.print("Seleccione una opcion: ");
		                    opcionPasajero = sc.nextInt();

		                    switch (opcionPasajero) {
		                        case 1:
		                        	System.out.println("Introduzca los datos del pasajero (nombre/edad/peso)");
		            				String nombre = sc.next();
		            				int edad = sc.nextInt();
		            				double peso = sc.nextDouble();
		            				Pasajero p = new Pasajero();
		            				p.setNombre(nombre);
		            				p.setEdad(edad);
		            				p.setPeso(peso);
		            				
		            				boolean alta = gp.alta(p);
		            				if(alta) {
		            					System.out.println("Pasajero dado de alta");
		            				}
		                            break;
		                        case 2:
		                        	System.out.println("Introduzca la ID a borrar");
		            				int id = sc.nextInt();
		            				boolean baja = gp.baja(id);
		            				if(baja) {
		            					System.out.println("Persona dada de baja");
		            				}
		                            break;
		                        case 3:
		                        	System.out.println("Introduzca la ID a consultar");
			          				  int id2 = sc.nextInt();
			          				  Pasajero obtener = gp.obtener(id2);
			          				  if (obtener != null) {
			          				    System.out.println("ID: " + obtener.getId() + ", Nombre: " + obtener.getNombre() + ", Edad: " + obtener.getEdad() + ", Peso: " + obtener.getEdad() + ", IdCoche: " + obtener.getCocheId());
			          				  } else {
			          				    System.out.println("No se ha encontrado un coche con esa ID");
			          				  }
		                            break;
		                        case 4:
		                        	List<Pasajero> listaPasajeros = gp.listar();
			          				  if(listaPasajeros != null) {
			          				    for(Pasajero p1 : listaPasajeros) {
			          				    	System.out.println("ID: " + p1.getId() + ", Nombre: " + p1.getNombre() + ", Edad: " + p1.getEdad() + ", Peso: " + p1.getEdad() + ", IdCoche: " + p1.getCocheId());
			          				    }
			          				  } else {
			          				    System.out.println("No se ha podido listar los coches");
			          				  }
		                            break;
		                        case 5:
		                        	 System.out.println("Introduzca la ID del pasajero");
			           				  int idP = sc.nextInt();
			           				  Pasajero pasajeroC = gp.obtener(idP);
			           				  if (pasajeroC != null) {
			           				    System.out.println("Introduzca la id del coche");
			           				    int idC = sc.nextInt();
			           				 pasajeroC.setCocheId(idC);
			           				    boolean resultado = gp.altaC(pasajeroC);
			           				    if (resultado) {
			           				      System.out.println("Coche modificado correctamente");
			           				    } else {
			           				      System.out.println("Error al modificar el coche");
			           				    }
			           				  } else {
			           				    System.out.println("No se ha encontrado un coche con esa ID");
			           				  }
			                            break;
		                        case 6:
		                        	System.out.println("Introduzca la ID del pasajero");
			           				  int idP2 = sc.nextInt();
			           				  Pasajero pasajeroC2 = gp.obtener(idP2);
			           				  if (pasajeroC2 != null) {
			           				    boolean resultado = gp.bajaC(pasajeroC2);
			           				    if (resultado) {
			           				      System.out.println("Coche modificado correctamente");
			           				    } else {
			           				      System.out.println("Error al modificar el coche");
			           				    }
			           				  } else {
			           				    System.out.println("No se ha encontrado un coche con esa ID");
			           				  }
			                            break;
		                        case 7:
		                        	  System.out.println("Introduzca la ID del coche");
		                        	  int idCoche = sc.nextInt();
			           				  Pasajero pasajeroC3 = gp.obtener(idCoche);
		                        	  List<Pasajero> listaPasajerosC = gp.listarC(pasajeroC3);
		                        	  if (listaPasajerosC != null) {
		                        	    System.out.println("Lista de pasajeros en el coche con ID " + idCoche + ":");
		                        	    for (Pasajero pC : listaPasajerosC) {
		                        	    	if(listaPasajerosC != null) {
		                        	        System.out.println("ID: " + pC.getId() + " Nombre: " + pC.getNombre() +
		                        	                           " Edad: " + pC.getEdad() + " Peso: " + pC.getPeso());
		                        	      }
		                        	    }
		                        	  } else {
		                        	    System.out.println("Error al obtener la lista de pasajeros");
		                        	  }
		                        	  break;
		                    }
		                }
		                break;
		        }
		    }
		    sc.close();
		}
		}
		
		