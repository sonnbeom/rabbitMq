package rabbitMq.rabbitMq.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import rabbitMq.rabbitMq.auth.constant.PassportConstant;
import rabbitMq.rabbitMq.auth.dto.Passport;
import rabbitMq.rabbitMq.jwt.constant.JwtHeaderConstant;
import rabbitMq.rabbitMq.jwt.service.JwtService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static rabbitMq.rabbitMq.auth.constant.PassportConstant.*;
import static rabbitMq.rabbitMq.jwt.constant.JwtHeaderConstant.*;

@RequiredArgsConstructor
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Optional<String> accessToken = getToken(request, HttpHeaders.AUTHORIZATION);
        if (accessToken.isPresent() && jwtService.isTokenValid(accessToken.get())){
            Passport passport = jwtService.createPassportFromToken(accessToken.get());
            request.setAttribute(PASSPORT, passport);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(passport, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
    private Optional<String> getToken(HttpServletRequest request, String headerName){
        String authorizationHeader = request.getHeader(headerName);

        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)){
            return Optional.ofNullable(authorizationHeader.split(" ")[1]);
        }else {
            return Optional.empty();
        }
    }
}