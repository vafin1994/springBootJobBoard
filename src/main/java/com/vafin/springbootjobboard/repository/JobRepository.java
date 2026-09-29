package com.vafin.springbootjobboard.repository;

import com.vafin.springbootjobboard.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepository {

    private final List<JobPost> jobs = new ArrayList<JobPost>(Arrays.asList(
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


    public List<JobPost> getAllJobs() {
        return this.jobs;
    }

    public JobPost addJob(JobPost jobPost) {
        this.jobs.add(jobPost);
        int jobPostId = jobPost.getPostId();
        return getJobById(jobPostId);
    }

    public JobPost getJobById(int id) {
        for (JobPost job : this.jobs) {
            if (job.getPostId() == id) {
                return job;
            }
        }

        return null;
    }

    public JobPost updateJob(JobPost jobPost) {
        for (JobPost job : this.jobs) {
            if (job.getPostId() == jobPost.getPostId()) {
                job.setPostProfile(jobPost.getPostProfile());
                job.setPostDesc(jobPost.getPostDesc());
                job.setReqExperience(jobPost.getReqExperience());
                job.setPostTechStack(jobPost.getPostTechStack());
            }
        }

        return this.getJobById(jobPost.getPostId());
    }

    public String deleteJobById(int id) {
        boolean result = this.jobs.removeIf(job -> job.getPostId() == id);
        if (result) {
            return "Job has been deleted";
        } else {
            return "No Jobs can be deleted";
        }
    }
}
