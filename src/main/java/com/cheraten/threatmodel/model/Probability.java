package com.cheraten.threatmodel.model;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Probability {
    private String probabilityString;
    private Long threatId;

    public Probability() {
    }

    @ModelAttribute("probability")
    public Probability getProbability(){
        return new Probability();
    }

    public Probability(String probabilityString, Long threatId) {
        this.probabilityString = probabilityString;
        this.threatId = threatId;
    }

    public String getProbabilityString() {
        return probabilityString;
    }

    public void setProbabilityString(String probabilityString) {
        this.probabilityString = probabilityString;
    }

    public Long getThreatId() {
        return threatId;
    }

    public void setThreatId(Long threatId) {
        this.threatId = threatId;
    }
}
