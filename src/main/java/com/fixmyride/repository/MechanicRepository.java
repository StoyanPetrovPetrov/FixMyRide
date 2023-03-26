package com.fixmyride.repository;

import com.fixmyride.model.dto.user.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic,Long> {

    List<Mechanic> findByCertification(String certification);

}
