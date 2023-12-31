package com.hcmute.ecommercebe.jwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@Data
public class JwtConfigurationModel {
    @Value("${jwt.configuration.secret}")
    private String secret;

    @Value("${jwt.configuration.issuer}")
    private String issuer;

    @Value("${jwt.configuration.audience}")
    private String audience;

    @Value("${jwt.configuration.expired}")
    private Long expired;
}
