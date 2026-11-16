package com.mindlance.urlshortener.workflow;

import org.springframework.stereotype.Service;

import com.mindlance.urlshortener.agent.DesignAgent;
import com.mindlance.urlshortener.agent.DocumentationAgent;
import com.mindlance.urlshortener.agent.ImplementationAgent;
import com.mindlance.urlshortener.agent.ReleaseAgent;
import com.mindlance.urlshortener.agent.RequirementAgent;
import com.mindlance.urlshortener.agent.TestingAgent;
import com.mindlance.urlshortener.service.RetryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkflowEngine {

    private final RequirementAgent
            requirementAgent;
    private final DesignAgent designAgent;
    private final ImplementationAgent implementationAgent;
    private final TestingAgent testingAgent;
    private final DocumentationAgent documentationAgent;
    private final ReleaseAgent releaseAgent;
    private final RetryService retryService;
        
    public void startWorkflow() {

        WorkflowContext context =
                new WorkflowContext();

        context.setRequirement(
                "Build URL Shortener");

        requirementAgent.execute(context);
        designAgent.execute(context);
        implementationAgent.execute(context);
        retryService.executeWithRetry(
                () -> testingAgent.execute(context));
        testingAgent.execute(context);
        documentationAgent.execute(context);
        releaseAgent.execute(context);
    }
}