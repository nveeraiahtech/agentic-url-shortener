package com.mindlance.urlshortener.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUrlResponse {

    private String shortCode;
    private String shortUrl;
}
