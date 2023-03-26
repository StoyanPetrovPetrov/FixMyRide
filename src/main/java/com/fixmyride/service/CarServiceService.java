package com.fixmyride.service;

import com.fixmyride.model.dto.service.CarServiceDTO;
import com.fixmyride.model.dto.user.entity.CarService;
import com.fixmyride.repository.CarServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceService {

    @Autowired
    private CarServiceRepository carServiceRepository;

    public List<CarService> getAllServices() {
        return carServiceRepository.findAll();
    }

    public CarService getServiceById(Long id) {
        Optional<CarService> optionalService = carServiceRepository.findById(id);
        return optionalService.orElse(null);
    }

    public CarServiceDTO updateService(CarServiceDTO serviceDTO) {
        return carServiceRepository.save(serviceDTO);
    }

    public void deleteService(Long id) {
        carServiceRepository.deleteById(id);
    }

}
