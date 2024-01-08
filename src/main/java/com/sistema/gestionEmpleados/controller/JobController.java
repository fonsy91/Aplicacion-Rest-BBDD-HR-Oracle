package com.sistema.gestionEmpleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.gestionEmpleados.model.Job;
import com.sistema.gestionEmpleados.service.JobService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class JobController {

	@Autowired
	private JobService jobService;
	
	@Operation(summary = "Lista de todos los Empleos")
	@GetMapping("listaEmpleos")
	public ResponseEntity<List<Job>> listarEmpleos() {
		
		List<Job> jobs = jobService.listAll();
		
		if(jobs.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		// Si todo va bien devuelve empleados y OK
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}
}
