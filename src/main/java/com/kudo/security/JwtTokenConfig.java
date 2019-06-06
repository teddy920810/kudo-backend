package com.kudo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenConfig {

    @Value("${kudo.jwt.ignore-url:/login}")
    private String[] ignoreUrl;

    @Value("${kudo.jwt.header:Authorization}")
    private String header;

    @Value("${kudo.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${kudo.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${kudo.jwt.secret}")
    private String secret;

    public String[] getIgnoreUrl() {
        return ignoreUrl;
    }

    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public String getSecret() {
        return secret;
    }
}

