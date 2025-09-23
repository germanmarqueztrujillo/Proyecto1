# Library Management System

REST API for managing a library's book collection. Implements complete CRUD operations, search by title and author, unique ISBN validation, and error handling for duplicates.

## Technologies

- Java 21
- Spring Boot 3.3.4
- Spring Data JPA
- H2 Database (development)
- MapStruct
- Lombok
- Swagger/OpenAPI 3
- Maven 3.9.8
- Docker

## Local Deployment

```bash
# Clone repository
git clone https://github.com/germanmarqueztrujillo/Proyecto1
cd Proyecto1

# Build and run
mvn clean install
mvn spring-boot:run
```

Application available at: `http://localhost:8080`

## Docker Deployment

```bash
# Clone repository
git clone https://github.com/germanmarqueztrujillo/Proyecto1
cd Proyecto1

# Build and run
docker compose -f dev/docker-compose.yml up --build
```

Application available at: `http://localhost:8080`

## Useful Links

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **H2 Console**: http://localhost:8080/h2-console
  - URL: `jdbc:h2:mem:testdb`
  - Username: `user`
  - Password: `user`