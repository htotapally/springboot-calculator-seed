# Spring Boot Calculator Seed

An intentionally unhardened **Spring Boot** REST service built as a deterministic testbed for autonomous defect detection, dynamic JUnit 5 test generation, and automated runtime patch verification.

This repository serves as the target application for **[defect-repair-agent](https://github.com)**.

## Purpose

In real-world legacy or fast-moving codebases, production logs are often the only signal of how code fails under edge-case inputs. This project starts with **zero unit tests** and **zero defensive input checks** in its service layer so real Java runtime exceptions (`ArithmeticException`, `NullPointerException`) are written to `logs/app.log` for downstream AI repair agents to analyze and fix.

## Project Structure

```text
springboot-calculator-seed/
├── pom.xml
├── logs/
│   └── app.log                        # Runtime stack traces captured here
└── src/
    ├── main/
    │   ├── java/com/aiops/governance/calculator/
    │   │   ├── SpringbootCalculatorSeedApplication.java
    │   │   ├── controller/
    │   │   │   └── CalculatorController.java   # REST endpoints (/api/calc/*)
    │   │   └── service/
    │   │       └── CalculatorService.java      # Atomic arithmetic methods
    │   └── resources/
    │       └── application.properties          # Port (38080) & file logging config
    └── test/
        └── java/com/aiops/governance/calculator/service/
            └── (Populated dynamically by defect-repair-agent)
```

## Quick Start

### Prerequisites
* **Java 21** (or Java 17+)
* Maven Wrapper (`mvnw` / `mvnw.cmd` included)

### Run the Application
```bash
# Windows
mvnw.cmd spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```
The server starts on **`http://localhost:38080`** and writes logs to `logs/app.log`.

## Triggering Sample Production Exceptions

Use the commands below to generate real stack traces in `logs/app.log` for [`defect-repair-agent`](https://github.com) to repair:

### 1. Trigger `ArithmeticException` (`/ by zero`)
```powershell
Invoke-RestMethod -Uri "http://localhost:38080/api/calc/divide" `
  -Method Post `
  -ContentType "application/json" `
  -Body '{"a": 10, "b": 0}'
```

### 2. Trigger `NullPointerException` (Missing operand)
```powershell
Invoke-RestMethod -Uri "http://localhost:38080/api/calc/add" `
  -Method Post `
  -ContentType "application/json" `
  -Body '{"a": 10}'
```

## Running Generated JUnit 5 Tests
Once `defect-repair-agent` generates regression tests and patches `CalculatorService.java`, run the test suite:

```bash
mvnw.cmd test
```
