package com.ibm.internshipTool.services;

import com.ibm.internshipTool.repositories.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    // methods for CRUD operations or custom business logic
}
