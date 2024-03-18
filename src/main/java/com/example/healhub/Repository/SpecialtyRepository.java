package com.example.healhub.Repository;

import com.example.healhub.Entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    // Add custom query methods if needed
}
