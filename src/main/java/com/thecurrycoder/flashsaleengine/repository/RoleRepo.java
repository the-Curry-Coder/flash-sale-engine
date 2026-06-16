package com.thecurrycoder.flashsaleengine.repository;

import com.thecurrycoder.flashsaleengine.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
