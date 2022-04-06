package controlador;


import java.util.ArrayList;

import java.util.List;

import com.maria.dao.MascotaDao;
import com.maria.dao.ProductoDao;
import com.maria.entidades.Mascota;
import com.maria.entidades.Producto;

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

public class Coordinador {

	VentanaPrincipal miVentanaPrincipal;
	RegistrarPersonasGui miRegistrarPersonasGui;
	ListarPersonasGui miListarPersonasGui;
	ActualizarPersonaGui miActualizarPersonaGui;
	ConsultarPersonaGui consultarPersonaGui;
	EliminarPersonaGui eliminarPersonaGui;
	RegistrarProductos miRegistrarProductos;
	ConsultarProductos miConsultarProductos;
	ListarProductos miListarProductos;
	EliminarProductos miEliminarProductos;
	ActualizarProductos miActualizarProductos;
	RegistrarMascotasGui miRegistrarMascotasGui;
	ConsultarMascotasGui miConsultarMascotasGui;
	ActualizarMascotasGui miActualizarMascotasGui;
	ListarMascotasGui miListarMascotasGui;
	EliminarMasctoasGui miEliminarMascotasGui;
	ComprarProductos miComprarProducto;
	ProductoDao miProductoDao;
	MascotaDao miMascotaDao;
	

	
	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public void setRegistrarProductos(RegistrarProductos miRegistrarProductos){

		this.miRegistrarProductos=miRegistrarProductos;
		}
	
	public void setConsultarProductos(ConsultarProductos miConsultarProductos) {
		this.miConsultarProductos=miConsultarProductos;
	}
	
	public void setListarProductos(ListarProductos miListarProducto) {
		this.miListarProductos=miListarProducto;
	}
	
	public void setEliminarProductos(EliminarProductos miEliminarProductos) {
		this.miEliminarProductos=miEliminarProductos;
	}
	
	public void setActualizarProductos(ActualizarProductos miActualizarProductos) {
		this.miActualizarProductos=miActualizarProductos;
	}
	
	public void setProductoDao(ProductoDao miProductoDao) {
		this.miProductoDao=miProductoDao;
		}
	
	public void setComprarProductos(ComprarProductos miComprarProducto) {
		this.miComprarProducto=miComprarProducto;
	}

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		this.miRegistrarPersonasGui=miRegistrarPersonasGui;
	}
	
	public void setEliminarPersona(EliminarPersonaGui eliminarPersonaGui) {
		this.eliminarPersonaGui=eliminarPersonaGui;
	}
	
	public void setConsultarPersonaGUI(ConsultarPersonaGui miConsultarPersonaGui) {
		this.consultarPersonaGui=miConsultarPersonaGui;
	}
	
	public void setListarPersonasGui(ListarPersonasGui miListarPersonasGui) {
		this.miListarPersonasGui = miListarPersonasGui;
	}
	
	public void setActualizarPersonaGui(ActualizarPersonaGui miActualizarPersonaGui) {
		this.miActualizarPersonaGui = miActualizarPersonaGui;	
	}
	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		
		this.miRegistrarMascotasGui=miRegistrarMascotasGui;
		
	}
	public void setConsultarMascotasGui(ConsultarMascotasGui miConsultarMascotasGui) {
		this.miConsultarMascotasGui=miConsultarMascotasGui;		
	}

	public void setActualizarMascotasGui(ActualizarMascotasGui miActualizarMascotasGui) {
		this.miActualizarMascotasGui=miActualizarMascotasGui;
		
	}
	
	public void setListarMascotasGui(ListarMascotasGui miListarMascotasGui) {
		this.miListarMascotasGui=miListarMascotasGui;
		
	}
	
	public void setEliminarMascotasGui(EliminarMasctoasGui miEliminarMascotasGui) {
		this.miEliminarMascotasGui=miEliminarMascotasGui;
		
	}


	public String RegistrarMascotasGui(Mascota miAnimal) {
		return miMascotaDao.registrarMascota(miAnimal);
	}
	
	public void mostrarVentanaRegistroPersonas() {
		miRegistrarPersonasGui.setVisible(true);
	}
	
	public void mostrarVentanaConsultaPersona() {
		consultarPersonaGui.setVisible(true);	
	}
	
	public void mostrarVentanaEliminarPersona() {
		eliminarPersonaGui.setVisible(true);
	}
	
	public void mostrarVentanaActualizarPersona() {
		miActualizarPersonaGui.setVisible(true);
	}
	
	public void mostrarVentanaListarPersonas() {
		miListarPersonasGui.setVisible(true);
	}
	
	
	public void mostrarVentanaRegistroProductos() {
		miRegistrarProductos.setVisible(true);
		
	}
	
	

	public void mostrarVentanaConsultarProductos() {
		miConsultarProductos.setVisible(true);
		
	}
	
	public void mostrarVentanaActualizarProductos() {
		miActualizarProductos.setVisible(true);
		
	}
	
	
	
	public void mostrarVentanaEliminarProductos() {
		miEliminarProductos.setVisible(true);
	}
	
	public void mostrarVentanaRegistroMascotas() {
		miRegistrarMascotasGui.setVisible(true);
		
	}

	public void mostrarVentanaActualizarMascotas() {
		miActualizarMascotasGui.setVisible(true);
		
	}

	public void mostrarVentanaConsultarMascotas() {
		miConsultarMascotasGui.setVisible(true);
		
	}
	
	public void mostrarVentanaListarMascotas() {
		miListarMascotasGui.setVisible(true);
		miListarMascotasGui.listarM();
		
	}

	public void mostrarVentanaEliminarMascotas() {
		miEliminarMascotasGui.setVisible(true);
		
	}
	
	public void mostrarVentanalistarProductos() {
		List<Producto> producto = miProductoDao.consultarListaProductos();
		miListarProductos.llenar(producto);
		miListarProductos.setVisible(true);
		
		}
	
	

	public void mostrarVentanaComprarProductos() {
		miComprarProducto.setVisible(true);
		
	}
	

	}
	

