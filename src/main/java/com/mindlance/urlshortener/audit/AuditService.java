package com.mindlance.urlshortener.audit;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final WorkflowAuditRepository repository;

    public void saveAudit(
            String agentName,
            String status) {

        WorkflowAudit audit =
                new WorkflowAudit();

        audit.setAgentName(agentName);
        audit.setStatus(status);
        audit.setCreatedAt(
                LocalDateTime.now());

        repository.save(audit);
    }
}
