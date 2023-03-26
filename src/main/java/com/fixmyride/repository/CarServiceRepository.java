package com.fixmyride.repository;

import com.fixmyride.model.dto.service.CarServiceDTO;
import com.fixmyride.model.dto.user.entity.CarService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarServiceRepository extends JpaRepository<CarService,Long> {
    // method to retrieve all services
    List<CarService> findAll();

    // method to retrieve a service by id
    Optional<CarService> findById(Long id);

    // method to update an existing service
    <S extends CarServiceDTO> S save(S service);

    // method to delete a service by id
    void deleteById(Long id);




}
