# Spring Boot User Registration – Notes

These notes summarize the **complete learning process** for building a User Registration application using Spring Boot, Thymeleaf, Spring Data JPA, and MySQL.  
They include **data flow, annotations, validation steps, built-in methods, and best practices**.

---

## 1. Project Overview

- **Purpose:** Build a web application for user registration with server-side validation.
- **Main Components:**
  - **Entity:** `User` → Holds user data
  - **Controller:** `UserController` → Handles HTTP requests
  - **Service:** `UserService` → Contains business logic
  - **Repository:** `UserRepository` → Handles database operations
  - **View:** Thymeleaf templates → `userRegister.html` and `result.html`

---

## 2. Tech Stack

- **Java:** 25
- **Spring Boot:** 4.x
- **Spring MVC** → Request handling
- **Spring Data JPA** → Database CRUD operations
- **Thymeleaf** → Dynamic HTML templates
- **MySQL** → Database
- **Bootstrap 5** → Frontend styling
- **Maven** → Dependency management

---

## 3. Validation in Spring

### Why Validate?
- Prevent invalid data from being saved to the database
- Ensure user input meets business rules
- Improve application reliability

### How It Works
1. **Entity-level validation:** Annotations applied to fields in `User` class
2. **Controller:** Use `@Valid` and `BindingResult` to check validation
3. **Thymeleaf:** Display errors dynamically next to form fields

### Annotations Used
- `@NotBlank` → Field must not be empty
- `@Size(min, max)` → Restrict length of input
- `@Email` → Valid email format
- `@Pattern` → Regex for password complexity
- `@Pattern.List` → Apply multiple regex constraints on one field

### Fields Validated
- `username`
- `email`
- `password` → Must contain at least:
  - One uppercase letter
  - One lowercase letter
  - One number

---

## 4. Controller: `UserController`

### Endpoints
- `/` → Display registration form
  ```java
  model.addAttribute("user", new User());
````

* **Purpose:** Bind a `User` object to the form
* `/register` → Process registration

  ```java
  @ModelAttribute @Valid User user, BindingResult bindingResult
  ```

  * `@Valid` → Triggers validation
  * `BindingResult` → Stores validation errors
  * **If errors:** Return to registration form
  * **If valid:** Call `userService.saveUser(user)` → Show success page

---

## 5. Service Layer: `UserService`

* Provides **business logic** separate from controller
* Method: `saveUser(User user)` → Calls `userRepository.save(user)`
* **Benefit:** Maintains clean separation of concerns:

  * Controller → Handles requests
  * Service → Business logic
  * Repository → Database operations

---

## 6. Repository: `UserRepository`

* Extends `CrudRepository<User, Long>`
* Built-in methods:

  * `save()` → Insert or update entity
  * `findById()`, `findAll()`, `deleteById()` → Standard CRUD operations
* Simplifies database interaction without writing SQL queries

---

## 7. Thymeleaf Integration

* **Bind object:** `th:object="${user}"`
* **Bind field:** `th:field="*{username}"`
* **Show validation errors:**

  ```html
  <div th:if="${#fields.hasErrors('username')}" th:errors="*{username}"></div>
  ```
* **Purpose:** Connect backend `User` object with frontend form

---

## 8. Steps to Implement Validation

1. Add validation annotations to entity fields
2. Use `@Valid` and `BindingResult` in controller method
3. Bind entity object to form using `th:object` and `th:field`
4. Display validation errors in HTML with conditional Thymeleaf tags

---

## 9. Database Configuration

* MySQL database: `users`
* Configured in `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/users?useSSL=false&serverTimezone=UTC
    username: root
    password: 
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

* `ddl-auto: update` → Automatically creates tables if missing
* Spring automatically selects **MySQLDialect**

---

## 10. Password Validation Regex

```java
@Pattern.List({
    @Pattern(regexp=".*[A-Z].*", message="Password must have 1 uppercase letter"),
    @Pattern(regexp=".*[a-z].*", message="Password must have 1 lowercase letter"),
    @Pattern(regexp=".*\\d.*", message="Password must have 1 number")
})
```

* Ensures password complexity
* All rules validated at backend before saving

---

## 11. Data Flow Summary

1. User opens `/` → Controller adds empty `User` object to model
2. Thymeleaf binds form fields to `User` object
3. User submits form → `/register` endpoint called
4. Spring Validation checks fields (`@Valid`) → `BindingResult` stores errors
5. **If errors:** Form is re-rendered with error messages
6. **If valid:** `UserService.saveUser()` saves user to database
7. Success page (`result.html`) displayed

---

## 12. Important Notes for Revision

* **Model.addAttribute()** → Passes data from controller to view
* **BindingResult** → Must immediately follow `@Valid` parameter
* **CrudRepository.save()** → Handles both insert and update automatically
* **Validation** → Protects database integrity and improves UX
* **Thymeleaf + Spring Validation** → Seamless frontend-backend integration
* **Service layer** → Decouples business logic from controller

---

## Summary

This project demonstrates:

* Spring Boot MVC architecture
* Entity-level validation
* Thymeleaf form binding and error display
* CRUD operations with MySQL
* Clean separation of concerns
* Professional coding practices for enterprise-level applications
Do you want me to add that diagram?
```
