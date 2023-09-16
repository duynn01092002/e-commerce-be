package com.hcmute.ecommercebe.jwt;


import com.hcmute.ecommercebe.domain.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenProvider {
    private static final Logger LOG = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Autowired
    private JwtConfigurationModel jwtConfigurationModel;

    public JwtTokenProvider() {}

    public Claims extractAllClaims(String jwtToken) {
        return Jwts.parser()
                .setSigningKey(this.jwtConfigurationModel.getSecret())
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    public String extractUsername(String jwtToken) { return this.extractClaim(jwtToken, Claims::getSubject); }

    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + this.jwtConfigurationModel.getExpired());

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS512, this.jwtConfigurationModel.getSecret())
                .compact();
    }

    public Date extractExpiredDate(String jwtToken) {
        return this.extractClaim(jwtToken, Claims::getExpiration);
    }

    private boolean isTokenExpired(String jwtToken) {
        return this.extractExpiredDate(jwtToken).before(new Date());
    }

    public boolean isTokenValid(String jwtToken, UserDetails userDetails) {
        final String username = this.extractUsername(jwtToken);
        return userDetails.getUsername().equals(username) && !this.isTokenExpired(jwtToken);
    }

    public String generateToken(User userEntity) {
        Date now = new Date();
        Date expired = new Date(now.getTime() + this.jwtConfigurationModel.getExpired());
        return Jwts.builder()
                .setSubject(userEntity.getUsername())
                .setIssuedAt(now)
                .setExpiration(expired)
                .signWith(SignatureAlgorithm.HS512, this.jwtConfigurationModel.getSecret())
                .compact();
    }
}
