package com.cheraten.threatmodel.model;

import org.springframework.web.bind.annotation.ModelAttribute;

public class SecurityLevel {
    private String securityLevel1;
    private String securityLevel2;
    private String securityLevel3;
    private String securityLevel4;
    private String securityLevel5;
    private String securityLevel6;
    private String securityLevel7;
    private String securityLevel8;
    private String securityLevel9;
    private String securityLevel10;
    private Long isystemId;

    public SecurityLevel() {
    }

    @ModelAttribute("securityLevel")
    public SecurityLevel getSecurityLevel(){
        return new SecurityLevel();
    }

    public SecurityLevel(String securityLevel1, String securityLevel2, String securityLevel3,
                         String securityLevel4, String securityLevel5, String securityLevel6,
                         String securityLevel7, String securityLevel8, String securityLevel9,
                         String securityLevel10, Long isystemId) {
        this.securityLevel1 = securityLevel1;
        this.securityLevel2 = securityLevel2;
        this.securityLevel3 = securityLevel3;
        this.securityLevel4 = securityLevel4;
        this.securityLevel5 = securityLevel5;
        this.securityLevel6 = securityLevel6;
        this.securityLevel7 = securityLevel7;
        this.securityLevel8 = securityLevel8;
        this.securityLevel9 = securityLevel9;
        this.securityLevel10 = securityLevel10;
        this.isystemId = isystemId;
    }

    public String getSecurityLevel1() {
        return securityLevel1;
    }

    public String getSecurityLevel2() {
        return securityLevel2;
    }

    public String getSecurityLevel3() {
        return securityLevel3;
    }

    public String getSecurityLevel4() {
        return securityLevel4;
    }

    public String getSecurityLevel5() {
        return securityLevel5;
    }

    public String getSecurityLevel6() {
        return securityLevel6;
    }

    public String getSecurityLevel7() {
        return securityLevel7;
    }

    public String getSecurityLevel8() {
        return securityLevel8;
    }

    public String getSecurityLevel9() {
        return securityLevel9;
    }

    public String getSecurityLevel10() {
        return securityLevel10;
    }

    public void setSecurityLevel1(String securityLevel1) {
        this.securityLevel1 = securityLevel1;
    }

    public void setSecurityLevel2(String securityLevel2) {
        this.securityLevel2 = securityLevel2;
    }

    public void setSecurityLevel3(String securityLevel3) {
        this.securityLevel3 = securityLevel3;
    }

    public void setSecurityLevel4(String securityLevel4) {
        this.securityLevel4 = securityLevel4;
    }

    public void setSecurityLevel5(String securityLevel5) {
        this.securityLevel5 = securityLevel5;
    }

    public void setSecurityLevel6(String securityLevel6) {
        this.securityLevel6 = securityLevel6;
    }

    public void setSecurityLevel7(String securityLevel7) {
        this.securityLevel7 = securityLevel7;
    }

    public void setSecurityLevel8(String securityLevel8) {
        this.securityLevel8 = securityLevel8;
    }

    public void setSecurityLevel9(String securityLevel9) {
        this.securityLevel9 = securityLevel9;
    }

    public void setSecurityLevel10(String securityLevel10) {
        this.securityLevel10 = securityLevel10;
    }


    public Long getIsystemId() {
        return isystemId;
    }

    public void setIsystemId(Long isystemId) {
        this.isystemId = isystemId;
    }
}
