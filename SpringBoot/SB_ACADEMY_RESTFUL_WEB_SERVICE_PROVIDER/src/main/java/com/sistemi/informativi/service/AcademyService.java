package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Academy;

import java.util.List;
import java.util.Map;


public interface AcademyService {
    public Academy saveOrUpdateAcademy(Academy academy);
    public Academy getAcademyByCode(String code);
    public List<Academy> getAllAcademy();
    public Map<String, Boolean> removeAcademy(String code);
}
