package com.example.UserRegistration.repository;


import com.example.UserRegistration.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Long> {
}
