package com.mindlance.urlshortener.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AnalyticsResponse {

    private Long clickCount;

    private LocalDateTime lastAccessed;
}
