package com.example.UserRegistration.service;

import com.example.UserRegistration.entity.User;
import com.example.UserRegistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public void saveUser(User user){
        userRepository.save(user);/*user repository have built-in method
         save,update,create as it extends  CrudRepository
         it ask Entity as parameter
        */

    }
}
