package com.sistema.gestionEmpleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.gestionEmpleados.model.JobHistory;
import com.sistema.gestionEmpleados.repository.JobHistoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobHistoryService {

	@Autowired
	private JobHistoryRepository jobHistoryRepository;
	

	//Metodo que muestra todos las localizaciones de la empresa
	public List<JobHistory> listAll() {
		return jobHistoryRepository.findAll();
	}
}
