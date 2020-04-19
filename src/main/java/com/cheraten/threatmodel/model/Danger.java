package com.cheraten.threatmodel.model;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Danger {
    private String dangerString;

    public Danger() {
    }

    @ModelAttribute("danger")
    public Danger getFeasibility(){
        return new Danger();
    }

    public Danger(String dangerString) {
        this.dangerString = dangerString;

    }

    public String getDangerString() {
        return dangerString;
    }

    public void setDangerString(String dangerString) {
        this.dangerString = dangerString;
    }
}
