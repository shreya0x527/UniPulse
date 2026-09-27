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

    public List<Opportunity> getOpportunitiesByType(String type) {
        return opportunityRepository.findByType(type);
    }

    public List<Opportunity> searchOpportunitiesByTitle(String title) {
        return opportunityRepository.findByTitleContainingIgnoreCase(title);
    }

    public Opportunity getOpportunityById(Long id) {
        return opportunityRepository.findById(id).orElse(null);
    }

    public Opportunity updateOpportunity(Long id, Opportunity updatedOpportunity) {
        Opportunity existingOpportunity = opportunityRepository.findById(id)
                .orElse(null);

        if (existingOpportunity == null) {
            return null;
        }

        existingOpportunity.setTitle(updatedOpportunity.getTitle());
        existingOpportunity.setType(updatedOpportunity.getType());
        existingOpportunity.setDescription(updatedOpportunity.getDescription());
        existingOpportunity.setLink(updatedOpportunity.getLink());
        existingOpportunity.setDeadline(updatedOpportunity.getDeadline());

        return opportunityRepository.save(existingOpportunity);
    }

    public void deleteOpportunity(Long id) {
        opportunityRepository.deleteById(id);
    }
}