# WMS

---
**Date:** 2025-08-14 09:18:49
**Branch:** feature/WMS-1_20250814091758
---

## 📝 Project Summary

Feature: Create Java POJOs for various entities within a Warehouse Management System.
Input: Requirements specifying the entities and their attributes for a Warehouse Management System.
Output: Java POJO classes representing the defined entities with appropriate data types and annotations.
Constraints:
    * Must be written in Java 21 using Spring Boot 3.5.*
    * Must use Lombok annotations like `@Data`, `@Builder`, etc.
    * Must follow Java naming conventions and use appropriate types.
    * POJO classes must be created under `com.company.wms.model`.
    * Ready for JPA or MongoDB annotations
    * Must follow layered architecture (Controller, Service, Repository).
    * Must use Maven for build.
    * Data should be stored in a MongoDB database.
    * Should provide API documentation using Swagger/OpenAPI.
    * Unit and integration tests must be written using JUnit and Mockito.
    * Must provide Dockerfile for containerization.
    * Should include GitHub Actions CI workflow for build, test, and Docker image creation.
    * Package name: com.wms
Logic: Create Java classes with attributes corresponding to the specified entities (User, Product, SKU, Inventory, Location, PurchaseOrder, PurchaseOrderItem, SalesOrder, SalesOrderItem, PutawayTask, PickTask, AuditLog, InventoryAdjustment, WarehouseConfig). Annotate these classes using Lombok's `@Data`, `@Builder` and potentially JPA/MongoDB annotations.  The classes should reside under the `com.company.wms.model` package. Adhere to Java naming conventions and use appropriate data types for each attribute.  The implementation should consider future persistence in a MongoDB database.

### 🛠️ Core Dependencies

- `org.springframework.boot:spring-boot-starter-data-mongodb`
- `org.springframework.boot:spring-boot-starter-web`
- `org.projectlombok:lombok:optional`
- `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0`
- `org.springframework.boot:spring-boot-starter-test:runtime`
- `org.mockito:mockito-core:5.0.0`

--- END ---


---
**Date:** 2025-08-14 09:23:06
**Branch:** feature/WMS-2_20250814092159
---

## 📝 Project Summary

Feature: User registration and login with role-based authentication (Admin, Manager, Worker)
Input: User credentials (username, password, role) for registration and login.
Output: Successful registration creates a new user account. Successful login grants access based on user role.  API documentation via Swagger/OpenAPI.
Constraints: Java 21, Spring Boot 3.5.*, Layered architecture (Controller, Service, Repository), Maven, MongoDB, JUnit/Mockito, Docker, GitHub Actions CI.
Logic:  Implement registration endpoint to create new users with assigned roles. Implement login endpoint to authenticate users and grant access based on role.  Integrate with MongoDB for data persistence.  Document API with Swagger/OpenAPI. Implement unit and integration tests.  Provide Dockerfile and GitHub Actions CI workflow.

### 🛠️ Core Dependencies

- `org.springframework.boot:spring-boot-starter-data-mongodb`
- `org.springframework.boot:spring-boot-starter-web`
- `org.springframework.boot:spring-boot-starter-security`
- `org.projectlombok:lombok:optional`
- `org.springframework.boot:spring-boot-starter-test:runtime`
- `org.mockito:mockito-core:5.0.0`
- `org.springframework.boot:spring-boot-starter-validation`
- `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0`
- `org.slf4j:slf4j-api`
- `ch.qos.logback:logback-classic`

--- END ---
