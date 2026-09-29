package com.vafin.springbootjobboard.service;

import com.vafin.springbootjobboard.model.JobPost;
import com.vafin.springbootjobboard.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {


    @Autowired
    private JobRepository repository;

    public JobPost addJob(JobPost jobPost) {
        return repository.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repository.findAll();
    }

    public JobPost getJobById(int id) {
        return repository.findById(id).orElse(null);
    }

    public JobPost updateJob(JobPost jobPost) {
        return repository.save(jobPost);
    }

    public void deleteJobById(int id) {
        this.repository.deleteById(id);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<JobPost>(Arrays.asList(
                new JobPost(1, "Java Developer", "Build and maintain backend services using Java and Spring Boot",
                        2, List.of("Java", "Spring Boot", "Hibernate", "PostgreSQL")),
                new JobPost(2, "Frontend Developer", "Develop responsive web interfaces with modern JavaScript frameworks",
                        3, List.of("JavaScript", "React", "HTML", "CSS")),
                new JobPost(3, "Data Scientist", "Analyze large datasets and build machine learning models",
                        4, List.of("Python", "Pandas", "scikit-learn", "SQL")),
                new JobPost(4, "DevOps Engineer", "Automate deployments and manage cloud infrastructure",
                        3, List.of("Docker", "Kubernetes", "AWS", "Terraform")),
                new JobPost(5, "Full Stack Developer", "Work across the stack to deliver end-to-end features",
                        5, List.of("Java", "Spring Boot", "Angular", "MySQL"))
        ));

        repository.saveAll(jobs);
    }

    public List<JobPost> search(String text) {
        return this.repository.findByPostProfileContainingOrPostDescContaining(text, text);
    }
}
