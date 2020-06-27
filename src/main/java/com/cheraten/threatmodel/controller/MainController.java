package com.cheraten.threatmodel.controller;

import com.cheraten.threatmodel.model.Danger;
import com.cheraten.threatmodel.model.Probability;
import com.cheraten.threatmodel.model.SequrityLevel;

import com.cheraten.threatmodel.service.QuestionService;
import com.cheraten.threatmodel.util.ThreatUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class MainController {
    private static QuestionService service;
    private static ThreatUtil util;
    private static String finalSequrityLevel;
    private static String finalProbability;

    @RequestMapping(value={"/sequritylevel"}, method = RequestMethod.GET)
    public ModelAndView getQList1() {
        ModelAndView modelAndView = new ModelAndView();
        SequrityLevel sequrityLevel = new SequrityLevel();

        modelAndView.setViewName("sequritylevel.jsp");
        modelAndView.addObject("sequrityLevel", sequrityLevel);

        return modelAndView;
    }

    @RequestMapping(value = "/sequritylevel", method = RequestMethod.POST)
    public ModelAndView postQList1(@ModelAttribute("sequrityLevel") SequrityLevel sequrityLevel) {
        ModelAndView modelAndView = new ModelAndView();

        String[] splitString2 = service.splitString(sequrityLevel.getSequrityLevel2());
        String[] splitString3 = service.splitString(sequrityLevel.getSequrityLevel3());
        ArrayList<String> sequrityLevelList = new ArrayList<>();
        sequrityLevelList.add(sequrityLevel.getSequrityLevel1());
        for (int i = 0; i < splitString2.length; i++)
            sequrityLevelList.add(splitString2[i]);
        for (int i = 0; i < splitString3.length; i++)
            sequrityLevelList.add(splitString3[i]);
        sequrityLevelList.add(sequrityLevel.getSequrityLevel4());
        sequrityLevelList.add(sequrityLevel.getSequrityLevel5());
        sequrityLevelList.add(sequrityLevel.getSequrityLevel6());
        sequrityLevelList.add(sequrityLevel.getSequrityLevel7());
        sequrityLevelList.add(sequrityLevel.getSequrityLevel8());
        sequrityLevelList.add(sequrityLevel.getSequrityLevel9());
        sequrityLevelList.add(sequrityLevel.getSequrityLevel10());
        finalSequrityLevel = util.findSequrityLevel(sequrityLevelList);

        Probability probability = new Probability();
        modelAndView.setViewName("probability.jsp");
        modelAndView.addObject("probability", probability);
        return modelAndView;
    }

    @RequestMapping(value={"/probability"}, method = RequestMethod.GET)
    public ModelAndView getQList2() {
        ModelAndView modelAndView = new ModelAndView();
        Probability probability = new Probability();

        modelAndView.setViewName("probability.jsp");
        modelAndView.addObject("probability", probability);

        return modelAndView;
    }

    @RequestMapping(value = "/probability", method = RequestMethod.POST)
    public ModelAndView postQList2(@ModelAttribute("probability") Probability probability) {
        ModelAndView modelAndView = new ModelAndView();

        String[] splitString = service.splitString(probability.getProbabilityString());
        ArrayList<String> probabilityList = new ArrayList<>();
        for (int i = 0; i < splitString.length; i++)
            probabilityList.add(splitString[i]);
        finalProbability = util.findProbabilityThreat(probabilityList);

        Danger danger = new Danger();
        modelAndView.setViewName("danger.jsp");
        modelAndView.addObject("danger", danger);
        return modelAndView;
    }

    @RequestMapping(value={"/danger"}, method = RequestMethod.GET)
    public ModelAndView getQList3() {
        ModelAndView modelAndView = new ModelAndView();
        Danger danger = new Danger();

        modelAndView.setViewName("danger.jsp");
        modelAndView.addObject("danger", danger);

        return modelAndView;
    }

    @RequestMapping(value = "/danger", method = RequestMethod.POST)
    public ModelAndView postQList3(@ModelAttribute("danger") Danger danger) {
        ModelAndView modelAndView = new ModelAndView();
        String dangerString = util.findDangerThreat(danger.getDangerString());
        modelAndView.setViewName("final.jsp");
        modelAndView.addObject("sequrityLevel", finalSequrityLevel);
        modelAndView.addObject("probability", finalProbability);
        String feasibility = util.findFeasibilityThreat();
        modelAndView.addObject("feasibility", feasibility);
        modelAndView.addObject("danger", dangerString);
        String relevance = util.findRelevanceThreat(dangerString,feasibility);
        modelAndView.addObject("relevance", relevance);
        return modelAndView;
    }
}