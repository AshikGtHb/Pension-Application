package com.ashik.pension.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ashik.pension.model.Pension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ashik.pension.repository.PensionRepository;

@Service
public class PensionService {
    @Autowired
    private PensionRepository pensionRepository;
    
    private List<Pension> pensions = new ArrayList<>();
    
    public List<Pension> getAll() {
        return pensions;
    }

    public Pension add(Pension pension) {
        pensions.add(pension);
        return pension;
    }

    public void deleteAll() {
    pensionRepository.deleteAll();
}
    public Pension getById(Long id) {
        return pensionRepository.findById(id).orElse(null);
    }
    public void delete(Long id) {
    pensionRepository.deleteById(id);
}
public Pension update(Long id, Pension pension) {
    Pension existingPension = pensionRepository.findById(id).orElse(null);
    if (existingPension != null) {
        existingPension.setEmployeeName(pension.getEmployeeName());
        existingPension.setDepartment(pension.getDepartment());
        existingPension.setContributionAmount(pension.getContributionAmount());
        return pensionRepository.save(existingPension);
    }
    return null;
}

}

