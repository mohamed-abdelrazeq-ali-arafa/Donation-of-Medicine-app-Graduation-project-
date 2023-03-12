package com.medicalsystem.Medical.service.security;

import com.medicalsystem.Medical.service.security.models.TokenConfiguration;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtTokenService implements TokenService {

    @Override
    public String generateToken(String userId, TokenConfiguration tokenConfiguration) {
        Map<String, Object> map = Map.of("userId", userId);
        var claims = Jwts.claims(map);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, tokenConfiguration.secret)
                .setExpiration(new Date(System.currentTimeMillis() + tokenConfiguration.duration))
                .compact();

    }

    @Override
    public String getUserIdFromToken(String token) {
        var claims = Jwts.parser().parseClaimsJws(token).getBody();
        if (claims.containsKey("userId")) {
            return claims.get("userId").toString();
        }
        return null;
    }

    @Override
    public boolean validateToken(String token, TokenConfiguration tokenConfiguration) {
        return Jwts.parser()
                .setSigningKey(tokenConfiguration.secret)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .after(new Date());
    }
}
