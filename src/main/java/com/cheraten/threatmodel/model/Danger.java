package com.cheraten.threatmodel.model;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Danger {
    private String dangerString;
    private Long threatId;

    public Danger() {
    }

    @ModelAttribute("danger")
    public Danger getFeasibility(){
        return new Danger();
    }

    public Danger(String dangerString, Long threatId) {
        this.dangerString = dangerString;
        this.threatId = threatId;
    }

    public String getDangerString() {
        return dangerString;
    }

    public void setDangerString(String dangerString) {
        this.dangerString = dangerString;
    }

    public Long getThreatId() {
        return threatId;
    }

    public void setThreatId(Long threatId) {
        this.threatId = threatId;
    }
}
