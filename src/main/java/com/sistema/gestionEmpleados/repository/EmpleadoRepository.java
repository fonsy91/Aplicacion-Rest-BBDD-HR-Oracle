package com.sistema.gestionEmpleados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.gestionEmpleados.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{

	// CONSULTAS PERSONALIZADAS 
	
	//Consulta que devuelve los empleados con un sueldo superior a 15000
	@Query(value = "SELECT * FROM employees WHERE SALARY > 15000", nativeQuery = true)
	List<Empleado> sueldosAltos();
		
	
}
