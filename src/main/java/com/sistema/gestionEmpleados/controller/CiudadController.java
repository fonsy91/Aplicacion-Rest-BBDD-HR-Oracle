package com.sistema.gestionEmpleados.controller;

import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.gestionEmpleados.model.Ciudad;
import com.sistema.gestionEmpleados.service.CiudadService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RestController
@RequestMapping("/ciudades")
@Slf4j
public class CiudadController {

	@Autowired
	private CiudadService ciudadService;
	
	@Bean
    GroupedOpenApi ciudadesApi() {
		return GroupedOpenApi.builder().group("ciudades").pathsToMatch("/ciudades/**").build();
	}
	
	@Operation(summary = "Lista de todos los historiales de empleados")
	@GetMapping("listaCiudades")
	public ResponseEntity<List<Ciudad>> listarCiudades() {
		
		List<Ciudad> ciudades = ciudadService.listAll();
		
		if(ciudades.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		// Si todo va bien devuelve empleados y OK
		return new ResponseEntity<>(ciudades, HttpStatus.OK);
	}
	
	@Operation(summary = "Inserta una nueva ciudad")
	@PostMapping("altaCiudad")
	public ResponseEntity<String> insertarCiudad(@RequestParam String idCiudad, @RequestParam  String nombreCiudad, @RequestParam  Integer idContinente) {
		
		char[] miChar = idCiudad.toCharArray();
		
		if (miChar.length == 2) {
			char charValue = miChar[0]; // Obtiene el primer carácter
		    charValue = (char) (charValue << 8 | miChar[1]); // Concatena el segundo caracter
		}
		
		try {
			ciudadService.insertarCiudad(miChar, nombreCiudad, idContinente);
			return ResponseEntity.ok("Ciudad agregada correctamente");
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al agregar ciudad");
        }
	}
}
