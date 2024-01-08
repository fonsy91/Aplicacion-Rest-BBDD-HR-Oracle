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
@Table(name="countries")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ciudad {

	@Id
	@Column(name="COUNTRY_ID")
	@JsonProperty("country_id")
	private char country_id;
	
	@Column(name="COUNTRY_NAME")
	@JsonProperty("country_name")
	private String country_name;

	@Column(name="REGION_ID")
	@JsonProperty("region_id")
	private Integer region_id;
}
