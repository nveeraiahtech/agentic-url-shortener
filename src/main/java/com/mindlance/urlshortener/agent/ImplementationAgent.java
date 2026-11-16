package com.mindlance.urlshortener.agent;

import org.springframework.stereotype.Component;

import com.mindlance.urlshortener.audit.AuditService;
import com.mindlance.urlshortener.workflow.WorkflowContext;

@Component
public class ImplementationAgent
        implements EngineeringAgent {

	private final AuditService auditService;
	
	public ImplementationAgent(AuditService auditService) {
		this.auditService = auditService;
	}
	
    @Override
    public void execute(
            WorkflowContext context) {

        System.out.println(
                "Implementation Phase Started");
        
        auditService.saveAudit(
                "ImplementationAgent",
                "SUCCESS");

        context.getTasks()
                .add("Create Entity");

        context.getTasks()
                .add("Create Repository");

        context.getTasks()
                .add("Create Service");

        context.getTasks()
                .add("Create Controller");

        System.out.println(
                context.getTasks());
    }
}
