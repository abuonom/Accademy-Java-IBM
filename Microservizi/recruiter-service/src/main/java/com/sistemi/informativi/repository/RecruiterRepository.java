package com.sistemi.informativi.repository;

import com.sistemi.informativi.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruiterRepository extends JpaRepository<Recruiter, String> {
    public List<Recruiter> findByExperienceYearsGreaterThan(int experienceYears);
}
