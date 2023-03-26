package com.fixmyride.web;

import com.fixmyride.model.dto.vehicle.VehicleDTO;
import com.fixmyride.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) {
        VehicleDTO createdVehicle = vehicleService.createVehicle(vehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVehicle);
    }
}
