package com.example.healhub.Service;

import com.example.healhub.Entity.Specialty;
import com.example.healhub.Repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.findAll();
    }

    public Specialty getSpecialtyById(Long specialtyId) {
        Optional<Specialty> specialtyOptional = specialtyRepository.findById(specialtyId);
        return specialtyOptional.orElse(null);
    }

    public Specialty createSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public void deleteSpecialty(Long specialtyId) {
        specialtyRepository.deleteById(specialtyId);
    }

    // Add more service methods as needed
}
