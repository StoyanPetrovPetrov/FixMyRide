package com.fixmyride.repository;

import com.fixmyride.model.dto.user.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findByVehicleId(Long vehicleId);
    List<Appointment> findByMechanicId(Long mechanicId);

}
