package com.mindlance.urlshortener.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "analytics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortCode;

    private Long clickCount;

    private LocalDateTime lastAccessed;
}
