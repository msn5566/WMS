# WMS

---
**Date:** 2025-08-14 08:50:21
**Branch:** feature/WMS-2_20250814084939
---

## 📝 Project Summary

Feature: User registration and login with role-based authentication (Admin, Manager, Worker)
Input: User credentials (username, password, role) for registration and login.
Output: Successful registration creates a new user account. Successful login grants access based on user role.  API documentation via Swagger/OpenAPI.
Constraints: Java 21, Spring Boot 3.5.*, Layered architecture (Controller, Service, Repository), Maven, MongoDB, JUnit, Mockito, Docker, GitHub Actions CI.
Logic:  Register new users with assigned roles. Authenticate users upon login.  Control access based on roles.

### 🛠️ Core Dependencies

- `org.springframework.boot:spring-boot-starter-web`
- `org.springframework.boot:spring-boot-starter-data-mongodb`
- `org.springframework.boot:spring-boot-starter-security`
- `org.springframework.boot:spring-boot-starter-validation`
- `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0`
- `org.projectlombok:lombok:1.18.30:optional`
- `org.springframework.boot:spring-boot-starter-test:test`
- `org.mockito:mockito-core:5.4.0:test`

--- END ---


---
**Date:** 2025-08-14 08:51:05
**Branch:** feature/WMS-2_20250814085016
---

## 📝 Project Summary

Feature: User registration and login with role-based authentication (Admin, Manager, Worker)
Input: User credentials (username, password, role) for registration and login.
Output: Successful registration creates a new user account. Successful login returns a session or token.  Displays appropriate views/pages based on user role.
Constraints: Must use Java 21, Spring Boot 3.5.*, layered architecture, Maven, MongoDB, Swagger/OpenAPI, JUnit, Mockito, Docker, and GitHub Actions CI.  Follows the architecture of the existing WMS project.
Logic:  Implement registration endpoint to create new users in the database with assigned roles. Implement login endpoint to authenticate users against the database and establish a session.  Frontend should provide registration and login forms and redirect users based on their roles after successful login.

### 🛠️ Core Dependencies

- `org.springframework.boot:spring-boot-starter-web`
- `org.springframework.boot:spring-boot-starter-data-mongodb`
- `org.springframework.boot:spring-boot-starter-security`
- `org.springframework.boot:spring-boot-starter-validation`
- `org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0`
- `org.projectlombok:lombok:1.18.26:optional`
- `org.springframework.boot:spring-boot-starter-test:test`
- `org.mockito:mockito-core:5.2.0:test`

--- END ---
