package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Recruiter;
import com.sistemi.informativi.repository.RecruiterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    /*
    La logica di business non è presente per questioni temporali
     */

    private final RecruiterRepository recruiterRepository;

    public RecruiterServiceImpl(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    public List<Recruiter> getRecruiters() {
        return recruiterRepository.findAll();
    }

    @Override
    public List<Recruiter> getRecruitersByExperienceYears(int experienceYear) {
        return recruiterRepository.findByExperienceYearsGreaterThan(experienceYear);
    }

    @Override
    public List<Recruiter> saveMoreRecruiters(List<Recruiter> recruiters) {
        return recruiterRepository.saveAll(recruiters);
    }
}
