package com.hpe.hpe.repository;


import com.hpe.hpe.model.Employees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees, String> {

}
