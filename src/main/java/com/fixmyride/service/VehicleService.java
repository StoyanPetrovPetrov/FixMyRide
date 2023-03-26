package com.fixmyride.service;

import com.fixmyride.model.dto.vehicle.VehicleDTO;
import com.fixmyride.model.dto.user.entity.Vehicle;
import com.fixmyride.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setMake(vehicleDTO.getMake());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setYear(vehicleDTO.getYear());
        vehicle.setVin(vehicleDTO.getVin());
        vehicle.setUserId(vehicleDTO.getUserId());

        vehicle = vehicleRepository.save(vehicle);
        return toDTO(vehicle);
    }

    private VehicleDTO toDTO(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setMake(vehicle.getMake());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setYear(vehicle.getYear());
        vehicleDTO.setVin(vehicle.getVin());
        vehicleDTO.setUserId(vehicle.getUserId());
        return vehicleDTO;
    }
}
