package com.sistema.gestionEmpleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.gestionEmpleados.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer>{

}
