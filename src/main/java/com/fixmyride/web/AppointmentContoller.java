package com.fixmyride.web;

import com.fixmyride.model.dto.appointment.AppointmentDTO;
import com.fixmyride.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appointments")
public class AppointmentContoller {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody @Valid AppointmentDTO appointmentDTO) {
        AppointmentDTO createdAppointmentDTO = appointmentService.createAppointment(appointmentDTO);
        return new ResponseEntity<>(createdAppointmentDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id) {
        AppointmentDTO appointmentDTO = appointmentService.getAppointmentById(id);
        if (appointmentDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        List<AppointmentDTO> appointmentDTOList = appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointmentDTOList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable Long id, @RequestBody @Valid AppointmentDTO appointmentDTO) {
        AppointmentDTO updatedAppointmentDTO = appointmentService.updateAppointment(id, appointmentDTO);
        if (updatedAppointmentDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAppointmentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        boolean isDeleted = appointmentService.deleteAppointment(id);
        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


