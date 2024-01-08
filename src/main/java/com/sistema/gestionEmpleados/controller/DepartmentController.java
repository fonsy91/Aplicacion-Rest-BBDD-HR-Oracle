package com.sistema.gestionEmpleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.gestionEmpleados.model.Department;
import com.sistema.gestionEmpleados.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@Operation(summary = "Lista de todos los departamentos")
	@GetMapping("listaDepartamentos")
	public ResponseEntity<List<Department>> listarDepartamentos() {
		
		List<Department> departamentos = departmentService.listAll();
		
		if(departamentos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		// Si todo va bien devuelve empleados y OK
		return new ResponseEntity<>(departamentos, HttpStatus.OK);
	}
}
