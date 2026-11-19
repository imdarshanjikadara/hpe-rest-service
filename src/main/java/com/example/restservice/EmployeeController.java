package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  private final EmployeeManager employeeManager;

  public EmployeeController(EmployeeManager employeeManager) {
    this.employeeManager = employeeManager;
  }

  @GetMapping("/employees")
  public Employees getEmployees() {
    return employeeManager.getAllEmployees();
  }

  @PostMapping(path = "/employees", consumes = "application/json")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    employeeManager.getAllEmployees().getEmployeeList().add(employee);
    return new ResponseEntity<>(employee, HttpStatus.CREATED);
  }
}
