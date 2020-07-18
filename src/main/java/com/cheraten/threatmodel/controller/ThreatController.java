package com.cheraten.threatmodel.controller;

import com.cheraten.threatmodel.entity.ISystem;
import com.cheraten.threatmodel.entity.Threat;
import com.cheraten.threatmodel.model.Danger;
import com.cheraten.threatmodel.model.Probability;
import com.cheraten.threatmodel.service.ISystemService;
import com.cheraten.threatmodel.service.QuestionService;
import com.cheraten.threatmodel.service.ThreatService;
import com.cheraten.threatmodel.util.ModelingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class ThreatController {
    @Autowired
    private ISystemService isystemService;
    @Autowired
    private ThreatService threatService;
    @Autowired
    private static QuestionService qService;
    private static ModelingUtil modelingUtil;

    @GetMapping("/threat")
    public String threatMainPage(Model model) {
        model.addAttribute("threatForm", new Threat());
        model.addAttribute("allISystems", isystemService.allISystems());
        return "threat.jsp";
    }

    @PostMapping("/threat")
    public ModelAndView postThreat(@ModelAttribute("threatForm") @Valid Threat threatForm, String action) {
        ModelAndView modelAndView = new ModelAndView();
        if (action.equals("renameThreat")){
            threatForm.setIsystem(threatService.findThreatById(threatForm.getId()).getIsystem());
            if (threatForm.getName().equals("")) {
                modelAndView.addObject("nameError", "Введите название угрозы!");
                modelAndView.setViewName("threat_rename.jsp");
                return modelAndView;
            }
            if (!threatService.saveThreat(threatForm)){
                modelAndView.addObject("nameError", "Угроза с таким именем для системы уже существует!");
                modelAndView.setViewName("threat_rename.jsp");
                return modelAndView;
            }
        }
        if (action.equals("replaceThreat")) {
            if (threatForm.getIsystem() == null) {
                modelAndView.addObject("nameError", "Выберите систему!");
                modelAndView.setViewName("threat.jsp");
                modelAndView.addObject("allISystems", isystemService.allISystems());
                return modelAndView;
            }
            if (!threatService.saveThreat(threatForm)) {
                modelAndView.addObject("nameError", "Угроза с таким именем для системы уже существует!");
                modelAndView.setViewName("threat.jsp");
                modelAndView.addObject("allISystems", isystemService.allISystems());
                return modelAndView;
            }
        }
        if(action.equals("createThreat")) {
            if (threatForm.getName().equals("")) {
                modelAndView.addObject("nameError", "Введите название угрозы!");
                modelAndView.setViewName("threat.jsp");
                modelAndView.addObject("allISystems", isystemService.allISystems());
                return modelAndView;
            }
            if (threatForm.getIsystem() == null) {
                modelAndView.addObject("nameError", "Выберите систему!");
                modelAndView.setViewName("threat.jsp");
                modelAndView.addObject("allISystems", isystemService.allISystems());
                return modelAndView;
            }
            if (!threatService.saveThreat(threatForm)) {
                modelAndView.addObject("nameError", "Угроза с таким именем для системы уже существует!");
                modelAndView.setViewName("threat.jsp");
                modelAndView.addObject("allISystems", isystemService.allISystems());
                return modelAndView;
            }
        }
        for (int i = 0; i < isystemService.allISystems().size(); i++)
            isystemService.setThreatListByISystem(isystemService.allISystems().get(i), threatService.allThreats());
        modelAndView.addObject("allISystems", isystemService.allISystems());
        modelAndView.setViewName("modeling.jsp");
        return modelAndView;
    }

    @PostMapping("/threat_rename")
    public ModelAndView renameThreat(@ModelAttribute("threatForm") @Valid Threat threatForm) {
        ModelAndView modelAndView = new ModelAndView();

        if (!threatService.saveThreat(threatForm)){
            modelAndView.addObject("nameError", "Угроза с таким именем для системы уже существует!");
            modelAndView.setViewName("threat_rename.jsp");
            return modelAndView;
        }
        for (int i = 0; i < isystemService.allISystems().size(); i++)
            isystemService.setThreatListByISystem(isystemService.allISystems().get(i), threatService.allThreats());
        modelAndView.addObject("allISystems", isystemService.allISystems());
        modelAndView.setViewName("modeling.jsp");
        return modelAndView;
    }

    @PostMapping("/threat_replace")
    public ModelAndView replaceThreat(@ModelAttribute("threatForm") @Valid Threat threatForm) {
        ModelAndView modelAndView = new ModelAndView();

        if (!threatService.saveThreat(threatForm)){
            modelAndView.addObject("nameError", "Угроза с таким именем для системы уже существует!");
            modelAndView.setViewName("threat_replace.jsp");
            return modelAndView;
        }
        for (int i = 0; i < isystemService.allISystems().size(); i++)
            isystemService.setThreatListByISystem(isystemService.allISystems().get(i), threatService.allThreats());
        modelAndView.addObject("allISystems", isystemService.allISystems());
        modelAndView.setViewName("modeling.jsp");
        return modelAndView;
    }

    @RequestMapping(value={"/probability"}, method = RequestMethod.GET)
    public ModelAndView getProbability() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("probability.jsp");
        modelAndView.addObject("probabilityForm", new Probability());
        modelAndView.addObject("allThreats", threatService.allThreats());

        return modelAndView;
    }

    @RequestMapping(value = "/probability", method = RequestMethod.POST)
    public ModelAndView postProbability(@ModelAttribute("probabilityForm") @Valid Probability probabilityForm) {
        ModelAndView modelAndView = new ModelAndView();
        Long threatId = probabilityForm.getThreatId();
        if (threatId == null) {
            modelAndView.addObject("threatError", "Угроза не выбрана!");
            modelAndView.setViewName("probability.jsp");
            modelAndView.addObject("allThreats", threatService.allThreats());
            return modelAndView;
        }

        if (probabilityForm.getProbabilityString() == null) {
            modelAndView.addObject("probabilityError", "Нарушитель не выбран!");
            modelAndView.setViewName("probability.jsp");
            modelAndView.addObject("allThreats", threatService.allThreats());
            return modelAndView;
        }
        String[] splitString = qService.splitString(probabilityForm.getProbabilityString());

        ArrayList<String> probabilityList = new ArrayList<>();
        for (int i = 0; i < splitString.length; i++)
            probabilityList.add(splitString[i]);
        String probability = modelingUtil.findProbabilityThreat(probabilityList);
        threatService.setProbabilityByName(threatId,probability);

        String feasibility = modelingUtil.findFeasibilityThreat(threatService.findThreatById(threatId).getIsystem().getSecurityLevel(),
                threatService.findThreatById(threatId).getProbability());
        threatService.setFeasibilityByName(threatId,feasibility);

        String relevance = modelingUtil.findRelevanceThreat(threatService.findThreatById(threatId).getFeasibility(), threatService.findThreatById(threatId).getDanger());
        threatService.setRelevanceByName(threatId,relevance);

        for (int i = 0; i < isystemService.allISystems().size(); i++)
            isystemService.setThreatListByISystem(isystemService.allISystems().get(i), threatService.allThreats());
        modelAndView.addObject("allISystems", isystemService.allISystems());
        modelAndView.setViewName("modeling.jsp");
        return modelAndView;
    }

    @RequestMapping(value={"/danger"}, method = RequestMethod.GET)
    public ModelAndView getDanger() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("danger.jsp");
        modelAndView.addObject("dangerForm", new Danger());
        modelAndView.addObject("allThreats", threatService.allThreats());

        return modelAndView;
    }

    @RequestMapping(value = "/danger", method = RequestMethod.POST)
    public ModelAndView postDanger(@ModelAttribute("dangerForm") @Valid Danger dangerForm) {
        ModelAndView modelAndView = new ModelAndView();
        Long threatId = dangerForm.getThreatId();
        if (threatId == null) {
            modelAndView.addObject("threatError", "Угроза не выбрана!");
            modelAndView.setViewName("danger.jsp");
            modelAndView.addObject("allThreats", threatService.allThreats());
            return modelAndView;
        }

        if (dangerForm.getDangerString() == null) {
            modelAndView.addObject("dangerError", "Оценка уровня ущерба не выполнена!");
            modelAndView.setViewName("danger.jsp");
            modelAndView.addObject("allThreats", threatService.allThreats());
            return modelAndView;
        }
        String danger = modelingUtil.findDangerThreat(dangerForm.getDangerString());
        threatService.setDangerByName(threatId,danger);
        String feasibility = modelingUtil.findFeasibilityThreat(threatService.findThreatById(threatId).getIsystem().getSecurityLevel(),
                threatService.findThreatById(threatId).getProbability());
        threatService.setFeasibilityByName(threatId,feasibility);
        String relevance = modelingUtil.findRelevanceThreat(threatService.findThreatById(threatId).getFeasibility(),
                threatService.findThreatById(threatId).getDanger());
        threatService.setRelevanceByName(threatId,relevance);

        for (int i = 0; i < isystemService.allISystems().size(); i++)
            isystemService.setThreatListByISystem(isystemService.allISystems().get(i), threatService.allThreats());
        modelAndView.addObject("allISystems", isystemService.allISystems());
        modelAndView.setViewName("modeling.jsp");
        return modelAndView;
    }
}