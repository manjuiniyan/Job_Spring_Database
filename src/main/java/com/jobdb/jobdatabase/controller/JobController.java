package com.jobdb.jobdatabase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobdb.jobdatabase.model.Job;
import com.jobdb.jobdatabase.services.JobServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
public class JobController {
   
    @Autowired
    private JobServices jobServices;

    @PostMapping("/saveJob")
    public String saveJob(@RequestBody Job job) {
        Job savedJob = jobServices.save(job);
        int jobId = savedJob.getId(); 
        // Assuming getId returns an int
        String message = "Job Saved Successfully. Id No is = " + jobId;
        System.out.println(message);
        return message;
    }
    
    @GetMapping("/getJob/{id}")
    public Optional<Job> findById(@PathVariable Integer id) {
        return jobServices.findById(id);
    }
    
    @GetMapping("/getAllJobs")
    public List<Job> getAllJobs() {
        List <Job> jobs = jobServices.findAll();
        System.out.println(jobs);
        return jobs;
    }
    
}
