package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employees {

  @JsonProperty("Employees")
  private List<Employee> employeeList;

  public Employees() {
    this.employeeList = new ArrayList<>();
  }

  public List<Employee> getEmployeeList() {
    return employeeList;
  }

  public void setEmployeeList(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }
}
