package rabbitMq.rabbitMq.jwt.service;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import rabbitMq.rabbitMq.auth.dto.Passport;
import rabbitMq.rabbitMq.jwt.constant.ClaimConstant;
import rabbitMq.rabbitMq.jwt.dto.CustomUserDetails;
import rabbitMq.rabbitMq.jwt.dto.TokenDto;
import rabbitMq.rabbitMq.jwt.exception.InvalidJwtException;
import rabbitMq.rabbitMq.member.dto.MemberDto;

import static rabbitMq.rabbitMq.jwt.constant.ClaimConstant.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    @Value("${secretKey}")
    private String secretKey;
    private final CustomUserDetailService customUserDetailService;

    public Passport createPassportFromToken(String token) {
        System.out.println("어디서 문제일까요? JwtServiceImpl");
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        String email = claims.get(EMAIL).toString();
        Long memberId = (Long)claims.get(MEMBER_ID);
        return Passport.builder()
                .memberId(memberId)
                .name(email)
                .build();
    }
    private String createToken(MemberDto memberDto) {
        Claims claims = Jwts.claims();
        claims.put(EMAIL, memberDto.getEmail());
        claims.put(MEMBER_ID, memberDto.getId());
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    @Override
    public TokenDto provideToken(MemberDto memberDto) {
        String accessToken = createToken(memberDto);

        return TokenDto.builder()
                .accessToken(accessToken)
                .build();
    }
    @Override
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }
}
