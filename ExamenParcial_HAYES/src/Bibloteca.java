import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Bibloteca {

	// Atributos
	private String nombreLibro;
	private boolean estado;
	private String nombreCliente;
	private LocalDate fechaPrestamo;
	private LocalDate fechaDevolucion;
	private int precio;
	private String historial;

	public Bibloteca(String nombreLibro, boolean estado, String nombreCliente, LocalDate fechaPrestamo,
			LocalDate fechaDevolucion, int precio) {
		this.nombreLibro = nombreLibro;
		this.estado = estado;
		this.nombreCliente = nombreCliente;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
		this.precio = precio;
		this.historial = "Historial: \n";

	}

	public Bibloteca() {
		this.nombreLibro = "Sin nombre";
		this.estado = true;
		this.nombreCliente = "No asignado";
		this.fechaPrestamo = null;
		this.fechaDevolucion = null;
		this.precio = 0;
		this.historial = "Historial: \n";

	}

	// Metodos GET
	public String getnombreLibro() {
		return nombreLibro;
	}

	public boolean getestado() {
		return estado;
	}

	public String getnombreCliente() {
		return nombreCliente;
	}

	public LocalDate getfechaPrestamo() {
		return fechaPrestamo;
	}

	public LocalDate getfechaDevolucion() {
		return fechaDevolucion;
	}

	// Metodos Set
	public void setnombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public void estado(boolean estado) {
		this.estado = estado;
	}

	public void nombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public void fechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public void fechaDevolucion(LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;

	}

	public void RegistarLibro() {

		this.nombreLibro = validarCaracteres("Ingrese el nombre del libro: ");

	}

	public void registrarLibro() {
		this.nombreLibro = validarCaracteres("Ingrese el nombre del libro: ");
	}

	public void registrarRenta() {
		this.nombreLibro = getnombreLibro();
		this.nombreCliente = validarCaracteres("Ingrese el nombre del cliente: ");
		this.estado = validarEstado(this.estado);
		this.fechaPrestamo = LocalDate.now();
		this.fechaDevolucion = LocalDate.now().plusDays(8);
		this.precio = validarNumeros("Ingrese precio");
		this.historial = this.historial + "\nNombre del libro: " + getnombreLibro()+ "\nFecha prestamo: " + getfechaPrestamo() + "\nFecha devolucion: "
				+ getfechaDevolucion() + "\n Nombre cliente: " + getnombreCliente();
	}

	public void registrarDevolucion(LocalDate fechaDevolucionReal) {
		this.nombreLibro = getnombreLibro();
		this.nombreCliente = getnombreCliente();
		this.estado = true;
		this.fechaDevolucion = fechaDevolucionReal;
		verificarDevolucionTardia(fechaDevolucionReal);

	}

	public boolean verificarDevolucionTardia(LocalDate fechaDevolucionReal) {
		
		//UNICO BUG
		if (verificacionEstado(true)) {
			
			if (fechaDevolucionReal.isAfter(this.fechaDevolucion)) {
				JOptionPane.showMessageDialog(null, "El cliente esta atrasado y debe abonar $100");
			}
			else {
				JOptionPane.showMessageDialog(null, "Devolucion en tiempo correcto, gracias por elegirnos!");
			}
			return false;
			}
		else {
			
			return true;
			
		}
	}

	public String validarCaracteres(String mensaej) {
		String palabra = "";
		while (palabra.equals("")) {
			palabra = JOptionPane.showInputDialog(mensaej);
		}
		return palabra;
	}

	public String estadoLibro(boolean estado) {
		if (estado) {
			return "Libro disponible.";

		} else {
			return "Libro rentado.";
		}
	}

	public void verHistorial () {
		JOptionPane.showMessageDialog(null, this.historial);
	}
	
	public boolean verificacionEstado (boolean estado) {
		if (this.estado == true ) {
			JOptionPane.showMessageDialog(null, "El libro no se puede devolver porque esta disponible.");
			return false;
			
		}
		else {
			this.estado=false;
			JOptionPane.showMessageDialog(null, "Devolviendo libro...");
			return true;
		}
		
	}
	
	public boolean validarEstado (boolean estado) {
		if (this.estado == true ) {
			
			return false;
			
		}
		else {
			
			return true;
		}
		
	}
	
	public int validarNumeros(String mensaje) {
		boolean flag ;
		String num ="" ;
		do {
			flag =true;
			num = JOptionPane.showInputDialog(mensaje);
			while (num.isEmpty()) {
				num = JOptionPane.showInputDialog(mensaje);
			}
			for (int i = 0; i < num.length(); i++) {
				if (!Character.isDigit(num.charAt(i))) {
					flag = false;
					break;
				}
			}
		} while (!flag);
		
		return Integer.parseInt(num);
	}
	
	
	@Override
	public String toString() {
		return "Bibloteca Lectores felices: \n Nombre del libro:" + nombreLibro + "\n Estado: " + estadoLibro(estado)
				+ "\nNombre cliente: " + nombreCliente + "\nFecha prestamo: " + fechaPrestamo + "\nFecha devolucion: "
				+ fechaDevolucion + "\nPrecio: " + precio;
	}

}
