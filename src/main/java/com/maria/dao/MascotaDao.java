package com.maria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.maria.aplicacion.JPAUtil;
import com.maria.entidades.Mascota;

public class MascotaDao {
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	
	public String registrarMascota(Mascota miMascota) {
		String resp="";
		try {
		entityManager.getTransaction().begin();
		entityManager.persist(miMascota);
		entityManager.getTransaction().commit();
		
		resp="Mascota Registrada!";
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede registrar la mascota verifique que el due?o exista",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
		return resp;
	}
	
	public Mascota consultarMascota(Long idMascota) {
		Mascota miMascota=entityManager.find(Mascota.class, idMascota);
		
		if(miMascota!=null) {
			return miMascota;
		}else {
			return null;
		}
	}
	
	public List<Mascota> consultarListaMascotas(){
		List<Mascota> listaMascotas=new ArrayList<Mascota>();
		Query query=entityManager.createQuery("SELECT m FROM Mascota m");
		listaMascotas=query.getResultList();
		
		return listaMascotas;
	}
	
	public List<Mascota> consultarListaMascotasPorSexo(String sexo){
		List<Mascota> listaMascotas=new ArrayList<Mascota>();
		String sentencia="SELECT m FROM Mascota m WHERE m.sexo= :sexoMascota";
		Query query=entityManager.createQuery(sentencia);
			query.setParameter("sexoMascota", sexo);
		listaMascotas=query.getResultList();
		
		return listaMascotas;
	}
	
	public String actualizarMascota(Mascota miMascota) {
		
		entityManager.getTransaction().begin();
		entityManager.merge(miMascota);
		entityManager.getTransaction().commit();
		
		String resp="Mascota Actualizada";
		
		return resp;
	}
	
	
	public String eliminarMascota(Mascota miMascota) {
		entityManager.getTransaction().begin();
		entityManager.remove(miMascota);
		entityManager.getTransaction().commit();
		
		String resp="Mascota Eliminada";
		return resp;
	}
	
	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}
	
}
