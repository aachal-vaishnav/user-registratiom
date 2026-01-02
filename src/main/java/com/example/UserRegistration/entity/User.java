package com.example.UserRegistration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="users")
public class User {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Size(min = 6, max = 12, message = "Username must be between 6 and 12 characters")
    private String username;

    @NotNull(message = "Email is required")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Pattern.List(value = {
    @Pattern(regexp=".*[A-Z].*",message = "Password should contain at least 1 Uppercase character"),
    @Pattern(regexp=".*[a-z].*",message = "Password should contain at least 1 Lowercase character"),
    @Pattern(regexp=".*\\d.*",message = "Password should contain at least 1 Number")
    })
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
