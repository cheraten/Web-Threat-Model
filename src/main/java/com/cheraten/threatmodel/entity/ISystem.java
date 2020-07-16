package com.cheraten.threatmodel.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "t_isystem")
public class ISystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String securityLevel;
    @Transient
    @OneToMany(mappedBy = "isystem",cascade = CascadeType.ALL)
    private List<Threat> threats;

    public ISystem() {
    }

    public ISystem(Long id) {
        this.id = id;
    }

    public ISystem(Long id, String name, String securityLevel) {
        this.id = id;
        this.name = name;
        this.securityLevel = securityLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public List<Threat> getThreats() {
        return threats;
    }

    public void setThreats(List<Threat> threats) {
        this.threats = threats;
    }

}


