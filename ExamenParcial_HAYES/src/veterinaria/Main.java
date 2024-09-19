package veterinaria;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Veterinaria generico = new Veterinaria();
		
		Veterinaria perro = new Veterinaria();
		Veterinaria gato = new Veterinaria();
		Veterinaria hamster = new Veterinaria();
		
		
		String[] menu1 = { "Agendar turno", "Ver estado de paciente", "Dar de alta", "Agregar diagnostico", "Salir" };
		int opcion1 = 0;
		
		String[] menu2 = { "Perro", "Gato", "Hamster"};
		 int opcion2 = JOptionPane.showOptionDialog(null, "selecione", null, 0, 0, null, menu2, menu2[0]);
		 
		 
		switch (opcion1) {
		case 0:
			generico = perro;
			break;
		case 1:
			generico = gato;
			break;
		case 2:
			generico = hamster;
			break;
		

		
		}
		
		do {
			
			opcion1 = JOptionPane.showOptionDialog(null, "seleciona una opcion", null, 0, 0, null, menu1, menu1[0]);
		switch (opcion1) {
		case 0:
			if (generico.getanimal().equals("Sin asignar")) {
				generico.registrarTurno();
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Esta paciente ya esta siendo atentido.");
			}
			
			
			break;
		case 1:
			JOptionPane.showMessageDialog(null, generico);
			break;
		case 2:
			if (!generico.getanimal().equals("Sin asignar")) {
				generico.darAlta();
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Error. No hay paciente asignado.");
			}
			break;
		case 3:
			if (!generico.getanimal().equals("Sin asignar")) {
				generico.registrarAnalisis();
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Error. No hay paciente asignado.");
			}
			
			break;
		
			}
		} while (opcion1 !=4);
			

		
		
	}

}
