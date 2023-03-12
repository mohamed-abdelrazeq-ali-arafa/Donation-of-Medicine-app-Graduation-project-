package com.medicalsystem.Medical.service.security.models;

public class TokenConfiguration {
    public String audience;
    public String issuer;
    public String secret;
    public int duration;

    public TokenConfiguration(String audience, String issuer, String secret, int duration) {
        this.audience = audience;
        this.issuer = issuer;
        this.secret = secret;
        this.duration = duration;
    }
}
