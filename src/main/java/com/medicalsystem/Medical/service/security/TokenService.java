package com.medicalsystem.Medical.service.security;

import com.medicalsystem.Medical.service.security.models.TokenConfiguration;

public interface TokenService {

    String generateToken(String userId, TokenConfiguration tokenConfiguration);

    String getUserIdFromToken(String token);

    boolean validateToken(String token, TokenConfiguration tokenConfiguration);
}
