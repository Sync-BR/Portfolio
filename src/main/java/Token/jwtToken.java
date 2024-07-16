package Token;

import Beans.usuarioBeans;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;

import java.util.Date;
import java.util.function.Function;

/**
 *
 * @author SYNC
 */
public class jwtToken {

    private final String secretKey = "secreto";

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String expireToken(String token) {
        Claims claims = extractAllClaims(token);
        claims.setExpiration(new Date(System.currentTimeMillis() - 1000)); // Define a expiração para o passado
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public static void main(String[] args) throws Exception, IOException {
        usuarioBeans user = new usuarioBeans();
        jwtToken token = new jwtToken();
        String tokentemp = token.generateToken("teste");
        System.out.println("Generated Token: " + tokentemp);
        boolean tokenacept = token.validateToken(tokentemp, "teste");
        System.out.println("Generated Token: " + tokenacept);
        System.out.println("Expirando token");
        String tokenexp = token.expireToken(tokentemp);
        System.out.println("Token expirado: " +tokenexp);
        boolean sucess = token.isTokenExpired(tokentemp);
        System.out.println("Estado: " +sucess);

    }
}
