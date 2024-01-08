package com.sistema.gestionEmpleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.gestionEmpleados.model.Department;
import com.sistema.gestionEmpleados.repository.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	//Metodo que muestra todos los empleados de la empresa
	public List<Department> listAll() {
		return departmentRepository.findAll();
	}
}
