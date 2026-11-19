package com.example.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {

  @Test
  public void managerShouldStartWithFourHardCodedEmployees() {
    EmployeeManager manager = new EmployeeManager();

    assertNotNull(manager.getAllEmployees());
    assertEquals(4, manager.getAllEmployees().getEmployeeList().size());
  }

  @Test
  public void firstHardCodedEmployeeShouldHaveExpectedData() {
    List<Employee> list = new EmployeeManager().getAllEmployees().getEmployeeList();
    Employee first = list.get(0);

    assertEquals("1", first.getEmployee_id());
    assertEquals("Prem", first.getFirst_name());
    assertEquals("Tiwari", first.getLast_name());
    assertEquals("prem.tiwari@example.com", first.getEmail());
    assertEquals("Software Engineer", first.getTitle());
  }
}
