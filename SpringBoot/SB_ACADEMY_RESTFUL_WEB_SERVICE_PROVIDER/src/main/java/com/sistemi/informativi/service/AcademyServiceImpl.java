package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Academy;
import com.sistemi.informativi.repository.AcademyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "academies")
public class AcademyServiceImpl implements AcademyService{

    AcademyRepository academyRepository;

    public AcademyServiceImpl(AcademyRepository academyRepository) {
        this.academyRepository = academyRepository;
    }

    @Override
    public Academy saveOrUpdateAcademy(Academy academy) {
        try {
            academyRepository.save(academy);
        }catch (Exception e){
            e.printStackTrace();
        }
        return academy;
    }

    @Cacheable(value = "code", key = "#code")
    @Override
    public Academy getAcademyByCode(String code) {
        return academyRepository.findById(code).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Academy> getAllAcademy() {
        List<Academy> academyList = new ArrayList<>();
        try {
            academyList = academyRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return academyList;
    }

    @Override
    public Map<String, Boolean> removeAcademy(String code) {
        try {
            academyRepository.deleteById(code);
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put(code + " elimination",true);
        return map;
    }
}
