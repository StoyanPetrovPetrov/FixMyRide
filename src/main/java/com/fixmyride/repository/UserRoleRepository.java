package com.fixmyride.repository;


import java.util.Optional;

import com.fixmyride.model.dto.user.entity.UserRoleEntity;
import com.fixmyride.model.dto.user.entity.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
  Optional<UserRoleEntity> findUserRoleEntityByRole(UserRoleEnum role);
}
