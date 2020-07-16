package com.cheraten.threatmodel.repo;

import com.cheraten.threatmodel.entity.Threat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThreatRepository extends JpaRepository<Threat, Long> {
    List<Threat> findByName (String name);
}
