package com.fixmyride.web;

import com.fixmyride.model.dto.service.CarServiceDTO;
import com.fixmyride.model.dto.user.entity.CarService;
import com.fixmyride.service.CarServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
public class CarServiceController {

    @Autowired
    private CarServiceService carServiceService;

    @GetMapping
    public List<CarService> getAllServices() {
        return carServiceService.getAllServices();
    }

    @GetMapping("/{id}")
    public CarService getServiceById(@PathVariable Long id) {
        return carServiceService.getServiceById(id);
    }

    @PostMapping
    public CarServiceDTO createService(@RequestBody CarServiceDTO serviceDTO) {
        // set id to null to ensure a new entity is created instead of updating an existing one
        serviceDTO.setId(null);
        return carServiceService.updateService(serviceDTO);
    }

    @PutMapping("/{id}")
    public CarServiceDTO updateService(@PathVariable Long id, @RequestBody CarServiceDTO serviceDTO) {
        // ensure that the id of the provided DTO matches the id in the URL path
        serviceDTO.setId(id);
        return carServiceService.updateService(serviceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        carServiceService.deleteService(id);
    }

    @GetMapping("/history")
    public String getCarServiceHistory(Model model) {
        List<CarService> services = carServiceService.getAllServices();
        model.addAttribute("services", services);
        return "CarService";
    }


}


