# Spring Boot REST API Project

A simple and professional RESTful API built with Spring Boot. This project provides a clean structure for building scalable and maintainable backend services.

## Features

- RESTful API design
- Spring Boot 3+
- Spring Data JPA
- H2/MySQL database support
- CRUD operations
- Exception handling
- Basic logging
- Cross-Origin Resource Sharing (CORS) enabled

## Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Postgres
- Maven

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.x
- (Optional) MySQL installed and running

### Clone the Project

```bash
git clone hhttps://github.com/sm-junior0/RestApis.git
cd RestApis
```

### Run the App

```bash
# Run using Maven
mvn spring-boot:run
```

Or package and run:

```bash
mvn clean package
java -jar target/*.jar
```

### API Endpoints

| Method | Endpoint             | Description     |
| ------ |----------------------| --------------- |
| GET    | `/api/products`      | Get all items   |
| GET    | `/api/products/{id}` | Get item by ID  |
| POST   | `/api/products`      | Create new item |
| PUT    | `/api/products/{id}` | Update item     |
| DELETE | `/api/products/{id}` | Delete item     |

## Configuration

You can configure your application properties in:

```
src/main/resources/application.properties
```

Example for Postgres:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_Database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## License

This project is open-source and available under the [MIT License](LICENSE).


