package rabbitMq.rabbitMq.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import rabbitMq.rabbitMq.jwt.filter.JwtTokenFilter;
import rabbitMq.rabbitMq.jwt.service.JwtService;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtService jwtService;
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(new JwtTokenFilter(jwtService), UsernamePasswordAuthenticationFilter.class);
        http
                .csrf(csrf -> csrf.disable());
        http
                .authorizeRequests(auth -> auth
                        .requestMatchers("/api/v1/gateway/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"api/v1/member").permitAll()
                        .requestMatchers(HttpMethod.POST,"/api/v1/auth/login").permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }
}
