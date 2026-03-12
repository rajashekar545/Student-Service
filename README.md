
# Student Service

The Student Service manages student information such as name, grade, school, and contact details.  
Other services (like Fee Service) call this service to retrieve student information when processing payments.

The service is built using **Spring Boot** and exposes REST APIs for managing students.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Swagger / OpenAPI

---

## Prerequisites

Make sure the following tools are installed:

- Java 17+
- Maven
- Git
- Postman (optional for API testing)

---

## How to Run the Service

Start the application using Maven:

cd student-service  
mvn spring-boot:run

The service will run on:

http://localhost:8081

---

## API Documentation (Swagger)

Swagger UI:

http://localhost:8081/swagger-ui.html

OpenAPI specification:

http://localhost:8081/v3/api-docs

---

## Postman Collection

A Postman collection is provided in the repository for testing APIs.

---

### Create Student

POST /students

Example request body:

{
  "studentName": "John Doe",
  "grade": "5",
  "mobileNumber": "9876543210",
  "schoolName": "Springfield School"
}

---

### Get All Students

GET /students

---

### Get Student By ID

GET /students/{id}

This endpoint is used by the **Fee Service** when processing payments.

---

### Update Student

PUT /students/{id}

---

### Delete Student

DELETE /students/{id}

---

## H2 Database Console

http://localhost:8081/h2-console

JDBC URL:

jdbc:h2:mem:studentdb

---

## Error Handling

Global exception handling ensures consistent error responses.

Example:

{
  "message": "Student not found with id: 10",
  "status": 404
}


