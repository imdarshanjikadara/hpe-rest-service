# Employee Management REST API - HPE Software Engineering Job Simulation

A RESTful web service built with **Java Spring Boot** that manages a list of employees. It supports querying all employees (`GET`) and adding new employees from JSON (`POST`), and is covered by unit and integration tests.

My work for Hewlett Packard Enterprise's **"Software Engineering"** job simulation on [Forage](https://www.theforage.com/) (completed November 2026).

---

## What I built

The simulation was split into four tasks, each building on the last:

| Task | What I did | Result |
|---|---|---|
| **1. Proposal** | Researched REST principles, Spring Boot and HPE GreenLake, and wrote a design proposal for the service | [`docs/Task1_Proposal.md`](docs/Task1_Proposal.md) |
| **2. GET endpoint** | Built the `Employee`, `Employees`, `EmployeeManager` and `EmployeeController` classes and a `GET /employees` endpoint returning hard-coded employees as JSON | Working read-only API |
| **3. POST endpoint** | Added setters and a `POST /employees` endpoint that accepts JSON and adds a new employee | API supports create + read |
| **4. Testing** | Wrote JUnit 5 unit tests for every class and integration tests that send real HTTP requests | 13 tests, all passing |

The project starts from Spring's [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/) guide. The `Greeting` classes are that guide's starter code; everything named `Employee*` is mine.

---

## Tech stack

- **Java 17+** (tested on JDK 27)
- **Spring Boot 4** (Spring Web MVC, embedded Tomcat)
- **Jackson** for JSON serialization
- **JUnit 5** and Spring's `RestTestClient` for testing
- **Maven** (wrapper included) - Gradle build also included

---

## API

### `GET /employees`
Returns every employee.

```json
{
  "Employees": [
    {
      "employee_id": "1",
      "first_name": "Prem",
      "last_name": "Tiwari",
      "email": "prem.tiwari@example.com",
      "title": "Software Engineer"
    }
  ]
}
```

### `POST /employees`
Adds an employee. Send JSON with `Content-Type: application/json`:

```json
{
  "employee_id": "5",
  "first_name": "John",
  "last_name": "Doe",
  "email": "john.doe@example.com",
  "title": "DevOps Engineer"
}
```

Responds with **`201 Created`** and the added employee.

> Data is stored in memory, so added employees reset when the app restarts.

---

## Project structure

```
src/main/java/com/example/restservice/
├── RestServiceApplication.java   # Spring Boot entry point
├── Employee.java                 # Employee model (fields, getters, setters)
├── Employees.java                # Wrapper holding the employee list ("Employees" in JSON)
├── EmployeeManager.java          # Initialises and holds the employee data
└── EmployeeController.java       # REST endpoints: GET and POST /employees

src/test/java/com/example/restservice/
├── EmployeeTest.java                       # Model: constructors, getters, setters
├── EmployeesTest.java                      # List wrapper behaviour
├── EmployeeManagerTest.java                # Initial hard-coded data
├── EmployeeControllerTest.java             # Controller logic (called directly)
└── EmployeeControllerIntegrationTest.java  # Real HTTP requests: JSON format, POST then GET
```

The data handling (`EmployeeManager`) is kept separate from the HTTP layer (`EmployeeController`), so each part has one responsibility and can be tested on its own.

---

## Run it locally

Requires **JDK 17 or newer**.

```bash
# Windows
mvnw.cmd clean package
java -jar target\rest-service-complete-0.0.1-SNAPSHOT.jar

# macOS / Linux
./mvnw clean package
java -jar target/rest-service-complete-0.0.1-SNAPSHOT.jar
```

The service starts on **http://localhost:8080**.

### Try it

```bash
# List employees
curl http://localhost:8080/employees

# Add an employee (macOS / Linux)
curl -X POST http://localhost:8080/employees \
  -H "Content-Type: application/json" \
  -d '{"employee_id":"5","first_name":"John","last_name":"Doe","email":"john.doe@example.com","title":"DevOps Engineer"}'
```

On Windows Command Prompt, escape the inner quotes:

```
curl -X POST http://localhost:8080/employees -H "Content-Type: application/json" -d "{\"employee_id\":\"5\",\"first_name\":\"John\",\"last_name\":\"Doe\",\"email\":\"john.doe@example.com\",\"title\":\"DevOps Engineer\"}"
```

### Run the tests

```bash
mvnw.cmd clean test     # Windows
./mvnw clean test       # macOS / Linux
```

---

## What I learned

- **REST API design** - modelling resources as nouns (`/employees`), using HTTP methods for actions (GET to read, POST to create) and returning meaningful status codes (`200 OK`, `201 Created`).
- **Spring Boot fundamentals** - how auto-configuration and the embedded server let a full web service run from one executable JAR; using `@RestController`, `@GetMapping`, `@PostMapping` and `@RequestBody`.
- **Dependency injection** - Spring creates the `EmployeeManager` as a `@Component` and injects it into the controller through its constructor.
- **JSON mapping** - how Jackson turns Java objects into JSON and back using getters and setters, and how `@JsonProperty` controls field names.
- **Separation of concerns** - keeping the data layer apart from the controller makes the code easier to maintain and test.
- **Testing** - writing fast unit tests with JUnit 5, plus integration tests that start the app and check real HTTP requests and responses; isolating tests with `@DirtiesContext` so they can't affect each other.
- **Build tools** - using the Maven wrapper to build and test the project with no global install.
- **Cloud context** - how a platform like HPE GreenLake could host a service like this on-premises with a cloud-style, pay-per-use model.

---

## Certificate

<img src="docs/certificate.png" alt="Forage certificate of completion" width="600">

---

## Acknowledgements

- [HPE Software Engineering Job Simulation](https://www.theforage.com/) on Forage
- Project scaffolding from the Spring guide [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/) ([spring-guides/gs-rest-service](https://github.com/spring-guides/gs-rest-service)), licensed under Apache 2.0
