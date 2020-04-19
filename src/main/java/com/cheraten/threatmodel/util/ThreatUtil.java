package com.cheraten.threatmodel.util;

import java.util.ArrayList;

public class ThreatUtil {
    private static int Y1 = -1;
    private static int Y2 = -1;

    public static String findSequrityLevel(ArrayList<String> sequrityLevelList) {
        int highLevelCount = 0;
        int mediumLevelCount = 0;
        int lowLevelCount = 0;
        for (int i = 0; i < sequrityLevelList.size(); i++) {
            if (sequrityLevelList.get(i).equals("high"))
                highLevelCount++;
            if (sequrityLevelList.get(i).equals("medium"))
                mediumLevelCount++;
            if (sequrityLevelList.get(i).equals("low"))
                lowLevelCount++;
        }

        String finalSequrityLevel = null;
        if (sequrityLevelList.size() * 0.7 < highLevelCount && lowLevelCount == 0) {
            finalSequrityLevel = "Высокий";
            Y1 = 0;
        } else {
            if (sequrityLevelList.size() * 0.3 > lowLevelCount) {
                finalSequrityLevel = "Средний";
                Y1 = 5;
            } else {
                finalSequrityLevel = "Низкий";
                Y1 = 10;
            }
        }
        System.out.println("Исходный уровень защищённости системы: " + finalSequrityLevel);
        return finalSequrityLevel;
    }

    public static String findProbabilityThreat(ArrayList<String> probabilityList) {
        String finalprobabilityThreat = null;
        for (int i = 0; i < probabilityList.size(); i++) {
            if (probabilityList.get(i).equals("medium")) {
                finalprobabilityThreat = "Средняя";
                Y2 = 5;
            }
            if (probabilityList.get(i).equals("high")) {
                finalprobabilityThreat = "Высокая";
                Y2 = 10;
                break;
            }
        }
        if (finalprobabilityThreat == null) {
            finalprobabilityThreat = "Низкая";
            Y2 = 0;
        }
        System.out.println("Вероятность реализации угрозы: " + finalprobabilityThreat);
        return finalprobabilityThreat;
    }

    public static String findFeasibilityThreat() {
        float Y = (float) (Y1 + Y2) / 20;
        String feasibilityThreat = null;
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
        System.out.println("Реализуемость угрозы: " + feasibilityThreat);
        return feasibilityThreat;
    }

    public static String findDangerThreat(String dangerString) {
        String danger = null;
        if (dangerString.equals("low"))
            danger = "Низкая";
        if (dangerString.equals("medium"))
            danger = "Средняя";
        if (dangerString.equals("high"))
            danger = "Высокая";
        System.out.println("Опасность угрозы: " + danger);
        return danger;
    }

    public static String findRelevanceThreat(String danger, String feasibility) {
        String relevanceThreat = null;
        if ((feasibility == "Низкая" &&  danger == "Низкий") ||
                (feasibility == "Средняя" &&  danger == "Низкий") ||
                (feasibility == "Низкая" &&  danger == "Средний"))
            relevanceThreat = "Неактуальная угроза";
        else
            relevanceThreat = "Актуальная угроза";
        return relevanceThreat;
    }
}
