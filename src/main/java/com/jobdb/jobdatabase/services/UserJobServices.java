package com.jobdb.jobdatabase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobdb.jobdatabase.model.User;
import com.jobdb.jobdatabase.model.UserSearchJobRepository;

@Service
public class UserJobServices {

     @Autowired
     private UserSearchJobRepository userSearchJobRepository;
    
     // create a save method
      public User save(User user) {
          User userObj = userSearchJobRepository.save(user);
          System.out.println("User Saved Successfully =" + user.getId());
          return userObj;
      }

}