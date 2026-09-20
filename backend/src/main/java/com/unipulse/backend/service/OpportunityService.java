package com.unipulse.backend.service;

import com.unipulse.backend.entity.Opportunity;
import com.unipulse.backend.repository.OpportunityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpportunityService {

    private final OpportunityRepository opportunityRepository;

    public OpportunityService(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public Opportunity createOpportunity(Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }

    public List<Opportunity> getAllOpportunities() {
        return opportunityRepository.findAll();
    }

    public Opportunity getOpportunityById(Long id) {
        return opportunityRepository.findById(id).orElse(null);
    }

    public void deleteOpportunity(Long id) {
        opportunityRepository.deleteById(id);
    }
}