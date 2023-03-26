package com.fixmyride.service;

import com.fixmyride.error.ResourceNotFoundException;
import com.fixmyride.model.dto.appointment.AppointmentDTO;
import com.fixmyride.model.dto.user.entity.Appointment;
import com.fixmyride.model.dto.user.entity.Mechanic;
import com.fixmyride.model.dto.user.entity.Vehicle;
import com.fixmyride.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + id));
        return convertToDTO(appointment);
    }

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = convertToEntity(appointmentDTO);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return convertToDTO(savedAppointment);
    }

    public AppointmentDTO updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Appointment existingAppointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + id));
        Appointment appointmentToUpdate = convertToEntity(appointmentDTO);
        appointmentToUpdate.setId(existingAppointment.getId());
        Appointment updatedAppointment = appointmentRepository.save(appointmentToUpdate);
        return convertToDTO(updatedAppointment);
    }

    public boolean deleteAppointment(Long id) {
        Appointment appointmentToDelete = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id " + id));
        appointmentRepository.delete(appointmentToDelete);
        return false;
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        AppointmentDTO appointmentDTO = new AppointmentDTO();
        appointmentDTO.setId(appointment.getId());
        appointmentDTO.setStartTime(appointment.getStartTime());
        appointmentDTO.setEndTime(appointment.getEndTime());
        appointmentDTO.setNotes(appointment.getNotes());
        appointmentDTO.setVehicleId(appointment.getVehicleId().getId());
        appointmentDTO.setMechanicId(appointment.getMechanic().getId());
        return appointmentDTO;
    }

    private Appointment convertToEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setStartTime(appointmentDTO.getStartTime());
        appointment.setEndTime(appointmentDTO.getEndTime());
        appointment.setNotes(appointmentDTO.getNotes());
        Vehicle vehicle = new Vehicle();
        vehicle.setId(appointmentDTO.getVehicleId());
        appointment.setVehicleId(vehicle);
        Mechanic mechanic = new Mechanic();
        mechanic.setId(appointmentDTO.getMechanicId());
        appointment.setMechanic(mechanic);
        return appointment;
    }
}
