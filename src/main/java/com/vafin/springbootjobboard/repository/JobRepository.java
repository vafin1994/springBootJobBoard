package com.vafin.springbootjobboard.repository;

import com.vafin.springbootjobboard.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {

    @Query()
    public List<JobPost> findByPostProfileContainingOrPostDescContaining(String profile, String description);
}
