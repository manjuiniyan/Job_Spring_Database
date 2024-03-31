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
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_skill")
    private String jobSkills;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "previous_experience")
    private String previousExperience;

    @Column(name = "salary_range")
    private Integer salaryRange;

    @Column(name = "job_location")
    private String jobLocation;

    @Column(name = "job_type")
    private String jobType;

    @Column(name = "company_name")
    private String company;
    
    
}
