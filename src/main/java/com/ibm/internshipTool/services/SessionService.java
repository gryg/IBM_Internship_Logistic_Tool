package com.ibm.internshipTool.services;

import com.ibm.internshipTool.repositories.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    // methods for CRUD operations or custom business logic
}
