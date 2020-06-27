package com.cheraten.threatmodel.repo;

import com.cheraten.threatmodel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

