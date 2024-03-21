package com.example.healhub.Service;

import com.example.healhub.Entity.Appointment;
import com.example.healhub.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long appointmentId) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(appointmentId);
        return appointmentOptional.orElse(null);
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    // Add more service methods as needed
}
