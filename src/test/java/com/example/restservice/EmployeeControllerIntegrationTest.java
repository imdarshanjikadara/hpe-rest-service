package com.example.restservice;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest
@AutoConfigureRestTestClient
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EmployeeControllerIntegrationTest {

  @Autowired
  private RestTestClient restTestClient;

  @Test
  public void getEmployeesShouldReturnListInExpectedJsonFormat() {
    this.restTestClient.get().uri("/employees")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.Employees").isArray()
        .jsonPath("$.Employees.length()").isEqualTo(4)
        .jsonPath("$.Employees[0].employee_id").isEqualTo("1")
        .jsonPath("$.Employees[0].first_name").isEqualTo("Prem")
        .jsonPath("$.Employees[0].last_name").isEqualTo("Tiwari")
        .jsonPath("$.Employees[0].email").isEqualTo("prem.tiwari@example.com")
        .jsonPath("$.Employees[0].title").isEqualTo("Software Engineer");
  }

  @Test
  public void postEmployeeShouldReturnCreatedEmployee() {
    String json = "{\"employee_id\":\"5\",\"first_name\":\"John\",\"last_name\":\"Doe\","
        + "\"email\":\"john.doe@example.com\",\"title\":\"DevOps Engineer\"}";

    this.restTestClient.post().uri("/employees")
        .contentType(MediaType.APPLICATION_JSON)
        .body(json)
        .exchange()
        .expectStatus().isCreated()
        .expectBody()
        .jsonPath("$.employee_id").isEqualTo("5")
        .jsonPath("$.first_name").isEqualTo("John")
        .jsonPath("$.last_name").isEqualTo("Doe")
        .jsonPath("$.email").isEqualTo("john.doe@example.com")
        .jsonPath("$.title").isEqualTo("DevOps Engineer");
  }

  @Test
  public void postedEmployeeShouldAppearInGetEmployees() {
    String json = "{\"employee_id\":\"5\",\"first_name\":\"John\",\"last_name\":\"Doe\","
        + "\"email\":\"john.doe@example.com\",\"title\":\"DevOps Engineer\"}";

    this.restTestClient.post().uri("/employees")
        .contentType(MediaType.APPLICATION_JSON)
        .body(json)
        .exchange()
        .expectStatus().isCreated();

    this.restTestClient.get().uri("/employees")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.Employees.length()").isEqualTo(5)
        .jsonPath("$.Employees[4].employee_id").isEqualTo("5")
        .jsonPath("$.Employees[4].first_name").isEqualTo("John");
  }
}
