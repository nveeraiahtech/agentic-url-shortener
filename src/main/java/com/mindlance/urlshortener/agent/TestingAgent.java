package com.mindlance.urlshortener.agent;

import org.springframework.stereotype.Component;

import com.mindlance.urlshortener.audit.AuditService;
import com.mindlance.urlshortener.workflow.WorkflowContext;

@Component
public class TestingAgent
        implements EngineeringAgent {

	private final AuditService auditService;
	
	public TestingAgent(AuditService auditService) {
		this.auditService = auditService;
	}
	
    @Override
    public void execute(
            WorkflowContext context) {

        System.out.println(
                "Testing Phase Started");
        
        auditService.saveAudit(
                "TestingAgent",
                "SUCCESS");

        context.getTasks()
                .add("Run Unit Tests");

        context.getTasks()
                .add("Run Integration Tests");

        System.out.println(
                context.getTasks());
        
        // TEMPORARY FOR RETRY TESTING
        //throw new RuntimeException(
          //      "Testing Agent Failed");
    }
}