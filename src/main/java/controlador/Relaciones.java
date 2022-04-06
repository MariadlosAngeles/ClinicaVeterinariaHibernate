package controlador;

import com.maria.dao.MascotaDao;
import com.maria.dao.ProductoDao;

import gui.ActualizarMascotasGui;
import gui.ActualizarPersonaGui;
import gui.ActualizarProductos;
import gui.ComprarProductos;
import gui.ConsultarMascotasGui;
import gui.ConsultarPersonaGui;
import gui.ConsultarProductos;
import gui.EliminarMasctoasGui;
import gui.EliminarPersonaGui;
import gui.EliminarProductos;
import gui.ListarMascotasGui;
import gui.ListarPersonasGui;
import gui.ListarProductos;
import gui.RegistrarMascotasGui;
import gui.RegistrarPersonasGui;
import gui.RegistrarProductos;
import gui.VentanaPrincipal;

public class Relaciones {

	public Relaciones() {
		
		Coordinador miCoordinador;
		VentanaPrincipal miVentanaPrincipal;
		ProductoDao miProductoDao;
		MascotaDao miAnimalDao;
		RegistrarProductos miRegistrarProductos;
		ConsultarProductos miConsultarProductos;
		ListarProductos miListarProductos;
		EliminarProductos miEliminarProductos;
		ActualizarProductos miActualizarProductos;
		ComprarProductos miComprarProducto;
		RegistrarPersonasGui miRegistrarPersonasGui;
		ListarPersonasGui miListarPersonasGui;
		ActualizarPersonaGui miActualizarPersonasGui;
		EliminarPersonaGui miEliminarPersonaGui;
		ConsultarPersonaGui miConsultarPersonaGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		ConsultarMascotasGui miConsultarMascotasGui;
		ActualizarMascotasGui miActualizarMascotasGui;
		ListarMascotasGui miListarMascotasGui;
		EliminarMasctoasGui miEliminarMascotasGui;

		miVentanaPrincipal= new VentanaPrincipal();
		miRegistrarProductos= new RegistrarProductos(miVentanaPrincipal, true);
		miConsultarProductos=new ConsultarProductos(miVentanaPrincipal,true);
		miListarProductos=new ListarProductos(miVentanaPrincipal,true);
		miEliminarProductos=new EliminarProductos(miVentanaPrincipal,true);
		miActualizarProductos=new ActualizarProductos(miVentanaPrincipal,true);
		miRegistrarPersonasGui= new RegistrarPersonasGui(miVentanaPrincipal, true);
		miListarPersonasGui= new ListarPersonasGui();
		miActualizarPersonasGui = new ActualizarPersonaGui(miVentanaPrincipal,true);
		miConsultarPersonaGui=new ConsultarPersonaGui(miVentanaPrincipal, true);
		miEliminarPersonaGui=new EliminarPersonaGui (miVentanaPrincipal,true);
		miRegistrarMascotasGui = new RegistrarMascotasGui(miVentanaPrincipal,true);
		miConsultarMascotasGui = new ConsultarMascotasGui(miVentanaPrincipal, true);
		miActualizarMascotasGui = new ActualizarMascotasGui(miVentanaPrincipal, true);
		miListarMascotasGui = new ListarMascotasGui();
		miEliminarMascotasGui = new EliminarMasctoasGui(miVentanaPrincipal, true);
		miComprarProducto = new ComprarProductos(miVentanaPrincipal,true);
		
		miCoordinador= new Coordinador();
		miProductoDao= new ProductoDao();
		miAnimalDao= new MascotaDao();
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setRegistrarProductos(miRegistrarProductos);
		miCoordinador.setConsultarProductos(miConsultarProductos);
		miCoordinador.setListarProductos(miListarProductos);
		miCoordinador.setEliminarProductos(miEliminarProductos);
		miCoordinador.setActualizarProductos(miActualizarProductos);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setListarPersonasGui(miListarPersonasGui);
		miCoordinador.setActualizarPersonaGui(miActualizarPersonasGui);
		miCoordinador.setConsultarPersonaGUI(miConsultarPersonaGui);
		miCoordinador.setEliminarPersona(miEliminarPersonaGui);
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setActualizarMascotasGui(miActualizarMascotasGui);
		miCoordinador.setConsultarMascotasGui(miConsultarMascotasGui);
		miCoordinador.setListarMascotasGui(miListarMascotasGui);
		miCoordinador.setEliminarMascotasGui(miEliminarMascotasGui);
		miCoordinador.setComprarProductos(miComprarProducto);
		miCoordinador.setProductoDao(miProductoDao);
		
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarProductos.setCoordinador(miCoordinador);
		miConsultarProductos.setCoordinador(miCoordinador);
		miListarProductos.setCoordinador(miCoordinador);
		miEliminarProductos.setCoordinador(miCoordinador);
		miActualizarProductos.setCoordinador(miCoordinador);
		miComprarProducto.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miListarPersonasGui.setCoordinador(miCoordinador);
		miActualizarPersonasGui.setCoordinador(miCoordinador);
		miConsultarPersonaGui.setCoordinador(miCoordinador);
		miEliminarPersonaGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miConsultarMascotasGui.setCoordinador(miCoordinador);
		miActualizarMascotasGui.setCoordinador(miCoordinador);
		miListarMascotasGui.setCoordinador(miCoordinador);
		miEliminarMascotasGui.setCoordinador(miCoordinador);
		
		
		
		miVentanaPrincipal.setVisible(true);
	}
	
}
