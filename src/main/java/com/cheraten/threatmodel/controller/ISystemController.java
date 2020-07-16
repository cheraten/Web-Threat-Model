package com.cheraten.threatmodel.controller;

import com.cheraten.threatmodel.entity.ISystem;
import com.cheraten.threatmodel.model.SecurityLevel;
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
public class ISystemController {
    private static QuestionService qService;
    private static ModelingUtil modelingUtil;

    @Autowired
    private ISystemService isystemService;
    @Autowired
    private ThreatService threatService;

    @GetMapping("/isystem")
    public String isystemMainPage(Model model) {
        model.addAttribute("isystemForm", new ISystem());

        return "isystem.jsp";
    }

    @PostMapping("/isystem")
    public ModelAndView postISystem(@ModelAttribute("isystemForm") @Valid ISystem isystemForm, Model model) {
        ModelAndView modelAndView = new ModelAndView();

        if (!isystemService.saveISystem(isystemForm)){
            model.addAttribute("nameError", "Система с таким именем уже существует");
            modelAndView.setViewName("isystem.jsp");
            return modelAndView;
        }
        for (int i = 0; i < isystemService.allISystems().size(); i++)
            isystemService.setThreatListByISystem(isystemService.allISystems().get(i), threatService.allThreats());
        modelAndView.addObject("allISystems", isystemService.allISystems());
        modelAndView.setViewName("modeling.jsp");
        return modelAndView;
    }

    @RequestMapping(value={"/security_level"}, method = RequestMethod.GET)
    public ModelAndView getDanger() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("securitylevel.jsp");
        modelAndView.addObject("securityLevelForm", new SecurityLevel());
        modelAndView.addObject("allISystems", isystemService.allISystems());

        return modelAndView;
    }

    @RequestMapping(value = "/security_level", method = RequestMethod.POST)
    public ModelAndView postSecLevel(@ModelAttribute("securityLevelForm") @Valid SecurityLevel securityLevelForm) {
        ModelAndView modelAndView = new ModelAndView();
        Long isystemId = securityLevelForm.getIsystemId();
        if (isystemId == null) {
            modelAndView.addObject("isystemError", "Система не выбрана!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }

        ArrayList<String> securityLevelList = new ArrayList<>();
        if (securityLevelForm.getSecurityLevel1() == null) {
            modelAndView.addObject("securityLevelError1", "Дайте ответ на вопрос!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }
        securityLevelList.add(securityLevelForm.getSecurityLevel1());

        if (securityLevelForm.getSecurityLevel2() == null) {
            modelAndView.addObject("securityLevelError2", "Выберите хотя бы один пункт!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }
        String[] splitString2 = qService.splitString(securityLevelForm.getSecurityLevel2());

        if (securityLevelForm.getSecurityLevel3() == null) {
            modelAndView.addObject("securityLevelError3", "Выберите хотя бы один пункт!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }
        String[] splitString3 = qService.splitString(securityLevelForm.getSecurityLevel3());

        for (int i = 0; i < splitString2.length; i++)
            securityLevelList.add(splitString2[i]);
        for (int i = 0; i < splitString3.length; i++)
            securityLevelList.add(splitString3[i]);

        if (securityLevelForm.getSecurityLevel4() == null) {
            modelAndView.addObject("securityLevelError4", "Дайте ответ на вопрос!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }
        securityLevelList.add(securityLevelForm.getSecurityLevel4());

        if (securityLevelForm.getSecurityLevel5() == null) {
            modelAndView.addObject("securityLevelError5", "Дайте ответ на вопрос!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }
        securityLevelList.add(securityLevelForm.getSecurityLevel5());

        if (securityLevelForm.getSecurityLevel6() == null) {
            modelAndView.addObject("securityLevelError6", "Дайте ответ на вопрос!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }
        securityLevelList.add(securityLevelForm.getSecurityLevel6());

        if (securityLevelForm.getSecurityLevel7() == null) {
            modelAndView.addObject("securityLevelError7", "Дайте ответ на вопрос!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }
        securityLevelList.add(securityLevelForm.getSecurityLevel7());

        if (securityLevelForm.getSecurityLevel8() == null) {
            modelAndView.addObject("securityLevelError8", "Дайте ответ на вопрос!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }
        securityLevelList.add(securityLevelForm.getSecurityLevel8());

        if (securityLevelForm.getSecurityLevel9() == null) {
            modelAndView.addObject("securityLevelError9", "Дайте ответ на вопрос!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }
        securityLevelList.add(securityLevelForm.getSecurityLevel9());

        if (securityLevelForm.getSecurityLevel10() == null) {
            modelAndView.addObject("securityLevelError10", "Дайте ответ на вопрос!");
            modelAndView.setViewName("securitylevel.jsp");
            modelAndView.addObject("allISystems", isystemService.allISystems());
            return modelAndView;
        }
        securityLevelList.add(securityLevelForm.getSecurityLevel10());

        String securityLevel = modelingUtil.findSecurityLevel(securityLevelList);
        isystemService.setSecLevelByName(isystemId,securityLevel);

        isystemService.setThreatListByISystem(isystemService.findISystemById(isystemId),threatService.allThreats());
        for (int i = 0; i < isystemService.findISystemById(isystemId).getThreats().size(); i++) {
            Long threatId = isystemService.findISystemById(isystemId).getThreats().get(i).getId();
            String feasibility = modelingUtil.findFeasibilityThreat(threatService.findThreatById(threatId).getIsystem().getSecurityLevel(),
                    threatService.findThreatById(threatId).getProbability());
            threatService.setFeasibilityByName(threatId,feasibility);
            String relevance = modelingUtil.findRelevanceThreat(threatService.findThreatById(threatId).getFeasibility(),
                    threatService.findThreatById(threatId).getDanger());
            threatService.setRelevanceByName(threatId,relevance);
        }

        for (int i = 0; i < isystemService.allISystems().size(); i++)
            isystemService.setThreatListByISystem(isystemService.allISystems().get(i), threatService.allThreats());
        modelAndView.addObject("allISystems", isystemService.allISystems());
        modelAndView.setViewName("modeling.jsp");
        modelAndView.setViewName("modeling.jsp");
        return modelAndView;
    }
}

