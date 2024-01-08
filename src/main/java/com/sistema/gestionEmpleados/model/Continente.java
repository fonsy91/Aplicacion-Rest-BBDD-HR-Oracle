package com.sistema.gestionEmpleados.model;


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
@Table(name="regions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Continente {

	@Id
	@Column(name="REGION_ID")
	@JsonProperty("idContinente")
	private Integer idContinente;
	
	@Column(name="REGION_NAME")
	@Temporal(TemporalType.DATE)
	@JsonProperty("nombreContinente")
	private String nombreContinente;
}
