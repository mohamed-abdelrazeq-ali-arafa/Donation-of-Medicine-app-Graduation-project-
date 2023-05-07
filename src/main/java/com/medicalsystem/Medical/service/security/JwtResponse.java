package com.medicalsystem.Medical.service.security;

public class JwtResponse {

    private String token;
    private String status;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
