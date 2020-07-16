package com.cheraten.threatmodel.repo;

import com.cheraten.threatmodel.entity.ISystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISystemRepository extends JpaRepository<ISystem, Long> {
    ISystem findByName (String name);
}
