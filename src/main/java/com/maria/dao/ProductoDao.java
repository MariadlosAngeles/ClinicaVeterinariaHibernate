package com.maria.dao;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.maria.aplicacion.JPAUtil;
import com.maria.entidades.Mascota;
import com.maria.entidades.Persona;
import com.maria.entidades.PersonasProductos;
import com.maria.entidades.Producto;

import controlador.Coordinador;



public class ProductoDao {

	Coordinador miCoordinador;
	Producto miProducto;
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	public String registrarProducto(Producto miProducto) {
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(miProducto);
			entityManager.getTransaction().commit();
			
			resp="Producto Registrado!";
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo registrar el producto", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	
		return resp;
	}
	
	
	public String registrarCompra(PersonasProductos producto) {
		String resp="";
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(producto);
			entityManager.getTransaction().commit();
			
			resp="Se realizo la compra del producto";
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "No se pudo registrar la compra del producto",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			
		}
		
		return resp;
	}
	
	
	//AGREGO YO
	
	public Producto consultarProducto(Long idProducto) {
		Producto miProducto=entityManager.find(Producto.class, idProducto);
		
		if(miProducto!=null) {
			System.out.println("DAO "+miProducto);
			return miProducto;
		}else {
			return null;
		}
	}
	
	
	public List<Producto> consultarListaProductos(){
		List<Producto> listaProductos=new ArrayList<Producto>();
		Query query=entityManager.createQuery("SELECT p FROM Producto p");
		listaProductos=query.getResultList();
		System.out.println(listaProductos);
		return listaProductos;
		
	}
	
	
	
	public String actualizarProducto(Producto miProducto) {
		
		String resp="";
	
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(miProducto);
			entityManager.getTransaction().commit();
			
			resp="Producto Actualizado";
			
		} catch (Exception e) {
			resp="No se pudo actualizar, verifica que exista este producto";
		}
		
		return resp;
	}
	
	
	public String eliminarProducto(Producto miProducto) {
		String resp="";
		try {
			
			entityManager.getTransaction().begin();
			entityManager.remove(miProducto);
			entityManager.getTransaction().commit();
			
			System.out.println("Se elimino el producto");
			resp="Producto Eliminado";
		} catch (Exception e) {
			resp="No se pudo eliminar, verifica que personas no hayan comprado este producto";
		}
		
		return resp;
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}
	
	public void setCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

}
