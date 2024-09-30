package rabbitMq.rabbitMq.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import rabbitMq.rabbitMq.auth.dto.Passport;
import rabbitMq.rabbitMq.auth.dto.ReqLoginDto;
import rabbitMq.rabbitMq.common.dto.Response;
import rabbitMq.rabbitMq.jwt.dto.TokenDto;
import rabbitMq.rabbitMq.jwt.service.JwtService;
import rabbitMq.rabbitMq.member.domain.Member;
import rabbitMq.rabbitMq.member.exception.MemberNotFoundException;
import rabbitMq.rabbitMq.member.repository.MemberRepository;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final JwtService jwtService;
    public TokenDto authorize(ReqLoginDto req){
        System.out.println("오냐"+req.toString());
        Member member = memberRepository.findByEmail(req.getEmail())
                .orElseThrow(() -> new MemberNotFoundException("해당 이메일에 해당하는 인원을 찾을 수 없습니다: %s "+ req.getEmail(), HttpStatus.NOT_FOUND));
        return jwtService.provideToken(member.entityToDto());
    }
    public Response<Passport> isValidPassport(Passport passport) {
        if (passport == null) {
            return Response
                    .<Passport>builder()
                    .code(HttpStatus.FORBIDDEN)
                    .data(null)
                    .success(false)
                    .build();
        } else {
            return Response
                    .<Passport>builder()
                    .code(HttpStatus.OK)
                    .data(passport)
                    .success(true)
                    .build();
        }
    }
}
