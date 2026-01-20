package com.hpe.hpe.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hpe.hpe.model.Employees;
import com.hpe.hpe.repository.EmployeeRepository;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    public Employees createEmployee(Employees employee) {
        return employeeRepository.save(employee);
    }

    public List<Employees> getallEmployee(){
        return employeeRepository.findAll();
    }

    public Employees getEmployeeById(String EmployeeId){
        return employeeRepository.findById(EmployeeId).orElseThrow(()-> new RuntimeException("Employee not found"));
    }
    public Employees updateEmployee(String EmployeeId,Employees employeeDetails){
        Employees employee = employeeRepository.findById(EmployeeId).orElseThrow(()-> new RuntimeException("Employee not found"));

        employee.setFirst_name(employeeDetails.getFirst_name());
        employee.setLast_name(employeeDetails.getLast_name());
        employee.setEmail(employeeDetails.getEmail());
        employee.setTitle(employeeDetails.getTitle());

        return employeeRepository.save(employee);
    }

    public String deleteEmployee(String EmployeeId){

        if (!employeeRepository.existsById(EmployeeId)) {
            throw new RuntimeException("Item not found");
        }
        employeeRepository.deleteById(EmployeeId);

        return "Employee Deleted Successfully";
    }

}
