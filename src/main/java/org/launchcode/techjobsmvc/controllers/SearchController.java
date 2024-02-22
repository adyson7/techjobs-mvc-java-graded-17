package org.launchcode.techjobsmvc.controllers;

import org.launchcode.techjobsmvc.models.Job;
import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    // HashMap to store column choices for search options
    static HashMap<String, String> columnChoices = new HashMap<>();
    // initializes columnChoices HashMap with search options
    static {
        columnChoices.put("all", "All");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("positionType", "Position Type");
        columnChoices.put("coreCompetency", "Skill");
    }

    // Handler method to render the search view
    @GetMapping(value = "")
    public String search(Model model) {
        //adds columnChoices to the model to populate the search form dropdown
        model.addAttribute("columns", columnChoices);
        //retyrns the search view
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.

    // Handler method to process search request and display search results
    @PostMapping(value = "results")
    public String displaySearchResults(Model model,
                                       @RequestParam String searchType,
                                       @RequestParam String searchTerm) {
        // ArrayList stores the search results
        ArrayList<Job> jobs;
        //checks if search term is "all" or empty, if so, retrieve all jobs
        if (searchTerm.equals("all") || searchTerm.isEmpty()) {
            jobs = JobData.findAll();
        } else {
            //otherwise, search by specified column and search term
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }
        //adds search results and column choices to the model
        model.addAttribute("jobs", jobs);
        model.addAttribute("columns", columnChoices);
        //returns the search view with updated search results
        return "search";
    }
}

