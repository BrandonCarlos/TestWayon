# Wayon Transfer Scheduler

Transfer scheduling system developed as a technical challenge using Java 11, Spring Boot, Domain-Driven Design (DDD), Clean Architecture, and Hexagonal Architecture.

---

# Overview

The application allows users to:

- Schedule financial transfers
- Calculate transfer fees according to business rules
- Validate transfer eligibility
- Persist transfers
- List scheduled transfers

The project was designed following software engineering best practices, emphasizing:

- Separation of concerns
- Domain-driven design
- Testability
- Maintainability
- Scalability

---

# Technology Stack

## Backend

- Java 11
- Spring Boot 2.7.x
- Spring Data JPA
- H2 Database
- MapStruct
- Lombok
- Maven
- Swagger / OpenAPI

## Testing

- JUnit 5
- Mockito
- Spring Boot Test
- MockMvc

## Architecture

- Domain-Driven Design (DDD)
- Clean Architecture
- Hexagonal Architecture (Ports & Adapters)

---

# Architecture Overview

The application follows a layered architecture inspired by:

- Domain-Driven Design
- Clean Architecture
- Hexagonal Architecture

```text
                ┌─────────────────┐
                │   Entrypoint    │
                │  REST API Layer │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │  Application    │
                │   Use Cases     │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │     Domain      │
                │ Business Rules  │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │ Infrastructure  │
                │ Persistence     │
                └─────────────────┘
```

Dependencies always point inward.

The domain layer is completely independent of frameworks and infrastructure concerns.

---

# Project Structure

```text
src/main/java/com/wayoncompany/wayon

├── application
│   ├── dto
│   ├── mapper
│   └── usecase
│
├── domain
│   ├── exception
│   ├── model
│   ├── ports
│   │   ├── in
│   │   └── out
│   └── service
│
├── infrastructure
│   ├── config
│   ├── exception
│   └── persistence
│       ├── adapter
│       ├── entity
│       ├── mapper
│       └── repository
│
├── entrypoint
│   └── rest
│
└── WayonApplication.java
```

---

# Domain Layer

The domain layer contains:

- Entities
- Business rules
- Domain services
- Exceptions
- Ports

No framework dependency exists in this layer.

Example:

```java
Transfer
FeeCalculator
BusinessException
TransferRepositoryPort
```

---

# Hexagonal Architecture

The application uses Ports and Adapters.

## Input Ports

```java
ScheduleTransferUseCase
GetTransfersUseCase
```

These represent operations exposed to the outside world.

## Output Ports

```java
TransferRepositoryPort
```

Represents persistence requirements.

## Adapter

```java
TransferRepositoryAdapter
```

Bridges the domain layer and JPA repository.

This design allows replacing:

- H2
- PostgreSQL
- MongoDB
- Redis

without changing domain logic.

---

# Database

Current implementation uses:

```text
H2 In-Memory Database
```

Advantages:

- Lightweight
- No installation required
- Fast startup
- Ideal for technical challenges

---

# Transfer Fee Rules

| Days Until Transfer | Fee |
|--------------------|------|
| Same day | R$ 3.00 + 2.5% |
| 1 to 10 | R$ 12.00 |
| 11 to 20 | 8.2% |
| 21 to 30 | 6.9% |
| 31 to 40 | 4.7% |
| 41 to 50 | 1.7% |
| Above 50 | Not allowed |

If no valid fee exists, the system rejects the scheduling request.

---

# API Endpoints

## Schedule Transfer

### Request

```http
POST /api/transfers
```

Request body:

```json
{
  "sourceAccount": "1234567890",
  "destinationAccount": "0987654321",
  "amount": 1000,
  "transferDate": "2030-01-01"
}
```

### Response

```json
{
  "id": 1,
  "sourceAccount": "1234567890",
  "destinationAccount": "0987654321",
  "amount": 1000,
  "fee": 17.00,
  "totalAmount": 1017.00,
  "transferDate": "2030-01-01",
  "scheduleDate": "2026-06-02"
}
```

---

## List Transfers

### Request

```http
GET /api/transfers
```

### Response

```json
[
  {
    "id": 1,
    "sourceAccount": "1234567890",
    "destinationAccount": "0987654321",
    "amount": 1000,
    "fee": 17.00,
    "totalAmount": 1017.00,
    "transferDate": "2030-01-01",
    "scheduleDate": "2026-06-02"
  }
]
```

---

# Running the Application

## Requirements

- Java 11
- Maven 3.8+

Verify installation:

```bash
java -version
mvn -version
```

---

## Clone

```bash
git clone <repository-url>
cd wayon
```

---

## Build

```bash
mvn clean compile
```

---

## Run

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

---

# Swagger Documentation

Available at:

```text
http://localhost:8080/swagger-ui.html
```

Used to:

- Explore endpoints
- Execute requests
- Validate responses

---

# H2 Console

Available at:

```text
http://localhost:8080/h2-console
```

Configuration:

```text
JDBC URL:
jdbc:h2:mem:transferdb

User:
sa

Password:
(empty)
```

---

# Running Tests

Run all tests:

```bash
mvn test
```

Run full verification:

```bash
mvn verify
```

---

# Test Coverage

The project includes:

## Domain Tests

- Fee calculation
- Business rule validation

## Application Tests

- Use case execution
- Scheduling flow

## Repository Tests

- Persistence validation

## Controller Tests

- Request validation
- HTTP behavior

## Integration Tests

- End-to-end workflow

---

# Design Decisions

## Why DDD?

DDD isolates business rules from technical concerns.

Benefits:

- Easier maintenance
- Better readability
- Business-focused code

---

## Why Hexagonal Architecture?

Allows replacing infrastructure without affecting business logic.

Examples:

- H2 → PostgreSQL
- JPA → MongoDB
- REST → Messaging

without changing domain code.

---

## Why MapStruct?

MapStruct provides:

- Compile-time mapping
- High performance
- Type safety

Avoiding manual conversion boilerplate.

---

## Why H2?

For a technical challenge:

- Simple setup
- Fast execution
- Zero external dependencies

---

# Future Improvements

Potential enhancements:

- PostgreSQL migration
- Redis caching
- Docker support
- Kubernetes deployment
- JWT Authentication
- Role-based authorization
- Audit logging
- Observability with Micrometer
- CI/CD pipeline
- SonarQube integration
- Testcontainers integration

---
