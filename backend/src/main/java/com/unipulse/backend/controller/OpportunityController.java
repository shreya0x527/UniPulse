package com.unipulse.backend.controller;

import com.unipulse.backend.entity.Opportunity;
import com.unipulse.backend.service.OpportunityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opportunities")
public class OpportunityController {

    private final OpportunityService opportunityService;

    public OpportunityController(OpportunityService opportunityService) {
        this.opportunityService = opportunityService;
    }

    @PostMapping
    public Opportunity createOpportunity(@RequestBody Opportunity opportunity) {
        return opportunityService.createOpportunity(opportunity);
    }

    @GetMapping
    public List<Opportunity> getAllOpportunities() {
        return opportunityService.getAllOpportunities();
    }

    @GetMapping("/{id}")
    public Opportunity getOpportunityById(@PathVariable Long id) {
        return opportunityService.getOpportunityById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteOpportunity(@PathVariable Long id) {
        opportunityService.deleteOpportunity(id);
        return "Opportunity deleted successfully";
    }
}