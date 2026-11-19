package com.example.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EmployeeControllerTest {

  private EmployeeController controller;

  @BeforeEach
  public void setUp() {
    controller = new EmployeeController(new EmployeeManager());
  }

  @Test
  public void getEmployeesShouldReturnAllEmployees() {
    Employees result = controller.getEmployees();

    assertEquals(4, result.getEmployeeList().size());
  }

  @Test
  public void addEmployeeShouldReturnCreatedWithEmployee() {
    Employee newEmployee = new Employee("5", "John", "Doe", "john.doe@example.com", "DevOps Engineer");

    ResponseEntity<Employee> response = controller.addEmployee(newEmployee);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertSame(newEmployee, response.getBody());
  }

  @Test
  public void addEmployeeShouldAddToEmployeeList() {
    Employee newEmployee = new Employee("5", "John", "Doe", "john.doe@example.com", "DevOps Engineer");

    controller.addEmployee(newEmployee);
    Employees result = controller.getEmployees();

    assertEquals(5, result.getEmployeeList().size());
    assertTrue(result.getEmployeeList().contains(newEmployee));
  }
}
