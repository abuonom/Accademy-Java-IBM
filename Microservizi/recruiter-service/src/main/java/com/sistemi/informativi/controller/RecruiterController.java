package com.sistemi.informativi.controller;

import com.sistemi.informativi.entity.Recruiter;
import com.sistemi.informativi.service.RecruiterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/recruiters")
public class RecruiterController {
    private final RecruiterService recruiterService;

    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @GetMapping
    public List<Recruiter> getRecruiters() {
        return recruiterService.getRecruiters();
    }

    @GetMapping("/greater-than/{experienceYears}")
    public List<Recruiter> getRecruitersByExperienceYears(@PathVariable int experienceYears) {
        return recruiterService.getRecruitersByExperienceYears(experienceYears);
    }

    @PostMapping
    public List<Recruiter> saveMoreRecruiters(@RequestBody List<Recruiter> recruiters) {
        return recruiterService.saveMoreRecruiters(recruiters);
    }

}
