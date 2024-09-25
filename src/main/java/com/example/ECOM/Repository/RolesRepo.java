package com.example.ECOM.Repository;

import com.example.ECOM.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Integer> {

    Roles findByRoleName(String roleName)    ;
}
