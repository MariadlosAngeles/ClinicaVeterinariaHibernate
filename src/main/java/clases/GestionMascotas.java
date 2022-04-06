package clases;

import java.util.List;

import javax.swing.JOptionPane;

import com.maria.dao.MascotaDao;
import com.maria.entidades.Mascota;
import com.maria.entidades.Persona;


public class GestionMascotas {
	MascotaDao miMascotaDao=new MascotaDao();
	
	public GestionMascotas() {
		String menu="MENU DE OPCIONES - GESTION MASCOTAS\n\n";
		menu+="1. Registrar mascota\n";
		menu+="2. Consultar mascota\n";
		menu+="3. Consultar Lista de mascotas\n";
		menu+="4. Consultar Lista de mascotas por sexo\n";
		menu+="5. Actualizar mascota\n";
		menu+="6. Eliminar mascota\n";
		menu+="7. Salir\n\n";
		
		int opc=0;
		
		while(opc!=7) {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
			case 1: registrar(); break;
			case 2: consultar(); break;
			case 3: consultarLista(); break;
			case 4: consultarListaPorSexo(); break;
			case 5: actualizar(); break;
			case 6: eliminar(); break;
			case 7: miMascotaDao.close(); break;
				
			}
		}
	}
	private void registrar() {
		Mascota miMascota=new Mascota();
		miMascota.setIdMascota(null);
		miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la mascota "));
		miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la raza de la mascota"));
		miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de la mascota"));
		miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de su mascota"));
		
		
		Long idDuenio=Long.parseLong(JOptionPane.showInputDialog("Ingrese el documento del dueño"));
		Persona duenio=new Persona();
		duenio.setIdPersona(idDuenio);
		miMascota.setDuenio(duenio);
		System.out.println(miMascotaDao.registrarMascota(miMascota));
		System.out.println();
		
	}
	
	private void consultar() {
		Long idMascota=Long.parseLong(JOptionPane.showInputDialog("Ingrese el Id de la mascota"));
		
		Mascota miMascota=miMascotaDao.consultarMascota(idMascota);
		
		if(miMascota!=null) {
			System.out.println(miMascota);
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro la mascota");
		}
		
	}
	
	
	private void consultarLista() {
		System.out.println("Lista Mascotas");
		
		List<Mascota> listaMascotas=miMascotaDao.consultarListaMascotas();
		
		for (Mascota mascota: listaMascotas) {
			System.out.println(mascota);
		}
		
	}
	
	private void consultarListaPorSexo() {
		System.out.println("Lista mascotas por Sexo");
		String sexo=JOptionPane.showInputDialog("Ingrese el sexo de la mascota");
		
		List<Mascota> listaMascotas=miMascotaDao.consultarListaMascotasPorSexo(sexo);
		
		for (Mascota mascota: listaMascotas) {
			System.out.println(mascota);
		}
		
	}
	
	private void actualizar() {
		Long idMascota=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la mascota a actualizar"));
		Mascota miMascota=miMascotaDao.consultarMascota(idMascota);
		
		if(miMascota!=null) {
			System.out.println(miMascota);
			System.out.println();
			miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la mascota"));
			miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la raza de la mascota"));
			miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de la mascota"));
			miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de la mascota"));
			
			System.out.println(miMascotaDao.actualizarMascota(miMascota));
			System.out.println();
			
		}else {
			System.out.println();
			System.out.println("No se encontro la mascota");
		}
		System.out.println();
	}
	
	private void eliminar() {
		Long idMascota=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la mascota para eliminar"));
		Mascota miMascota=miMascotaDao.consultarMascota(idMascota);
		
		if(miMascota!=null) {
			System.out.println(miMascota);
			System.out.println();
			System.out.println(miMascotaDao.eliminarMascota(miMascota));
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro la mascota");
		}
		System.out.println();
	}
	
	
	
}
