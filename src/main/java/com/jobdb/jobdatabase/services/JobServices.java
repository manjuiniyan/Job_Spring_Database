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

    public Job save(Job job) {
        Job savedJob = jobRepository.save(job);
        System.out.println("Job Saved Successfully. ID: " + savedJob.getId());
        return savedJob;
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Job getJobById(Integer id) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            System.out.println("Retrieved job with ID: " + id);
            return optionalJob.get();
        } else {
            System.out.println("Job with ID " + id + " not found.");
            return null;
        }
    }

    public Job updateJob(Integer id, Job job) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job existingJob = optionalJob.get();
            existingJob.setJobTitle(job.getJobTitle());
            existingJob.setJobSkills(job.getJobSkills());
            existingJob.setJobDescription(job.getJobDescription());
            existingJob.setPreviousExperience(job.getPreviousExperience());
            existingJob.setSalaryRange(job.getSalaryRange());
            existingJob.setCompany(job.getCompany());
            existingJob.setJobLocation(job.getJobLocation());
            existingJob.setJobType(job.getJobType());
            Job updatedJob = jobRepository.save(existingJob);
            System.out.println("Job with ID " + id + " updated successfully.");
            return updatedJob;
        } else {
            System.out.println("Job with ID " + id + " not found. Update failed.");
            return null;
        }
    }

    public boolean deleteJob(Integer id) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            jobRepository.delete(optionalJob.get());
            System.out.println("Job with ID " + id + " deleted successfully.");
            return true;
        } else {
            System.out.println("Job with ID " + id + " not found. Deletion failed.");
            return false;
        }
    }
}