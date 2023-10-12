package org.launchcode.techjobsmvc.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;

public class TechJobsController {
    static HashMap<String, String> actionChoices = new HashMap<>();
    public TechJobsController()
    {
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");
    }
    @ModelAttribute("actions")
    public static HashMap<String,String> getActionChoices(){
       // model.addAttribute("actions",actionChoices);

        return actionChoices;

    }
}
