package com.jobdb.jobdatabase.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "skill")
    private String skill;

    @Column(name = "year_of_experience")
    private String yearOfExperience;

    @Column(name = "location")
    private String location;

    @Column(name = "salary_range")
    private String salaryRange;
    
}
