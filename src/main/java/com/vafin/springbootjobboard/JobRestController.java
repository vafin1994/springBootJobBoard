package com.vafin.springbootjobboard;

import com.vafin.springbootjobboard.model.JobPost;
import com.vafin.springbootjobboard.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping({"/jobPosts"})
    public List<JobPost> getAllPosts() {
        return jobService.getAllJobs();
    }

    @GetMapping({"/jobPost/{id}"})
    public JobPost getJobPostById(@PathVariable int id) {
        return jobService.getJobById(id);
    }

    @PostMapping({"jobPost"})
    public JobPost createJobPost(@RequestBody JobPost jobPost) {
        return jobService.addJob(jobPost);
    }

    @PutMapping({"/jobPost"})
    public JobPost updateJobPost(@RequestBody JobPost jobPost) {
        return this.jobService.updateJob(jobPost);
    }

    @DeleteMapping({"/jobPost/{id}"})
    public String deleteJobPost(@PathVariable int id) {
        return this.jobService.deleteJobById(id);
    }
}
