package com.mindlance.urlshortener.repository;

import com.mindlance.urlshortener.entity.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository
        extends JpaRepository<UrlEntity, Long> {

    Optional<UrlEntity> findByShortCode(String shortCode);
}