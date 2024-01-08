package com.sistema.gestionEmpleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.gestionEmpleados.model.JobHistory;
import com.sistema.gestionEmpleados.service.JobHistoryService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class JobHistoryController {


	@Autowired
	private JobHistoryService jobHistoryService;
	
	@Operation(summary = "Lista de todos los historiales de empleados")
	@GetMapping("listaHistorialEmpleados")
	public ResponseEntity<List<JobHistory>> listarHistorialEmpleado() {
		
		List<JobHistory> historialEmpleados = jobHistoryService.listAll();
		
		if(historialEmpleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		// Si todo va bien devuelve empleados y OK
		return new ResponseEntity<>(historialEmpleados, HttpStatus.OK);
	}
}
