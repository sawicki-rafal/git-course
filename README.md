# User Information API

This is a simple Java and Spring-based REST API application for managing user information. Currently, the application provides endpoints for retrieving a list of users and specified by id user.

## Getting Started

Follow these steps to run the application locally:

### Prerequisites

Make sure you have Java 17 and Maven 3 installed on your machine.

### Build and Run
```bash
mvn spring-boot:run
```

### Endpoints

#### Get All Users
* Endpoint: GET /api/users
* Description: Retrieves a list of all users' information specified by DTO pattern (currently id and username).
#### Get User By ID
* Endpoint: GET /api/users/{id}
* Description: Retrieves information specified by DTO pattern (currently id and username) about user with given id.
##### Example Usage
Use tools like Postman or curl to make a GET request (you can also use your browser):
```bash
curl http://localhost:8080/api/users
```

### Additional Information
* The application uses an in-memory storage mechanism for simplicity. You can extend it to use a database for persistent storage.
* Feel free to explore and modify the code to add more features or enhance functionality based on your requirements.