# Task 1 - Proposal: Employee Management RESTful Web Service

To build this service, we will use Java Spring Boot. Its auto-configuration and embedded web server let us build a REST API quickly with very little setup. We will create the project with Spring Initializr and manage dependencies with Maven, using Spring Web for the REST endpoints.

First, we will create an `Employee` class to model a single employee. It will have a private variable for each field: `employee_id`, `first_name`, `last_name`, `email` and `title`, plus a getter and setter for each. We will also create an `Employees` class that holds and manages the full list of `Employee` objects. Last, an `EmployeeManager` (or repository) class will store the data and handle adding, updating, removing and retrieving employees.

Next, we will create an `EmployeeController` class marked with `@RestController`. This class receives HTTP requests and maps them to actions on the employee data:

- **GET `/employees`** returns the full list of employees.
- **POST `/employees`** adds a new employee.
- **PUT `/employees/{employee_id}`** updates an existing employee.
- **DELETE `/employees/{employee_id}`** removes an employee.

A GET request for the full list returns a response in this format:

```json
{
  "Employees": [
    {
      "employee_id": "string",
      "first_name": "string",
      "last_name": "string",
      "email": "string",
      "title": "string"
    },
    {
      "employee_id": "string",
      "first_name": "string",
      "last_name": "string",
      "email": "string",
      "title": "string"
    }
  ]
}
```

POST and PUT requests send a single employee in the request body, structured as follows:

```json
{
  "employee_id": "string",
  "first_name": "string",
  "last_name": "string",
  "email": "string",
  "title": "string"
}
```

A DELETE request only needs the `employee_id` in the URL. The service will return standard HTTP status codes: 200 OK for successful reads and updates, 201 Created for new employees, 204 No Content for deletions and 404 Not Found when an employee doesn't exist.

Finally, we need somewhere to host the service and its data. That's where the HPE GreenLake platform comes in. GreenLake provides cloud-native infrastructure that runs on-premises with pay-per-use pricing. We can deploy the application there and keep our employee data private and secure, with the scalability and lower cost of a cloud service.
