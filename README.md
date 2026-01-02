# User Registration Application

## Tech Stack
- **Java:** 25
- **Spring Boot:** 4.x
- **Spring Data JPA** with **CrudRepository**
- **Thymeleaf**: 3.x
- **MySQL**: 8.x
- **Bootstrap:** 5.3
- **Maven** for dependency management

---

## Project Structure

```

src/
└── main/
├── java/com/example/UserRegistration/
│   ├── controller/
│   │   └── UserController.java
│   ├── entity/
│   │   └── User.java
│   ├── repository/
│   │   └── UserRepository.java
│   ├── service/
│   │   └── UserService.java
│   └── UserRegistrationApplication.java
└── resources/
├── templates/
│   ├── userRegister.html
│   └── result.html
└── application.yml

````

---

## Main Features
- User registration with **username, email, and password**
- **Server-side validation** using Spring Validation (`@NotBlank`, `@Email`, `@Size`, `@Pattern`)
- Validation errors displayed dynamically via **Thymeleaf**
- **Data persistence** in MySQL using **Spring Data JPA**
- Built-in CRUD operations via `CrudRepository` (`save()`, `findAll()`, etc.)
- Clean MVC separation: Controller → Service → Repository → Database

---

## How to Run

1. **Clone the repository**
```bash
git clone <repository-url>
cd UserRegistration
````

2. **Configure MySQL**

* Create database `users`
* Update `application.yml` with your MySQL username/password

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

3. **Run the application**

```bash
mvn spring-boot:run
```

4. **Access the application**

* Open browser → `http://localhost:8080/`
* Fill the registration form and submit


## Notes

* Uses **@Valid + BindingResult** for validation
* `Model.addAttribute("user", new User())` binds form fields to backend object
* Password must include **uppercase, lowercase, and number**
* Spring automatically selects **MySQLDialect** and creates tables if not present
