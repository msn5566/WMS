# WMS

---
**Date:** 2025-08-12 17:09:37
**Branch:** feature/WMS-1_20250812170853
---

## 📝 Project Summary

Feature: Create Java POJOs for Warehouse Management System entities.
Input: Entity specifications including fields and data types.
Output: Java POJO classes with appropriate fields, Lombok annotations, and ready for persistence annotations.
Constraints:
    * Java 21, Spring Boot 3.5.*
    * Layered architecture (Controller, Service, Repository)
    * Maven build
    * MongoDB database
    * Swagger/OpenAPI documentation
    * JUnit and Mockito for testing
    * Dockerized
    * GitHub Actions CI workflow
Logic: Create Java classes under `com.company.wms.model` following Java naming conventions and using Lombok annotations.  Prepare classes for JPA or MongoDB persistence.  The entities to be created include User, Product, SKU, Inventory, Location, PurchaseOrder, PurchaseOrderItem, SalesOrder, SalesOrderItem, PutawayTask, PickTask, AuditLog, InventoryAdjustment, and WarehouseConfig.

### 🛠️ Core Dependencies

- `org.springframework.boot:spring-boot-starter-data-mongodb`
- `org.springframework.boot:spring-boot-starter-web`
- `org.projectlombok:lombok:optional`
- `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0`

--- END ---


---
**Date:** 2025-08-12 17:13:30
**Branch:** feature/WMS-2_20250812171222
---

## 📝 Project Summary

Feature: User registration and login with role-based authentication (Admin, Manager, Worker)
Input: User credentials (username, password, role) for registration and login.
Output: Successful registration creates a new user account. Successful login returns a session/token.  Displays appropriate UI based on role.
Constraints: Must use Java 21, Spring Boot 3.5.*, layered architecture, Maven, MongoDB, Swagger/OpenAPI, JUnit, Mockito, Docker, and GitHub Actions CI.  Must adhere to the specified package name (com.wms).
Logic:  Implement registration endpoint to create new user accounts with assigned roles, storing data in MongoDB. Implement login endpoint to authenticate users based on credentials and roles, returning session/token. Frontend should interact with these endpoints, displaying UI elements relevant to each role upon successful login.

### 🛠️ Core Dependencies

- `org.springframework.boot:spring-boot-starter-data-mongodb`
- `org.springframework.boot:spring-boot-starter-web`
- `org.springframework.boot:spring-boot-starter-security`
- `org.projectlombok:lombok:optional`
- `org.springframework.boot:spring-boot-starter-validation`
- `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0`
- `org.springframework.boot:spring-boot-starter-test:test`
- `org.slf4j:slf4j-api`
- `ch.qos.logback:logback-classic`
- `io.jsonwebtoken:jjwt-api:0.11.8`
- `io.jsonwebtoken:jjwt-impl:0.11.8`
- `io.jsonwebtoken:jjwt-jackson:0.11.8:runtime`

--- END ---


---
**Date:** 2025-08-12 18:02:00
**Branch:** feature/WMS-5_20250812180026
---

## 📝 Project Summary

Feature: Inventory tracking APIs allowing add, update, delete and view operations by SKU and location.
Input: SKU and location information for various operations.  Add operation requires inventory details. Update operation requires updated inventory data. Delete operation requires SKU and location. View operation requires SKU and location.
Output:
Add: Success/failure status.
Update: Success/failure status.
Delete: Success/failure status.
View: Inventory details for given SKU and location.
Constraints:
- Must be written in Java 21 using Spring Boot 3.5.*
- Must follow layered architecture (Controller, Service, Repository).
- Must use Maven for build.
- Data must be stored in a Mongodb database.
- Must provide API documentation using Swagger/OpenAPI.
- Must provide Dockerfile for containerization.
- Unit and integration tests must be written using JUnit and Mockito.
Logic:  The APIs will interact with a Mongodb database to manage inventory data based on SKU and location.  Standard CRUD operations will be implemented.  API documentation will be generated using Swagger/OpenAPI.  The application will be built using Maven and containerized using Docker. CI will be implemented using GitHub Actions.

### 🛠️ Core Dependencies

- `org.springframework.boot:spring-boot-starter-data-mongodb`
- `org.springframework.boot:spring-boot-starter-web`
- `org.springframework.boot:spring-boot-starter-security`
- `org.projectlombok:lombok:optional`
- `org.springframework.boot:spring-boot-starter-validation`
- `org.springframework.boot:spring-boot-starter-test:test`
- `io.jsonwebtoken:jjwt-api:0.12.5`
- `io.jsonwebtoken:jjwt-impl:0.12.5:runtime`
- `io.jsonwebtoken:jjwt-jackson:0.12.5:runtime`
- `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0`
- `org.springframework.boot:spring-boot-starter-data-jpa`
- `com.fasterxml.jackson.core:jackson-databind:2.16.1`

--- END ---


---
**Date:** 2025-08-13 11:11:53
**Branch:** feature/WMS-6_20250813111015
---

## 📝 Project Summary

Feature: Stock Adjustments and Cycle Counts
Input: Stock adjustments with reasons provided by authorized users.  Cycle count data.
Output: Updated inventory levels reflecting adjustments and cycle counts. Log of stock adjustment reasons.
Constraints: Must be implemented in Java 21 with Spring Boot 3.5.*, follow layered architecture, use Maven, MongoDB, Swagger/OpenAPI, JUnit, Mockito, provide a Dockerfile and GitHub Actions CI workflow.
Logic:  The system should allow authorized users to input adjustments to stock levels along with reasons for these adjustments. It should update inventory levels in the database based on these inputs.  The system should also support cycle counts, allowing comparison of physical inventory with recorded levels.

### 🛠️ Core Dependencies

- `org.springframework.boot:spring-boot-starter-data-mongodb`
- `org.springframework.boot:spring-boot-starter-web`
- `org.springframework.boot:spring-boot-starter-security`
- `org.projectlombok:lombok:optional`
- `org.springframework.boot:spring-boot-starter-validation`
- `org.springframework.boot:spring-boot-starter-test:test`
- `io.jsonwebtoken:jjwt-api:0.12.5`
- `io.jsonwebtoken:jjwt-impl:0.12.5:runtime`
- `io.jsonwebtoken:jjwt-jackson:0.12.5:runtime`
- `org.springframework.boot:spring-boot-starter-data-jpa`
- `com.fasterxml.jackson.core:jackson-databind:2.16.1`
- `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0`
- `org.slf4j:slf4j-api`
- `ch.qos.logback:logback-classic`
- `com.fasterxml.jackson.datatype:jackson-datatype-jsr310`

--- END ---
