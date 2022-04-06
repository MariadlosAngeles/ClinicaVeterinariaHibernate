package clases;

import java.util.List;

import javax.swing.JOptionPane;

import com.maria.dao.ProductoDao;
import com.maria.entidades.Mascota;
import com.maria.entidades.Persona;
import com.maria.entidades.PersonasProductos;
import com.maria.entidades.Producto;

public class GestionProductos {
	ProductoDao miProductoDao=new ProductoDao();
	
	public GestionProductos() {
		String menu="MENU DE OPCIONES - GESTION PRODUCTOS\n\n";
		menu+="1. Registrar Productos\n";
		menu+="2. Consultar Productos\n";
		menu+="3. Consultar Lista de Productos\n";
		menu+="4. Comprar Productos\n";
		menu+="5. Actualizar Productos\n";
		menu+="6. Eliminar Productos\n";
		menu+="7. Salir\n";
		
		int opc=0;
		while (opc!=7){
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
			case 1: registrar(); break;
			case 2: consultar(); break;
			case 3: consultarLista(); break;
			case 4: comprarProductos(); break;
			case 5: actualizar(); break;
			case 6: eliminar(); break;
			case 7: miProductoDao.close(); break;
				
			}
		}
	}
	
	private void comprarProductos() {
		PersonasProductos producto;
		
		Long personaId;
		Long productoId;
		
		int opc=0;
		
		do {
			producto=new PersonasProductos();
			personaId=Long.parseLong(JOptionPane.showInputDialog("Ingrese el documento de la persona"));
			productoId=Long.parseLong(JOptionPane.showInputDialog("Ingrese el codigo de el producto"));
			
			
			producto.setPersonaId(personaId);
			producto.setProductoId(productoId);
			System.out.println(miProductoDao.registrarCompra(producto));
			System.out.println();
			opc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea agregar otro producto"));
			
		} while (opc==1);
		
	}
	//AGREGO YO
	
		private void registrar() {
			Producto miProducto=new Producto();
			miProducto.setIdProducto(null);
			miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nombre de el producto"));
			miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Precio del producto")));
			
			System.out.println(miProductoDao.registrarProducto(miProducto));
			System.out.println();
		}
		
		private void consultar(){
			Long idProducto=Long.parseLong(JOptionPane.showInputDialog("Ingrese el Id de el producto"));
			
			Producto miProducto=miProductoDao.consultarProducto(idProducto);
			
			if(miProducto!=null) {
				System.out.println(miProducto);
				System.out.println();
			}else {
				System.out.println();
				System.out.println("No se encontro el producto");
			}
			
		}
		
		
		private void consultarLista(){
			System.out.println("Lista Productos");
			
			List<Producto> listaProductos=miProductoDao.consultarListaProductos();
			
			for (Producto producto: listaProductos) {
				System.out.println(producto);
			}
		}
		
		
		private void actualizar(){
			Long idProducto=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de el producto a actualizar"));
			Producto miProducto=miProductoDao.consultarProducto(idProducto);
			
			if(miProducto!=null) {
				System.out.println(miProducto);
				System.out.println();
				miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nombre de el producto"));
				miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de el producto")));
				
				System.out.println(miProductoDao.actualizarProducto(miProducto));
				System.out.println();
				
			}else {
				System.out.println();
				System.out.println("No se encontro el producto");
			}
			System.out.println();
		}
		
		
		private void eliminar(){
			Long idProducto=Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de el producto para eliminar"));
			Producto miProducto=miProductoDao.consultarProducto(idProducto);
			
			if(miProducto!=null) {
				System.out.println(miProducto);
				System.out.println();
			//	System.out.println(miProductoDao.eliminarProducto(miProducto));
				System.out.println();
			}else {
				System.out.println();
				System.out.println("No se encontro el producto");
			}
			System.out.println();
		}
}
	
	
	
