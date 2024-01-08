package com.sistema.gestionEmpleados.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DEPARTMENTS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {

	@Id
	@GeneratedValue(generator = "seq")
	@SequenceGenerator(name = "seq", sequenceName = "DEPARTMENTS_SEQ", allocationSize = 10)
	@Column(name = "DEPARTMENT_ID")
	@JsonProperty("idDepartamento")
	private Integer idDepartamento;

	@Column(name = "DEPARTMENT_NAME")
	@JsonProperty("nombreDepartamento")
	private String nombreDepartamento;

	@Column(name = "MANAGER_ID")
	@JsonProperty("idManager")
	private Integer idManager;

	@Column(name = "LOCATION_ID")
	@JsonProperty("idLocalizacion")
	private Integer idLocalizacion;

}
