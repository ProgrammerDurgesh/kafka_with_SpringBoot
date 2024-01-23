package durgeshkafka.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {
    static String compact =null;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    Date expirationTime = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);
    private String SECRET_KEY = "secret";

    public String getUsernameFromToken(String token) {

        String claimFromToken = getClaimFromToken(token, Claims::getSubject);
        System.out.println(claimFromToken);
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, @NotNull Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private @NotNull Boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }

    public String generateToken(@NotNull UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private String createToken(Map<String, Object> claims, String subject) {

        compact = Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
        System.out.println("This is Token you Can Access it          "+compact);
        return compact;
    }

    public Boolean validateToken(String token, @NotNull UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    public ResponseDTO tokenExpired() {
        return new ResponseDTO( HttpStatus.INTERNAL_SERVER_ERROR, "Token Expired","Timeout");
    }

    public static String token()
    {
        return compact;

    }


}