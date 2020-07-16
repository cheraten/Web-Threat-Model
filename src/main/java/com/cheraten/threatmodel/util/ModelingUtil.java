package com.cheraten.threatmodel.util;

import java.util.ArrayList;

public class ModelingUtil {
    public static String findSecurityLevel(ArrayList<String> securityLevelList) {
        int highLevelCount = 0;
        int mediumLevelCount = 0;
        int lowLevelCount = 0;
        String finalSecurityLevel = "unconfined";
        for (int i = 0; i < securityLevelList.size(); i++) {
            if (securityLevelList.get(i).equals("high"))
                highLevelCount++;
            if (securityLevelList.get(i).equals("medium"))
                mediumLevelCount++;
            if (securityLevelList.get(i).equals("low"))
                lowLevelCount++;
        }
        if (securityLevelList.size() * 0.7 < highLevelCount && lowLevelCount == 0) {
            finalSecurityLevel = "Высокий";
        } else {
            if (securityLevelList.size() * 0.3 > lowLevelCount) {
                finalSecurityLevel = "Средний";
            } else {
                finalSecurityLevel = "Низкий";
            }
        }
        return finalSecurityLevel;
    }

    public static String findProbabilityThreat(ArrayList<String> probabilityList) {
        String finalProbabilityThreat = "unconfined";
        for (int i = 0; i < probabilityList.size(); i++) {
            if (probabilityList.get(i).equals("medium")) {
                finalProbabilityThreat = "Средняя";
            }
            if (probabilityList.get(i).equals("high")) {
                finalProbabilityThreat = "Высокая";
                break;
            }
        }
        if (finalProbabilityThreat.equals("unconfined")) {
            finalProbabilityThreat = "Низкая";
        }
        return finalProbabilityThreat;
    }

    public static String findFeasibilityThreat(String securityLevel, String probability) {
        int Y1 = -1;
        int Y2 = -1;
        String feasibilityThreat = "unconfined";

        if (!probability.equals("unconfined")) {
            if (securityLevel.equals("Высокий"))
                Y1 = 0;
            if (securityLevel.equals("Средний"))
                Y1 = 5;
            if (securityLevel.equals("Низкий"))
                Y1 = 10;

            if (probability.equals("Высокая"))
                Y2 = 10;
            if (probability.equals("Средняя"))
                Y2 = 5;
            if (securityLevel.equals("Низкая"))
                Y2 = 0;

            float Y = (float) (Y1 + Y2) / 20;

            if (Y <= 0.3)
                feasibilityThreat = "Низкая";
            else {
                if (Y <= 0.6)
                    feasibilityThreat = "Средняя";
                else {
                    if (Y <= 0.8)
                        feasibilityThreat = "Высокая";
                    else
                        feasibilityThreat = "Очень высокая";
                }
            }
        }
        return feasibilityThreat;
    }

    public static String findDangerThreat(String dangerString) {
        String danger = "unconfined";
        if (dangerString.equals("low"))
            danger = "Низкая";
        if (dangerString.equals("medium"))
            danger = "Средняя";
        if (dangerString.equals("high"))
            danger = "Высокая";
        return danger;
    }

    public static String findRelevanceThreat(String feasibility, String danger) {
        String relevanceThreat = "unconfined";
        System.out.println(feasibility);
        System.out.println(danger);
        if (!danger.equals("unconfined") && !feasibility.equals("unconfined")) {
            if ((feasibility.equals("Низкая") && danger.equals("Низкая")) ||
                    (feasibility.equals("Средняя") && danger.equals("Низкая")) ||
                    (feasibility.equals("Низкая") && danger.equals("Средняя")))
                relevanceThreat = "Неактуальная угроза";
            else
                relevanceThreat = "Актуальная угроза";
        }
        return relevanceThreat;
    }
}
