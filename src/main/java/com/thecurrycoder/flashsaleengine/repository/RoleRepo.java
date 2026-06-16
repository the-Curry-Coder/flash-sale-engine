package com.thecurrycoder.flashsaleengine.repository;

import com.thecurrycoder.flashsaleengine.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {



    Role findByRole(String roleName);
}
