package com.mindlance.urlshortener.agent;

import org.springframework.stereotype.Component;

import com.mindlance.urlshortener.audit.AuditService;
import com.mindlance.urlshortener.workflow.WorkflowContext;

@Component
public class RequirementAgent
        implements EngineeringAgent {

	private final AuditService auditService;
	
	public RequirementAgent(AuditService auditService) {
		this.auditService = auditService;
	}
	
    @Override
    public void execute(
            WorkflowContext context) {

        System.out.println(
                "Requirement Analysis Started");
        
        auditService.saveAudit(
                "RequirementAgent",
                "SUCCESS");

        context.getTasks()
                .add("Create Database");

        context.getTasks()
                .add("Create APIs");

        context.getTasks()
                .add("Create Tests");

        System.out.println(
                context.getTasks());
    }
}
