package com.sistema.gestionEmpleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.gestionEmpleados.model.Continente;
import com.sistema.gestionEmpleados.repository.ContinenteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContinenteService {

	@Autowired
	private ContinenteRepository continenteRepository;
	

	//Metodo que muestra todos las localizaciones de la empresa
	public List<Continente> listAll() {
		return continenteRepository.findAll();
	}
}
