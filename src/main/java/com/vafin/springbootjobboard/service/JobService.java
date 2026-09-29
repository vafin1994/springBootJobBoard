package com.vafin.springbootjobboard.service;

import com.vafin.springbootjobboard.model.JobPost;
import com.vafin.springbootjobboard.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public JobPost addJob(JobPost jobPost) {
        return repository.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repository.getAllJobs();
    }

    public JobPost getJobById(int id) {
        return repository.getJobById(id);
    }

    public JobPost updateJob(JobPost jobPost) {
        return repository.updateJob(jobPost);
    }

    public String deleteJobById(int id) {
        return this.repository.deleteJobById(id);
    }
}
