package com.basiony.employeemanager.controller;

import com.basiony.employeemanager.modle.Employee;
import com.basiony.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
/*fixme use
 GET    /employees         to return all employees     returns 200 ok
 POST   /employees         to create a resource        returns 201 created
 GET    /employees/{id}    to return a resource        returns 200 ok
 PUT    /employees/{id}    to update a resource        returns 200 ok with body or 204 no content
 DELETE /employees/{id}    to delete a resource        returns 204 no content
 ------------------------
 don't use verbs on uri like find , add or update
*/
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        //returning a response entity and passing the object to the body, along with status code ok to give 200 to the user.
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getAllEmployees(@PathVariable Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
