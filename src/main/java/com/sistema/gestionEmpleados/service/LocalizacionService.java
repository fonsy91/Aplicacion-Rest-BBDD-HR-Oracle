package com.sistema.gestionEmpleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistema.gestionEmpleados.model.Localizacion;
import com.sistema.gestionEmpleados.repository.LocalizacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocalizacionService {

	@Autowired
	private LocalizacionRepository localizacionRepository;
	

	//Metodo que muestra todos las localizaciones de la empresa
	public List<Localizacion> listAll() {
		return localizacionRepository.findAll();
	}
}
