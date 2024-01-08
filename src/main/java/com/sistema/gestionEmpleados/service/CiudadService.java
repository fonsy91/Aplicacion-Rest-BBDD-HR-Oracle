package com.sistema.gestionEmpleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.gestionEmpleados.model.Ciudad;
import com.sistema.gestionEmpleados.repository.CiudadRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class CiudadService {

	@Autowired
	private CiudadRepository ciudadRepository;
	

	//Metodo que muestra todos las localizaciones de la empresa
	public List<Ciudad> listAll() {
		return ciudadRepository.findAll();
	}
	
	// Metodo que inserta una nueva ciudad
	public void insertarCiudad(char[] idCiudad, String nombreCiudad, Integer idContinente) {
		ciudadRepository.insertarCiudad(idCiudad, nombreCiudad, idContinente);
	}
}
