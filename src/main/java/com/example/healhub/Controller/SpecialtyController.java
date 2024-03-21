package com.example.healhub.Controller;

import com.example.healhub.Entity.Specialty;
import com.example.healhub.Service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specialties")
public class SpecialtyController {

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping
    public List<Specialty> getAllSpecialties() {
        return specialtyService.getAllSpecialties();
    }

    @GetMapping("/{specialtyId}")
    public Specialty getSpecialtyById(@PathVariable Long specialtyId) {
        return specialtyService.getSpecialtyById(specialtyId);
    }

    @PostMapping
    public Specialty createSpecialty(@RequestBody Specialty specialty) {
        return specialtyService.createSpecialty(specialty);
    }

    @DeleteMapping("/{specialtyId}")
    public void deleteSpecialty(@PathVariable Long specialtyId) {
        specialtyService.deleteSpecialty(specialtyId);
    }

    // Add more endpoints as needed
}
