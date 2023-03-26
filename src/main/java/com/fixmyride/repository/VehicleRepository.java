package com.fixmyride.repository;

import com.fixmyride.model.dto.user.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    List<Vehicle> findByUserId(Long userId);
    Optional<Vehicle> findByVin(String vin);

}
