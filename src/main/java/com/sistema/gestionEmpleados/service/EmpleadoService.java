package com.sistema.gestionEmpleados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.gestionEmpleados.model.Empleado;
import com.sistema.gestionEmpleados.repository.EmpleadoRepository;
import com.sistema.gestionEmpleados.repository.EmpleadoRepositoryEspecifico;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@SuppressWarnings("unused")
	@Autowired
	private EmpleadoRepositoryEspecifico empleadoRepositoryEspecifico;
	
	//Metodo que muestra todos los empleados de la empresa
	public List<Empleado> listAll() {
		return empleadoRepository.findAll();
	}
	
	public Optional<Empleado> findEmpleadoById(Integer empleadoId) {
		return empleadoRepository.findById(empleadoId);
	}
	
	public int insertarEmpleado(Empleado empleado) {
		//return this.empleadoRepository.save(empleado);
		return EmpleadoRepositoryEspecifico.insertarEmpleado(empleado);
	}
	
	//Metodo que muestra los sueldos mayores de 15000 Utiliza una consulta oracle Sql especifica 1
	public List<Empleado> listSueldos() {
		return empleadoRepository.sueldosAltos();
	}
	
	//Metodo que devuelve los empleados que su numero de telefono comienza con '6' ocualquier numero su
	//salario es menor a 10000 y su job_id es = a 'ST_MAN por ejemplo'. Utiliza una consulta oracle Sql especifica 2
	public List<Empleado> empleadosEspecificos(String numero, String idJob) {
		return EmpleadoRepositoryEspecifico.empleadosEspecificos(numero, idJob);
	}
	
	
	
	/*
	 * La libreria JpaRepository ofrece una serie de metodos pre hechos estos son: 

		La interfaz JpaRepository en Spring Boot proporciona una variedad de métodos para realizar operaciones de acceso a datos de manera sencilla y eficiente en aplicaciones que utilizan el framework Spring Data JPA. Estos métodos se heredan de varias interfaces que JpaRepository extiende, como PagingAndSortingRepository y CrudRepository, y se complementan con otros métodos definidos por convención de nomenclatura. Algunos de los métodos más comunes que JpaRepository ofrece son:
		
		1. Guardar y actualizar entidades:
		
			save(T entity): Guarda o actualiza una entidad en la base de datos.
			saveAll(Iterable<S> entities): Guarda o actualiza una colección de entidades en la base de datos.
		
		2. Buscar entidades:
		
			findById(ID id): Recupera una entidad por su ID.
			findAll(): Recupera todas las entidades de un tipo.
			findAllById(Iterable<ID> ids): Recupera entidades por una lista de IDs.
			count(): Cuenta el número de entidades en la base de datos.
			existsById(ID id): Verifica si una entidad con un ID dado existe en la base de datos.
		
		3. Eliminar entidades:
		
			delete(T entity): Elimina una entidad de la base de datos.
			deleteById(ID id): Elimina una entidad por su ID.
			deleteAll(): Elimina todas las entidades de un tipo.
			deleteAll(Iterable<? extends T> entities): Elimina una colección de entidades de la base de datos.
		
		4. Métodos de paginación y ordenamiento:
		
			findAll(Pageable pageable): Recupera entidades con paginación y opciones de ordenamiento.
			findAll(Sort sort): Recupera entidades con opciones de ordenamiento.
		
	 * */
}
