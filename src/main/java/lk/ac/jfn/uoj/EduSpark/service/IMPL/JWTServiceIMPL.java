package lk.ac.jfn.uoj.EduSpark.service.IMPL;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lk.ac.jfn.uoj.EduSpark.service.JWTService;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service
public class JWTServiceIMPL implements JWTService {
    private final SecretKey secretKey;

    public JWTServiceIMPL() {
        try {
            SecretKey k = KeyGenerator.getInstance("HmacSHA256").generateKey();
            secretKey= Keys.hmacShaKeyFor(k.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String jwtToken() {
        return Jwts.builder()
                .subject("Sachintha")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*15))
                .signWith(secretKey)
                .compact();
    }

    @Override
    public String getUserName(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
