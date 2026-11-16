package com.mindlance.urlshortener.audit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkflowAuditRepository
        extends JpaRepository<WorkflowAudit, Long> {
}
