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
