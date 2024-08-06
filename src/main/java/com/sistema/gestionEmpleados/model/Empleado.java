package com.sistema.gestionEmpleados.model;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Empleado {

	// Esta clase representa a la tabla employees de la BBDD HR
	@Id
	@Column(name="EMPLOYEE_ID")
	@NotNull
	@JsonProperty("employee_id")
	private Integer employee_id;
	
	@Column(name="FIRST_NAME")
	@JsonProperty("first_name")
	private String first_name;
	
	@Column(name="LAST_NAME")
	@NotNull
	@JsonProperty("last_name")
	private String last_name;
	
	@Column(name="EMAIL")
	@NotNull
	@JsonProperty("email")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	@JsonProperty("phone_number")
	private String phone_number;
	
	@Column(name="HIRE_DATE")
	@NotNull
	@JsonProperty("hire_date")
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date hire_date;
	
	@Column(name = "JOB_ID")
	@NotNull
	@JsonProperty("job_id")
	private String job_id;
	
	@Column(name = "SALARY")
	@JsonProperty("salary")
	private Double salary;

	@Column(name = "COMMISSION_PCT")
	@JsonProperty("commission_pct")
	private Double commission_pct;

	@Column(name = "MANAGER_ID")
	@JsonProperty("manager_id")
	private Integer manager_id;
	
	@Column(name = "DEPARTMENT_ID")
	@JsonProperty("department_id")
	private Integer department_id;

	//Constructores
	/*
	public Empleado() {
        // Constructor sin argumentos
    }
    */

	/*
	public Empleado(Integer employee_id, String first_name, String last_name, String email, String phone_number,
			Date hire_date, String job_id, Double salary, Double commission_pct, Integer manager_id,
			Integer department_id) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.job_id = job_id;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.manager_id = manager_id;
		this.department_id = department_id;
	}
	*/

	/*
	 * @ManyToOne: se usa para indicar que hay una relacion entre dos entidades como en el 
	 * caso de private DepartmentBean department osea que un un departamento puede tener 
	 * muchos empleados pero cada empleados solo puede tener un departamento.
	 * 
	 * @JoinColumn: especificamos la columna de clave foranea en la tabla de empleados
	 * */
	
}
