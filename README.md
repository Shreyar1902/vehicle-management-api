# Vehicle Management REST API

A backend application developed using Java and Spring Boot to manage vehicle records through RESTful APIs. The application provides secure authentication, role-based authorization and database operations using MySQL.

## 1. Technologies Used

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- JWT (JSON Web Token)
- Maven
- Postman
- Git and GitHub

## 2. Features

- User registration and login.
- JWT-based authentication.
- Role-based access control (ADMIN and USER).
- Add new vehicle records.
- Retrieve all vehicles.
- Retrieve vehicle details using vehicle ID.
- Update existing vehicle information.
- Delete vehicle records.
- Password encryption using BCrypt.
- Centralized exception handling.

## 3. User Roles

| Role | Permissions |
|---|---|
| ADMIN | View, add, update and delete vehicles |
| USER | View vehicle records |

## 4. Project Structure

```text
vehicle-management-api/
│
├── src/
│   ├── main/
│   │   ├── java/com/shreya/vehiclemanagement/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   ├── exception/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── user/
│   │   │
│   │   └── resources/
│   │       └── application.properties.example
│   │
│   └── test/
│
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 5. Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE vehicle_management;
```

Configure your database credentials in `src/main/resources/application.properties`.

A sample configuration is provided in `application.properties.example`.

Update the database username, password and JWT secret with your local values.

## 6. Run the Application

**Step 1:** Clone the repository.

```bash
git clone https://github.com/Shreyar1902/vehicle-management-api.git
```

**Step 2:** Open the project directory.

```bash
cd vehicle-management-api
```

**Step 3:** Configure your `application.properties` file.

**Step 4:** Run the application using Maven.

Windows:

```bash
.\mvnw.cmd spring-boot:run
```

The application runs at:

```text
http://localhost:8080
```

## 7. API Endpoints

### Authentication APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Authenticate user and generate JWT |

### Vehicle APIs

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/vehicles` | Retrieve all vehicles |
| GET | `/api/vehicles/{id}` | Retrieve vehicle by ID |
| POST | `/api/vehicles` | Add a new vehicle |
| PUT | `/api/vehicles/{id}` | Update vehicle details |
| DELETE | `/api/vehicles/{id}` | Delete a vehicle |

## 8. Authentication and Authorization

The application uses Spring Security and JWT for securing REST API endpoints.

1. Register a new user.
2. Log in using registered credentials.
3. Receive a JWT token.
4. Include the token in the Authorization header when accessing protected endpoints.

```text
Authorization: Bearer <JWT_TOKEN>
```

ADMIN users have permission to perform all vehicle operations, while USER accounts have read-only access.

## 9. API Testing

All endpoints were tested using Postman.

The following operations were verified:

- User registration and login.
- JWT authentication.
- Vehicle creation and retrieval.
- Vehicle updates and deletion.
- ADMIN and USER authorization.
- Access restriction for unauthorized roles.

## 10. GitHub Repository

Project Source Code:

https://github.com/Shreyar1902/vehicle-management-api

---

**Developed using Java, Spring Boot, MySQL and Spring Security.**