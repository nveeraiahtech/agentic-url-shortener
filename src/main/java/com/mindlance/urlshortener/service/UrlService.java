package com.mindlance.urlshortener.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mindlance.urlshortener.dto.CreateUrlRequest;
import com.mindlance.urlshortener.dto.CreateUrlResponse;
import com.mindlance.urlshortener.entity.AnalyticsEntity;
import com.mindlance.urlshortener.entity.UrlEntity;
import com.mindlance.urlshortener.repository.AnalyticsRepository;
import com.mindlance.urlshortener.repository.UrlRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository repository;
    
    private final AnalyticsRepository analyticsRepository;

    public CreateUrlResponse createShortUrl(
            CreateUrlRequest request) {

        String code = UUID.randomUUID()
                .toString()
                .substring(0, 8);

        UrlEntity entity = UrlEntity.builder()
                .originalUrl(request.getOriginalUrl())
                .shortCode(code)
                .build();

        repository.save(entity);
        
        analyticsRepository.save(
                AnalyticsEntity.builder()
                        .shortCode(code)
                        .clickCount(0L)
                        .build()
        );

        return CreateUrlResponse.builder()
                .shortCode(code)
                .shortUrl("http://localhost:8080/" + code)
                .build();
    }

	/*
	 * public String getOriginalUrl(String code) {
	 * 
	 * return repository.findByShortCode(code) .orElseThrow() .getOriginalUrl(); }
	 */
    
    public String getOriginalUrl(String code) {

        UrlEntity urlEntity =
                repository.findByShortCode(code)
                        .orElseThrow();

        AnalyticsEntity analytics =
                analyticsRepository
                        .findByShortCode(code)
                        .orElseThrow();

        System.out.println("Before : "
                + analytics.getClickCount());
        
        analytics.setClickCount(
                analytics.getClickCount() + 1);
        
        System.out.println("After : "
                + analytics.getClickCount());
        
        analytics.setLastAccessed(
                LocalDateTime.now());

        analyticsRepository.save(analytics);

        return urlEntity.getOriginalUrl();
    }
}