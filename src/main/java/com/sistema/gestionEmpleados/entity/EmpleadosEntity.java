package com.sistema.gestionEmpleados.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employees") 
public class EmpleadosEntity implements RowMapper<EmpleadosEntity> {

	@Id
    @Column(name = "EMPLOYEE_ID")
    private Integer employee_id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE")
    private Date hireDate;

    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "SALARY")
    private double salary;

    @Column(name = "COMMISSION_PCT")
    private short comission;

    @Column(name = "MANAGER_ID")
    private Integer managerId;

    @Column(name = "DEPARTMENT_ID")
    private Integer departament;
    

    @Override
    public EmpleadosEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
        EmpleadosEntity empleado = new EmpleadosEntity();
        
        empleado.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
        empleado.setFirstName(rs.getString("FIRST_NAME"));
        empleado.setLastName(rs.getString("LAST_NAME"));
        empleado.setEmail(rs.getString("EMAIL"));
        empleado.setPhoneNumber(rs.getString("PHONE_NUMBER"));
        empleado.setHireDate(rs.getDate("HIRE_DATE"));
        empleado.setJobId(rs.getString("JOB_ID"));
        empleado.setSalary(rs.getDouble("SALARY"));
        empleado.setComission(rs.getShort("COMMISSION_PCT"));
        empleado.setManagerId(rs.getInt("MANAGER_ID"));
        empleado.setDepartament(rs.getInt("DEPARTMENT_ID"));
        
        return empleado;
    }
}
