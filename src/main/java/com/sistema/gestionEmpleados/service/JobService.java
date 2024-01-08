package com.sistema.gestionEmpleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.gestionEmpleados.model.Job;
import com.sistema.gestionEmpleados.repository.JobRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobService {

	@Autowired
	private JobRepository jobRepository;
	
	//Metodo que muestra todos los empleados de la empresa
	public List<Job> listAll() {
		return jobRepository.findAll();
	}
}
