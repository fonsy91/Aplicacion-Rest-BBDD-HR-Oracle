package com.sistema.gestionEmpleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.gestionEmpleados.model.Continente;
import com.sistema.gestionEmpleados.service.ContinenteService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ContinenteController {

	@Autowired
	private ContinenteService continenteService;
	
	@Operation(summary = "Lista de todos los continentes")
	@GetMapping("listaContinentes")
	public ResponseEntity<List<Continente>> listarContinentes() {
		
		List<Continente> continentes = continenteService.listAll();
		
		if(continentes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		// Si todo va bien devuelve empleados y OK
		return new ResponseEntity<>(continentes, HttpStatus.OK);
	}
}
