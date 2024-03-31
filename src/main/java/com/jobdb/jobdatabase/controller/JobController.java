package com.jobdb.jobdatabase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jobdb.jobdatabase.model.Job;
import com.jobdb.jobdatabase.services.JobServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1")
public class JobController {
   
    @Autowired
    private JobServices jobServices;

    @GetMapping("/getAllJobs")
    public List<Job> getAllJobs() {
        List <Job> jobs = jobServices.findAll();
        System.out.println(jobs);
        return jobs;
    }

    @PostMapping("/saveJob")
    public String saveJob(@RequestBody Job job) {
        Job savedJob = jobServices.save(job);
        int jobId = savedJob.getId(); 
        String message = "Job Saved Successfully. Id No is = " + jobId;
        System.out.println(message);
        return message;
    }

    @GetMapping("/getJob/{id}")
    public Job getJob(@PathVariable Integer id){
        System.out.println("The input value for get job = " + id);
        return jobServices.getJobById(id);
    }
 
    @PutMapping("/updateJob/{id}")
    public Job updateJob(@PathVariable Integer id, @RequestBody Job job){
      System.out.println("The input value for update job = " + id);
      return jobServices.updateJob(id, job);
    }


    @DeleteMapping("/deleteJob/{id}")
    public Job deleteJob(@PathVariable Integer id){
        System.out.println("The input value for delete job = " + id);
        return jobServices.getJobById(id);
    }
    
}