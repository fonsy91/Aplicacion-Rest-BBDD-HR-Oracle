package com.sistema.gestionEmpleados.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_history")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobHistory {

	@Id
	@Column(name="EMPLOYEE_ID")
	@JsonProperty("idEmpleado")
	private Integer idEmpleado;
	
	@Column(name="START_DATE")
	@Temporal(TemporalType.DATE)
	@JsonProperty("contratacion")
	private Date contratacion;

	@Column(name="END_DATE")
	@Temporal(TemporalType.DATE)
	@JsonProperty("finContratacion")
	private Date finContratacion;
	
	@Column(name="JOB_ID")
	@JsonProperty("idjob")
	private String idjob;
	
	@Column(name="DEPARTMENT_ID")
	@JsonProperty("idDepartment")
	private Integer idDepartment;
}
