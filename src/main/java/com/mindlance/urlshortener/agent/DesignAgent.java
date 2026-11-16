package com.mindlance.urlshortener.agent;

import org.springframework.stereotype.Component;

import com.mindlance.urlshortener.audit.AuditService;
import com.mindlance.urlshortener.workflow.WorkflowContext;

@Component
public class DesignAgent
        implements EngineeringAgent {
	
	private final AuditService auditService;
	
	public DesignAgent(AuditService auditService) {
		this.auditService = auditService;
	}

    @Override
    public void execute(
            WorkflowContext context) {

        System.out.println(
                "Design Phase Started");
        
        auditService.saveAudit(
        	       "DesignAgent",
        	       "SUCCESS");

        context.getTasks()
                .add("Design Database");

        context.getTasks()
                .add("Design APIs");

        System.out.println(
                context.getTasks());
    }
}
