package com.mindlance.urlshortener.service;

import org.springframework.stereotype.Service;

import com.mindlance.urlshortener.dto.AnalyticsResponse;
import com.mindlance.urlshortener.entity.AnalyticsEntity;
import com.mindlance.urlshortener.repository.AnalyticsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final AnalyticsRepository repository;

    public AnalyticsResponse getAnalytics(
            String code){

        AnalyticsEntity analytics =
             repository.findByShortCode(code)
                    .orElseThrow();

        return AnalyticsResponse.builder()
                .clickCount(
                  analytics.getClickCount())
                .lastAccessed(
                  analytics.getLastAccessed())
                .build();
    }
}
