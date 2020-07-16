package com.cheraten.threatmodel.controller;

import com.cheraten.threatmodel.service.ISystemService;
import com.cheraten.threatmodel.service.ThreatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
    @Autowired
    private ThreatService threatService;
    @Autowired
    private ISystemService isystemService;

    @RequestMapping(value={"/modeling"}, method = RequestMethod.GET)
    public ModelAndView getMainPage() {
        ModelAndView modelAndView = new ModelAndView();

        for (int i = 0; i < isystemService.allISystems().size(); i++)
            isystemService.setThreatListByISystem(isystemService.allISystems().get(i), threatService.allThreats());

        modelAndView.addObject("allISystems", isystemService.allISystems());
        modelAndView.setViewName("modeling.jsp");
        return modelAndView;
    }

    @RequestMapping(value={"/modeling"}, method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(required = true, defaultValue = "" ) Long id,
                              @RequestParam(required = true, defaultValue = "" ) String action) {
        ModelAndView modelAndView = new ModelAndView();
        if (action.equals("deleteThreat")){
            threatService.deleteThreat(id);
        }
        if (action.equals("deleteISystem")){
            isystemService.setThreatListByISystem(isystemService.findISystemById(id), threatService.allThreats());
            for (int i = 0; i < isystemService.findISystemById(id).getThreats().size(); i++) {
                Long threatId = isystemService.findISystemById(id).getThreats().get(i).getId();
                threatService.deleteThreat(threatId);
            }
            isystemService.deleteISystem(id);
        }

        for (int i = 0; i < isystemService.allISystems().size(); i++)
            isystemService.setThreatListByISystem(isystemService.allISystems().get(i), threatService.allThreats());
        modelAndView.addObject("allISystems", isystemService.allISystems());
        modelAndView.setViewName("modeling.jsp");
        return modelAndView;
    }

    @GetMapping("/modeling/gt/{threatId}")
    public String  gtThreat(@PathVariable("threatId") Long threatId, Model model) {
        model.addAttribute("allThreats", threatService.threatgtList(threatId));
        return "modeling.jsp";
    }

    @GetMapping("/modeling/gt/{isystemId}")
    public String  gtISystem(@PathVariable("isystemId") Long isystemId, Model model) {
        model.addAttribute("allISystems", isystemService.isystemgtList(isystemId));
        return "modeling.jsp";
    }
}