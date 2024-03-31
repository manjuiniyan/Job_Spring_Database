package com.jobdb.jobdatabase.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobdb.jobdatabase.services.UserJobServices;

public interface UserSearchJobRepository extends JpaRepository<User, Integer> {
    
}
