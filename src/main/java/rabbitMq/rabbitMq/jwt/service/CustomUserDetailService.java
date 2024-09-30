package rabbitMq.rabbitMq.jwt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rabbitMq.rabbitMq.jwt.dto.CustomUserDetails;
import rabbitMq.rabbitMq.member.domain.Member;
import rabbitMq.rabbitMq.member.exception.MemberNotFoundException;
import rabbitMq.rabbitMq.member.repository.MemberRepository;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new MemberNotFoundException("해당 이메일에 해당하는 인원을 찾을 수 없습니다: %s "+ email, HttpStatus.NOT_FOUND));
        return new CustomUserDetails(member);
    }
}