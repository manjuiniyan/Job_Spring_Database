package com.jobdb.jobdatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobdb.jobdatabase.model.User;
import com.jobdb.jobdatabase.services.UserJobServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1")
public class UserJobController {

    @Autowired
    private UserJobServices userJobServices;

    @PostMapping("/saveUserJob")
    public String saveUserJob(@RequestBody User user) {
        User savedUser = userJobServices.save(user); // Assuming save method exists in UserJobServices
        int userId = savedUser.getId();
        String message = "User Saved Successfully. Id No is = " + userId;
        System.out.println(message);
        return message;
    }
    
}
