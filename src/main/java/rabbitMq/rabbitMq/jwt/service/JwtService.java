package rabbitMq.rabbitMq.jwt.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import rabbitMq.rabbitMq.auth.dto.Passport;
import rabbitMq.rabbitMq.jwt.dto.TokenDto;
import rabbitMq.rabbitMq.member.dto.MemberDto;

public interface JwtService {
    public TokenDto provideToken(MemberDto memberDto);
    public boolean isTokenValid(String token);
    public Passport createPassportFromToken(String token);
}
