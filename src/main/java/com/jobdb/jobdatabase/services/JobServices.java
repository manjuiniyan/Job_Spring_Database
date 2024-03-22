package com.jobdb.jobdatabase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobdb.jobdatabase.model.Job;
import com.jobdb.jobdatabase.model.JobRepository;

@Service
public class JobServices {
    @Autowired
    private JobRepository jobRepository;

    //create a save method
    public Job save(Job job) {
        Job jobObj = jobRepository.save(job);
        System.out.println("Job Saved Successfully =" + job.getId());
        return jobObj;
    }
    //create a get method 
    public Optional<Job> findById(int id){
        Optional<Job> optionalJobObj = jobRepository.findById(id);
        return optionalJobObj;

    }

    public List <Job> findAll(){
        return jobRepository.findAll();

    }
    
}
