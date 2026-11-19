package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

  private final Employees employees;

  public EmployeeManager() {
    List<Employee> list = new ArrayList<>();
    list.add(new Employee("1", "Prem", "Tiwari", "prem.tiwari@example.com", "Software Engineer"));
    list.add(new Employee("2", "Vikash", "Kumar", "vikash.kumar@example.com", "Data Analyst"));
    list.add(new Employee("3", "Ritesh", "Ojha", "ritesh.ojha@example.com", "Project Manager"));
    list.add(new Employee("4", "Sara", "Lopez", "sara.lopez@example.com", "QA Engineer"));

    employees = new Employees();
    employees.setEmployeeList(list);
  }

  public Employees getAllEmployees() {
    return employees;
  }
}
