package rabbitMq.rabbitMq.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import rabbitMq.rabbitMq.common.dto.Response;
import rabbitMq.rabbitMq.common.service.ResponseService;
import rabbitMq.rabbitMq.member.domain.Member;
import rabbitMq.rabbitMq.member.dto.MemberDto;
import rabbitMq.rabbitMq.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final ResponseService responseService;
    @Override
    public Response create(MemberDto memberDto) {
        Member member = memberDto.dtoToEntity();
        Member saved = memberRepository.save(member);
        MemberDto resMemberDto = saved.entityToDto();
        return responseService.getResponse(resMemberDto, true, HttpStatus.CREATED);
    }
}
