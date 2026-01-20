package com.hpe.hpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.hpe.hpe.service.EmployeeService;
import com.hpe.hpe.model.Employees;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employees> getAllEmployees(){
        return employeeService.getallEmployee();
    }

    @PostMapping
    public Employees createEmployee(@RequestBody Employees employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/{EmployeeId}")
    public Employees getEmployeeById(@PathVariable String EmployeeId){
        return employeeService.getEmployeeById(EmployeeId);
    }
    @PutMapping("/{EmployeeId}")
    public Employees updateEmployee(@PathVariable String EmployeeId, @RequestBody Employees employeeDetails){
        return  employeeService.updateEmployee(EmployeeId, employeeDetails);
    }


    @DeleteMapping("/{EmployeeId}")
    public String deleteEmployee(@PathVariable String EmployeeId){
        return employeeService.deleteEmployee(EmployeeId);
    }
}
