package com.vafin.springbootjobboard.repository;

import com.vafin.springbootjobboard.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {

}
