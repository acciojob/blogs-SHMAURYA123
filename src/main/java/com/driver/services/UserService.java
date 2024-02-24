package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        return userRepository3.save(user);
    }

    public void deleteUser(int userId){
        Optional<User> optionalUser=userRepository3.findById(userId);
        User user=optionalUser.get();
        userRepository3.delete(user);
    }

    public User updateUser(Integer id, String password){
        User user=userRepository3.findById(id).get();
        user.setPassword(password);
        return userRepository3.save(user);
    }
}
