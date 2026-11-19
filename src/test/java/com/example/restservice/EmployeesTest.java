package com.example.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class EmployeesTest {

  @Test
  public void newEmployeesShouldHaveEmptyList() {
    Employees employees = new Employees();

    assertNotNull(employees.getEmployeeList());
    assertTrue(employees.getEmployeeList().isEmpty());
  }

  @Test
  public void setEmployeeListShouldReplaceList() {
    Employees employees = new Employees();
    List<Employee> list = new ArrayList<>();
    list.add(new Employee("1", "A", "B", "a.b@example.com", "Engineer"));

    employees.setEmployeeList(list);

    assertSame(list, employees.getEmployeeList());
    assertEquals(1, employees.getEmployeeList().size());
  }
}
