# WMS

---
**Date:** 2025-08-14 08:29:32
**Branch:** feature/WMS-1_20250814082837
---

## 📝 Project Summary

Feature: Create Java POJOs for core entities of a Warehouse Management System.
Input: Requirements describing the entities and their attributes.
Output: Java POJO classes for User, Product, SKU, Inventory, Location, PurchaseOrder, PurchaseOrderItem, SalesOrder, SalesOrderItem, PutawayTask, PickTask, AuditLog, InventoryAdjustment, and WarehouseConfig.
Constraints:
    * POJOs must be in the `com.company.wms.model` package.
    * Fields must follow Java naming conventions and use appropriate types.
    * Lombok annotations (@Data, @Builder, etc.) should be used.
    * Classes must be ready for JPA or MongoDB annotations.
    * Java 21, Spring Boot 3.5.*, Maven, MongoDB, Swagger/OpenAPI, JUnit, Mockito, Docker, and GitHub Actions CI workflow are required. Layered architecture (Controller, Service, Repository) must be followed.
Logic: Create Java classes with the specified attributes for each entity, using appropriate data types and Lombok annotations.  The classes should be designed for persistence using either JPA or MongoDB annotations, allowing for flexibility in database choice.  The implementation must adhere to the specified technology stack and development practices.

### 🛠️ Core Dependencies

- `org.springframework.boot:spring-boot-starter-data-mongodb`
- `org.springframework.boot:spring-boot-starter-web`
- `org.springframework.boot:spring-boot-starter-validation`
- `org.projectlombok:lombok:1.18.30:optional`
- `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0`
- `org.springframework.boot:spring-boot-starter-test:test`
- `org.mockito:mockito-core:5.4.0:test`

--- END ---
