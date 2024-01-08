package com.sistema.gestionEmpleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sistema.gestionEmpleados.model.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{

	//CONSULTAS PERSONALIZADAS 
	
	//Consulta que inserta una nueva ciudad 
	@Modifying
	@Query(value="INSERT INTO COUNTRIES (country_id, country_name, region_id) VALUES (?1, ?2, ?3)", nativeQuery = true)
	void insertarCiudad(char[] country_id, String country_name, Integer region_id);
}
