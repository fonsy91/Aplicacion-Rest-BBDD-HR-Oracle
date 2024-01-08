package com.sistema.gestionEmpleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

	// https://github.com/YairMendoza95/crud-spring/blob/main/src/main/java/com/indra/bbva/model/EmployeeBean.java
	//http://localhost:8081/
	
	// http://localhost:8081/api/swagger-ui/index.html#/
	// http://localhost:8081/api/listEmpleados
	// http://localhost:8081/api/swagger-ui/index.html#/empleado-controller/listarEmpleados
}
