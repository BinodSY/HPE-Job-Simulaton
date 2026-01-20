# HPE REST Service

A Spring Boot REST API application for managing employee information. This project demonstrates a complete CRUD (Create, Read, Update, Delete) operation using Spring Boot, JPA, and H2 database.

## Project Overview

HPE REST Service is a microservice built with Spring Boot that provides RESTful endpoints for managing employee records. It uses an in-memory H2 database for data persistence and follows Spring Boot best practices.

## Tech Stack

- **Java:** 21
- **Framework:** Spring Boot 3.5.9
- **Database:** H2 (in-memory)
- **ORM:** Spring Data JPA
- **Build Tool:** Maven
- **Container:** Docker

## Project Structure

```
hpeRestService/
├── src/
│   ├── main/
│   │   ├── java/com/hpe/hpe/
│   │   │   ├── RestServiceApplication.java
│   │   │   ├── controller/
│   │   │   │   └── EmployeeController.java
│   │   │   ├── model/
│   │   │   │   └── Employees.java
│   │   │   ├── repository/
│   │   │   │   └── EmployeeRepository.java
│   │   │   └── service/
│   │   │       └── EmployeeService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/com/hpe/hpe/
├── pom.xml
├── Dockerfile
├── docker-compose.yml
└── mvnw
```

## Features

- **Get All Employees:** Retrieve a list of all employees
- **Get Employee by ID:** Retrieve details of a specific employee
- **Create Employee:** Add a new employee record
- **Update Employee:** Modify existing employee information
- **Delete Employee:** Remove an employee record

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/employees` | Get all employees |
| GET | `/employees/{EmployeeId}` | Get employee by ID |
| POST | `/employees` | Create a new employee |
| PUT | `/employees/{EmployeeId}` | Update an employee |
| DELETE | `/employees/{EmployeeId}` | Delete an employee |

## Employee Model

The `Employees` entity contains the following fields:

```
{
  "employee_id": "string",
  "first_name": "string",
  "last_name": "string",
  "email": "string",
  "title": "string"
}
```

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6+
- Docker (optional, for containerization)

### Build

Using Maven:

```bash
./mvnw clean build
```

Or on Windows:

```bash
mvnw.cmd clean build
```

### Run

To start the application:

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080/`

### Docker

To build and run with Docker:

```bash
docker-compose up --build
```

## Configuration

Application properties can be configured in [src/main/resources/application.properties](src/main/resources/application.properties)

## Testing

Run the test suite:

```bash
./mvnw test
```

## Usage Examples

### Get All Employees

```bash
curl http://localhost:8080/employees
```

### Create Employee

```bash
curl -X POST http://localhost:8080/employees \
  -H "Content-Type: application/json" \
  -d '{
    "employee_id": "EMP001",
    "first_name": "John",
    "last_name": "Doe",
    "email": "john.doe@hpe.com",
    "title": "Software Engineer"
  }'
```

### Get Employee by ID

```bash
curl http://localhost:8080/employees/EMP001
```

### Update Employee

```bash
curl -X PUT http://localhost:8080/employees/EMP001 \
  -H "Content-Type: application/json" \
  -d '{
    "employee_id": "EMP001",
    "first_name": "John",
    "last_name": "Doe",
    "email": "john.doe@hpe.com",
    "title": "Senior Software Engineer"
  }'
```

### Delete Employee

```bash
curl -X DELETE http://localhost:8080/employees/EMP001
```

## Architecture

The application follows a layered architecture:

- **Controller Layer:** Handles HTTP requests and responses
- **Service Layer:** Contains business logic
- **Repository Layer:** Manages data persistence with Spring Data JPA
- **Model Layer:** Defines the data entities

## Dependencies

Key dependencies include:
- `spring-boot-starter-web` - Web support
- `spring-boot-starter-data-jpa` - JPA/Hibernate support
- `h2` - In-memory database
- `lombok` - Reduce boilerplate code
- `spring-boot-devtools` - Development tools

## License

This is a demo project for learning and development purposes.

## Support

For issues or questions, please refer to the project structure and ensure all endpoints are properly configured.
