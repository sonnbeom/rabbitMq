package rabbitMq.rabbitMq.auth.contoller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbitMq.rabbitMq.auth.dto.Passport;
import rabbitMq.rabbitMq.auth.dto.ReqLoginDto;
import rabbitMq.rabbitMq.auth.service.AuthService;
import rabbitMq.rabbitMq.common.dto.Response;
import rabbitMq.rabbitMq.jwt.dto.TokenDto;

import static rabbitMq.rabbitMq.jwt.constant.JwtHeaderConstant.AUTHORIZATION;
import static rabbitMq.rabbitMq.jwt.constant.JwtHeaderConstant.BEARER;

@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    //로그인
    @PostMapping("/authenticate")
    public <T> Response authenticate(HttpServletRequest request){
        return authService.isValidPassport((Passport) request.getAttribute("passport"));
    }
    @PostMapping("/login")
    public void login(@RequestBody ReqLoginDto reqLoginDto, HttpServletResponse response){
        TokenDto tokenDto = authService.authorize(reqLoginDto);
        response.addHeader(AUTHORIZATION, BEARER + tokenDto.getAccessToken());
    }
}
