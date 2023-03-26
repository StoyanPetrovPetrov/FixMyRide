package com.fixmyride.service;

import com.fixmyride.model.dto.mechanic.MechanicDTO;
import com.fixmyride.model.dto.user.entity.Mechanic;
import com.fixmyride.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MechanicService {

    private final MechanicRepository mechanicRepository;
    private MechanicDTO mapMechanicToMechanicDTO(Mechanic mechanic) {
        MechanicDTO mechanicDTO = new MechanicDTO();
        mechanicDTO.setId(mechanic.getId());
        mechanicDTO.setFirstName(mechanic.getFirstName());
        mechanicDTO.setLastName(mechanic.getLastName());
        mechanicDTO.setCertification(mechanic.getCertification());
        mechanicDTO.setPhone(mechanic.getPhone());
        mechanicDTO.setEmail(mechanic.getEmail());
        return mechanicDTO;
    }

    @Autowired
    public MechanicService(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    public MechanicDTO createMechanic(MechanicDTO mechanicDTO) {
        Mechanic mechanic = new Mechanic();
        mechanic.setFirstName(mechanicDTO.getFirstName());
        mechanic.setLastName(mechanicDTO.getLastName());
        mechanic.setCertification(mechanicDTO.getCertification());
        mechanic.setPhone(mechanicDTO.getPhone());
        mechanic.setEmail(mechanicDTO.getEmail());
        Mechanic createdMechanic = mechanicRepository.save(mechanic);
        return mapMechanicToMechanicDTO(createdMechanic);
    }

    public MechanicDTO getMechanicById(Long id) {
        Mechanic mechanic = mechanicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mechanic not found"));
        return mapMechanicToMechanicDTO(mechanic);
    }

    public MechanicDTO updateMechanic(Long id, MechanicDTO mechanicDTO) {
        Mechanic mechanicToUpdate = mechanicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mechanic not found"));

        mechanicToUpdate.setFirstName(mechanicDTO.getFirstName());
        mechanicToUpdate.setLastName(mechanicDTO.getLastName());
        mechanicToUpdate.setCertification(mechanicDTO.getCertification());
        mechanicToUpdate.setPhone(mechanicDTO.getPhone());
        mechanicToUpdate.setEmail(mechanicDTO.getEmail());

        Mechanic updatedMechanic = mechanicRepository.save(mechanicToUpdate);
        return mapMechanicToMechanicDTO(updatedMechanic);
    }

    public void deleteMechanic(Long id){
        mechanicRepository.deleteById(id);
    }
}
