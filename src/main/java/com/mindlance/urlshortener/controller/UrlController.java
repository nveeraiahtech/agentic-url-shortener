package com.mindlance.urlshortener.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindlance.urlshortener.dto.AnalyticsResponse;
import com.mindlance.urlshortener.dto.CreateUrlRequest;
import com.mindlance.urlshortener.dto.CreateUrlResponse;
import com.mindlance.urlshortener.entity.AnalyticsEntity;
import com.mindlance.urlshortener.service.AnalyticsService;
import com.mindlance.urlshortener.service.UrlService;
import com.mindlance.urlshortener.workflow.WorkflowEngine;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService service;
        private final AnalyticsService analyticsService;
        private final WorkflowEngine workflowEngine;

    @PostMapping("/api/v1/urls")
    public ResponseEntity<CreateUrlResponse>
                createShortUrl(
        @RequestBody CreateUrlRequest request) {

        return ResponseEntity.ok(
                service.createShortUrl(request));
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(
            @PathVariable String shortCode) {

        String originalUrl =
                service.getOriginalUrl(shortCode);

        return ResponseEntity
                .status(302)
                .location(URI.create(originalUrl))
                .build();
    }
    
    @GetMapping("/analytics/{shortCode}")
    public ResponseEntity<AnalyticsResponse> getAnalytics(
            @PathVariable String shortCode) {

        return ResponseEntity.ok(
                analyticsService.getAnalytics(shortCode));
    }
    
    @GetMapping("/workflow")
    public String workflow() {

        workflowEngine.startWorkflow();

        return "Workflow Started";
    }
    
}
