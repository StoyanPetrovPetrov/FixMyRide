package com.fixmyride.web;

import com.fixmyride.model.dto.mechanic.MechanicDTO;
import com.fixmyride.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mechanic")
public class MechanicController {

    private final MechanicService mechanicService;

    @Autowired
    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @PostMapping
    public ResponseEntity<MechanicDTO> createMechanic(@RequestBody MechanicDTO mechanicDTO) {
        MechanicDTO createdMechanic = mechanicService.createMechanic(mechanicDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMechanic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MechanicDTO> getMechanicById(@PathVariable Long id) {
        MechanicDTO mechanic = mechanicService.getMechanicById(id);
        return ResponseEntity.ok(mechanic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MechanicDTO> updateMechanic(@PathVariable Long id, @RequestBody MechanicDTO mechanicDTO) {
        MechanicDTO updatedMechanic = mechanicService.updateMechanic(id, mechanicDTO);
        return ResponseEntity.ok(updatedMechanic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMechanic(@PathVariable Long id) {
        mechanicService.deleteMechanic(id);
        return ResponseEntity.noContent().build();
    }
}

