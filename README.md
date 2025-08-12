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
