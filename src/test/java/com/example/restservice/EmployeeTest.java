package com.example.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class EmployeeTest {

  @Test
  public void constructorShouldSetAllFields() {
    Employee employee = new Employee("10", "Jane", "Smith", "jane.smith@example.com", "Developer");

    assertEquals("10", employee.getEmployee_id());
    assertEquals("Jane", employee.getFirst_name());
    assertEquals("Smith", employee.getLast_name());
    assertEquals("jane.smith@example.com", employee.getEmail());
    assertEquals("Developer", employee.getTitle());
  }

  @Test
  public void defaultConstructorShouldLeaveFieldsEmpty() {
    Employee employee = new Employee();

    assertNull(employee.getEmployee_id());
    assertNull(employee.getFirst_name());
    assertNull(employee.getLast_name());
    assertNull(employee.getEmail());
    assertNull(employee.getTitle());
  }

  @Test
  public void settersShouldUpdateFields() {
    Employee employee = new Employee();
    employee.setEmployee_id("11");
    employee.setFirst_name("Tom");
    employee.setLast_name("Brown");
    employee.setEmail("tom.brown@example.com");
    employee.setTitle("Tester");

    assertEquals("11", employee.getEmployee_id());
    assertEquals("Tom", employee.getFirst_name());
    assertEquals("Brown", employee.getLast_name());
    assertEquals("tom.brown@example.com", employee.getEmail());
    assertEquals("Tester", employee.getTitle());
  }
}
