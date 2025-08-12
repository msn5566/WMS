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
