import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Bibloteca generico = new Bibloteca();
		Bibloteca nuevoLibro1 = new Bibloteca();
		Bibloteca nuevoLibro2 = new Bibloteca();
		Bibloteca nuevoLibro3 = new Bibloteca();
		Bibloteca nuevoLibro4 = new Bibloteca();
		
		String [] prestamos = {"Registar libro","Rentar libro", "Devolver libro", "Ver estado del libro", "Ver historial", "Salir"};
		
		 String[] libros = {"Libro1","Libro2","Libro3","Libro4"};
	
		 int opcion1 = JOptionPane.showOptionDialog(null, "seleciona libro", null, 0, 0, null, libros, libros[0]);
		 int opcion2= 0;
		 switch (opcion1) {
		case 0:
			generico = nuevoLibro1;
			break;
		case 1:
			generico = nuevoLibro2;
			break;
		case 2:
			generico = nuevoLibro3;
			break;
		case 3:
			generico = nuevoLibro4;
			break;

		
		}
		 JOptionPane.showMessageDialog(null, "Entrando a la base de datos de Lectores felices: ");
		 
		 do {
			 opcion2 = JOptionPane.showOptionDialog(null, "seleciona una operacion", null, 0, 0, null, prestamos, prestamos[0]);
			 
			 
			 switch (opcion2) {
			case 0: 
				if (generico.getnombreLibro().equals("Sin nombre")) {
					JOptionPane.showMessageDialog(null, "Cargando nombre del libro: ");
					generico.RegistarLibro();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "El libro ya esta cargado.");
				}
				break;
			case 1: 
				if (generico.getnombreLibro().equals("Sin nombre")) {
					JOptionPane.showMessageDialog(null, "No se puede registar una renta, debe cargar el nombre del libro primero.");
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Va a rentar: " + generico.getnombreLibro());
					generico.registrarRenta();
					
				}
				break;
			case 2: 
				if (generico.verificacionEstado (true)) {
					
					
					
				}
				else {
					
					generico.registrarDevolucion(LocalDate.now());
				}
				break;
			case 3: 
				JOptionPane.showMessageDialog(null, generico);
				break;
			case 4: 
				generico.verHistorial();
				break;

			
			}
		} while (opcion2 !=5);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	

}
