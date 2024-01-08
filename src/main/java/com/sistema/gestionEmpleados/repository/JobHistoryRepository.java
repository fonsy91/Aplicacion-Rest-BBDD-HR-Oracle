package com.sistema.gestionEmpleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.gestionEmpleados.model.JobHistory;

public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer>{

}
