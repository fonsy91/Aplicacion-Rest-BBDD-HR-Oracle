package com.sistema.gestionEmpleados.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="JOBS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Job {

	@Id
	@Column(name="JOB_ID")
	@JsonProperty("idEmpleo")
	private String idEmpleo;
	
	@Column(name = "JOB_TITLE")
	@JsonProperty("nombreEmpleo")
	private String nombreEmpleo;
	
	@Column(name = "MIN_SALARY")
	@JsonProperty("salarioMin")
	private Integer salarioMin;
	
	@Column(name = "MAX_SALARY")
	@JsonProperty("maxSalary")
	private Integer salariomax;
	
}
