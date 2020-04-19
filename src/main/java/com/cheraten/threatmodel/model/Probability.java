package com.cheraten.threatmodel.model;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Probability {
    private String probabilityString;

    public Probability() {
    }

    @ModelAttribute("probability")
    public Probability getProbability(){
        return new Probability();
    }

    public Probability(String probabilityString) {
        this.probabilityString = probabilityString;

    }

    public String getProbabilityString() {
        return probabilityString;
    }

    public void setProbabilityString(String probabilityString) {
        this.probabilityString = probabilityString;
    }
}
