package com.sistema.gestionEmpleados.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sistema.gestionEmpleados.entity.EmpleadosEntity;
import com.sistema.gestionEmpleados.model.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmpleadoRepositoryEspecifico {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	private static JdbcTemplate jdbcTemplate = new JdbcTemplate();
	
	@Autowired
	private JdbcTemplate jdbcTemplateExpecifico;

    public EmpleadoRepositoryEspecifico(JdbcTemplate jdbcTemplate) {
        EmpleadoRepositoryEspecifico.jdbcTemplate = jdbcTemplate;
    }
	
	//Metodo que devuelve los empleados que su numero de telefono comienza con '6' ocualquier numero su
	//salario es menor a 10000 y su job_id es = a 'ST_MAN por ejemplo'
	public static List<Empleado> empleadosEspecificos(String numero, String idJob) {
		
		StringBuilder consulta = new StringBuilder();
		
		consulta.append(" SELECT * FROM EMPLOYEES ");
	    consulta.append(" WHERE SUBSTR(PHONE_NUMBER, 1, 1) = ? ");
	    consulta.append(" AND SALARY < 10000 ");
	    consulta.append(" AND JOB_ID = ? ");
		
	    return jdbcTemplate.query(consulta.toString(), new Object[]{numero, idJob}, (rs, rowNum) -> new Empleado(
	    		
		        rs.getInt("EMPLOYEE_ID"),
		        rs.getString("FIRST_NAME"),
		        rs.getString("LAST_NAME"),
		        rs.getString("EMAIL"),
		        rs.getString("PHONE_NUMBER"),
		        rs.getDate("HIRE_DATE"),
		        rs.getString("JOB_ID"),
		        rs.getDouble("SALARY"),
		        rs.getDouble("COMMISSION_PCT"),
		        rs.getInt("MANAGER_ID"),
		        rs.getInt("DEPARTMENT_ID")
		        
		));  
	}
	
	
	public static int insertarEmpleado(Empleado empleado) {
		
		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER " +
					 " , HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) " +
					 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		int idEmplaedo = jdbcTemplate.update(
	            sql,
	            empleado.getEmployee_id(),
	            empleado.getFirst_name(),
	            empleado.getLast_name(),
	            empleado.getEmail(),
	            empleado.getPhone_number(),
	            empleado.getHire_date(),
	            empleado.getJob_id(),
	            empleado.getSalary(),
	            empleado.getCommission_pct(),
	            empleado.getManager_id(),
	            empleado.getDepartment_id()
	        );
		
		return idEmplaedo;
	}
	
	/*
	 * obtenerNumeroDepartment: obtiene cuantos department hay con el numero pasado
	 * params: numeroDepartment
	 * return: Integer con cuantos departaments hay con ese numero
	 */
	public Integer obtenerNumeroDepartment(Integer numeroDepartment) {
		
		StringBuilder consulta = new StringBuilder();
		ArrayList<Object> criteriosBusqueda = new ArrayList<>();
		
		consulta.append(" SELECT COUNT(1) FROM EMPLOYEES ");
	    consulta.append(" WHERE DEPARTMENT_ID = ? ");

	    criteriosBusqueda.add(numeroDepartment);
	    
	    return this.jdbcTemplateExpecifico.queryForObject(consulta.toString(), int.class, criteriosBusqueda.toArray());
	}
	
	/*
	 * obtenerEmpleados entre dos fechas de contratacion
	 * params: fecha1
	 * params: fecha2
	 * return: List<Empleado>
	 */
	public List<EmpleadosEntity> obtenerEmpleadosEntreDosFechas(String fechaInicio, String fechaFin){
		
		StringBuilder consulta = new StringBuilder();
		ArrayList<Object> criteriosBusqueda = new ArrayList<>();
		
        consulta.append(" SELECT * FROM EMPLOYEES ");
        consulta.append(" WHERE HIRE_DATE BETWEEN ? AND ? ");
        
        criteriosBusqueda.add(fechaInicio);
        criteriosBusqueda.add(fechaFin);

        // Ejecutar la consulta y devolver la lista de empleados
        return jdbcTemplate.query(consulta.toString(), criteriosBusqueda.toArray(), new EmpleadosEntity());

	}
	
	
	
	
	
	
	
	
	
}
