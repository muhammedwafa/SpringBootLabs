package com.basiony.employeemanager.service;

import com.basiony.employeemanager.exeptions.UserNotFoundException;
import com.basiony.employeemanager.modle.Employee;
import com.basiony.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
/*
    fixme use interfaces
 */
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    //fixme use java doc
    // use dto as a request and a response
    // don't expose Entity to consumer
    //add employee
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    //get a list of employee
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }


    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        // fixme search first for a resource before delete it
        employeeRepository.deleteById(id);
    }

     public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException(
                "user by id"+id + "Was not found"
        ));
     }
}
