package com.mindlance.urlshortener.agent;

import org.springframework.stereotype.Component;

import com.mindlance.urlshortener.audit.AuditService;
import com.mindlance.urlshortener.workflow.WorkflowContext;

@Component
public class DocumentationAgent implements EngineeringAgent {

	private final AuditService auditService;
	
	public DocumentationAgent(AuditService auditService) {
		this.auditService = auditService;
	}
	
    @Override
    public void execute(WorkflowContext context) {

        System.out.println("Documentation Phase Started");
        
        auditService.saveAudit(
     	       "DocumentationAgent",
     	       "SUCCESS");

        context.getTasks().add("Generate README");
        context.getTasks().add("Generate API Docs");
    }
}
