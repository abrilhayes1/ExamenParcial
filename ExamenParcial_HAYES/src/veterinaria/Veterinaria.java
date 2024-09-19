package veterinaria;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Veterinaria {

	private LocalDate fechaTurno;
	private LocalDate fechaFin;
	private String animal;
	private String nombreDuenio;
	private String motivoConsulta;
	private String internacion;
	private String estadoPaciente;
	private int precioConsulta;

	private String historial;
	private int numTelDuenio;



	public Veterinaria(LocalDate fechaTurno, LocalDate fechaFin, String animal, String nombreDuenio,
			String motivoConsulta, String internacion, String estadoPaciente, int precioConsulta, int numTelDuenio) {
		this.fechaTurno = fechaTurno;
		this.fechaFin = fechaFin;
		this.animal = animal;
		this.nombreDuenio = nombreDuenio;
		this.motivoConsulta = motivoConsulta;
		this.internacion = internacion;
		this.estadoPaciente = estadoPaciente;
		this.precioConsulta = precioConsulta;
		
		this.historial = "Historial \n";
		this.numTelDuenio = numTelDuenio;
	}
	
	public Veterinaria() {
		this.fechaTurno = null;
		this.fechaFin = null;
		this.animal = "Sin asignar";
		this.nombreDuenio = "Sin asignar";
		this.motivoConsulta = "Sin asignar";
		this.internacion = "Sin asignar";
		this.estadoPaciente = "Sin asignar";
		this.precioConsulta = 0;
		this.historial = "Historial \n";
		this.numTelDuenio = 0;
	}
	

	
	//Metodos get
	
	public LocalDate getfechaTurno() {
		return fechaTurno;
	}
	
	public LocalDate getfechaFin() {
		return fechaFin;
	}
	
	public String getanimal () {
		return animal;
	}
	
	public String getnombreDuenio () {
		return nombreDuenio;
	}
	
	public String getmotivoConsulta() {
		return motivoConsulta;
	}
	
	public String getinternacion () {
		return internacion;
	}
	
	public int getprecioConsulta() {
		return precioConsulta;
	}
	

	public String gethistorial () {
		return historial;
	} 
	
	public int getnumTelDuenio () {
		return numTelDuenio;
	}
	
	public String getestadoPaciente() {
		return estadoPaciente;
	}
	
	
	
	//Metodos set 
	
	public void setfechaTurno(LocalDate fechaTurno) {
		this.fechaTurno= fechaTurno;
	}
	
	public void setfechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public void setanimal (String animal) {
		this.animal = animal;
	}
	
	public void setnombreDuenio (String nombre ) {
		this.nombreDuenio = nombre;
	}
	
	public void setmotivoConsulta(String motivo) {
		this.motivoConsulta = motivo;
	}
	
	public void setinternacion (String internacion) {
		this.internacion = internacion;
	}
	
	public void setprecioConsulta(int precio) {
		this.precioConsulta = precio;
	}
	

	
	public void sethistorial (String historial) {
		this.historial = historial;
	} 
	
	public void setnumTelDuenio (int numTel) {
		this.numTelDuenio = numTel;;
	}
	
	
	public void registrarTurno() {
		this.animal = validarCaracteres("Ingrese la especie: ");
		this.fechaTurno = LocalDate.of(validarNumeros("Ingrese año: "), validarNumeros("Ingrese mes: "), validarNumeros("Ingrese dia: "));
		this.nombreDuenio = validarCaracteres("Ingrese nombre y apellido: ");
		this.numTelDuenio = validarNumeros("Ingrese numero de telefono: ");
		this.motivoConsulta = validarCaracteres("Ingrese el motivo del turno: ");
		this.precioConsulta = validarNumeros("Ingrese precio: ");
		this.historial = this.historial + "Fecha de consulta: " + getfechaTurno() + "Nombre y apellido: " + getnombreDuenio()
		+ "Numero de telefono: " + getnumTelDuenio() + "Motivo  de consulta: " + getmotivoConsulta() + "Estado ";
		
	}
	
	public void registrarAnalisis() {
		this.estadoPaciente = validarCaracteres("Ingrese observaciones y/o diagnostico: ");
		this.internacion = validarCaracteres("Necesita internacion: "); 
		
	}
	
	public void darAlta () {
		this.fechaFin = LocalDate.now();
		JOptionPane.showMessageDialog(null, gethistorial());
		
	}
	
	
	
	
	
	
	public String validarCaracteres(String mensaej) {
		String palabra = "";
		while (palabra.equals("")) {
			palabra = JOptionPane.showInputDialog(mensaej);
		}
		return palabra;
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
		return "Veterinaria\n Fecha turno: " + fechaTurno + "\n Fecha alta: " + fechaFin + "\nPaciente: " + animal
				+ "\n Nombre dueño:" + nombreDuenio + "\n Mootivo consulta: " + motivoConsulta + "\n Internacion: "
				+ internacion + "\nEstado paciente: " + estadoPaciente + "\n Total a pagar: " + precioConsulta
				+ "\n Numero de telefono: " + numTelDuenio;
	}
}
