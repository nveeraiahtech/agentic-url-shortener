package com.mindlance.urlshortener.repository;

import com.mindlance.urlshortener.entity.AnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnalyticsRepository
         extends JpaRepository<AnalyticsEntity, Long> {

    Optional<AnalyticsEntity>
         findByShortCode(String shortCode);
}
