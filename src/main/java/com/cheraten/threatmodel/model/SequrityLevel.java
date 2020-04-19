package com.cheraten.threatmodel.model;

import org.springframework.web.bind.annotation.ModelAttribute;

public class SequrityLevel {
    private String sequrityLevel1;
    private String sequrityLevel2;
    private String sequrityLevel3;
    private String sequrityLevel4;
    private String sequrityLevel5;
    private String sequrityLevel6;
    private String sequrityLevel7;
    private String sequrityLevel8;
    private String sequrityLevel9;
    private String sequrityLevel10;

    public SequrityLevel() {
    }

    @ModelAttribute("sequrityLevel")
    public SequrityLevel getSequrityLevel(){
        return new SequrityLevel();
    }

    public SequrityLevel(String sequrityLevel1, String sequrityLevel2, String sequrityLevel3,
                         String sequrityLevel4, String sequrityLevel5, String sequrityLevel6,
                         String sequrityLevel7, String sequrityLevel8, String sequrityLevel9,
                         String sequrityLevel10) {
        this.sequrityLevel1 = sequrityLevel1;
        this.sequrityLevel2 = sequrityLevel2;
        this.sequrityLevel3 = sequrityLevel3;
        this.sequrityLevel4 = sequrityLevel4;
        this.sequrityLevel5 = sequrityLevel5;
        this.sequrityLevel6 = sequrityLevel6;
        this.sequrityLevel7 = sequrityLevel7;
        this.sequrityLevel8 = sequrityLevel8;
        this.sequrityLevel9 = sequrityLevel9;
        this.sequrityLevel10 = sequrityLevel10;
    }

    public String getSequrityLevel1() {
        return sequrityLevel1;
    }

    public String getSequrityLevel2() {
        return sequrityLevel2;
    }

    public String getSequrityLevel3() {
        return sequrityLevel3;
    }

    public String getSequrityLevel4() {
        return sequrityLevel4;
    }

    public String getSequrityLevel5() {
        return sequrityLevel5;
    }

    public String getSequrityLevel6() {
        return sequrityLevel6;
    }

    public String getSequrityLevel7() {
        return sequrityLevel7;
    }

    public String getSequrityLevel8() {
        return sequrityLevel8;
    }

    public String getSequrityLevel9() {
        return sequrityLevel9;
    }

    public String getSequrityLevel10() {
        return sequrityLevel10;
    }

    public void setSequrityLevel1(String sequrityLevel1) {
        this.sequrityLevel1 = sequrityLevel1;
    }

    public void setSequrityLevel2(String sequrityLevel2) {
        this.sequrityLevel2 = sequrityLevel2;
    }

    public void setSequrityLevel3(String sequrityLevel3) {
        this.sequrityLevel3 = sequrityLevel3;
    }

    public void setSequrityLevel4(String sequrityLevel4) {
        this.sequrityLevel4 = sequrityLevel4;
    }

    public void setSequrityLevel5(String sequrityLevel5) {
        this.sequrityLevel5 = sequrityLevel5;
    }

    public void setSequrityLevel6(String sequrityLevel6) {
        this.sequrityLevel6 = sequrityLevel6;
    }

    public void setSequrityLevel7(String sequrityLevel7) {
        this.sequrityLevel7 = sequrityLevel7;
    }

    public void setSequrityLevel8(String sequrityLevel8) {
        this.sequrityLevel8 = sequrityLevel8;
    }

    public void setSequrityLevel9(String sequrityLevel9) {
        this.sequrityLevel9 = sequrityLevel9;
    }

    public void setSequrityLevel10(String sequrityLevel10) {
        this.sequrityLevel10 = sequrityLevel10;
    }
}
