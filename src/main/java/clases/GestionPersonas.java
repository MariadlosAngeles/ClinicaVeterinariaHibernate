package clases;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.maria.dao.PersonaDao;
import com.maria.entidades.Mascota;
import com.maria.entidades.Nacimiento;
import com.maria.entidades.Persona;

public class GestionPersonas {
	PersonaDao miPersonaDao=new PersonaDao();
	
	public GestionPersonas() {
			String menu="MENU DE OPCIONES - GESTION PERSONAS\n\n";
			menu+="1. Registrar persona\n";
			menu+="2. Consultar persona\n";
			menu+="3. Consultar Lista de personas\n";
			menu+="4. Actualizar persona\n";
			menu+="5. Eliminar persona\n";
			menu+="6. Salir\n\n";
			
			int opc=0;
			
			while(opc!=6) {
				opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
				
				switch (opc) {
				case 1: registrar(); break;
				case 2: consultar(); break;
				case 3: consultarLista(); break;
				case 4: actualizarNombre(); break;
				case 5: eliminar(); break;
				case 6: miPersonaDao.close(); break;
					
				}
			}
		}
	
	
	
	private void registrar() {
		Persona miPersona=new Persona();
		miPersona.setIdPersona(Long.parseLong(JOptionPane.showInputDialog("Ingrese el documento de la persona")));
		miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la Persona"));
		miPersona.setTelefono(JOptionPane.showInputDialog("Ingrese el telefono de la persona"));
		miPersona.setProfesion(JOptionPane.showInputDialog("Ingrese la profesion de la persona"));
		miPersona.setTipo(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo")));
		
		miPersona.setNacimiento(obtenerDatosNacimiento());
		
		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog("Desea Registrar una Mascota?"
					+ "\n1.SI\n2.NO"));
			
			if(opc==1) {
				Mascota miMascota=new Mascota();
				miMascota.setIdMascota(null);
				miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la mascota "));
				miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la raza de la mascota"));
				miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de la mascota"));
				miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de su mascota"));
				miMascota.setDuenio(miPersona);
				
				miPersona.getListaMascotas().add(miMascota);
			}
		} while (opc!=2);
		
		System.out.println(miPersonaDao.registrarPersona(miPersona));
		System.out.println();
	}
	
	private Nacimiento obtenerDatosNacimiento() {
		int dia=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DIA de nacimiento"));
		int mes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el MES de nacimiento"));
		int anio=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el AÑO de nacimiento"));
		
		Nacimiento datosNacimiento=new Nacimiento();
		datosNacimiento.setIdNacimiento(null);
		datosNacimiento.setFechaNacimiento(LocalDate.of(anio,mes,dia));
		datosNacimiento.setCiudadNacimiento(JOptionPane.showInputDialog("Ingrese la ciudad de nacimiento"));
		datosNacimiento.setDepartamentoNacimiento(JOptionPane.showInputDialog("Ingrese el departamento de nacimiento"));
		datosNacimiento.setPaisNacimiento(JOptionPane.showInputDialog("Ingrese el pais de nacimiento"));
		
		return datosNacimiento;
			
	}
	
	
	private void consultar() {
		Long idPersona=Long.parseLong(JOptionPane.showInputDialog("Ingrese el Id de la persona"));
		
		Persona miPersona=miPersonaDao.consultarPersona(idPersona);
		
		if (miPersona !=null) {
			System.out.println(miPersona);
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro la persona");
		}
		System.out.println();
	}
	
	
	private void consultarLista() {
		System.out.println("Lista de personas");
		List<Persona> listaPersonas=miPersonaDao.consultarListaPersonas();
		
		for (Persona persona: listaPersonas) {
			System.out.println(persona);
		}
		
		
	}
	
	private void actualizarNombre() {
		Long idPersona=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la persona para actualizar el nombre"));
		
		Persona miPersona=miPersonaDao.consultarPersona(idPersona);
		
		if(miPersona!=null) {
			System.out.println(miPersona);
			System.out.println();
			miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la persona"));
			
			System.out.println(miPersonaDao.actualizarPersona(miPersona));
			System.out.println();
			
		}else {
			System.out.println();
			System.out.println("No se encontro la persona");
		}
		
	}
	
	private void eliminar() {
		Long idPersona=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la personas para eliminar"));
		
		Persona miPersona=miPersonaDao.consultarPersona(idPersona);
		
		if(miPersona!=null) {
			System.out.println(miPersona);
			System.out.println();
			
			System.out.println(miPersonaDao.eliminarPersona(miPersona));
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro la persona");
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	}

