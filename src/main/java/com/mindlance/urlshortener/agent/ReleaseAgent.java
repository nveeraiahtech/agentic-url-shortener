package com.mindlance.urlshortener.agent;

import org.springframework.stereotype.Component;

import com.mindlance.urlshortener.audit.AuditService;
import com.mindlance.urlshortener.service.ApprovalService;
import com.mindlance.urlshortener.workflow.WorkflowContext;

@Component
public class ReleaseAgent implements EngineeringAgent {

	private final ApprovalService approvalService;
	private final AuditService auditService;

	public ReleaseAgent(ApprovalService approvalService,AuditService auditService) {
		this.approvalService = approvalService;
		this.auditService = auditService;
	}

	@Override
	public void execute(WorkflowContext context) {

		System.out.println("Release Phase Started");
		auditService.saveAudit(
			       "ReleaseAgent",
			       "SUCCESS");

		
		if (!approvalService.isApproved()) {

			System.out.println("Approval Required. Release Stopped.");

			return;
		}

		System.out.println("Release Approved Successfully");

		context.getTasks().add("Release Ready");
	}
}
