package com.example.tuan.services;

import com.example.tuan.enums.EmployeeStatus;
import com.example.tuan.models.Employee;
import com.example.tuan.repositories.EmployeeRepository;


import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeService(){
        employeeRepository= new EmployeeRepository();
    }
    public Employee add(Employee e){
        employeeRepository.add(e);
        return e;
    }

    public void deleteEmployee(long id, EmployeeStatus es){
        Employee e =  employeeRepository.findById(id);
        e.setStatus(es);
    }

    public Employee updateEmployee(Employee e){
        employeeRepository.update(e);
        return e;
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.getAll();
    }

    public Employee findEmployeeById(long id){
        return employeeRepository.findById(id);
    }
}
