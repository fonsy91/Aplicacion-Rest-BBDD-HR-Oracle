package com.sistema.gestionEmpleados.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.gestionEmpleados.entity.EmpleadosEntity;
import com.sistema.gestionEmpleados.model.Empleado;
import com.sistema.gestionEmpleados.service.EmpleadoService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.text.ParseException;
import java.text.SimpleDateFormat;


@Configuration
@Tag(name = "EmpleadoController", description = "Controlador para gestionar empleados")
@RestController
@RequestMapping("/empleados")
@Slf4j
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@Bean
    GroupedOpenApi empleadosApi() {
		return GroupedOpenApi.builder().group("empleados").pathsToMatch("/empleados/**").build();
	}
	
	/*
	 * listarEmpleados
	 * params: 
	 * return: ResponseEntity<List<Empleado>>
	 */
	@Operation(summary = "Lista de todos los empelados")
	@GetMapping("listaEmpleados")
	public ResponseEntity<List<Empleado>> listarEmpleados() {
		
		List<Empleado> empleados = empleadoService.listAll();
		
		if(empleados.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		// Si todo va bien devuelve empleados y OK
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
	
	/*
	 * empleadoById
	 * params: empleadoId
	 * return: ResponseEntity<Empleado>
	 */
	@Operation(summary = "Obtiene un empleado a partir de un ID")
	@GetMapping("empleado/{empleadoId}")
	public ResponseEntity<Empleado> empleadoById(@PathVariable Integer empleadoId) {
		Optional<Empleado> empleadoOpcional = empleadoService.findEmpleadoById(empleadoId);
		
		if(empleadoOpcional.isPresent()) {
			Empleado empleado = empleadoOpcional.get();
	        return new ResponseEntity<>(empleado, HttpStatus.OK);
		} else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * addEmpleado
	 * params: empleado
	 * return: Empleado
	 */
	@Operation(summary = "Inserta un empleado")
	@PostMapping("/altaEmpleado")
	public ResponseEntity<Integer> addEmpleado(@RequestBody Empleado empleado) {

		int idEmpleado = empleadoService.insertarEmpleado(empleado);
		
        if (idEmpleado > 0) {
            return new ResponseEntity<>(idEmpleado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
		
	}
	
	/*
	 * 
		{
		  "employee_id": 210,
		  "first_name": "Carmen",
		  "last_name": "Sanz",
		  "email": "luis@gmail.com",
		  "phone_number": "619224610",
		  "hire_date": "2023-10-23T19:27:25.897Z",
		  "job_id": "MK_MAN",
		  "salary": 20000,
		  "commission_pct": 0.4,
		  "manager_id": 100,
		  "department_id": 90
		}
	 */
	
	
	@Operation(summary = "Lista los sueldos mas altos (Ejemplo de utilizacion sentencia @Query, EmpleadoRepository)")
	@GetMapping("sueldosAltos")
	public ResponseEntity<List<Empleado>> sueldosAltos() {
		List<Empleado> sueldos = empleadoService.listSueldos();
		
		if(sueldos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		// Si todo va bien devuelve empleados y OK
		return new ResponseEntity<>(sueldos, HttpStatus.OK);
	}
	
	@Operation(summary = "Lista Empleados especificos (Ejemplo de utilizacion sentencia especifica StringBuilder, EmpleadoRepositoryEspecifico)")
	@GetMapping("listaEspecificos")
	public ResponseEntity<List<Empleado>> empleadosEspecificos(@RequestParam String primernumTlf, String idJob) {
		List<Empleado> empleadosEspecificos = empleadoService.empleadosEspecificos(primernumTlf, idJob);
		
		if(empleadosEspecificos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		// Si todo va bien devuelve empleados y OK
		return new ResponseEntity<>(empleadosEspecificos, HttpStatus.OK);
	}
	
	
	// http://localhost:8081/api/swagger-ui/index.html#/
	// http://localhost:8081/api/swagger-ui/index.html#/empleado-controller/listarEmpleados


	@Operation(summary = "Nos dice en numero de departamentos que hay a partir del id_department")
	@GetMapping("/numero-department/{numeroDepartment}")
    public Integer obtenerNumeroDepartment(@PathVariable Integer numeroDepartment) {
        return empleadoService.obtenerNumeroDepartment(numeroDepartment);
    }
	
	/*
	 * Datos de entrada ejemplo:
	 * startDate: 2003/06/17
	 * endDate: 2003/06/25
	 */
	@GetMapping("/empleadosEntreDosFechas")
    @Operation(summary = "Nos dice los empleados que hay entre dos fechas")
    public List<EmpleadosEntity> obtenerEmpleadosEntreDosFechas(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy/MM/dd") String fechaInicioStr,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy/MM/dd") String fechaFinStr) throws ParseException {

        // Convertir las fechas de String (yyyy/MM/dd) a Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaInicio = sdf.parse(fechaInicioStr);
        Date fechaFin = sdf.parse(fechaFinStr);

        return empleadoService.obtenerEmpleadosEntreDosFechas(fechaInicio, fechaFin);
    }
	
	
	
	
}
