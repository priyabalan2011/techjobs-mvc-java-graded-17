package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.techjobsmvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController extends TechJobsController{

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("searchType","all");
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @PostMapping(value="results")
   public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam(required = false) String searchTerm)
   {
       ArrayList<Job> jobs;
       if (searchType.equals("all") && (searchTerm.isEmpty() || searchTerm.equals("all"))){
           jobs = JobData.findAll();
           model.addAttribute("title", "All Jobs");
       } else {
           jobs = JobData.findByColumnAndValue(searchType, searchTerm);
           model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
       }
       model.addAttribute("jobs", jobs);
       model.addAttribute("columns",columnChoices);
       model.addAttribute("searchType",searchType);
       return "search";
   }

    @GetMapping(value="results")
    public String displaySearchResults1(Model model, @RequestParam String searchType, @RequestParam(required = false) String searchTerm)
    {
        ArrayList<Job> jobs;
        if (searchType.equals("all") && (searchTerm.isEmpty() || searchTerm.equals("all"))){
            jobs = JobData.findAll();
            model.addAttribute("title", "All Jobs");
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        }
        model.addAttribute("jobs", jobs);
        model.addAttribute("columns",columnChoices);
        model.addAttribute("searchType",searchType);
        return "search";
    }



}

