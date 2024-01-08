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
@Table(name="locations")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Localizacion {

	@Id
	@Column(name="LOCATION_ID")
	@JsonProperty("idLocalizacion")
	private Integer idLocalizacion;
	
	@Column(name="STREET_ADDRESS")
	@JsonProperty("direccion")
	private String direccion;

	@Column(name="POSTAL_CODE")
	@JsonProperty("codPostal")
	private String codPostal;
	
	@Column(name="CITY")
	@JsonProperty("ciudad")
	private String ciudad;
	
	@Column(name="STATE_PROVINCE")
	@JsonProperty("provincia")
	private String provincia;
	
	@Column(name="COUNTRY_ID")
	@JsonProperty("idCiudad")
	private String idCiudad;
	
}
