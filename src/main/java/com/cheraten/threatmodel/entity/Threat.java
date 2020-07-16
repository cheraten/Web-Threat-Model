package com.cheraten.threatmodel.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "t_threat")
public class Threat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    private ISystem isystem;
    @JoinColumn(name = "probability")
    private String probability;
    @JoinColumn(name = "feasibility")
    private String feasibility;
    @JoinColumn(name = "danger")
    private String danger;
    @JoinColumn(name = "relevance")
    private String relevance;

    public Threat() {
    }

    public Threat(Long id, String name, String probability, String feasibility, String danger, String relevance) {
        this.id = id;
        this.name = name;
        this.probability = probability;
        this.feasibility = feasibility;
        this.danger = danger;
        this.relevance = relevance;
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

    public ISystem getIsystem() {
        return isystem;
    }

    public void setIsystem(ISystem isystem) {
        this.isystem = isystem;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getFeasibility() {
        return feasibility;
    }

    public void setFeasibility(String feasibility) {
        this.feasibility = feasibility;
    }

    public String getDanger() {
        return danger;
    }

    public void setDanger(String danger) {
        this.danger = danger;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }
}