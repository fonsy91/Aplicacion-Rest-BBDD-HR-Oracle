package com.sistema.gestionEmpleados.controller;

import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sistema.gestionEmpleados.model.Localizacion;
import com.sistema.gestionEmpleados.service.LocalizacionService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RestController
@RequestMapping("/localizacion")
@Slf4j
public class LocalizacionController {

	@Autowired
	private LocalizacionService localizacionService;
	
	@Bean
    GroupedOpenApi localizacionApi() {
		return GroupedOpenApi.builder().group("localizacion").pathsToMatch("/localizacion/**").build();
	}
	
	@Operation(summary = "Lista de todos las localizaciones")
	@GetMapping("listaLocalizacion")
	public ResponseEntity<List<Localizacion>> listarLocalizaciones() {
		
		List<Localizacion> localizaciones = localizacionService.listAll();
		
		if(localizaciones.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		// Si todo va bien devuelve empleados y OK
		return new ResponseEntity<>(localizaciones, HttpStatus.OK);
	}
}
