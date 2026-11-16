# Agentic URL Shortener System

## Overview

This project demonstrates an Agentic Software Engineering System that builds and manages a URL Shortener service.

The system includes:

- URL Shortening
- URL Redirection
- Analytics Tracking
- Agentic SDLC Workflow Orchestration
- Human Approval Gate
- Retry Mechanism
- Audit Logging

## Technology Stack

- Java 21
- Spring Boot
- MySQL
- Spring Data JPA
- Lombok
- Maven

## Features

### URL Shortener

- Generate short URL
- Redirect short URL to original URL

### Analytics

- Click Count
- Last Accessed Timestamp

### Agentic Workflow

- Requirement Analysis Agent
- Design Agent
- Implementation Agent
- Testing Agent
- Documentation Agent
- Release Agent

### Governance

- Approval Gate
- Retry Logic
- Audit Trail

## APIs

POST /api/v1/urls

GET /{shortCode}

GET /api/v1/analytics/{shortCode}

## Run Project

mvn spring-boot:run

## Database

MySQL

Database Name:

url_shortener