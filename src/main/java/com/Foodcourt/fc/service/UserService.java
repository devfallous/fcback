package com.Foodcourt.fc.service;

import com.Foodcourt.fc.Entity.User;
import com.Foodcourt.fc.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository usersRepository;


    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
